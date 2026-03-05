package vod.repository.mem;

import vod.model.Manga;
import vod.model.MangaStore;
import vod.repository.MangaStoreDao;

import java.util.List;
import java.util.stream.Collectors;


public class MemMangaStoreDao implements MangaStoreDao {

    @Override
    public List<MangaStore> findAll() {
        return SampleData.mangaStores;
    }

    @Override
    public MangaStore findById(int id) {
        return SampleData.mangaStores.stream().filter(c -> c.getId() == id).findFirst().orElse(null);
    }

    @Override
    public List<MangaStore> findByManga(Manga m) {
        return SampleData.mangaStores.stream().filter(c -> c.getMangaList().contains(m)).collect(Collectors.toList());
    }
}
