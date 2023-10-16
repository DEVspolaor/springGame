package com.senai.giovanni.PrjGame.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.senai.giovanni.PrjGame.entities.Jogo;
import com.senai.giovanni.PrjGame.service.JogoService;



@RestController
@RequestMapping("/Jogo")
public class JogoController {
	
	@GetMapping("/home")
	public String paginaInicial() {
		return "index"; 
	}
private final JogoService jogoService;
	
	@Autowired
	public JogoController (JogoService jogoService) {
		this.jogoService = jogoService;
		
	}
	
	@PostMapping
	public Jogo createJogo(@RequestBody Jogo Jogo) {
		return jogoService.saveJogo(Jogo);
	}
	@GetMapping
	public List<Jogo> getAllJogo(){
		return jogoService.getAllJogos();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Jogo> getJogo(@PathVariable Long id) {
		Jogo jogo = jogoService.getJogoById(id);
		if (jogo !=null) {
			return ResponseEntity.ok(jogo);
		} else {
			return ResponseEntity.notFound().build();
		}
	}
		
	
	
	@DeleteMapping
	public void deleteJogo(@PathVariable Long id) {
		jogoService.deleteJogo(id);
	}

}


