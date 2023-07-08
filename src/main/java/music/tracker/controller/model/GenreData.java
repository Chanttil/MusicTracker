package music.tracker.controller.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import music.tracker.entity.Genre;

//GenreData class for genre id and name
@Data
@NoArgsConstructor
public class GenreData {
    private Long genreId;
    private String genreName;

    public GenreData(Genre genre) {
        this.genreId = genre.getGenreId();
        this.genreName = genre.getGenreName();
    }

}
