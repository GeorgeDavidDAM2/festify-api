package GeorgeDavidDAM2.festify_api.mapper;

import GeorgeDavidDAM2.festify_api.dto.request.CreateArtistRequest;
import GeorgeDavidDAM2.festify_api.dto.response.ArtistResponse;
import GeorgeDavidDAM2.festify_api.dto.response.ArtistsDetailResponse;
import GeorgeDavidDAM2.festify_api.persistence.jpa.entity.ArtistEntity;

public class ArtistMapper {

    public static ArtistResponse ArtistsToArtisResume(ArtistEntity artistEntity) {
        return new ArtistResponse(
                "ART-" + artistEntity.getId(),
                artistEntity.getName(),
                artistEntity.getGenres(),
                artistEntity.getCountry(),
                artistEntity.getListeners(),
                artistEntity.getStatus());
    }

    public static ArtistsDetailResponse ArtistsDetailResponse(ArtistEntity artistEntity) {
        return new ArtistsDetailResponse(
                "ART-" + artistEntity.getId(),
                artistEntity.getName(),
                artistEntity.getGenres(),
                artistEntity.getCountry(),
                artistEntity.getListeners(),
                artistEntity.getStatus(),
                artistEntity.getBiography());
    }

    public static ArtistEntity CreateArtistRequestToArtistEntity(CreateArtistRequest request) {
        ArtistEntity artistEntity = new ArtistEntity();
        artistEntity.setName(request.name());
        artistEntity.setGenres(request.genres());
        artistEntity.setCountry(request.country());
        artistEntity.setListeners((int) request.listeners());
        artistEntity.setStatus(request.status());
        artistEntity.setBiography(request.biography());

        return artistEntity;
    }
}
