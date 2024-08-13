package br.edu.unipe.api.controller;

import br.edu.unipe.api.model.dto.AtivoDTO;
import br.edu.unipe.api.model.dto.UsuarioDTO;
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

		return ResponseEntity.status(HttpStatus.CREATED).body(ativoService.salvar(ativoDTO));
		
	}

	@GetMapping("/{id}")
	public ResponseEntity<AtivoDTO> consultarPorId(@PathVariable int id){

		return ResponseEntity.ok(ativoService.buscarAtivoPorId(id));

	}

	@GetMapping
	public ResponseEntity<List<AtivoDTO>> listarAtivos() {
		List<AtivoDTO> ativosDto = ativoService.listarAtivos();
		log.info(ativosDto.toString());
		return ResponseEntity.ok(ativosDto);
		
	}

}
