package fiap.gamefinder.gamefinder.domain;

import java.time.LocalDate;

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
}
