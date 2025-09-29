package GeorgeDavidDAM2.festify_api.web.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import GeorgeDavidDAM2.festify_api.dto.response.ArtistResponse;

@RestController  // Indica que esta clase es un controlador REST
public class ArtistaController {

    private List<ArtistResponse> artists = List.of(
        new ArtistResponse("ART-001", "Bad bunny", "Trap", "Puerto Rico") // Lista para almacenar los artistas inmutables
    ); 
    /* 
    private List<ArtistResponse> artists;
    public ArtistController() {
        this.artists = new ArrayList<>();
        this.artists.add(
            new ArtistResponse("ART-001","Bad Bunny", "Pop","España")
        );
    }
    */
    @GetMapping(path="/artists")  // Mapea las solicitudes GET a /artists , es decir, cuando alguien acceda a /artists se ejecutará este método
    public List<ArtistResponse> listArtists() {
        return artists;
    }
   
    
}
