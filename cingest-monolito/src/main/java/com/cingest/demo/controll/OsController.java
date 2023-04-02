package com.cingest.demo.controll;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cingest.demo.model.Fachada;
import com.cingest.demo.model.os.Os;

@Controller
public class OsController {
	
	@Autowired
	private Fachada fachada;
	
	@GetMapping(value = "/os/{id}")
	public String getOs(@PathVariable("id") int id, Model model) {
		Os os = fachada.getOS(id);
		if(os != null) {
			model.addAttribute("os", os);
		}
		return "osscreen";
	}
	
	@GetMapping(value = "/os")
	public String getOs(Model model) {
		model.addAttribute("os", fachada.getOS());
		return "osscreen";
	}
	
	@GetMapping(value = "/os/update/screen")
	public String getUpdateScreen(Model model) {
		return "updateosscreen";
	}
	
	@PostMapping(value = "/os")
	public String addOs(
			@RequestParam String titulo,
			@RequestParam String responsavel,
			@RequestParam String supervisor,
			@RequestParam String cliente,
			@RequestParam String inicio,
			@RequestParam String fim,
			Model model) {
		Os os = new Os(titulo, responsavel, supervisor, cliente, "Aprovada", inicio, fim);
		fachada.insert(os);
		return "redirect:/os";
	}
	
	@PostMapping(value = "/os/update")
	public String updateOs(
			@RequestParam(defaultValue = "") String id,
			@RequestParam(defaultValue = "") String titulo,
			@RequestParam(defaultValue = "") String responsavel,
			@RequestParam(defaultValue = "") String supervisor,
			@RequestParam(defaultValue = "") String cliente,
			@RequestParam(defaultValue = "") String status,
			@RequestParam(defaultValue = "") String inicio,
			@RequestParam(defaultValue = "") String fim,
			Model model) {
		int key;
		try {
			key = Integer.parseInt(id);
		} catch(Exception e) {
			return "redirect:/os/update/screen";
		}
		fachada.update(key, new Os(titulo, responsavel, supervisor, cliente, status, inicio, fim));
		return "redirect:/os/update/screen";
	}
	
	@GetMapping(value = "/os/delete/{id}")
	public String delete(@PathVariable("id") int id, Model model) {
		fachada.delete(id);
		model.addAttribute("os", fachada.getOS());
		return "redirect:/os";
	}
}
