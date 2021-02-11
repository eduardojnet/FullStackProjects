package com.money.resource;


import com.money.event.RecursoCriadoEvent.RecursoCriadoEvent;
import com.money.model.Lancamento;
import com.money.repository.LancamentoRepository;
import com.money.service.LancamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping("/lancamentos")
public class LancamentoResource {

    @Autowired
    private LancamentoRepository lancamentoRepository;

    @Autowired
    private ApplicationEventPublisher publisher;

    @Autowired
    private LancamentoService lancamentoService;

    @GetMapping
    public List<Lancamento> listar() {
        return lancamentoRepository.findAll();
    }

    @PostMapping
    public ResponseEntity<Lancamento> criar(@Valid @RequestBody final Lancamento Lancamento, final HttpServletResponse response) {
        Lancamento LancamentoSalvo = lancamentoRepository.save(Lancamento);
        publisher.publishEvent(new RecursoCriadoEvent(this, response, LancamentoSalvo.getCodigo()));
        return ResponseEntity.status(HttpStatus.CREATED).body(LancamentoSalvo);
    }

    @GetMapping("/{codigo}")
    public ResponseEntity<Lancamento> buscarPeloCodigo(@PathVariable final Long codigo) {
        Lancamento lancamento = lancamentoRepository.findById(codigo).orElse(null);
        return lancamento != null ? ResponseEntity.ok(lancamento) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{codigo}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void remover(@PathVariable final Long codigo) {
        lancamentoRepository.deleteById(codigo);
    }

    /*@PutMapping("/{codigo}")
    public ResponseEntity<Lancamento> atualizar(@PathVariable final Long codigo, @Valid @RequestBody final Lancamento lancamento) {
        Lancamento lancamentoSalvo = lancamentoService.atualizar(codigo, lancamento);
        return ResponseEntity.ok(lancamentoSalvo);

    }*/
}
