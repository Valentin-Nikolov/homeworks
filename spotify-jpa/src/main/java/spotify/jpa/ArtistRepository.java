package spotify.jpa;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

@Repository
public interface ArtistRepository extends CrudRepository<Artist, Long> {

    @Transactional
    @Modifying
    @Query(value = "update artists set first_name = :first_name, " +
            "last_name = :last_name, " +
            "date_of_birth = :date_of_birth, " +
            "genre = :genre " +
            "WHERE id = :id", nativeQuery = true)
    void updateArtist(@Param("id") Long id,
                         @Param("first_name") String first_name,
                         @Param("last_name") String last_name,
                         @Param("date_of_birth") Date date_of_birth,
                         @Param("genre") String genre);
}