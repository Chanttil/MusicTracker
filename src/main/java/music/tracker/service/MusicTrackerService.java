package music.tracker.service;

import music.tracker.controller.model.AlbumData;
import music.tracker.controller.model.ArtistData;
import music.tracker.controller.model.GenreData;
import music.tracker.controller.model.SongData;
import music.tracker.dao.AlbumDao;
import music.tracker.dao.ArtistDao;
import music.tracker.dao.GenreDao;
import music.tracker.dao.SongDao;
import music.tracker.entity.Album;
import music.tracker.entity.Artist;
import music.tracker.entity.Genre;
import music.tracker.entity.Song;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

// MusicTrackerService provides methods to create, get, and delete Albums, Genres, Artist, Songs and their associated data
@Service
public class MusicTrackerService {
    @Autowired
    private AlbumDao albumDao;

    @Autowired
    private ArtistDao artistDao;

    @Autowired
    private GenreDao genreDao;

    @Autowired
    private SongDao songDao;

    // saves an album to the database
    public AlbumData saveAlbum(AlbumData albumData) {
        Long albumId = albumData.getAlbumId();
        Album album = findOrCreateAlbum(albumId);

        copyAlbumFields(album, albumData);
        return new AlbumData(albumDao.save(album));
    }

    // retrieves an album from the database
    @Transactional(readOnly = true)
    public AlbumData getAlbumByAlbumId(Long albumId) {
        Album album = albumDao.findById(albumId).orElseThrow(NoSuchElementException::new);
        return new AlbumData(album);
    }

    // retrieves all albums from the database
    @Transactional(readOnly = true)
    public List<AlbumData> getAllAlbums() {
        List<Album> albums = albumDao.findAll();
        List<AlbumData> albumData = new LinkedList<>();
        for (Album album : albums) {
            albumData.add(new AlbumData(album));
        }
        return albumData;
    }

    // deletes an album from the database
    @Transactional(readOnly = false)
    public void deleteAlbumById(Long albumId) {
        albumDao.deleteById(albumId);
    }

    // finds album in the database or creates a new album if no album is found
    private Album findOrCreateAlbum(Long albumId) {
        if (Objects.nonNull(albumId)) {
            return albumDao.findById(albumId).orElseThrow(NoSuchElementException::new);
        }
        return new Album();
    }

    // copies field variables for an album in the albumData object to the album
    public void copyAlbumFields(Album album, AlbumData albumData) {
        album.setAlbumName(albumData.getAlbumName());
        album.setArtist(albumData.getArtist());
        album.setGenres(albumData.getGenres());
        album.setSongs(albumData.getSongs());
    }
    public ArtistData saveArtist(ArtistData artistData) {
        Long artistId = artistData.getArtistId();
        Artist artist = findOrCreateArtist(artistId);

        copyArtistFields(artist, artistData);

        return new ArtistData(artistDao.save(artist));
    }
    private Artist findOrCreateArtist(Long artistId) {
        Artist artist;

        if (Objects.isNull(artistId)) {
            artist = new Artist();
        } else {
            artist = findArtistById( artistId);
        }
        return artist;
    }
    public Artist findArtistById(Long artistId) {
        Artist artist = artistDao.findById(artistId).orElseThrow(() -> new NoSuchElementException(
                "Artist with ID=" + artistId + " does not exist."));
        return artist;
    }
    private void copyArtistFields(Artist artist, ArtistData artistData) {
        artist.setArtistId(artistData.getArtistId());
        artist.setArtistName(artistData.getArtistName());
    }

    public List<ArtistData> getAllArtists() {
        List<ArtistData> artistDataList = new ArrayList<>();
        List<Artist> artistList = artistDao.findAll();

        for (Artist artist : artistList) {
            artistDataList.add(new ArtistData(artist));
        }
        return artistDataList;
    }
    public ArtistData getArtistByArtistId(Long artistId) {
        Artist artist = artistDao.findById(artistId).orElseThrow(NoSuchElementException::new);
        return new ArtistData(artist);
    }

    public void deleteArtistById(Long artistId) {
        artistDao.deleteById(artistId);
    }

    @Transactional(readOnly = false)
    public GenreData saveGenre(GenreData genreData) {
        Long genreId = genreData.getGenreId();
        Genre genre = findOrCreateGenre(genreId);

        copyGenreFields(genre, genreData);
        return new GenreData(genreDao.save(genre));
    }

    @Transactional(readOnly = true)
    public GenreData getGenreByGenreId(Long genreId) {
        Genre genre = genreDao.findById(genreId).orElseThrow(NoSuchElementException::new);
        return new GenreData(genre);
    }

    @Transactional(readOnly = true)
    public List<GenreData> getAllGenres() {
        List<Genre> genres = genreDao.findAll();
        List<GenreData> genreDatas = new LinkedList<>();
        for (Genre genre : genres) {
            genreDatas.add(new GenreData(genre));
        }
        return genreDatas;
    }

    @Transactional(readOnly = false)
    public void deleteGenreById(Long genreId) {
        genreDao.deleteById(genreId);
    }

    private Genre findOrCreateGenre(Long genreId) {
        if (Objects.nonNull(genreId)) {
            return genreDao.findById(genreId).orElseThrow(NoSuchElementException::new);
        }
        return new Genre();
    }

    private void copyGenreFields(Genre genre, GenreData genreData) {
        genre.setGenreId(genreData.getGenreId());
        genre.setGenreName(genreData.getGenreName());
    }
    public SongData saveSong(SongData songData) {
        Long songId = songData.getSongId();
        Song song = findOrCreateSong(songId);

        copySongFields(song, songData);
        return new SongData(songDao.save(song));
    }

    @Transactional(readOnly = true)
    public SongData getSongBySongId(Long songId) {
        Song song = songDao.findById(songId).orElseThrow(NoSuchElementException::new);
        return new SongData(song);
    }

    @Transactional(readOnly = true)
    public List<SongData> getAllSongs() {
        List<Song> songs = songDao.findAll();
        List<SongData> songData = new LinkedList<>();
        for (Song song : songs) {
            songData.add(new SongData(song));
        }
        return songData;
    }

    @Transactional(readOnly = false)
    public void deleteSongById(Long songId) {
        songDao.deleteById(songId);
    }

    private Song findOrCreateSong(Long songId) {
        if (Objects.nonNull(songId)) {
            return songDao.findById(songId).orElseThrow(NoSuchElementException::new);
        }
        return new Song();
    }


    public void copySongFields(Song song, SongData songData) {
        song.setSongName(songData.getSongName());
        song.setAlbum(songData.getAlbum());
        song.setArtist(songData.getArtist());
        song.setGenres(songData.getGenres());
    }

}
