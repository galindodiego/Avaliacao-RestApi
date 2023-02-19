package com.diegogalindo.endereco;


import static org.assertj.core.api.Assertions.assertThat;

import org.hibernate.exception.ConstraintViolationException;
//import org.junit.jupiter.api.Test;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.diegogalindo.domain.model.Endereco;
import com.diegogalindo.domain.repository.EnderecoRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
class CadastroEnderecoIntegrationTests {

	@Autowired
	EnderecoRepository enderecoRepository;
	
	@Test
	public void testarCadastroEnderecoComSucesso() {
		//cenário
		Endereco novoEndereco = new Endereco();
		novoEndereco.setCep("123");
		novoEndereco.setCidade("Suzano");
		novoEndereco.setLogradouro("Maria Helena");
		novoEndereco.setNumero("314");
		
		//ação
		novoEndereco = enderecoRepository.save(novoEndereco);
		
		//validação
		assertThat(novoEndereco).isNotNull();
		assertThat(novoEndereco.getId()).isNotNull();
	}
	
	@Test(expected = ConstraintViolationException.class)
	public void deveFalharAoCadastrarEnderecoQuandoCidadeSemNome() {
		Endereco novoEndereco = new Endereco();
		novoEndereco.setCep("123");
		novoEndereco.setCidade(null);
		novoEndereco.setLogradouro("Maria Helena");
		novoEndereco.setNumero("314");
		
		novoEndereco = enderecoRepository.save(novoEndereco);
	}
	

}