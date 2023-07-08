package music.tracker.dao;

import music.tracker.entity.Artist;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArtistDao extends JpaRepository<Artist, Long> {
}
