package com.br.charles.Repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.br.charles.Entity.Game;

public interface GameRepository extends JpaRepository<Game, UUID> {

}