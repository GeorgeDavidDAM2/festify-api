package GeorgeDavidDAM2.festify_api.service;
import java.util.List;
import GeorgeDavidDAM2.festify_api.dto.response.ArtistResponse;

public interface ArtistService { //injection de dependencias
    List<ArtistResponse> listArtists();
}
