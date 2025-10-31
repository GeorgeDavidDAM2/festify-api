package GeorgeDavidDAM2.festify_api.persistence.jpa.entity.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import GeorgeDavidDAM2.festify_api.persistence.jpa.entity.AlbumEntity;

public interface AlbumJpaRepository extends JpaRepository<AlbumEntity, Long> {
    List<AlbumEntity> findByArtistId(Long Id);

}
