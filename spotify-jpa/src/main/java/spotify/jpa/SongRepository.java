package spotify.jpa;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Date;

@Repository
public interface SongRepository extends CrudRepository<Song, Long> {

    @Transactional
    @Modifying
    @Query(value = "update songs set title = :title, " +
            "date_of_publishing = :date_of_publishing, " +
            "duration = :duration " +
            "artist_id = :artist_id " +
            "WHERE id = :id", nativeQuery = true)
    void updateSong(@Param("id") Long id,
                        @Param("title") String title,
                        @Param("date_of_publishing") Date date_of_publishing,
                        @Param("duration") int duration,
                        @Param("artist_id") long artist_id);

    @Query(value = "select title from songs where id = :id", nativeQuery = true)
    String playSong(@Param("id") long id);
}