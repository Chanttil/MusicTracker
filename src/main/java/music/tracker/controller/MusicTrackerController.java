package music.tracker.controller;

import lombok.extern.slf4j.Slf4j;
import music.tracker.controller.model.AlbumData;
import music.tracker.controller.model.ArtistData;
import music.tracker.controller.model.GenreData;
import music.tracker.controller.model.SongData;
import music.tracker.service.MusicTrackerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// Controller for managing music tracking data
@RestController
@RequestMapping("/music_tracker")
@Slf4j
public class MusicTrackerController {
    @Autowired
    private MusicTrackerService musicTrackerService;

    // Method for inserting a new album
    @PostMapping("/album")
    @ResponseStatus(code = HttpStatus.CREATED)
    public AlbumData insertAlbum(@RequestBody AlbumData albumData) {
        log.info("Creating album with ID={}", albumData);
        MusicTrackerService musicTrackerService = new MusicTrackerService();
        return musicTrackerService.saveAlbum(albumData);
    }

    // Method for modifying an existing album
    @PutMapping("/album/{albumId}")
    public AlbumData modifyAlbum(@PathVariable Long albumId, @RequestBody AlbumData albumData) {
        albumData.setAlbumId(albumId);
        log.info("Updating album {}", albumData);
        MusicTrackerService musicTrackerService = new MusicTrackerService();
        return musicTrackerService.saveAlbum(albumData);
    }

    // Method for getting an album by its ID
    @GetMapping("/album/{albumId}")
    public AlbumData getAlbumByAlbumId(@PathVariable Long albumId) {
        log.info("Getting album with ID={}", albumId);
        MusicTrackerService musicTrackerService = new MusicTrackerService();
        AlbumData albumData = musicTrackerService.getAlbumByAlbumId(albumId);
        return albumData;
    }

    // Method for getting all albums
    @GetMapping("/album")
    public List<AlbumData> getAllAlbums() {
        return musicTrackerService.getAllAlbums();
    }

    // Method for deleting an album by ID
    @DeleteMapping("/album/{albumId}")
    public void deleteAlbumById(@PathVariable Long albumId) {
        log.info("Deleting album with ID={}", albumId);
        musicTrackerService.deleteAlbumById(albumId);
    }

    //method for inserting a new artist
    @PostMapping("/artist")
    @ResponseStatus(code = HttpStatus.CREATED)
    public ArtistData insertArtist(@RequestBody ArtistData artistData) {
        log.info("Creating artist with ID={}", artistData);
        musicTrackerService.saveArtist(artistData);
        return artistData;
    }

    //Method for modifying an existing artist
    @PutMapping("/artist/{artistId}")
    public ArtistData modifyArtist(@PathVariable Long artistId, @RequestBody ArtistData artistData) {
        artistData.setArtistId(artistId);
        log.info("Updating artist {}", artistData);
        MusicTrackerService musicTrackerService = new MusicTrackerService();
        return musicTrackerService.saveArtist(artistData);
    }

    //Method for getting artist by ID
    @GetMapping("/artist/{artistId}")
    public ArtistData getArtistByArtistId(@PathVariable Long artistId) {
        log.info("Getting artist with ID={}", artistId);
        MusicTrackerService musicTrackerService = new MusicTrackerService();
        ArtistData artistData = musicTrackerService.getArtistByArtistId(artistId);
        return artistData;
    }

    // Method for getting all artist
    @GetMapping("/artist")
    public List<ArtistData> getAllArtists() {
        return musicTrackerService.getAllArtists();
    }

    // Method for deleting an artist by ID
    @DeleteMapping("/artist/{artistId}")
    public void deleteArtistById(@PathVariable Long artistId) {
        log.info("Deleting artist with ID={}", artistId);
        musicTrackerService.deleteArtistById(artistId);
    }

    @PostMapping("/genre")
    @ResponseStatus(code = HttpStatus.CREATED)
    public GenreData insertGenre(@RequestBody GenreData genreData) {
        log.info("Creating genre with ID={}", genreData);
        musicTrackerService.saveGenre(genreData);
        return genreData;
    }

    @PutMapping("/genre/{genreId}")
    public GenreData modifyGenre(@PathVariable Long genreId, @RequestBody GenreData genreData) {
        genreData.setGenreId(genreId);
        log.info("Updating genre {}", genreData);
        MusicTrackerService musicTrackerService = new MusicTrackerService();
        return musicTrackerService.saveGenre(genreData);
    }

    @GetMapping("/genre/{genreId}")
    public GenreData getGenreByGenreId(@PathVariable Long genreId) {
        log.info("Getting genre with ID={}", genreId);
        MusicTrackerService musicTrackerService = new MusicTrackerService();
        GenreData genreData = musicTrackerService.getGenreByGenreId(genreId);
        return genreData;
    }

    @GetMapping("/genre")
    public List<GenreData> getAllGenres() {
        return musicTrackerService.getAllGenres();
    }

    @DeleteMapping("/genre/{genreId}")
    public void deleteGenreById(@PathVariable Long genreId) {
        log.info("Deleting genre with ID={}", genreId);
        musicTrackerService.deleteGenreById(genreId);
    }

    @PostMapping("/song")
    @ResponseStatus(code = HttpStatus.CREATED)
    public SongData insertSong(@RequestBody SongData songData) {
        log.info("Creating song with ID={}", songData);
        musicTrackerService.saveSong(songData);
        return songData;
    }

    @PutMapping("/song/{songId}")
    public SongData modifySong(@PathVariable Long songId, @RequestBody SongData songData) {
        songData.setSongId(songId);
        log.info("Updating song {}", songData);
        MusicTrackerService musicTrackerService = new MusicTrackerService();
        return musicTrackerService.saveSong(songData);
    }

    @GetMapping("/song/{songId}")
    public SongData getSongBySongId(@PathVariable Long songId) {
        log.info("Getting song with ID={}", songId);
        MusicTrackerService musicTrackerService = new MusicTrackerService();
        SongData songData = musicTrackerService.getSongBySongId(songId);
        return songData;
    }

    @GetMapping("/song")
    public List<SongData> getAllSongs() {
        return musicTrackerService.getAllSongs();
    }

    @DeleteMapping("/song/{songId}")
    public void deleteSongById(@PathVariable Long songId) {
        log.info("Deleting song with ID={}", songId);
        musicTrackerService.deleteSongById(songId);
    }
}



