package com.example.demo.person.mapper;

import com.example.demo.person.dto.PersonDto;
import com.example.demo.person.respository.dao.Person;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface PersonMapper
{
    Person fromPersonDtoToPerson(PersonDto PersonDto);

    PersonDto fromPersonToPersonDto(Person person);
}
