package music.tracker.dao;

import music.tracker.entity.Song;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SongDao extends JpaRepository<Song, Long> {
}
