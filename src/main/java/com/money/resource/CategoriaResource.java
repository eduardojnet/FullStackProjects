package com.money.resource;

import com.money.model.Categoria;
import com.money.repository.CategoriaRepository;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.servlet.http.HttpServletResponse;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/categorias")
public class CategoriaResource {

    @Autowired
    private CategoriaRepository categoriaRepository;

    @GetMapping
    public List<Categoria> listar() {
        //List<Categoria> categorias = categoriaRepository.findAll();
        //return categorias.isEmpty() ? ResponseEntity.ok(categorias) : ResponseEntity.notFound().build();
        return categoriaRepository.findAll();

    }

    @PostMapping
    public ResponseEntity<Categoria> criar(@RequestBody final Categoria categoria, final HttpServletResponse response) {
        Categoria categoriaSalva = categoriaRepository.save(categoria);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{codigo}")
                .buildAndExpand(categoriaSalva.getCodigo()).toUri();

        response.setHeader("Location", uri.toASCIIString());

        return ResponseEntity.created(uri).body(categoriaSalva);
    }

    @GetMapping("/{codigo}")
    public ResponseEntity<?> buscarPeloCodigo(@PathVariable final Long codigo) {
        Categoria categoriaId = categoriaRepository.findById(codigo).orElse(null);

        if (categoriaId == null ){
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.status(HttpStatus.OK).body(categoriaId);
        }

    }


}
