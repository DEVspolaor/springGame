package com.senai.giovanni.PrjGame.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.senai.giovanni.PrjGame.entities.Jogo;
import com.senai.giovanni.PrjGame.repositories.JogoRepository;

@Service
public class JogoService {
	private final JogoRepository jogoRepository;
	
	@Autowired
	public JogoService(JogoRepository jogoRepository) {
		this.jogoRepository = jogoRepository;
	}
	
	public Jogo saveJogo(Jogo jogo) {
		return jogoRepository.save(jogo);
	}
	
	public Jogo getJogoById(Long Id) {
	return jogoRepository.findById(Id).orElse(null);
	}
	
	public List<Jogo> getAllJogos(){
		return jogoRepository.findAll();
	}
	//apagar produto
	public void deleteJogo(Long id) {
		jogoRepository.deleteById(id);
	}
}
