package com.morotti.projetos.controller;

import com.morotti.projetos.entity.ProjetosEntity;
import com.morotti.projetos.service.ProjetosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/projetos")
public class ProjetosController {
    @Autowired
    private ProjetosService projetosService;

    @PostMapping
    public ResponseEntity<ProjetosEntity> criarProjeto(@RequestBody ProjetosEntity entity){
        ProjetosEntity projeto = projetosService.criarProjeto(entity);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}")
                .buildAndExpand(projeto.getId()).toUri();
        return ResponseEntity.created(uri).body(projeto);
    }

    @GetMapping
    public ResponseEntity<List<ProjetosEntity>> findAll(){
        List<ProjetosEntity> entities = projetosService.findAll();
        return ResponseEntity.ok().body(entities);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProjetosEntity> buscarPorId(@PathVariable Long id){
        try {
            ProjetosEntity entity = projetosService.buscarPorId(id);
            return ResponseEntity.ok().body(entity);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletar(@PathVariable Long id){
        projetosService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
