package GeorgeDavidDAM2.festify_api.web.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import GeorgeDavidDAM2.festify_api.dto.request.CreateArtistRequest;
import GeorgeDavidDAM2.festify_api.dto.response.ArtistResponse;
import GeorgeDavidDAM2.festify_api.service.ArtistService;

@RestController  // Indica que esta clase es un controlador REST
public class ArtistaController{ // Implementa la interfaz ArtistService
    /*
    private List<ArtistResponse> artists = List.of(
        new ArtistResponse("ART-001", "Bad bunny", "Trap", "Puerto Rico") // Lista para almacenar los artistas inmutables
    ); 
    */
     // Inyección de dependencias
    private final ArtistService artistService;  //creamos una variable de tipo ArtistService que es la interfaz

    //private List<ArtistResponse> artists;

    public ArtistaController(ArtistService artistService) {  // Inyección de dependencias a través del constructor
        this.artistService = artistService;
       /*  this.artists = new ArrayList<>();
        this.artists.add(
            new ArtistResponse("ART-1","Bad Bunny", new String[]{"Pop","Trap"},"España",1000000, 25,"Activo")
        );
        this.artists.add(
            new ArtistResponse("ART-2","Box Bunny", new String[]{"Dibujos"},"USA",500000, 10,"Inactivo")
        );
        */
    }

    
    @GetMapping(path="/artists")  // Mapea las solicitudes GET a /artists , es decir, cuando alguien acceda a /artists se ejecutará este método
    public List<ArtistResponse> listArtists() {
        return artistService.listArtists(); // Devuelve la lista de artistas
    }
    /* 
   @GetMapping(path="/artists/{id}")  // Mapea las solicitudes GET a /artists/{id} , es decir, cuando alguien acceda a /artists/ART-001 se ejecutará este método
   public ArtistResponse getArtistById(@PathVariable String id) { // PathVariable indica que el valor de id se obtiene de la URL
        return artists.stream() // Stream es una secuencia de elementos que se pueden procesar de manera funcional
            .filter(artist -> artist.id().equals(id)) // Filtra los artistas que tienen el id igual al id pasado por la URL
            .findFirst() // Devuelve el primer artista que cumple la condición del filtro
            .orElseThrow(() -> new RuntimeException("Artist not found")); // Si no encuentra ningún artista, lanza una excepción
    }
    */
     
    @GetMapping(path="/artists/{id}")  // Mapea las solicitudes GET a /artists/{id} , es decir, cuando alguien acceda a /artists/ART-001 se ejecutará este método
    public ArtistResponse getArtistById(@PathVariable String id) { // PathVariable indica que el valor de id se obtiene de la URL
        for (ArtistResponse artist : artistService.listArtists()) { // Recorre la lista de artistas
            if (artist.id().equals(id)) { // Si el id del artista es igual al id pasado por la URL
                return artist; // Devuelve el artista
            }
        }
        return null; // Si no encuentra ningún artista, devuelve null 
    }
    
    @PostMapping(path="/artists")  // Mapea las solicitudes POST a /artists , es decir, cuando alguien acceda a /artists se ejecutará este método
    public List<ArtistResponse> createArtist(@RequestBody CreateArtistRequest request){
        String id="ART-" + (artistService.listArtists().size()+1); //sumamos 1 al tamaño de la lista para que el id sea unico
        ArtistResponse artist = new ArtistResponse(
            id, //aqui pongo el id que he creado arriba
            request.name(), 
            request.genre(),
            request.country(),
            request.oyentes(),
            request.festivales(),
            request.estado()
        );

        artistService.listArtists().add(artist);

        return artistService.listArtists(); // Devuelve la lista de artistas actualizada
        //he encontrado un metodo request, que seriviria para crear un artista con los datos que le pasas
        //luego en el postman debemos ir al body e introducir los parametros en tipo json
    }
}
