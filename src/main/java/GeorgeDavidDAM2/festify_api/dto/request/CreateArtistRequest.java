package GeorgeDavidDAM2.festify_api.dto.request;

import java.util.List;

public record CreateArtistRequest(String name, List<String> genres, String country, long listeners, String estado,
        String biografia) {
}
