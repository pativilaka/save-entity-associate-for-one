package com.vilaka.saveentityassociateforone.repositories;

import com.vilaka.saveentityassociateforone.entities.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {

}
