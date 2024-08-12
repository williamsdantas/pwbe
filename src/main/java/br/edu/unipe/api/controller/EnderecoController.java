package br.edu.unipe.api.controller;

import br.edu.unipe.api.client.ViaCepClient;
import br.edu.unipe.api.model.Endereco;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/endereco")
public class EnderecoController {

    private final ViaCepClient viaCepClient;

    @GetMapping("/cep/{cep}")
    public Endereco consultarEnderecoPorCEP(@PathVariable String cep){
        log.info("Inicio - Consulta endereço por cep {} " , cep);
        var endereco = viaCepClient.consultaEnderecoPorCep(cep);
        log.info("Fim  - Consulta endereço por cep {} " , cep);
        return endereco;
    }
}
