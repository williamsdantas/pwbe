package br.edu.unipe.api.controller;

import br.edu.unipe.api.model.Usuario;
import br.edu.unipe.api.model.dto.UsuarioDTO;
import br.edu.unipe.api.service.UsuarioService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    private final UsuarioService service;

    @GetMapping
    public List<Usuario> listar(){
        log.info("Listando Usuarios");
        return service.listarUsuarios();
    }

    @GetMapping("/{id}")
    public UsuarioDTO consultarPorId(@PathVariable int id){
        log.info("Inicio - Consulta usuário id {} " , id);
        var usuario = service.convertToDto(service.consultar(id));
        log.info("Fim  - Consulta usuário id {} " , id);
        return usuario;
    }

    @GetMapping("/email/{email}")
    public Usuario  getUsuarioPorEmail(@PathVariable String  email){
        var usuario = service.buscarPorEmail(email);
        return usuario;
    }
    @PostMapping
    public ResponseEntity<UsuarioDTO> salvar(@RequestBody UsuarioDTO usuarioDTO){
        usuarioDTO = service.salvar(usuarioDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(usuarioDTO);
    }

    @PutMapping
    public Usuario atualizar(@RequestBody Usuario usuario){
        return service.alterar(usuario);
    }

    @DeleteMapping("/{id}")
    public void deleteUsuario(@PathVariable Integer id){
        service.deletar(id);
    }

}
