package GeorgeDavidDAM2.festify_api.service.impl;
import java.util.List;
import org.springframework.stereotype.Service;
import GeorgeDavidDAM2.festify_api.dto.response.ArtistResponse;
import GeorgeDavidDAM2.festify_api.service.ArtistService;
import java.util.ArrayList;

@Service    // Indica que esta clase es un servicio de Spring
public class ArtistServiceImpl implements ArtistService {

    private final List<ArtistResponse> artists = List.of(
        new ArtistResponse("ART-001", "Bad bunny", new String[]{"Trap","Reggaeton"}, "Puerto Rico" ,1000000,50,"activo"),
        new ArtistResponse("ART-002", "Dua Lipa", new String[]{"Pop","Dance"}, "Reino Unido" ,800000,30,"activo"),
        new ArtistResponse("ART-003", "Billie Eilish", new String[]{"Pop","Electropop"}, "Estados Unidos" ,900000,40,"inactivo")
    );

    @Override
    public List<ArtistResponse> listArtists() {
        return artists;
    }
}
