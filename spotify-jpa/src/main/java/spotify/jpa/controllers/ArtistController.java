package spotify.jpa.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import spotify.jpa.entities.Artist;
import spotify.jpa.entities.Song;
import spotify.jpa.repositories.ArtistRepository;
import spotify.jpa.repositories.SongRepository;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/spotify-jpa/artists")
public class ArtistController {

    @Autowired
    private ArtistRepository repository;
    @Autowired
    private SongRepository songRepository;

    @PostMapping(value = "/add")
    public void addArtist(@RequestBody final Artist artist) {
        repository.save(artist);
    }

    @DeleteMapping(value = "/del/{id}")
	public void deleteArtist(@PathVariable final long id) {
        repository.deleteById(id);
    };

    @GetMapping(value = "/get/{id}")
	public Optional<Artist> getArtist(@PathVariable final long id)  {
        return repository.findById(id);
    };

    @GetMapping(value = "/get/all")
    public List<Artist> getAllArtists() {
        return (List<Artist>) repository.findAll();
    }

    @PutMapping(value = "/edit/{id}")
	public void updateArtist(@PathVariable final long id, @RequestBody final Artist artist) {
        repository.updateArtist(id, artist.getFirstName(), artist.getLastName(),
                artist.getDateOfBirth(), artist.getGenre());
    };

    @PostMapping(value = "/song/add")
    public void addSong(@RequestBody final Song song) {
        songRepository.save(song);
    }

    @PutMapping(value = "/song/edit/{id}")
    public void updateSong(@PathVariable final long id, @RequestBody final Song song) {
        songRepository.updateSong(id, song.getTitle(), song.getDateOfPublishing(),
                song.getDuration(), song.getArtistId());
    };

    @DeleteMapping(value = "/song/del/{id}")
    public void deleteSong(@PathVariable final long id) {
        songRepository.deleteById(id);
    };
}
