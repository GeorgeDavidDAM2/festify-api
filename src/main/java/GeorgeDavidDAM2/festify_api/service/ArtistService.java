package GeorgeDavidDAM2.festify_api.service;

import java.util.List;

import GeorgeDavidDAM2.festify_api.dto.request.CreateArtistRequest;
import GeorgeDavidDAM2.festify_api.dto.response.ArtistResponse;

public interface ArtistService {
    List<ArtistResponse> listArtists();

    ArtistResponse createArtist(CreateArtistRequest request);

    ArtistResponse getArtistById(String id);

    void deleteArtistById(String id);

    ArtistResponse updateArtist(String id, CreateArtistRequest request);

}