package fiap.gamefinder.gamefinder.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import fiap.gamefinder.gamefinder.domain.Game;
import fiap.gamefinder.gamefinder.repository.GameRepository;
import jakarta.persistence.EntityNotFoundException;

@Service
public class GameService {

    private final GameRepository gameRepository;

    GameService(GameRepository gameRepository) {
        this.gameRepository = gameRepository;
    }

    public Page<Game> getAllGames(Pageable pageable){
        return gameRepository.findAll(pageable);
    }   

    public Game getGameById(Long id) {
        return gameRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Game not found"));
    }

    public List<Game> getGamesByGenreId(Long id) {
        return gameRepository.findAll().stream()
                .filter(game -> game.getGenre().getId().equals(id))
                .toList();
    }

    public List<Game> getGamesByPlataformId(Long id) {
        return gameRepository.findAll().stream()
                .filter(game -> game.getPlatform().getId().equals(id))
                .toList();
    }
} 
