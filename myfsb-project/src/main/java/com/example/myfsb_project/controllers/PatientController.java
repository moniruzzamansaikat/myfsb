package com.example.myfsb_project.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.myfsb_project.models.Patient;
import com.example.myfsb_project.services.PatientRepository;

@Controller
@RequestMapping("/patients")
public class PatientController {
	@Autowired
	private PatientRepository repo;

	@GetMapping("")
	public String allPatients(Model model) {
		List<Patient> patients = repo.findAll();
		
		System.out.print(patients);
		
		model.addAttribute("patients", patients);
		return "patients/all";
	}
	
	@GetMapping("/create")
	public String createPatient(Model model) {
	    model.addAttribute("patient", new Patient());
	    return "patients/add";
	}
	
	@PostMapping("/store")
	public String storePatient(@ModelAttribute Patient patient, RedirectAttributes redirectAttributes) {
		repo.save(patient);
	    redirectAttributes.addFlashAttribute("success", "Patient saved successfully!");
		return "redirect:/patients";
	}
	
	@GetMapping("/edit")
    public String editPatient(@RequestParam("id") int id, Model model) {
        Patient patient = repo.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid patient ID"));
        model.addAttribute("patient", patient);
        return "patients/edit";
    }
	
	@PostMapping("/update")
    public String updatePatient(Patient patient, RedirectAttributes redirectAttributes) {
        repo.save(patient);
        redirectAttributes.addFlashAttribute("success", "Patient details updated successfully!");
        return "redirect:/patients";
    }
	
	@GetMapping("/delete")
	public String deletePatient(@RequestParam int id, RedirectAttributes redirectAttributes) {
		repo.deleteById(id);
		redirectAttributes.addFlashAttribute("success", "Patient deleted successfully");
		return "redirect:/patients";
	}
}
