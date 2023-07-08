package music.tracker.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.HashSet;
import java.util.Set;

// This class represents an Artist and stores information about the artist such as id, name, and the genres they produce.
@Entity
@Data
public class Artist {
    // Primary key for the Artist
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long artistId;
    private String artistName;

    //Relationship between Albums and Artists one to many
    @EqualsAndHashCode.Exclude
    @OneToMany(mappedBy = "artist", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Album> albums = new HashSet<>();

    //Relationship between Genres and Artists many to many
    @EqualsAndHashCode.Exclude
    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "artists_genres",
            joinColumns = @JoinColumn(name = "artist_id"),
            inverseJoinColumns = @JoinColumn(name = "genre_id"))
    private Set<Genre> genres = new HashSet<>();

    // The one-to-many relationship between Artist and Songs, where each Song is linked to one Artist.
    @EqualsAndHashCode.Exclude
    @OneToMany(mappedBy = "artist", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Song> songs = new HashSet<>();
}
