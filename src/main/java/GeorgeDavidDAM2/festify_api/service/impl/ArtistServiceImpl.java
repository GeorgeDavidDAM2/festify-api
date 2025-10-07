package GeorgeDavidDAM2.festify_api.service.impl;

import java.util.ArrayList;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import GeorgeDavidDAM2.festify_api.persistence.jpa.entity.repository.ArtistJpaRepository;
import GeorgeDavidDAM2.festify_api.dto.response.ArtistResponse;
import GeorgeDavidDAM2.festify_api.service.ArtistService;


@Service
public class ArtistServiceImpl implements ArtistService {

    private ArtistJpaRepository artistRepository;
    @Autowired
    public ArtistServiceImpl(ArtistJpaRepository artistRepository) {
        this.artistRepository = artistRepository;
    }

    @Override
    public List<ArtistResponse> listArtists() {

        return new ArrayList<>();
    }



}


