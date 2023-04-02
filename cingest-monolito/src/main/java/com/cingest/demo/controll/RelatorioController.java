package com.cingest.demo.controll;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cingest.demo.model.Fachada;


@Controller
public class RelatorioController {
	
	@Autowired
	private Fachada fachada;
	
	@GetMapping("/relatorio")
	public String getScreen(){
		return "relatorioscreen";
	}
	
	@PostMapping("/relatorio/create")
	public String gerarRelatorio(@RequestParam String cargo) {
		fachada.exportarRelatorio(cargo);
		return "redirect:/relatorio";
	}
}
