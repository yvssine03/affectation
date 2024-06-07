package com.example.demo.Service;


import com.example.demo.Entity.Employe;
import com.example.demo.Entity.Project;
import com.example.demo.Repo.ProjectRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProjectService {
    @Autowired
    private ProjectRepo projectRepo;

    public void addProject(Project project) {
        Optional<Project> option = projectRepo.findProjectById(project.getId());

        if (option.isPresent()) {
            throw new IllegalStateException("Project deja existant ");
        } else {
            projectRepo.save(project);

        }
    }

    public void deleteProject(Project project) {
        Optional<Project> option = projectRepo.findProjectById(project.getId());

        if (option.isEmpty()) {
            throw new IllegalStateException("projet n'existe pas ");

        } else {
projectRepo.delete(project);
        }
    }

    public List<Project> getAllProjects() {
        return projectRepo.findAll();
    }



}

