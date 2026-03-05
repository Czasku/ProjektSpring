package vod.repository.mem;

import vod.model.Manga;
import vod.model.MangaStore;
import vod.repository.MangaDao;
import vod.model.Mangaka;

import java.util.List;
import java.util.stream.Collectors;

public class MemMangaDao implements MangaDao {
    @Override
    public List<Manga> findAll() {
        return SampleData.mangaList;
    }

    @Override
    public Manga findById(int id) {
        return SampleData.mangaList.stream().filter(m -> m.getId() == id).findFirst().orElse(null);
    }

    @Override
    public List<Manga> findByMangaka(Mangaka mangaka) {
       return SampleData.mangaList.stream().filter(m -> m.getMangaka() == mangaka).collect(Collectors.toList());
    }

    @Override
    public List<Manga> findByMangaStore(MangaStore store) {
        return SampleData.mangaList.stream().filter(m -> m.getMangaStores().contains(store)).collect(Collectors.toList());
    }

    @Override
    public Manga add(Manga m) {
        int max = SampleData.mangaList.stream().max((m1, m2) -> m1.getId() - m2.getId()).get().getId();
        m.setId(++max);
        SampleData.mangaList.add(m);
        return m;
    }
}
