package net.javaguides.departmentservice.service.impl;

import lombok.AllArgsConstructor;
import net.javaguides.departmentservice.dto.DepartmentDTO;
import net.javaguides.departmentservice.entity.Department;
import net.javaguides.departmentservice.mapper.AutoDepartmentMapper;
import net.javaguides.departmentservice.repository.DepartmentRepository;
import net.javaguides.departmentservice.service.DepartmentService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {

	private DepartmentRepository departmentRepository;
	ModelMapper modelMapper;

	@Override
	public DepartmentDTO saveDepartment(DepartmentDTO departmentDTO) {

		// convert departmentdto to

		// Using MapStruct
//		Department department = AutoDepartmentMapper.MAPPER.departmentDtoToDepartment(departmentDTO);

		// Using ModelMapper
		Department department = modelMapper.map(departmentDTO, Department.class);

		Department savedDepartment = departmentRepository.save(department);

		// Using MapStruct
//		DepartmentDTO savedDepartmentDTO = AutoDepartmentMapper.MAPPER.departmentToDepartmentDto(department);

		// Using Model Mapper
		DepartmentDTO savedDepartmentDTO = modelMapper.map(savedDepartment, DepartmentDTO.class);



		return savedDepartmentDTO;
	}

	@Override
	public DepartmentDTO getDepartmentByCode(String code) {
		Department department = departmentRepository.findByDepartmentCode(code);

		// using MapStruct
//		DepartmentDTO departmentDTO = AutoDepartmentMapper.MAPPER.departmentToDepartmentDto(department);

		// using model mapper
		DepartmentDTO departmentDTO = modelMapper.map(department, DepartmentDTO.class);

		return departmentDTO;
	}
}
