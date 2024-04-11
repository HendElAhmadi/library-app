package com.example.library.mapper;

import com.example.library.dtos.PatronDto;
import com.example.library.model.entity.Patron;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE,
        componentModel = "spring",
        builder = @Builder(disableBuilder = true))
public interface PatronMapper {

    @Mapping(target = "id",ignore = true)
    Patron patronDtoToPatron(PatronDto patronDto);

    PatronDto patronToPatronDto(Patron patron);


    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "id",ignore = true)
    Patron updatePatronFromPatronDto(PatronDto patronDto, @MappingTarget Patron patron);
}
