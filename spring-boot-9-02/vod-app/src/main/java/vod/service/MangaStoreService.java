package vod.service;

import vod.model.Manga;
import vod.model.MangaStore;

import java.util.List;

public interface MangaStoreService {
//api zwraca nam wszystkie kina
    MangaStore getMangaStoreById(int id);

    List<MangaStore> getAllMangaStores();

    List<MangaStore> getMangaStoresByManga(Manga m);

    List<Manga> getMangaListInMangaStore(MangaStore store);

    MangaStore addMangaStore(MangaStore m);
}
