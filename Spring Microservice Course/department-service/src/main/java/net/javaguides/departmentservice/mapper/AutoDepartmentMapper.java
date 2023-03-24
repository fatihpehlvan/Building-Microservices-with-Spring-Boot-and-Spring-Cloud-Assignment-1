package net.javaguides.departmentservice.mapper;

import net.javaguides.departmentservice.dto.DepartmentDTO;
import net.javaguides.departmentservice.entity.Department;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AutoDepartmentMapper {

	AutoDepartmentMapper MAPPER = Mappers.getMapper(AutoDepartmentMapper.class);

	DepartmentDTO departmentToDepartmentDto(Department department);

	Department departmentDtoToDepartment(DepartmentDTO departmentDTO);
}
