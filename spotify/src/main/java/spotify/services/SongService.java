package spotify.services;

import spotify.repository.Song;

import java.util.List;

public interface SongService {

  void addSong(Song song);

  void deleteSong(long id);

  Song getSong(long id);

  List<Song> getAllSongs();

  void update(Song song);
}
