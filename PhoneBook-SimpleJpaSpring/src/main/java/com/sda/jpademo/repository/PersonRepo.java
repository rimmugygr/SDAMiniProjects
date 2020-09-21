package com.sda.jpademo.repository;


import com.sda.jpademo.model.Person;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonRepo extends CrudRepository<Person, Long> {
    List<Person> findAllByLastName(String lastName );
}
