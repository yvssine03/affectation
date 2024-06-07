package com.example.demo.Repo;

import com.example.demo.Entity.Employe;
import com.example.demo.Entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface EmployeRepo  extends JpaRepository<Employe , Long> {
    Optional<Employe>  findEmployeByEmail (String email);
    Optional<Employe> findEmployeByEmploye_name(String Employe_name);
    Optional<Employe> findEmployeByEmploye_id(String employe_id);

    List<Project> findByEmploye_id (String employe_id);

}
