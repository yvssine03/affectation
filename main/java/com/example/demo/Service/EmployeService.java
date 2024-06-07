package com.example.demo.Service;


import com.example.demo.Entity.Employe;
import com.example.demo.Repo.EmployeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeService {
    @Autowired
    private EmployeRepo employeRepo;

    public List<Employe> getAllEmployees() {
        return employeRepo.findAll();
    }

    public void addEmploye(Employe employe) {
        Optional<Employe> option1 = employeRepo.findEmployeByEmail(employe.getEmail());
        Optional<Employe> option2 = employeRepo.findEmployeByEmploye_id(String.valueOf(employe.getEmploye_id()));

        if (option1.isPresent()||option2.isPresent() ) {
    throw new IllegalStateException("Employe deja existant ");}
        else {
            employeRepo.save(employe);



    }
}
public  void deleteemploye(Employe employe){
Optional<Employe> option = employeRepo.findEmployeByEmploye_id(String.valueOf(employe.getEmploye_id()));

if (option.isEmpty()){
    throw new IllegalStateException("Employe n'existe pas ");}
    else{
       employeRepo.delete(employe);

}

}

}
