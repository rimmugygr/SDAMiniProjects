package com.sda.jpademo.repository;


import com.sda.jpademo.model.Person;
import com.sda.jpademo.model.Phone;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PhoneRepo extends CrudRepository<Phone, Long> {

    List<Phone> findAllByOwnerId(Long id);
    List<Phone> findAllByOwner(Person owner);
    List<Phone> findAllByNumberEndingWith(String numberEnding);

    @Query("select p from Phone p where p.number like :compare")
    List<Phone> findAllByNumberLike(@Param("compare") String compareLike);

}
