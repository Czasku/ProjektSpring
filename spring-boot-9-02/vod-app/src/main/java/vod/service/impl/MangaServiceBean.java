package vod.service.impl;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import vod.model.Manga;
import vod.model.Mangaka;
import vod.repository.MangaStoreDao;
import vod.repository.MangakaDao;
import vod.repository.MangaDao;
import vod.model.MangaStore;
import vod.service.MangaService;

import java.util.List;
import java.util.logging.Logger;

@Service
public class MangaServiceBean implements MangaService {

    private static final Logger log = Logger.getLogger(MangaService.class.getName());

    private MangakaDao mangakaDao;
    private MangaStoreDao mangaStoreDao;
    private MangaDao mangaDao;

    public MangaServiceBean(MangakaDao mangakaDao, MangaStoreDao mangaStoreDao, MangaDao mangaDao) {
        this.mangakaDao = mangakaDao;
        this.mangaStoreDao = mangaStoreDao;
        this.mangaDao = mangaDao;
    }

    public List<Manga> getAllMangaList() {
        log.info("searching all movies...");
        return mangaDao.findAll();
    }

    public List<Manga> getMangaByMangaka(Mangaka mangaka) {
        log.info("serching movies by diretor " + mangaka.getId());
        return mangaDao.findByMangaka(mangaka);
    }

    public List<Manga> getMoviesInCinema(MangaStore c) {
        log.info("searching movies played in cinema " + c.getId());
        return mangaDao.findByMangaStore(c);
    }

    public Manga getMangaById(int id) {
        log.info("searching movie by id " + id);
        return mangaDao.findById(id);
    }

    public List<MangaStore> getAllCinemas() {
        log.info("searching all cinemas");
        return mangaStoreDao.findAll();
    }

    public List<MangaStore> getCinemasByMovie(Manga m) {
        log.info("searching cinemas by movie " + m.getId());
        return mangaStoreDao.findByManga(m);
    }

    public MangaStore getCinemaById(int id) {
        log.info("searching cinema by id " + id);
        return mangaStoreDao.findById(id);
    }

    public List<Mangaka> getAllMangakas() {
        log.info("searching all directors");
        return mangakaDao.findAll();
    }

    public Mangaka getMangakaById(int id) {
        log.info("searching director by id " + id);
        return mangakaDao.findById(id);
    }

    @Override
    public Manga addManga(Manga m) {
        log.info("about to add movie " + m);
        return mangaDao.add(m);
    }

    @Override
    public Mangaka addMangaka(Mangaka d) {
        log.info("about to add director " + d);
        return mangakaDao.add(d);
    }

}
