 package com.employeeapp.entities;

//import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

//Anti corruption pattern in rest
//Entity --> controller
//entity --> dto --> send to the user
//dto-> entity -> service layer

@Data
@NoArgsConstructor
@ToString(exclude = {"employees"})
@Entity
@Table(name = "d_table")
public class Department {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int did;
	private String dname;

	//@JsonIgnore --> this will just remove the total relationship like it will remove it from
	//json and from memory too so we do not use this 
	@JsonManagedReference
	// this is used for the manager like who manages. like here department is managing the
	//employees and on employee table we'll use JsonBackreference so that it'll ignore the
	// department over there and will prevent infinite recursion calling
	@OneToMany(mappedBy = "department", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<Employee> employees=new ArrayList<>();

	public Department(String dname) {
		this.dname = dname;
	}
}






