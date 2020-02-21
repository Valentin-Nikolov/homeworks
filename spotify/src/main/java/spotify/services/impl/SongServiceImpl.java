package spotify.services.impl;

import org.springframework.stereotype.Service;
import spotify.repository.Song;
import spotify.repository.SongRepository;
import spotify.services.SongService;

import java.util.List;

@Service
public class SongServiceImpl implements SongService {

    private final SongRepository songRepository;

    public SongServiceImpl(final SongRepository songRepository) {
        this.songRepository = songRepository;
    }

    @Override
    public void addSong(final Song song) {
        songRepository.add(song);
    }

    @Override
    public void deleteSong(final long id) {
        songRepository.delete(id);
    }

    @Override
    public Song getSong(final long id) {
        return songRepository.get(id);
    }

    @Override
    public List<Song> getAllSongs() {
        return songRepository.getAll();
    }

    @Override
    public void update(final Song song) {
        songRepository.update(song);
    }

}
