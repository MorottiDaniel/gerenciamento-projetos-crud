package com.morotti.projetos.repository;

import com.morotti.projetos.entity.ProjetosEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjetosRepository extends JpaRepository<ProjetosEntity, Long> {
}
