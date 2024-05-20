package com.example.backend.person.respository.interfaces;

import com.example.backend.person.respository.dao.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface HibernatePersonRepository extends JpaRepository<Person, Integer>,
        JpaSpecificationExecutor<Person>
{

}
