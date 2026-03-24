package vod.repository.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import vod.model.Manga;
import vod.model.MangaStore;

import java.util.List;

public interface MangaStoreRepository extends JpaRepository<MangaStore,Integer> {

    List<MangaStore> findAllByNameContaining(String name);

    @Query("select ms from MangaStore ms inner join ms.mangaList manga where manga=:manga")
    List<MangaStore> findAllByManga(@Param("manga")Manga manga);
}