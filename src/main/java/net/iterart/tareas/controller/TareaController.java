package net.iterart.tareas.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import net.iterart.tareas.repository.TareaRepo;

@Controller
@RequestMapping("/tareas")
public class TareaController {

	@GetMapping("/list")
	public String home(Model m) {
		
		TareaRepo tr = new TareaRepo();
		
		m.addAttribute("titulo", "Lista de Tareas");
		m.addAttribute("tareas", tr.getTareas());
		
		return "home";
	}
}
