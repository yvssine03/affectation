package com.example.demo.Controller;

import com.example.demo.Entity.Project;
import com.example.demo.Service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/projects")
public class ProjectController {

    @Autowired
    private ProjectService projectService;

    @GetMapping("/getprojects")
    public List<Project> getAllProjects() {
        return projectService.getAllProjects();
    }

    @PostMapping("/saveproject")
    public void addProject(@RequestBody Project project) {
        projectService.addProject(project);
    }

    @DeleteMapping("/delete")
    public void deleteProject(@RequestBody Project project) {
        projectService.deleteProject(project);
    }
}
