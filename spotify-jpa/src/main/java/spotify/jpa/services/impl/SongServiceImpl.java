package spotify.jpa.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spotify.jpa.entities.Artist;
import spotify.jpa.entities.Song;
import spotify.jpa.repositories.SongRepository;
import spotify.jpa.services.SongService;

import java.util.List;
import java.util.Optional;

@Service
public class SongServiceImpl implements SongService {

    @Autowired
    private SongRepository repository;


    public SongServiceImpl(SongRepository repository) {
        this.repository = repository;
    }


    @Override
    public void addSong(final Song song) {
        repository.save(song);
    }

    @Override
    public void deleteSong(final long id) {
        repository.deleteById(id);
    }

    @Override
    public Optional<Song> getSong(final long id) {
        return repository.findById(id);
    }

    @Override
    public List<Song> getAllSongs() {
        return (List<Song>) repository.findAll();
    }

    @Override
    public void updateSong(final long id, final Song song) {
        repository.updateSong(id, song.getTitle(), song.getDateOfPublishing(),
                song.getDuration(), song.getArtist().getId());
    }
}
