package vod.repository.data;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;
import vod.model.Mangaka;
import vod.repository.MangakaDao;

import java.util.List;

@Repository
@RequiredArgsConstructor
@Primary
public class DataMangakaDao implements MangakaDao {

    private final MangakaRepository mangakaRepository;

    @Override
    public List<Mangaka> findAll() { return mangakaRepository.findAll(); }

    @Override
    public Mangaka findById(int id) { return mangakaRepository.findById(id).orElse(null); }

    @Override
    public Mangaka add(Mangaka d) { return mangakaRepository.save(d); }
}
