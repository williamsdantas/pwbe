package br.edu.unipe.api.model.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class UsuarioDTO {

    private Integer id;

    @Email
    @NotEmpty
    private String email;

    @NotEmpty
    private String nome;

}
