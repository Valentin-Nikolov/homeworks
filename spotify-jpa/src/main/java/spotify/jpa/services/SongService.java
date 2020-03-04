package spotify.jpa.services;

import spotify.jpa.entities.Song;

import java.util.List;
import java.util.Optional;

public interface SongService {

    void addSong(final Song song);

    void deleteSong(final long id);

    Optional<Song> getSong(final long id);

    List<Song> getAllSongs();

    void updateSong(final long id, final Song song);
}
