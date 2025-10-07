package GeorgeDavidDAM2.festify_api.persistence.jpa.entity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import GeorgeDavidDAM2.festify_api.persistence.jpa.entity.ArtistEntity;

public interface ArtistJpaRepository extends JpaRepository<ArtistEntity, Long> {
}
