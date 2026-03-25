package com.rest_with_spring.rest_with_spring.repository;

import com.rest_with_spring.rest_with_spring.models.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {

}
