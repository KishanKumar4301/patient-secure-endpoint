package com.boot.controller;

import com.boot.entity.Patient;
import com.boot.repo.PatientRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/patient")
public class PatientController {
    private final PatientRepository patientRepository;

    public PatientController(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }
     @GetMapping
    public List<Patient> getAllPatients(){
        return patientRepository.findAll();
    }
    @GetMapping("/{id}")
    public Patient getPatient(@PathVariable Long id){
        Optional<Patient> optional= patientRepository.findById(id);
        return optional.orElse(null);
    }
    @PostMapping()
    public Patient createPatient(@RequestBody Patient patient){

        return patientRepository.save(patient);
    }
    @DeleteMapping("/{id}")
    public String deletePatient(@PathVariable Long id){
        patientRepository.deleteById(id);
        return "Patient deleted ID is: " + id;
    }


}
