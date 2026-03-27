package vod.repository.jpa;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;
import vod.model.Manga;
import vod.model.MangaStore;
import vod.model.Mangaka;
import vod.repository.MangaDao;

import java.util.List;

@Repository
public class JpaMangaDao implements MangaDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Manga> findAll() {
        return entityManager.
                createQuery("select m from Manga m").getResultList();
    }

    @Override
    public Manga findById(int id) {
        return entityManager.
                find( Manga.class, id );
    }

    @Override
    public List<Manga> findByMangaka(Mangaka man) {
        return entityManager
                .createQuery("select m from Manga m where m.mangaka=:mangaka")
                .setParameter("mangaka", man)
                .getResultList();
    }

    @Override
    public List<Manga> findByMangaStore(MangaStore ms) {
        return entityManager
                .createQuery("select m from Manga m inner join m.mangaStores mangastore where mangastore=:mangastore")
                .setParameter("mangastore", ms)
                .getResultList();
    }

    @Override
    public Manga add(Manga m) {
        entityManager.persist(m);
        return m;
    }
}
