package GeorgeDavidDAM2.festify_api.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import GeorgeDavidDAM2.festify_api.dto.response.AlbumResponse;
import GeorgeDavidDAM2.festify_api.persistence.jpa.entity.repository.AlbumJpaRepository;
import GeorgeDavidDAM2.festify_api.service.AlbumService;

@Service
public class AlbumServiceImpl implements AlbumService {

    @Override
    public List<AlbumResponse> listAlbums(Long id) {
        return albumJpaRepository.findByArtistId(id)
                .stream()
                .map(albumEntity -> new AlbumResponse(
                        albumEntity.getId(),
                        albumEntity.getArtistId(),
                        albumEntity.getTitle(),
                        albumEntity.getReleaseDate(),
                        albumEntity.getTracksCount(),
                        albumEntity.getDurationSeconds()))
                .toList();

    }

    final private AlbumJpaRepository albumJpaRepository;

    @Autowired
    public AlbumServiceImpl(AlbumJpaRepository albumJpaRepository) {
        this.albumJpaRepository = albumJpaRepository;
    }

}
