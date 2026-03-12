package vod.repository;

import org.springframework.beans.CachedIntrospectionResults;
import vod.model.MangaStore;
import vod.model.Manga;

import java.util.List;

public interface MangaStoreDao {

    List<MangaStore> findAll();

    MangaStore findById(int id);

    List<MangaStore> findByManga(Manga m);

    MangaStore save(MangaStore m);
}
