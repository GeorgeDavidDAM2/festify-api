package GeorgeDavidDAM2.festify_api.mapper;

import GeorgeDavidDAM2.festify_api.dto.response.ArtistResponse;
import GeorgeDavidDAM2.festify_api.persistence.jpa.entity.ArtistEntity;

public class ArtistMapper {

    private static final int DEFAULT_FESTIVALS = 0;
    public static ArtistResponse ArtistsToArtisResume(ArtistEntity artistEntity) {
        return new ArtistResponse(
                artistEntity.getId(),
                artistEntity.getName(),
                artistEntity.getGenres(),
                artistEntity.getListeners().intValue(),
                artistEntity.getCountry(),
                DEFAULT_FESTIVALS
        );
    }
}
