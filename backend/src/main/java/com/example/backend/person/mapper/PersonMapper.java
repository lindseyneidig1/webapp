package com.example.backend.person.mapper;

import com.example.backend.person.dto.PersonDto;
import com.example.backend.person.respository.dao.Person;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface PersonMapper
{
    Person fromPersonDtoToPerson(PersonDto PersonDto);

    PersonDto fromPersonToPersonDto(Person person);
}
