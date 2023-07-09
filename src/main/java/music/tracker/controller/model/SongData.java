package music.tracker.controller.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import music.tracker.entity.Album;
import music.tracker.entity.Artist;
import music.tracker.entity.Genre;
import music.tracker.entity.Song;

import java.util.HashSet;
import java.util.NoSuchElementException;
import java.util.Set;

//SongData class for song title, genre name, and a set of GenreData objects
@Data
@NoArgsConstructor
public class SongData {
    private Long songId;
    private String songName;
    

    public SongData(Song song) {
        songId = song.getSongId();
        songName = song.getSongName();
    }
}


