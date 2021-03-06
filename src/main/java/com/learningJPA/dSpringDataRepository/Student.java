package com.learningJPA.dSpringDataRepository;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "student")
public class Student {

	@Id
	@GeneratedValue
	@Column(name = "id")
	private Long id;
	@Size(min=2,message = "Names should be atleast characters long")
	@Column(name = "first_name")
	private String firstName;
	@Column(name = "last_name")
	private String lastName;
	@Past(message = "DOB Cannot be in the Future")
	@Column(name = "dob")
	private Date dob;
	@Column(name = "gender")
	private String gender;
	@Column(name = "university")
	private String university;
	@Column(name = "email")
	private String email;
	@Column(name = "CITYOFBIRTH")
	private String cityOfBirth;
}
