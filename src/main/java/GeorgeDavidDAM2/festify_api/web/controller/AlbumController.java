package GeorgeDavidDAM2.festify_api.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import GeorgeDavidDAM2.festify_api.dto.response.AlbumResponse;
import GeorgeDavidDAM2.festify_api.service.AlbumService;

@CrossOrigin(origins = "*")
@RestController

public class AlbumController {
    final private AlbumService albumService;

    @Autowired
    public AlbumController(AlbumService albumService) {
        this.albumService = albumService;
    }

    @GetMapping(path = "/artists/{id}/album")
    public List<AlbumResponse> listAlbums(@PathVariable Long id) {
        return albumService.listAlbums(id);
    }

}
