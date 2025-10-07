package GeorgeDavidDAM2.festify_api.mapper;

import GeorgeDavidDAM2.festify_api.dto.response.ArtistResponse;
import GeorgeDavidDAM2.festify_api.persistence.jpa.entity.ArtistEntity;

public class ArtistMapper {

    private static final int DEFAULT_FESTIVALS = 0;
    //private static final String DEFAULT_ARTIST_IMG = "https://images.stockcake.com/public/d/c/5/dc531c69-8802-4f3c-a147-0cad55b8c1aa_large/singer-performing-passionately-stockcake.jpg";
    public static ArtistResponse toArtistDetailResponse(ArtistEntity e) {
        return new ArtistResponse(
                e.getId(),
                e.getName(),
                e.getGenres(),
                e.getListeners().intValue(),
                e.getCountry(),
                DEFAULT_FESTIVALS
        );
    }
}
