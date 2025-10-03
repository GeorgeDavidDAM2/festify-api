package GeorgeDavidDAM2.Service;

import java.util.List;

import GeorgeDavidDAM2.festify_api.dto.response.ArtistResponse;

public interface ArtistService {
    List<ArtistResponse> listArtists();

}