package GeorgeDavidDAM2.festify_api.dto.response;

import java.util.List;

public record ArtistResponse(String id, String name, List<String> genre, long oyentes, String country, int festivales) {

}
