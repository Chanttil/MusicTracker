package music.tracker.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;

//This entity class is used to represent a Song object which will be given a unique id when saved to the database
@Entity
@Data
public class Song {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long songId;
    private String songName;

    //This is a many-to-one relationship linking the Song entity to the Album entity
    @ManyToOne
    @JoinColumn(name="album_id")
    private Album album;

    //This is a many-to-one relationship linking the Song entity to the Artist entity
    @ManyToOne
    @JoinColumn(name="artist_id")
    private Artist artist;

    //This is a many-to-many relationship linking the Song entity to the Genre entity through an intermediate table
    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(
            name = "song_genre",
            joinColumns = @JoinColumn(name = "song_id"),
            inverseJoinColumns = @JoinColumn(name = "genre_id")
    )
    private Set<Genre> genres = new HashSet<>();
}