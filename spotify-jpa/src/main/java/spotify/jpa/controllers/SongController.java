package spotify.jpa.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import spotify.jpa.entities.Song;
import spotify.jpa.services.impl.SongServiceImpl;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/spotify-jpa/songs")
public class SongController {

    @Autowired
    private SongServiceImpl songService;

    public SongController(SongServiceImpl songService) {
        this.songService = songService;
    }

    @PostMapping(value = "/add")
    public void addSong(@RequestBody final Song song) {
        songService.addSong(song);
    }

    @DeleteMapping(value = "/del/{id}")
	public void deleteSong(@PathVariable final long id) {
        songService.deleteSong(id);
    };

    @GetMapping(value = "/get/{id}")
	public Optional<Song> getSong(@PathVariable final long id)  {
        return songService.getSong(id);
    };

    @GetMapping(value = "/get/all")
    public List<Song> getAllSongs() {
        return (List<Song>) songService.getAllSongs();
    }

    @PutMapping(value = "/edit/{id}")
	public void updateSong(@PathVariable final long id, @RequestBody final Song song) {
        songService.updateSong(id, song);
    };

}
