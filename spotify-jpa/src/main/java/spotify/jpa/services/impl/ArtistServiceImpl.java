package spotify.jpa.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spotify.jpa.entities.Artist;
import spotify.jpa.entities.Song;
import spotify.jpa.repositories.ArtistRepository;
import spotify.jpa.repositories.SongRepository;
import spotify.jpa.services.ArtistService;

import java.util.List;
import java.util.Optional;

@Service
public class ArtistServiceImpl implements ArtistService {

    @Autowired
    private ArtistRepository repository;
    @Autowired
    private SongRepository songRepository;

    public ArtistServiceImpl(ArtistRepository repository, SongRepository songRepository) {
        this.repository = repository;
        this.songRepository = songRepository;
    }


    @Override
    public void addArtist(final Artist artist) {
        repository.save(artist);
    }

    @Override
    public void deleteArtist(final long id) {
        repository.deleteById(id);
    }

    @Override
    public Optional<Artist> getArtist(final long id) {
        return repository.findById(id);
    }

    @Override
    public List<Artist> getAllArtists() {
        return (List<Artist>) repository.findAll();
    }

    @Override
    public void updateArtist(final long id, final Artist artist) {
        repository.updateArtist(id, artist.getFirstName(), artist.getLastName(),
                artist.getDateOfBirth(), artist.getGenre());
    }

    @Override
    public void addSong(final Song song) {
        songRepository.save(song);
    }

    @Override
    public void updateSong(final long id, final Song song, final Artist artist) {
        songRepository.updateSong(id, song.getTitle(), song.getDateOfPublishing(),
                song.getDuration(), artist.getId());
    }

    @Override
    public void deleteSong(final long id) {
        songRepository.deleteById(id);
    }
}
