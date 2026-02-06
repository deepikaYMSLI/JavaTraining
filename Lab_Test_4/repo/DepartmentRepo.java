package com.employeeapp.repo;

import com.employeeapp.dto.DeptEmpResponse;
import com.employeeapp.entities.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DepartmentRepo extends JpaRepository<Department, Integer> {
	
	
	
	@Query("SELECT DISTINCT d FROM Department d JOIN FETCH d.employees")
	//we have used FETCH JOIN to get rid of the N+1 problem over here 
	List<Department> findAllWithEmployees();
	
    @Query("select new com.employeeapp.dto.DeptEmpResponse(e.name, e.salary, d.dname) from Department d inner join d.employees e")
    List<DeptEmpResponse> deptEmployeeData();
}















