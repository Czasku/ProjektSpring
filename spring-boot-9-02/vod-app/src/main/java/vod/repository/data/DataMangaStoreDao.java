package vod.repository.data;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;
import vod.model.Manga;
import vod.model.MangaStore;
import vod.repository.MangaStoreDao;

import java.util.List;

@Repository
@Primary
@RequiredArgsConstructor
public class DataMangaStoreDao implements MangaStoreDao {

    private final MangaStoreRepository mangaStoreRepository;

    @Override
    public List<MangaStore> findAll() { return mangaStoreRepository.findAll(); }

    @Override
    public MangaStore findById(int id) {
        return mangaStoreRepository.findById(id).orElse(null);
    }

    @Override
    public List<MangaStore> findByManga(Manga m) { return mangaStoreRepository.findAllByManga(m); }

    @Override
    public MangaStore save(MangaStore m) { return mangaStoreRepository.save(m); };
}