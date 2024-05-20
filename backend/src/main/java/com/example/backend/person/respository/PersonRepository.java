package com.example.backend.person.respository;

import com.example.backend.person.dto.PersonDto;
import com.example.backend.person.mapper.PersonMapper;
import com.example.backend.person.respository.interfaces.HibernatePersonRepository;
import com.example.backend.person.usecase.repositoryInterface.CreatePerson;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@RequiredArgsConstructor
public class PersonRepository implements CreatePerson {
    private final PersonMapper personMapper;
    private final HibernatePersonRepository hibernatePersonRepository;

    @Override
    @Transactional
    public PersonDto createPerson(PersonDto personDto)
    {
        hibernatePersonRepository.save(
                personMapper.fromPersonDtoToPerson(personDto)
        );

        return personDto;
    }
}
