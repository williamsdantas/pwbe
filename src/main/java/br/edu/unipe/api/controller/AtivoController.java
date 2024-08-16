package br.edu.unipe.api.controller;

import br.edu.unipe.api.model.dto.AtivoDTO;
import br.edu.unipe.api.service.AtivoService;
import br.edu.unipe.api.service.ServiceResponse;
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

		ServiceResponse<AtivoDTO> sr = ativoService.salvar(ativoDTO);
		return ResponseEntity.status(HttpStatus.CREATED).body(sr.getBody());
	}

	@GetMapping("/{id}")
	public ResponseEntity<AtivoDTO> consultarPorId(@PathVariable int id){

		ServiceResponse<AtivoDTO> sr = ativoService.buscarAtivoPorId(id);

		return ResponseEntity.status(sr.getStatus()).body(sr.getBody());

	}

	@DeleteMapping("/ativos/{id}")
	public ResponseEntity<Void> excluirAtivo(@PathVariable int id){

		ServiceResponse<Void> sr = ativoService.deletar(id);
		return ResponseEntity.status(sr.getStatus()).body(sr.getBody());

	}

	@PutMapping()
	public ResponseEntity<AtivoDTO> alterarAtivo(@RequestBody AtivoDTO ativoDTO){

		ServiceResponse<AtivoDTO> sr = ativoService.alterar(ativoDTO);
		return ResponseEntity.status(sr.getStatus()).body(sr.getBody());

	}

	@GetMapping
	public ResponseEntity<List<AtivoDTO>> listarAtivos() {
		ServiceResponse<List<AtivoDTO>> sr = ativoService.listarAtivos();
		return ResponseEntity.status(sr.getStatus()).body(sr.getBody());
		
	}

}
