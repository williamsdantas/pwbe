package br.edu.unipe.api.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Endereco {
       private String logradouro;
       private String complemento;
       private String unidade;
       private String bairro;
       private String localidade;
       private String uf;
       private String ibge;
       private String ddd;
}

