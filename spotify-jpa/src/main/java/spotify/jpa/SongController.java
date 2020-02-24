package spotify.jpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/spotify-jpa/songs")
public class SongController {

    @Autowired
    private SongRepository repository;

    @PostMapping(value = "/add")
    public void addCustomer(@RequestBody final Song song) {
        repository.save(song);
    }

    @DeleteMapping(value = "/del/{id}")
	public void deleteSong(@PathVariable final long id) {
        repository.deleteById(id);
    };

    @GetMapping(value = "/get/{id}")
	public Optional<Song> getSong(@PathVariable final long id)  {
        return repository.findById(id);
    };

    @GetMapping(value = "/get/all")
    public List<Song> getAllSongs() {
        return (List<Song>) repository.findAll();
    }

    @PutMapping(value = "/edit/{id}")
	public void updateSong(@PathVariable final long id, @RequestBody final Song song) {
        repository.updateCustomer(id, song.getTitle(), song.getDateOfPublishing(), song.getDuration(), song.getArtistId());
    };

}
