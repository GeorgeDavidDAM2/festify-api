package GeorgeDavidDAM2.festify_api.service;

import java.util.List;

import GeorgeDavidDAM2.festify_api.dto.response.AlbumResponse;

public interface AlbumService {
    List<AlbumResponse> listAlbums(Long id);

    AlbumResponse getAlbumsById(Long id);
}
