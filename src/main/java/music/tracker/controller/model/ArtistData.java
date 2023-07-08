package music.tracker.controller.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import music.tracker.entity.Artist;

@Data
@NoArgsConstructor
public class ArtistData {
    private Long artistId;
    private String artistName;

    public ArtistData(Artist artist) {
        artistId = artist.getArtistId();
        artistName = artist.getArtistName();
    }
}

