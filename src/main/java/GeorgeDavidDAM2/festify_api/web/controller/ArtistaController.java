package GeorgeDavidDAM2.festify_api.web.controller;

import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;

import GeorgeDavidDAM2.festify_api.dto.response.ArtistResponse;
import GeorgeDavidDAM2.festify_api.service.ArtistService;

@RestController // Indica que esta clase es un controlador REST
public class ArtistaController {
    private ArtistService artistService;

    @Autowired
    public ArtistaController(ArtistService artistService) {
        this.artistService = artistService;
    }

    @GetMapping(path = "/artists") // Mapea las solicitudes GET a /artists , es decir, cuando alguien acceda a
                                   // /artists se ejecutará este método
    public List<ArtistResponse> listArtists() {
        return artistService.listArtists();
    }

    /*
     * @GetMapping("/artists/{id}")
     * public ArtistResponse getArtistById(@PathVariable String id) {
     * return artists.stream()
     * .filter(a -> a.id().equals(id))
     * .findFirst()
     * .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
     * "Artista no encontrado"));
     * }
     */
}
