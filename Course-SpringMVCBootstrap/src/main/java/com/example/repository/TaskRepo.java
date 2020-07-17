package com.example.repository;

import com.example.model.Level;
import com.example.model.Task;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepo extends JpaRepository<Task,Long> {

    @Override
    @Query("select distinct t from Task t join fetch t.person")
    List<Task> findAll();

    @Query("select distinct t from Task t join fetch t.person WHERE t.level = :level")
    List<Task> findAllByLevel(@Param("level") Level level);
}
