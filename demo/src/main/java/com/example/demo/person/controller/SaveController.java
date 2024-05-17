package com.example.demo.person.controller;

import com.example.demo.person.dto.PersonDto;
import com.example.demo.person.usecase.CreateNewPerson;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@CrossOrigin
public class SaveController {

    private final CreateNewPerson createNewPerson;

    @PostMapping(value = "/person", headers = "Accept=application/json")
    public ResponseEntity<PersonDto> addDriver(
            @RequestBody
            PersonDto personDto) {
        return ResponseEntity.ok(createNewPerson.execute(personDto));
    }

}
