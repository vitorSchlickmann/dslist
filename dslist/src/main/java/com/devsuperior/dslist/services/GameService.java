package com.devsuperior.dslist.services;

import java.util.List;

import com.devsuperior.dslist.dto.GameDTO;
import com.devsuperior.dslist.dto.GameMinDTO;
import com.devsuperior.dslist.entities.Game;
import com.devsuperior.dslist.repositories.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class GameService {

    @Autowired
    private GameRepository gameRepository;

    @Transactional(readOnly = true)
    public GameDTO findById(Long gameId) {
       Game result = gameRepository.findById(gameId).get();
       GameDTO dto = new GameDTO(result);

       return dto;
    }

    @Transactional(readOnly = true)
    public List<GameMinDTO> findAll() {
        List<Game> resultadoConsultaGames = gameRepository.findAll();
        List<GameMinDTO> resultadoConsultaMinGames = resultadoConsultaGames.stream().map(x -> new GameMinDTO(x)).toList();
        return resultadoConsultaMinGames;
    }
}
