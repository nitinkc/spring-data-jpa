# Validations

Use of @Valid in the Controller class forces a validation check. The validation is defined in the Entity calss

in Controller
```java
//Add a new User
@PostMapping("/users")
public ResponseEntity<Object> addNewUser(@Valid  @RequestBody User user){
```

User Entity Class (Using Lombok)
```java
@Data
public class User {
	private Integer id;
	@Size(min=2,message = "Names should be at least characters long")
	private String name;
	@Past(message = "DOB Cannot be in the Future")
	private Date dob;
}
```

Exception for Failed Validations in the customized response entity exception handler
```java
 //Exception for Failed Validations
@Override
protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request){

    ExceptionResponse exceptionResponse = new ExceptionResponse(new Date(), "Validation Failed", ex.getBindingResult().toString());
    return  new ResponseEntity(exceptionResponse, HttpStatus.BAD_REQUEST);
}
```