package br.edu.unipe.api.service;



import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.http.HttpStatus;

/***
 * Esta class serve para de um tipo de container que isola a resposta do serviço, incluindo o status HTTP e o corpo da resposta.
 * o objetivo é simplificar o Controller e o Service, que não vão precisar tratar os códigos HTTP de retorno junto com lóigica de negócio.
 */


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ServiceResponse<T>{
    private T body;
    private HttpStatus status;

}
