package br.edu.unipe.api.model.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class AtivoDTO{

    private Integer id;
    @NotEmpty
    private String nome;
    @NotEmpty
    private String papel;
}


