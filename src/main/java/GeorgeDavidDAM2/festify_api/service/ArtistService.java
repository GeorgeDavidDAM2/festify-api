package GeorgeDavidDAM2.festify_api.service;
import java.util.List;

import org.springframework.stereotype.Service;

import GeorgeDavidDAM2.festify_api.dto.response.ArtistResponse;
import java.util.ArrayList;


public interface ArtistService { //injection de dependencias
    List<ArtistResponse> listArtists();
    
}
