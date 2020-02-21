package spotify.rest;

import org.springframework.web.bind.annotation.*;
import spotify.repository.Song;
import spotify.services.SongService;

import java.util.List;

@RestController
@RequestMapping("/spotify/song")
public class SongController {

  private final SongService songService;

  public SongController(final SongService customerService, SongService songService) {
    this.songService = songService;
  }

  @PostMapping("/add")
  public void addSong(@RequestBody final Song customer) {
    songService.addSong(customer);
  }

  @DeleteMapping("/delete/{id}")
  public void deleteSong(@PathVariable final long id) {
    songService.deleteSong(id);
  }

  @GetMapping("/get/{id}")
  public Song getSong(@PathVariable final long id) {
    return songService.getSong(id);
  }

  @GetMapping("/get/all")
  public List<Song> getAllSongs() {
    return songService.getAllSongs();
  }

  @PutMapping("/edit")
  public void updateSong(@RequestBody final Song customer) {
    songService.update(customer);
  }
}
