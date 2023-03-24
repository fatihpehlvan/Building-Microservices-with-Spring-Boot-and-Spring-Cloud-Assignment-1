package net.javaguides.employeeservice.controller;

import lombok.AllArgsConstructor;
import net.javaguides.employeeservice.dto.EmployeeDTO;
import net.javaguides.employeeservice.entity.Employee;
import net.javaguides.employeeservice.service.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/employees")
@AllArgsConstructor
public class EmployeeController {

	private EmployeeService employeeService;

	@PostMapping
	public ResponseEntity<EmployeeDTO> saveEmployee(@RequestBody EmployeeDTO employeeDTO) {
		return new ResponseEntity<>(employeeService.saveEmployee(employeeDTO), HttpStatus.CREATED);
	}

	@GetMapping("/{employeeId}")
	public  ResponseEntity<EmployeeDTO> getEmployee(@PathVariable Long employeeId) {
		EmployeeDTO employeeDTO = employeeService.getEmployee(employeeId);
		return new ResponseEntity<>(employeeDTO, HttpStatus.OK);
	}


}
