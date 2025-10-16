package fiap.gamefinder.gamefinder.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.util.List;

import fiap.gamefinder.gamefinder.domain.Game;
import fiap.gamefinder.gamefinder.service.GameService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.PagedModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;



@RestController
@RequestMapping("/games")
public class GameController {

    @Autowired
    private GameService gameService;

    @GetMapping
    public PagedModel<EntityModel<Game>> getAll(Pageable pageable, PagedResourcesAssembler<Game> assembler) {
        var page = gameService.getAllGames(pageable);
        return assembler.toModel(page);
    }

    @GetMapping("{id}")
    public EntityModel<Game> getGameById(@PathVariable Long id) {
        var game = gameService.getGameById(id);
        var genreId = game.getGenre().getId();
        var platformId = game.getPlatform().getId();

        return EntityModel.of(game,
                linkTo(methodOn(GameController.class).getGameById(id)).withSelfRel().withTitle("Get this game"),
                linkTo(methodOn(GameController.class).getAll(null, null)).withRel("list").withTitle("List all games"),
                linkTo(methodOn(GameController.class).getGamesByGenre(genreId)).withRel("list").withTitle("Same genre "),
                linkTo(methodOn(GameController.class).getPlataformById(platformId)).withRel("list").withTitle("List all games")
        );
    }
      @GetMapping("/genres/{id}")
    public List<Game> getGamesByGenre(@PathVariable Long id) {
        return gameService.getGamesByGenreId(id);
    }

    @GetMapping("/platforms/{id}")
    public List<Game> getPlataformById(@PathVariable Long id) {
        return gameService.getGamesByGenreId(id);
    }  
    

}

