package vod.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.DefaultTransactionDefinition;
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
@RequiredArgsConstructor
public class MangaServiceBean implements MangaService {

    private static final Logger log = Logger.getLogger(MangaService.class.getName());

    private final MangakaDao mangakaDao;
    private final MangaStoreDao mangaStoreDao;
    private final MangaDao mangaDao;
    private final PlatformTransactionManager transactionManager;

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

    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public Manga addManga(Manga m) {
        log.info("about to add movie " + m);

//        TransactionStatus ts = transactionManager.getTransaction(new DefaultTransactionDefinition());
//        try {
//            m = mangaDao.add(m);
//            if (m.getTitle().equals("test")) {
//                throw new RuntimeException("test exception");
//            }
//            transactionManager.commit(ts);
//        } catch (RuntimeException e){
//            transactionManager.rollback(ts);
//            throw e;
//        }

        m = mangaDao.add(m);
        if(m.getTitle().equals("test")) {
            throw new RuntimeException("test exception");
        }

        return m;
    }

    @Override
    public Mangaka addMangaka(Mangaka d) {
        log.info("about to add director " + d);
        return mangakaDao.add(d);
    }

}
