package com.devsuperior.dslist.services;

import java.util.List;

import com.devsuperior.dslist.dto.GameMinDTO;
import com.devsuperior.dslist.entities.Game;
import com.devsuperior.dslist.repositories.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class GameService {

    @Autowired
    private GameRepository gameRepository;


    public List<GameMinDTO> findAll() {
        List<Game> resultadoConsultaGames = gameRepository.findAll();
        List<GameMinDTO> resultadoConsultaMinGames = resultadoConsultaGames.stream().map(x -> new GameMinDTO(x)).toList();
        return resultadoConsultaMinGames;
    }
}
