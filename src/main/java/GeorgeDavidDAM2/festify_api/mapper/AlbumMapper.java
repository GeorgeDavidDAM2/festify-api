package GeorgeDavidDAM2.festify_api.mapper;

import GeorgeDavidDAM2.festify_api.dto.response.AlbumResponse;
import GeorgeDavidDAM2.festify_api.persistence.jpa.entity.AlbumEntity;

public class AlbumMapper {

    public static AlbumResponse AlbumToAlbumResume(AlbumEntity albumEntity) {
        return new AlbumResponse(
                albumEntity.getId(),
                albumEntity.getArtistId(),
                albumEntity.getTitle(),
                albumEntity.getReleaseDate(),
                albumEntity.getTracksCount(),
                albumEntity.getDurationSeconds());
    }
}
