package com.spring.san.controller;

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

import com.spring.san.spec.entity.Specialization;
import com.spring.san.spec.service.ISpecializationService;

@Controller
@RequestMapping("/spec")
public class SpecializationController {

	@Autowired
	private ISpecializationService specializationService;

	@GetMapping("/reg")
	public String showRegistaion() {

		return "SpecRegistation";
	}

	@PostMapping("/create")
	public String specCreate(@ModelAttribute Specialization spec, Model model) {

		specializationService.createSpec(spec);
		model.addAttribute("message", "Record has been created!");
		return "SpecRegistation";
	}

	@GetMapping("/getAll")
	public String showSpecDetails(Model model, @RequestParam(value = "message", required = false) String message) {

		List<Specialization> List = specializationService.getAllSpec();
		System.out.println("Redirect message from delete:::::" + message);
		model.addAttribute("list", List);
		model.addAttribute("message", message);

		return "ShowSpecData";
	}

	@GetMapping("/delete")
	public String specDelete(@RequestParam Integer id, RedirectAttributes redirectAttribute) {

		specializationService.deleteSpec(id);

		redirectAttribute.addAttribute("message", "Record has been Deleted!");
		return "redirect:getAll";
	}
}
