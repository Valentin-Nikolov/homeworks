package spotify.services.impl;

import org.springframework.stereotype.Service;

import spotify.repository.Artist;
import spotify.repository.ArtistRepository;
import spotify.repository.Song;
import spotify.repository.SongRepository;
import spotify.services.ArtistService;

import java.util.List;

@Service
public class ArtistServiceImpl implements ArtistService {

    private final ArtistRepository artistRepository;
    private final SongRepository songRepository;

    public ArtistServiceImpl(final ArtistRepository artistRepository, final SongRepository songRepository) {
        this.artistRepository = artistRepository;
        this.songRepository = songRepository;
    }

    @Override
    public void addArtist(final Artist artist) {
        artistRepository.add(artist);
    }

    @Override
    public void deleteArtist(final long id) {
        artistRepository.delete(id);
    }

    @Override
    public Artist getArtist(final long id) {
        return artistRepository.get(id);
    }

    @Override
    public List<Artist> getAllArtists() {
        return artistRepository.getAll();
    }

    @Override
    public void update(final Artist artist) {
        artistRepository.update(artist);
    }

    @Override
    public void addSong(Song song) {
        songRepository.add(song);
    }

    @Override
    public void update(Song song) {
        songRepository.update(song);
    }

    @Override
    public void deleteSong(long id) {
        songRepository.delete(id);
    }
}
