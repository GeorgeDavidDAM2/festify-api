package GeorgeDavidDAM2.festify_api.web.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import GeorgeDavidDAM2.festify_api.dto.request.CreateArtistRequest;
import GeorgeDavidDAM2.festify_api.dto.response.ArtistResponse;
import GeorgeDavidDAM2.festify_api.service.ArtistService;
import jakarta.validation.Valid;

@CrossOrigin(origins = "*")

@RestController // Indica que esta clase es un controlador REST
public class ArtistaController {

    final private ArtistService artistService;

    @Autowired
    public ArtistaController(ArtistService artistService) {
        this.artistService = artistService;
    }

    @GetMapping(path = "/artists") // Mapea las solicitudes GET a /artists , es decir, cuando alguien acceda a
                                   // /artists se ejecutará este método
    public List<ArtistResponse> listArtists() {
        return artistService.listArtists();
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/artists")
    public ArtistResponse createArtist(@Valid @RequestBody CreateArtistRequest request) {
        return this.artistService.createArtist(request);
    }
}
