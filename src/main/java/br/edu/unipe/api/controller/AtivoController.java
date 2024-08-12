package br.edu.unipe.api.controller;

import br.edu.unipe.api.model.dto.AtivoDTO;
import br.edu.unipe.api.service.AtivoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/ativos")
public class AtivoController {

	private final AtivoService ativoService;
	
	@PostMapping
	public ResponseEntity<AtivoDTO> cadastrar(@RequestBody AtivoDTO ativoDTO) {
		log.info("Cadastrando ativo: {}", ativoDTO);
		ativoService.salvar(ativoDTO);
		return ResponseEntity.status(HttpStatus.CREATED).body(ativoDTO);
		
	}
	
	@GetMapping
	public ResponseEntity<List<AtivoDTO>> getAtivos() {
		
		return ResponseEntity.ok(ativoService.listarAtivos());
		
	}

}
