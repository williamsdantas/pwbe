package br.edu.unipe.api.service;


import br.edu.unipe.api.model.Ativo;
import br.edu.unipe.api.model.Operacao;
import br.edu.unipe.api.model.dto.AtivoDTO;
import br.edu.unipe.api.model.dto.OperacaoDTO;
import br.edu.unipe.api.repository.AtivoRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Slf4j
@RequiredArgsConstructor
@Service
public class AtivoService {

    private final AtivoRepository repository;
    private final ModelMapper modelMapper;

    public List<AtivoDTO> listarAtivos(){
        return convertToListaAtivoDTO(repository.findAll());

    }

    public Ativo buscarAtivoPorId(Integer id) {
       return repository.findById(id).orElseThrow(() -> new RuntimeException("Ativo não encontrado"));
    }
    /**
     * Inclui um novo ativo */
    public AtivoDTO salvar(AtivoDTO ativoDTO){
        Ativo ativo = repository.save(convertToEntity(ativoDTO));
        return convertToDto(ativo);
    }

    public  Ativo alterar(Ativo ativo){
        validarExistenciaId(ativo.getId());
        return repository.save(ativo);
    }


    public void deletar(Integer id){
        log.info("Start - Excluindo user ID {} ", id);
        repository.deleteById(id);
        log.info("End - Excluindo user ID {} ", id);
    }


    private void validarExistenciaId(Integer id){
        if(Objects.isNull(id) || !repository.existsById(id)){
            throw new RuntimeException("Ativo não existe para o id "+id);
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
                .map(ativo -> modelMapper.map(ativos, AtivoDTO.class))
                .collect(Collectors.toList());
    }


}
