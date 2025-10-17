package GeorgeDavidDAM2.festify_api.service.impl;

import java.util.List;

//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import GeorgeDavidDAM2.festify_api.dto.request.CreateArtistRequest;
import GeorgeDavidDAM2.festify_api.dto.response.ArtistResponse;
import GeorgeDavidDAM2.festify_api.mapper.ArtistMapper;
import GeorgeDavidDAM2.festify_api.persistence.jpa.entity.ArtistEntity;
import GeorgeDavidDAM2.festify_api.persistence.jpa.entity.repository.ArtistJpaRepository;
import GeorgeDavidDAM2.festify_api.service.ArtistService;

@Service
public class ArtistServiceImpl implements ArtistService {

    final private ArtistJpaRepository artistJpaRepository;

    // private static final Logger logger =
    // LoggerFactory.getLogger(ArtistServiceImpl.class);

    @Autowired
    public ArtistServiceImpl(ArtistJpaRepository artistRepository) {
        this.artistJpaRepository = artistRepository;
    }

    @Override
    public List<ArtistResponse> listArtists() {
        List<ArtistEntity> artists = this.artistJpaRepository.findAll();
        // artists.stream().forEach(a -> logger.info(a.getName()));
        return artists.stream().map(ArtistMapper::ArtistsToArtisResume).toList();

    }

    @Override
    public ArtistResponse createArtist(CreateArtistRequest request) {
        ArtistEntity artist = ArtistMapper.CreateArtistRequestToArtistEntity(request);
        ArtistEntity artistCreated = this.artistJpaRepository.save(artist);
        return ArtistMapper.ArtistsToArtisResume(artistCreated);

    }
    /*
     * @Override
     * public ArtistResponse updateArtist(String id, CreateArtistRequest request) {
     * 
     * }
     * 
     * @Override
     * public ArtistResponse getArtistById(String id) {
     * 
     * }
     */
}
