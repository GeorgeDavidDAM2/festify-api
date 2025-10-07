package GeorgeDavidDAM2.festify_api.dto.response;

import java.util.List;

public record ArtistResponse(Long id, String name, List<String> genre, Integer oyentes, String country, Integer festivales) {

}
