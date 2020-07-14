package in.nit.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,

        property = "empId")
public class Employee {

	@Id
	@Column(name = "employee_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long empId;
	
	@Column(name = "emp_name")
	private String empName;
	
	@Column(name = "emp_email")
	private String empEmail;
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(
			name = "Employee_Project",
	        joinColumns = { 
	        		@JoinColumn(name  = "employee_id")
	        },
	        inverseJoinColumns = {
	        		@JoinColumn(name = "project_id")
	        }
	
		)
	private List<Project> projects;
}
