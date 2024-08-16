package br.edu.unipe.api.service;


import br.edu.unipe.api.exception.AtivoNotFoundException;
import br.edu.unipe.api.model.Ativo;
import br.edu.unipe.api.model.dto.AtivoDTO;
import br.edu.unipe.api.repository.AtivoRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.service.spi.ServiceException;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Slf4j
@RequiredArgsConstructor
@Service
public class AtivoService {

    private final AtivoRepository repository;
    private final ModelMapper modelMapper;

    /**
     * lista todos os ativos */
    public ServiceResponse<List<AtivoDTO>> listarAtivos(){
        try {
            return new ServiceResponse<>(convertToListaAtivoDTO(repository.findAll()), HttpStatus.OK);
        } catch(Exception e){
            throw new ServiceException("Erro ao obter lista de ativos "+  e.getMessage());
        }
    }

    public ServiceResponse<AtivoDTO> buscarAtivoPorId(Integer id) {
        try {
            return repository.findById(id)
                    .map(ativo -> new ServiceResponse<>(convertToDto(ativo), HttpStatus.OK))
                    .orElse(new ServiceResponse<>(null,HttpStatus.NO_CONTENT));
        }
        catch(ServiceException e) {
            throw new ServiceException("Erro ao obter o ativo " + id + "." + e.getMessage());
        }
    }


    /**
     * Inclui um novo ativo */
    public ServiceResponse<AtivoDTO> salvar(AtivoDTO ativoDTO){
        try{
            return new ServiceResponse<>(convertToDto(repository.save(convertToEntity(ativoDTO))), HttpStatus.CREATED);
        }
        catch(ServiceException e) {
            throw new ServiceException("Erro ao criar um ativo." + e.getMessage());
        }
    }

    public  ServiceResponse<AtivoDTO> alterar(AtivoDTO ativoDTO){
        try{
            validarExistenciaId(ativoDTO.getId());
            return new ServiceResponse<>(convertToDto(repository.save(convertToEntity(ativoDTO))),HttpStatus.OK);
        }
        catch(ServiceException e) {
            throw new ServiceException("Erro ao alterar um ativo." + e.getMessage());
        }

    }


    public ServiceResponse<Void> deletar(Integer id){
        try{
            log.info("Start - Excluindo user ID {} ", id);
            validarExistenciaId(id);

            repository.deleteById(id);
            log.info("End - Excluindo user ID {} ", id);
            return new ServiceResponse<>(null, HttpStatus.NO_CONTENT);
        }
        catch(ServiceException e) {
            throw new ServiceException("Erro ao excluir um ativo." + e.getMessage());
        }

    }


    private void validarExistenciaId(Integer id){
        if(Objects.isNull(id) || !repository.existsById(id)){
            throw new AtivoNotFoundException("Ativo não existe para o id "+id);
        }
    }

    public AtivoDTO convertToDto(Ativo ativo) {
        return modelMapper.map(ativo, AtivoDTO.class);
    }

    public Ativo convertToEntity(AtivoDTO ativoDTO) {
        log.info("antes convertToEntity -> " + ativoDTO);
        var ativo = modelMapper.map(ativoDTO, Ativo.class);
        log.info("convertToEntity -> id=" + ativo.getId()+"; Nome=" + ativo.getNome()+"; Papel=" + ativo.getPapel());
        return ativo;
    }

    private List<AtivoDTO> convertToListaAtivoDTO(List<Ativo> ativos) {
        return ativos.stream()
                .map(ativo -> modelMapper.map(ativo, AtivoDTO.class))
                .collect(Collectors.toList());
    }



}
