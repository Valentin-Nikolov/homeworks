package spotify.services;

import spotify.repository.Artist;
import spotify.repository.Song;

import java.util.List;

public interface ArtistService {

  void addArtist(Artist artist);

  void deleteArtist(long id);

  Artist getArtist(long id);

  List<Artist> getAllArtists();

  void update(Artist artist);

  void addSong(Song song);

  void update(Song song);

  void deleteSong(long id);
}
