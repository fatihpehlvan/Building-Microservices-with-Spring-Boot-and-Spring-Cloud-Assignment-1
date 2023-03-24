package net.javaguides.employeeservice.mapper;

import net.javaguides.employeeservice.dto.EmployeeDTO;
import net.javaguides.employeeservice.entity.Employee;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AutoEmployeeMapper {

	AutoEmployeeMapper MAPPER = Mappers.getMapper(AutoEmployeeMapper.class);

	Employee mapEmployeeDtoToEmployee(EmployeeDTO employeeDTO);
	EmployeeDTO mapEmployeeToEmployeeDto(Employee employee);


}
