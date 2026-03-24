package vod.repository.data;

import org.springframework.data.jpa.repository.JpaRepository;
import vod.model.MangaStore;

public interface MangaRepository extends JpaRepository<MangaStore,Integer> {
}
