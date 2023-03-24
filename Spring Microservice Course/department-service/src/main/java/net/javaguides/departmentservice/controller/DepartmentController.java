package net.javaguides.departmentservice.controller;

import lombok.AllArgsConstructor;
import net.javaguides.departmentservice.dto.DepartmentDTO;
import net.javaguides.departmentservice.entity.Department;
import net.javaguides.departmentservice.service.DepartmentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/departments")
@AllArgsConstructor
public class DepartmentController {

	private DepartmentService departmentService;

	@PostMapping
	public ResponseEntity<DepartmentDTO> saveDepartment(@RequestBody DepartmentDTO departmentDTO) {
		DepartmentDTO savedDepartment = departmentService.saveDepartment(departmentDTO);
		return new ResponseEntity<>(savedDepartment, HttpStatus.CREATED);
	}

	@GetMapping("{department-code}")
	public ResponseEntity<DepartmentDTO> getDepartment(@PathVariable("department-code") String departmentCode) {
		DepartmentDTO departmentDTO = departmentService.getDepartmentByCode(departmentCode);

		return new ResponseEntity<>(departmentDTO, HttpStatus.OK);
	}
}
