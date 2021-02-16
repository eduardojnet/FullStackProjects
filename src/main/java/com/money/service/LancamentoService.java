package com.money.service;

import com.money.model.Lancamento;
import com.money.model.Pessoa;
import com.money.repository.LancamentoRepository;
import com.money.repository.PessoaRepository;
import com.money.service.exception.PessoaInexistenteOuInativaException;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

@Service
public class LancamentoService {

    @Autowired
    private LancamentoRepository lancamentoRepository;

    @Autowired
    private PessoaRepository pessoaRepository;

    @Autowired
    private PessoaService pessoaService;

    public Lancamento salvar(Lancamento lancamento) {
        Pessoa pessoa = pessoaRepository.findById(lancamento.getPessoa().getCodigo()).orElse(null);
        if (pessoa == null || pessoa.isInativo()) {
            throw new PessoaInexistenteOuInativaException();
        }
        return lancamentoRepository.save(lancamento);
    }

    public Lancamento atualizar(Long codigo, Lancamento lancamento) {
        Lancamento LancamentoSalva = encontrarLancamentoPeloCodigo(codigo);
        BeanUtils.copyProperties(lancamento, LancamentoSalva, "codigo");
        return lancamentoRepository.save(LancamentoSalva);
    }

    protected Lancamento encontrarLancamentoPeloCodigo(Long codigo) {
        Lancamento LancamentoSalva = lancamentoRepository.findById(codigo).orElse(null);
        if (LancamentoSalva == null) {
            throw new EmptyResultDataAccessException(1);
        }
        return LancamentoSalva;
    }
}
