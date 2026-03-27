package vod.repository.data;

import org.springframework.data.jpa.repository.JpaRepository;
import vod.model.Manga;
import vod.model.MangaStore;
import vod.model.Mangaka;

import java.util.List;

public interface MangaRepository extends JpaRepository<Manga,Integer> {
    List<Manga> findAllByMangaka(Mangaka mangaka);

    List<Manga> findByMangaStoresContaining(MangaStore ms);
}
