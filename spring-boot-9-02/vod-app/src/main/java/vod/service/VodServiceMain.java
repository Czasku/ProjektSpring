package vod.service;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import vod.model.MangaStore;
import vod.repository.MangaStoreDao;
import vod.repository.MangaDao;
import vod.repository.mem.MemMangaStoreDao;
import vod.repository.mem.MemMangaDao;
import vod.service.impl.MangaStoreServiceBean;

import java.util.List;

public class VodServiceMain {

    public static void main(String[] args) {
        System.out.println("Let's find mangaStores!");

        ApplicationContext context =
                new AnnotationConfigApplicationContext("vod");

        MangaStoreService service = context.getBean(MangaStoreService.class);
        // używamy kontekstu do pobrania beana typu interfejsowego MangaStoreService
        MangaStoreService service2 = context.getBean(MangaStoreService.class);

        // service use
        List<MangaStore> mangaStores = service.getAllMangaStores();
        System.out.println(mangaStores.size() + " mangaStores found:");
        mangaStores.forEach(System.out::println);


        String foo = context.getBean(String.class);
        System.out.println("\nfoo string: " + foo);
    }
}
