package com.example.demo.Entity;


import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
@Table
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Setter
@Getter
public class Employe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "employe_id " , nullable = false)
private Long employe_id;
    private String employe_name;
    private String email;
    private List<String> skills;
    @ManyToMany(mappedBy = "employe")
    private Set<Project> projects = new HashSet<>();



}
