package com.morotti.projetos.service;

import com.morotti.projetos.entity.ProjetosEntity;
import com.morotti.projetos.repository.ProjetosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjetosService {
    @Autowired
    private ProjetosRepository projetosRepository;

    public ProjetosEntity criarProjeto(ProjetosEntity entity){
        return projetosRepository.save(entity);
    }

    public List<ProjetosEntity> findAll(){
        return projetosRepository.findAll();
    }

    public ProjetosEntity buscarPorId(Long id){
        return projetosRepository.findById(id).get();
    }

    public void deletar(Long id){
        projetosRepository.deleteById(id);
    }
}
