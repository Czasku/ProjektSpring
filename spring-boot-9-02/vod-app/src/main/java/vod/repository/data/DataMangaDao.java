package vod.repository.data;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import vod.model.Manga;
import vod.model.MangaStore;
import vod.model.Mangaka;
import vod.repository.MangaDao;

import java.util.List;

@Repository
@RequiredArgsConstructor
@Primary
public class DataMangaDao implements MangaDao {

    private final MangaRepository mangaRepository;

    @Override
    public List<Manga> findAll() { return mangaRepository.findAll(); }

    @Override
    public Manga findById(int id) { return mangaRepository.findById(id).orElse(null); }

    @Override
    public List<Manga> findByMangaka(Mangaka man) { return mangaRepository.findAllByMangaka(man); }

    @Override
    public List<Manga> findByMangaStore(MangaStore ms) { return mangaRepository.findByMangaStoresContaining(ms); }

    @Transactional(propagation = Propagation.MANDATORY)
    @Override
    public Manga add(Manga m) { return mangaRepository.save(m); }
}
