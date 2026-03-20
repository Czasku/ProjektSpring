package vod.repository.jpa;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;
import vod.model.Manga;
import vod.model.MangaStore;
import vod.repository.MangaStoreDao;

import java.util.List;

@Repository
@Primary
public class JpaMangaStoreDao implements MangaStoreDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<MangaStore> findAll() {
        return entityManager
                .createQuery( "select m from MangaStore m")
                .getResultList();
    }

    @Override
    public MangaStore findById(int id) {
        return entityManager.find(MangaStore.class, id);
    }

    @Override
    public List<MangaStore> findByManga(Manga m)
    {
        return entityManager
                .createQuery("select m from MangaStore m inner join m.mangaList manga where manga=: manga")
                .setParameter("manga",m)
                .getResultList();
    }

    @Override
    public MangaStore save(MangaStore mangaStore)
    {
        entityManager.persist(mangaStore);
        return mangaStore;
    }
}


