package spotify.rest;

import org.springframework.web.bind.annotation.*;
import spotify.repository.Artist;
import spotify.repository.Song;
import spotify.services.ArtistService;

import java.util.List;

@RestController
@RequestMapping("/spotify/artist")
public class ArtistController {

  private final ArtistService artistService;

  public ArtistController(final ArtistService artistService) {
    this.artistService = artistService;
  }

  @PostMapping("/add")
  public void addArtist(@RequestBody final Artist artist) {
    artistService.addArtist(artist);
  }

  @DeleteMapping("/delete/{id}")
  public void deleteArtist(@PathVariable final long id) {
    artistService.deleteArtist(id);
  }

  @GetMapping("/get/{id}")
  public Artist getArtist(@PathVariable final long id) {
    return artistService.getArtist(id);
  }

  @GetMapping("/get/all")
  public List<Artist> getAllArtists() {
    return artistService.getAllArtists();
  }

  @PutMapping("/edit")
  public void updateArtist(@RequestBody final Artist artist) {
    artistService.update(artist);
  }

  @PostMapping("/add/song")
  public void addSong(@RequestBody final Song song) {
    artistService.addSong(song);
  }

  @PutMapping("/edit/song")
  public void editSong(@RequestBody final Song song) {
    artistService.update(song);
  }

  @DeleteMapping("/delete/song/{id}")
  public void deleteSong(@PathVariable final long id) {
    artistService.deleteSong(id);
  }
}
