package fiap.gamefinder.gamefinder.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import fiap.gamefinder.gamefinder.domain.Game;

public interface GameRepository extends JpaRepository<Game, Long> {

}
