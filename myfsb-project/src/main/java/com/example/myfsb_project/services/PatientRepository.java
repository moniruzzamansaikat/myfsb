package com.example.myfsb_project.services;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.myfsb_project.models.Patient;

public interface PatientRepository extends JpaRepository<Patient, Integer> {
	
}
