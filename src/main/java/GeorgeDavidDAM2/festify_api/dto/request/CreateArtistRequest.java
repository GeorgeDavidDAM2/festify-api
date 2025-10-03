package GeorgeDavidDAM2.festify_api.dto.request;

import java.util.List;

public record CreateArtistRequest(String id, String name, List<String> genre, long oyentes, String country,
        int festivales) {

}
