package GeorgeDavidDAM2.festify_api.dto.response;

import java.sql.Date;

public record AlbumResponse(Long getId, Long artistId, String title, Date releaseDate, Integer tracksCount,
        Integer durationSeconds) {
}
