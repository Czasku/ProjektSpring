package vod.repository.data;

import org.springframework.data.jpa.repository.JpaRepository;
import vod.model.Mangaka;

public interface MangakaRepository extends JpaRepository<Mangaka,Integer> {
}
