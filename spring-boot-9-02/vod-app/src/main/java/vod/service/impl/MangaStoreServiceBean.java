package vod.service.impl;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import vod.model.Manga;
import vod.model.MangaStore;
import vod.repository.MangaStoreDao;
import vod.repository.MangaDao;
import vod.service.MangaStoreService;

import java.util.List;
import java.util.logging.Logger;

@Service
public class MangaStoreServiceBean implements MangaStoreService {

    private static final Logger log = Logger.getLogger(MangaStoreService.class.getName());

    private MangaStoreDao mangaStoreDao;
    private MangaDao mangaDao;

    public MangaStoreServiceBean(MangaStoreDao mangaStoreDao, MangaDao mangaDao) {
        log.info("creating cinema service bean");
        this.mangaStoreDao = mangaStoreDao;
        this.mangaDao = mangaDao;
    }

    @Override
    public MangaStore getMangaStoreById(int id) {
        log.info("searching cinema by id " + id);
        return mangaStoreDao.findById(id);
    }

    @Override
    public List<Manga> getMangaListInMangaStore(MangaStore store) {
        log.info("searching movies played in cinema " + store.getId());
        return mangaDao.findByMangaStore(store);
    }

    @Override
    public List<MangaStore> getAllMangaStores() {
        log.info("searching all cinemas");
        return mangaStoreDao.findAll();
    }

    @Override
    public List<MangaStore> getMangaStoresByManga(Manga m) {
        log.info("searching cinemas by movie " + m.getId());
        return mangaStoreDao.findByManga(m);
    }

    @Override
    public MangaStore addMangaStore(MangaStore m) {
        log.info("about to add cinema " + m);
        return mangaStoreDao.save(m);
    }
}
