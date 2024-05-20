package com.example.backend.person.usecase.repositoryInterface;

import com.example.backend.person.dto.PersonDto;

public interface CreatePerson
{
    PersonDto createPerson(PersonDto personDto);
}
