package br.edu.unipe.api.service;

import br.edu.unipe.api.model.Operacao;
import br.edu.unipe.api.model.dto.OperacaoDTO;
import br.edu.unipe.api.repository.OperacaoRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@RequiredArgsConstructor
@Service
public class OperacaoService {
    private final OperacaoRepository repository;

    private final ModelMapper modelMapper;

    public OperacaoDTO salvar(OperacaoDTO operacaoDTO) {
        Operacao operacao = convertToEntity(operacaoDTO);
        operacao = repository.save(operacao);
        return convertToDto(operacao);
    }

    public List<OperacaoDTO> listarOperacoes() {

        List<Operacao> lista = repository.findAll();

        if (!lista.isEmpty()){
            return convertToListaOperqacaoDTO(lista);
        }
        return null;
    }

    private OperacaoDTO convertToDto(Operacao operacao) {
        return modelMapper.map(operacao, OperacaoDTO.class);
    }

    private Operacao convertToEntity(OperacaoDTO operacaoDTO) {
        return modelMapper.map(operacaoDTO, Operacao.class);
    }

    private List<OperacaoDTO> convertToListaOperqacaoDTO(List<Operacao> operacoes) {
        return operacoes.stream()
                .map(operacao -> modelMapper.map(operacao, OperacaoDTO.class))
                .collect(Collectors.toList());
    }
}
