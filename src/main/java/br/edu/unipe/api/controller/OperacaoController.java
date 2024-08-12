package br.edu.unipe.api.controller;

import br.edu.unipe.api.model.DadosListagemOperacoes;
import br.edu.unipe.api.model.Operacao;
import br.edu.unipe.api.model.dto.OperacaoDTO;
import br.edu.unipe.api.repository.OperacaoRepository;
import br.edu.unipe.api.service.OperacaoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/operacoes")
public class OperacaoController {
	
	private OperacaoRepository repositorio;
	private OperacaoService service;
	
	@PostMapping
	public ResponseEntity<OperacaoDTO> cadastrar(@RequestBody OperacaoDTO dados) {

		return ResponseEntity.ok(service.salvar(dados));
		
	}
	
	@GetMapping
	public ResponseEntity<List<OperacaoDTO>> getOperacoes() {
		
		return ResponseEntity.ok(service.listarOperacoes());
		
	}


}
