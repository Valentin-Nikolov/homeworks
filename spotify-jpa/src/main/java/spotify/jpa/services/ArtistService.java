package spotify.jpa.services;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import spotify.jpa.entities.Artist;
import spotify.jpa.entities.Customer;
import spotify.jpa.entities.Song;

import java.util.List;
import java.util.Optional;

public interface ArtistService {

    void addArtist(final Artist artist);

    public void deleteArtist(final long id);

    Optional<Artist> getArtist(final long id);

    List<Artist> getAllArtists();

    void updateArtist(final long id, final Artist artist);

    public void addSong(final Song song);

    public void updateSong(final long id, final Song song, Artist artist);

    public void deleteSong(final long id);
}
