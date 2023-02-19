package com.diegogalindo.controller;

import java.util.List;
import java.util.Optional;

import org.hibernate.exception.GenericJDBCException;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.orm.jpa.JpaObjectRetrievalFailureException;
import org.springframework.orm.jpa.JpaSystemException;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.diegogalindo.domain.model.Pessoa;
import com.diegogalindo.domain.repository.PessoaRepository;

@RestController
@RequestMapping("/pessoas")
public class PessoaController {

	@Autowired
	private PessoaRepository pessoaRepository;

	@GetMapping
	public List<Pessoa> listar() {
		return pessoaRepository.findAll();

	}

	@GetMapping("/{pessoaId}")
	public ResponseEntity<Pessoa> buscar(@PathVariable Long pessoaId) {
		Optional<Pessoa> pessoa = pessoaRepository.findById(pessoaId);

		if (pessoa.isPresent()) {
			return ResponseEntity.ok(pessoa.get());
		}
		return ResponseEntity.notFound().build();
	}

	@PostMapping
	public ResponseEntity<?> salvar(@RequestBody Pessoa pessoa) {
		try {
			pessoa = pessoaRepository.save(pessoa);
			return ResponseEntity.status(HttpStatus.CREATED).body(null);
		} catch (JpaSystemException | GenericJDBCException | HttpMessageNotReadableException
				| DataIntegrityViolationException e) {
			return ResponseEntity.badRequest().body("Dados inválidos");
		}

	}

	@PutMapping("/{pessoaId}")
	public ResponseEntity<?> atualizar(@PathVariable Long pessoaId, @RequestBody Pessoa pessoa) {

		try {
			Pessoa pessoaAtual = pessoaRepository.findById(pessoaId).orElse(null);
			if (pessoaAtual != null) {
				BeanUtils.copyProperties(pessoa, pessoaAtual, "id");
				pessoaAtual = pessoaRepository.save(pessoaAtual);
				return ResponseEntity.ok(pessoaAtual);
			}
			return ResponseEntity.notFound().build();
		} catch (JpaSystemException | GenericJDBCException | HttpMessageNotReadableException
				| DataIntegrityViolationException | JpaObjectRetrievalFailureException e) {
			return ResponseEntity.badRequest().body("Dados inválidos");
		}

	}

	@DeleteMapping("/{pessoaId}")
	public ResponseEntity<Pessoa> deletar(@PathVariable Long pessoaId) {
		Optional<Pessoa> pessoa = pessoaRepository.findById(pessoaId);
		if (pessoa.isPresent()) {
			pessoaRepository.deleteById(pessoaId);
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.notFound().build();

	}

}
