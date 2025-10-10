package GeorgeDavidDAM2.festify_api.dto.request;

import java.util.List;

public record CreateArtistRequest(String name, List<String> genre, String country, long oyentes, String estado,
                String biografia) {
}
