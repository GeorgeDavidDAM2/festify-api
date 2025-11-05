package GeorgeDavidDAM2.festify_api.persistence.jpa.entity;

import java.sql.Date;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "albums")

public class AlbumEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "artist_id")
    private Long artistId;

    @Column
    private String title;

    @Column(name = "release_date")
    private Date releaseDate;

    @Column(name = "tracks_count")
    private Integer tracksCount;

    @Column(name = "duration_seconds")
    private Integer durationSeconds;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    public AlbumEntity() {

    }

    public AlbumEntity(Long id, Long artistId, String title, Date releaseDate, Integer tracksCount,
            Integer durationSeconds) {
        this.id = id;
        this.artistId = artistId;
        this.title = title;
        this.releaseDate = releaseDate;
        this.tracksCount = tracksCount;
        this.durationSeconds = durationSeconds;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getArtistId() {
        return artistId;
    }

    public void setArtistId(Long artistId) {
        this.artistId = artistId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    public Integer getTracksCount() {
        return tracksCount;
    }

    public void setTracksCount(Integer tracksCount) {
        this.tracksCount = tracksCount;
    }

    public Integer getDurationSeconds() {
        return durationSeconds;
    }

    public void setDurationSeconds(Integer durationSeconds) {
        this.durationSeconds = durationSeconds;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

}
