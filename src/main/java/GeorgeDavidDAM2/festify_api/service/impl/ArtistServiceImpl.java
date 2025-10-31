package GeorgeDavidDAM2.festify_api.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import GeorgeDavidDAM2.festify_api.dto.request.CreateArtistRequest;
import GeorgeDavidDAM2.festify_api.dto.response.ArtistResponse;
import GeorgeDavidDAM2.festify_api.mapper.ArtistMapper;
import GeorgeDavidDAM2.festify_api.persistence.jpa.entity.ArtistEntity;
import GeorgeDavidDAM2.festify_api.persistence.jpa.entity.repository.ArtistJpaRepository;
import GeorgeDavidDAM2.festify_api.service.ArtistService;
import GeorgeDavidDAM2.festify_api.utils.exceptions.InvalidFormatIdException;
import GeorgeDavidDAM2.festify_api.utils.exceptions.InvalidIdException;

@Service
public class ArtistServiceImpl implements ArtistService {

    final private ArtistJpaRepository artistJpaRepository;

    private Long parseArtistId(String strId) {

        try {
            strId = strId.trim().replace("ART-", "");
            Long id = Integer.valueOf(strId).longValue();
            return id;
        } catch (Exception e) {
            throw new InvalidFormatIdException("El formato del id " + strId + " no es valido.");
        }

    }

    @Autowired
    public ArtistServiceImpl(ArtistJpaRepository artistRepository) {
        this.artistJpaRepository = artistRepository;
    }

    @Override
    public List<ArtistResponse> listArtists() {
        List<ArtistEntity> artists = this.artistJpaRepository.findAll();
        return artists.stream().map(ArtistMapper::ArtistsToArtisResume).toList();

    }

    @Override
    public ArtistResponse createArtist(CreateArtistRequest request) {
        ArtistEntity artist = ArtistMapper.CreateArtistRequestToArtistEntity(request);
        ArtistEntity artistCreated = this.artistJpaRepository.save(artist);
        return ArtistMapper.ArtistsToArtisResume(artistCreated);

    }

    public ArtistResponse getArtistById(String pubId) {
        Long id = parseArtistId(pubId);
        Optional<ArtistEntity> artistEntity = this.artistJpaRepository.findById(id);
        return ArtistMapper.ArtistsToArtisResume(artistEntity.get());
    }

    public void deleteArtistById(String pubId) {
        Long id = parseArtistId(pubId);

        if (!this.artistJpaRepository.existsById(id)) {
            throw new InvalidIdException("Artista con el id " + pubId + " no existe.");
        }

        this.artistJpaRepository.deleteById(id);

    }
    /*
     * @Override
     * public ArtistResponse updateArtist(String puId, CreateArtistRequest request)
     * {
     * long id = parseArtistId(puId);
     * ArtistEntity artistToUpdate = artistJpaRepository.findById(id)
     * .orElseThrow(() -> new InvalidIdException("El artist no existe"));
     * 
     * if (request.name() != null && !request.name().trim().isEmpty()) {
     * artistToUpdate.setName(request.name());
     * }
     * if (request.genres() != null && !request.genres().isEmpty()) {
     * artistToUpdate.setGenres(request.genres());
     * }
     * 
     * if (request.country() != null && !request.country().isEmpty()) {
     * artistToUpdate.setCountry(request.country());
     * }
     * if (request.biography() != null && !request.biography().isEmpty()) {
     * artistToUpdate.setBiography(request.biography());
     * }
     * if (request.status() != null && !request.status().isEmpty()) {
     * artistToUpdate.setStatus(request.status());
     * }
     * 
     * if (request.listeners() != null) {
     * artistToUpdate.setListeners(request.listeners().intValue());
     * }
     * 
     * ArtistEntity updatedArtist = artistJpaRepository.save(artistToUpdate);
     * // Mapear la entidad actualizada a la respuesta y devolver
     * return ArtistMapper.ArtistsDetailResponse(updateArtist);
     * }
     */
}
