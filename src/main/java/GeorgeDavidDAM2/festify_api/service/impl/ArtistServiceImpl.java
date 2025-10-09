package GeorgeDavidDAM2.festify_api.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import GeorgeDavidDAM2.festify_api.dto.response.ArtistResponse;
import GeorgeDavidDAM2.festify_api.mapper.ArtistMapper;
import GeorgeDavidDAM2.festify_api.persistence.jpa.entity.ArtistEntity;
import GeorgeDavidDAM2.festify_api.persistence.jpa.entity.repository.ArtistJpaRepository;
import GeorgeDavidDAM2.festify_api.service.ArtistService;


@Service
public class ArtistServiceImpl implements ArtistService {

    final private ArtistJpaRepository artistJpaRepository;
    
    @Autowired
    public ArtistServiceImpl(ArtistJpaRepository artistRepository) {
        this.artistJpaRepository = artistRepository;
    }

    @Override
    public List<ArtistResponse> listArtists() {
        List<ArtistEntity> artists = this.artistJpaRepository.findAll();

        return artists.stream().map(ArtistMapper::mapArtistsToArtisResume).toList();
            
        }
    }


