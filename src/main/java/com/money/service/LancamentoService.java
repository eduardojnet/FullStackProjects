package com.money.service;

import com.money.model.Lancamento;
import com.money.repository.LancamentoRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

@Service
public class LancamentoService {
    
    @Autowired
    private LancamentoRepository LancamentoRepository;

    public Lancamento atualizar(Long codigo, Lancamento lancamento) {
        Lancamento LancamentoSalva = encontrarLancamentoPeloCodigo(codigo);
        BeanUtils.copyProperties(lancamento, LancamentoSalva, "codigo");
        return LancamentoRepository.save(LancamentoSalva);
    }

    protected Lancamento encontrarLancamentoPeloCodigo(Long codigo) {
        Lancamento LancamentoSalva = LancamentoRepository.findById(codigo).orElse(null);
        if (LancamentoSalva == null) {
            throw new EmptyResultDataAccessException(1);
        }
        return LancamentoSalva;
    }

    /*public void atualizarPropriedadeAtivo(Long codigo, Boolean ativo) {
        Lancamento LancamentoSalva = encontrarLancamentoPeloCodigo(codigo);
        LancamentoSalva.setAtivo(ativo);
        LancamentoRepository.save(LancamentoSalva);
    }*/
    
    
}
