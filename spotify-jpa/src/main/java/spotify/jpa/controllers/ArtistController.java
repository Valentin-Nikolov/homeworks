package spotify.jpa.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import spotify.jpa.entities.Artist;
import spotify.jpa.entities.Song;
import spotify.jpa.services.impl.ArtistServiceImpl;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/spotify-jpa/artists")
public class ArtistController {

    @Autowired
    private ArtistServiceImpl artistService;

    public ArtistController(ArtistServiceImpl artistService) {
        this.artistService = artistService;
    }


    @PostMapping(value = "/add")
    public void addArtist(@RequestBody final Artist artist) {
        artistService.addArtist(artist);
    }

    @DeleteMapping(value = "/del/{id}")
	public void deleteArtist(@PathVariable final long id) {
        artistService.deleteArtist(id);
    };

    @GetMapping(value = "/get/{id}")
	public Optional<Artist> getArtist(@PathVariable final long id)  {
        return artistService.getArtist(id);
    };

    @GetMapping(value = "/get/all")
    public List<Artist> getAllArtists() {
        return (List<Artist>) artistService.getAllArtists();
    }

    @PutMapping(value = "/edit/{id}")
	public void updateArtist(@PathVariable final long id, @RequestBody final Artist artist) {
        artistService.updateArtist(id, artist);
    };

    @PostMapping(value = "/song/add")
    public void addSong(@RequestBody final Song song) {
        artistService.addSong(song);
    }

    @PutMapping(value = "/song/edit/{id}")
    public void updateSong(@PathVariable final long id, @RequestBody final Song song, @RequestBody final Artist artist) {
        artistService.updateSong(id, song, artist);
    };

    @DeleteMapping(value = "/song/del/{id}")
    public void deleteSong(@PathVariable final long id) {
        artistService.deleteSong(id);
    };
}
