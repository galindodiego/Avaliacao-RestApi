package com.diegogalindo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.diegogalindo.domain.model.Endereco;
import com.diegogalindo.domain.repository.EnderecoRepository;

@RestController
@RequestMapping("/enderecos")
public class EnderecoController {

	@Autowired
	private EnderecoRepository enderecoRepository;
	
	@GetMapping
	public List<Endereco> listar(){
		return enderecoRepository.findAll();
	}
	
	@PostMapping
	public ResponseEntity<Endereco> salvar(@RequestBody Endereco endereco) {
		enderecoRepository.save(endereco);
		return ResponseEntity.status(HttpStatus.CREATED).body(endereco);
	}
}
