package vod.repository.mem;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import vod.repository.MangakaDao;
import vod.model.Mangaka;

import java.util.List;

@Repository
public class MemMangakaDao implements MangakaDao {
    @Override
    public List<Mangaka> findAll() {
        return SampleData.mangakas;
    }

    @Override
    public Mangaka findById(int id) {
        return SampleData.mangakas.stream().filter(d -> d.getId() == id).findFirst().orElse(null);
    }

    @Override
    public Mangaka add(Mangaka d) {
        int max = SampleData.mangakas.stream().max((d1, d2) -> d1.getId() - d2.getId()).get().getId();
        d.setId(++max);
        SampleData.mangakas.add(d);
        return d;
    }
}
