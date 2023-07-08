package music.tracker.dao;

import music.tracker.entity.Album;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlbumDao extends JpaRepository<Album, Long> {
}
