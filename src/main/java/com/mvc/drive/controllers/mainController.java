package com.mvc.drive.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mvc.drive.models.Licenses;
import com.mvc.drive.models.Persons;
import com.mvc.drive.services.LiceService;
import com.mvc.drive.services.PersonService;

@Controller
public class mainController {
	private final PersonService personService;
	private final LiceService licenseService;
	public mainController(PersonService personService, LiceService licenseService) {
		this.personService = personService;
		this.licenseService = licenseService;
	}

	@RequestMapping("/")
	public String index() {
		return "redirect:/person/new";
	}

	//render person creation form
	@RequestMapping("/person/new")
	public String newPerson(@ModelAttribute("person") Persons person) {
		return "home.jsp";
	}
	
	//create a Person
	@RequestMapping(value = "/create/person", method = RequestMethod.POST)
	public String createPerson(@Valid @ModelAttribute("person") Persons person, BindingResult result) {
		if (result.hasErrors()) {
			return "home.jsp";
		} else {

			personService.createPerson(person);
			return "redirect:/person/new";
		}
	}
	
	//render license creation form
	@RequestMapping("/licenses/new")
	public String newLicense(@ModelAttribute("license")Licenses license, Model model) {
		List<Persons> listPerson = personService.findAll();
		model.addAttribute("persons", listPerson);
		return "licenseForm.jsp";
	}
	
	//create license
	@RequestMapping(value="/licenses/create", method=RequestMethod.POST)
	public String createLicense(@Valid @ModelAttribute("license")Licenses license, BindingResult result) {
		if(result.hasErrors()) {
			
			return "redirect:/licenses/new";
		}else {
			licenseService.createLicense(license);
			return "redirect:/";
		}
		
	}
	//render user profile
	@RequestMapping("/person/{id}")
	public String showProfile(@PathVariable("id")Long id, Model model) {
		Persons findPerson = personService.findPerson(id);
		if (findPerson == null) {
			return "redirect:/";
		}else {
			model.addAttribute("person", findPerson);
			System.out.print(findPerson);
			return "result.jsp";
			
		}
		
	}
	

}
