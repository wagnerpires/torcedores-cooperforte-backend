package br.com.desafio.cooperforteservice.controllers;

import br.com.desafio.cooperforteservice.dtos.TorcedorDTO;
import br.com.desafio.cooperforteservice.entities.Torcedor;
import br.com.desafio.cooperforteservice.services.AutenticacaoService;
import br.com.desafio.cooperforteservice.services.TorcedorService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@Controller
@AllArgsConstructor
@RequestMapping("/torcedores")
public class TorcedorController {

    private TorcedorService torcedorService;
    private AutenticacaoService autenticacaoService;

    @PostMapping
    public ResponseEntity<TorcedorDTO> novo(@RequestBody @Valid TorcedorDTO torcedorDTO){
        torcedorDTO = torcedorService.novo(torcedorDTO);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(torcedorDTO.getId()).toUri();
        return ResponseEntity.created(uri).body(torcedorDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity excluir(@PathVariable("id") Long id){
        torcedorService.excluir(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<TorcedorDTO> editar(@PathVariable("id") Long id, @RequestBody @Valid TorcedorDTO torcedorDTO){
        torcedorDTO = torcedorService.editar(id, torcedorDTO);
        return ResponseEntity.ok(torcedorDTO);
    }

    @GetMapping
    public ResponseEntity<List<TorcedorDTO>> listar(){
        return ResponseEntity.ok(torcedorService.listar());
    }
}
