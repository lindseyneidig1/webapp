package com.example.demo.person.usecase;

import com.example.demo.person.dto.PersonDto;
import com.example.demo.person.usecase.repositoryInterface.CreatePerson;
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
