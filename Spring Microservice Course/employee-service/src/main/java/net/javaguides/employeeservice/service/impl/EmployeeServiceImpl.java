package net.javaguides.employeeservice.service.impl;

import lombok.AllArgsConstructor;
import net.javaguides.employeeservice.dto.EmployeeDTO;
import net.javaguides.employeeservice.entity.Employee;
import net.javaguides.employeeservice.repository.EmployeeRepository;
import net.javaguides.employeeservice.service.EmployeeService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

	private EmployeeRepository employeeRepository;
	private ModelMapper modelMapper;

	@Override
	public EmployeeDTO saveEmployee(EmployeeDTO employeeDTO) {

		// Using MapStruct
//		Employee employee = AutoEmployeeMapper.MAPPER.mapEmployeeDtoToEmployee(employeeDTO);

		// Using ModelMapper
		Employee employee = modelMapper.map(employeeDTO, Employee.class);

		Employee savedEmployee = employeeRepository.save(employee);

		// Using MapStruct
//		EmployeeDTO savedEmployeeDto = AutoEmployeeMapper.MAPPER.mapEmployeeToEmployeeDto(savedEmployee);

		// Using ModelMapper
		EmployeeDTO savedEmployeeDto = modelMapper.map(savedEmployee, EmployeeDTO.class);

		return savedEmployeeDto;
	}

	@Override
	public EmployeeDTO getEmployee(Long employeeId) {
		Employee employee = employeeRepository.findById(employeeId).get();
		// Using MapStruct
//		EmployeeDTO employeeDTO = AutoEmployeeMapper.MAPPER.mapEmployeeToEmployeeDto(employee);

		// Using ModalMapper
		EmployeeDTO employeeDTO = modelMapper.map(employee, EmployeeDTO.class);

		return employeeDTO;
	}
}
