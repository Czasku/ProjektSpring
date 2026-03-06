package vod.repository.dummy;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import vod.model.Manga;
import vod.model.MangaStore;
import vod.repository.MangaStoreDao;

import java.util.List;

@Component
//@Primary
public class DummyMangaStoreDao implements MangaStoreDao {

    @Override
    public List<MangaStore> findAll() {
        return List.of();
    }

    @Override
    public MangaStore findById(int id) {return null; }

    @Override
    public List<MangaStore> findByManga(Manga m)  {
        return List.of();
    }
}
