package com.example.demo.Repo;

import com.example.demo.Entity.Employe;
import com.example.demo.Entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProjectRepo extends JpaRepository< Project,Long > {
    Optional<Project> findProjectById(Long id);
    Optional<Project> findProjectByBudget(double budget);
    Optional<Project> findProjectByName (String name );


}


