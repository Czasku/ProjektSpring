package vod.repository.mem;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import vod.model.Manga;
import vod.model.MangaStore;
import vod.repository.MangaStoreDao;

import java.util.List;
import java.util.stream.Collectors;

@Repository("mangaStoreDao")
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

    @Override
    public MangaStore save(MangaStore m){
        int maxId = SampleData.mangaStores.stream()
                .sorted((m1, m2) -> m2.getId() - m1.getId())
                .findFirst()
                .map(ms->ms.getId())
                .orElse(0);
        m.setId(maxId+1);
        SampleData.mangaStores.add(m);
        return m;
    }
}
