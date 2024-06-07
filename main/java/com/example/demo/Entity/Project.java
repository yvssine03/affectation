package com.example.demo.Entity;


import jakarta.persistence.*;
import jdk.jfr.DataAmount;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@Table
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "project_id", nullable = false)

    private Long id;
    private String name;
    private double budget;
    @ManyToMany
    @JoinTable(
            name = "employee_project",
            joinColumns = @JoinColumn(name = "project_id"),
            inverseJoinColumns = @JoinColumn(name = "employe_id"))
    private Set<Employe> employe = new HashSet<>();

}
