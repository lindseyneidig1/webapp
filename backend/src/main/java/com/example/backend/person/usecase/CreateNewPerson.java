package com.example.backend.person.usecase;

import com.example.backend.person.dto.PersonDto;
import com.example.backend.person.usecase.repositoryInterface.CreatePerson;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CreateNewPerson
{
    private final CreatePerson createPerson;

    @Transactional
    public PersonDto execute(PersonDto personDto) {
        return createPerson.createPerson(personDto);
    }
}
