package GeorgeDavidDAM2.festify_api.mapper;

import GeorgeDavidDAM2.festify_api.dto.response.ArtistResponse;
import GeorgeDavidDAM2.festify_api.persistence.jpa.entity.ArtistEntity;

public class ArtistMapper {

    public static ArtistResponse ArtistsToArtisResume(ArtistEntity artistEntity) {
        return new ArtistResponse(
                "ART-" + artistEntity.getId(),
                artistEntity.getName(),
                artistEntity.getCountry(),
                artistEntity.getGenres(),
                artistEntity.getListeners());
    }
}
