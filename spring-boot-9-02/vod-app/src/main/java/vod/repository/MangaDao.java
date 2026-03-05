package vod.repository;

import vod.model.Manga;
import vod.model.MangaStore;
import vod.model.Mangaka;

import java.util.List;

public interface MangaDao {

    List<Manga> findAll();

    Manga findById(int id);

    List<Manga> findByMangaka(Mangaka mangaka);

    List<Manga> findByMangaStore(MangaStore store);

    Manga add(Manga m);

}
