package music.tracker.controller.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import music.tracker.entity.Album;
import music.tracker.entity.Artist;
import music.tracker.entity.Genre;
import music.tracker.entity.Song;

import java.util.HashSet;
import java.util.Set;

@Data
@NoArgsConstructor
public class AlbumData {
    private Long albumId;
    private String albumName;

    private Artist artist;
    private Set<Genre> genres;
    private Set<Song> songs;

    public AlbumData(Album album) {
        albumId = album.getAlbumId();
        albumName = album.getAlbumName();
        artist = album.getArtist();
        genres = album.getGenres();
        songs = album.getSongs();
    }
}


