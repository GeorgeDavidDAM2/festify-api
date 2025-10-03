package GeorgeDavidDAM2.Service.impl;

import java.util.List;

import GeorgeDavidDAM2.Service.ArtistService;
import GeorgeDavidDAM2.festify_api.dto.response.ArtistResponse;

public class ArtistServiceImpl implements ArtistService {

    private final List<ArtistResponse> artists;

    public ArtistServiceImpl() {
        this.artists = List.of(
                new ArtistResponse("ART-001", "Bad bunny", List.of("Trap", "Hip Hop"), 1200, "Puerto Rico", 12),
                new ArtistResponse("ART-002", "Kid Keo", List.of("Trap"), 800, "España", 7));
    }

    @Override
    public List<ArtistResponse> listArtists() {

        return artists;
    }

}
