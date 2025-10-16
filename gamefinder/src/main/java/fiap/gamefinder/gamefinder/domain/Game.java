package fiap.gamefinder.gamefinder.domain;

import java.time.LocalDate;

import org.springframework.hateoas.EntityModel;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import fiap.gamefinder.gamefinder.controller.GameController;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Game {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String description;

    private LocalDate releaseDate;

    private Double rating;

    @ManyToOne
    private Genre genre;

    @ManyToOne
    private Platform platform;

    private String coverUrl;

    private String backdropUrl;

    private boolean inWishlist;

    public EntityModel<Game> ToEntityModel(){
        return EntityModel.of(this,
                linkTo(methodOn(GameController.class).getGameById(id)).withSelfRel().withTitle(this.getTitle())
                //linkTo(methodOn(GameController.class).getAll(null, null)).withTitle("Games in " + this.getGenre()).withRel("list").withTitle("List all games"),
                //linkTo(methodOn(GameController.class).getGamesByGenre(this.getGenre().getId()))withTitle("Games in " + this.getTitle()).withRel("list").withTitle("Same genre "),
                //linkTo(methodOn(GameController.class).getPlataformById(this.getPlatform().getId()))withTitle().withRel("list").withTitle("List all games")
        );
    }    
}
