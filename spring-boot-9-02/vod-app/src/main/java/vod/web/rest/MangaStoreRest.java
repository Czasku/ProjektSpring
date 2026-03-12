package vod.web.rest;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vod.model.Manga;
import vod.model.MangaStore;
import vod.service.MangaService;
import vod.service.MangaStoreService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/webapi")
public class MangaStoreRest {

    private final MangaStoreService mangaStoreService;
    private final MangaService mangaService;

    @GetMapping("/mangastores")
    List<MangaStore> getMangaStores(
            @RequestParam(value = "phrase", required = false) String phrase,
            @RequestParam(value = "custom-header", required = false) String customHeader,
            @CookieValue(value = "some-cookie", required = false) String someCookie
    ){
        log.info("about to retrive all manga stores");
        log.info("phrase: {}", phrase);
        log.info("custom-header: {}", customHeader);
        log.info("some-cookie: {}", someCookie);
        List<MangaStore> mangaStores = mangaStoreService.getAllMangaStores();
        log.info("{} manga stores found", mangaStores.size());
        return mangaStores;
    }

    @GetMapping("/mangastores/{id}")
    ResponseEntity<MangaStore> getMangaStore(@PathVariable("id") int id){
        log.info("about to retrive manga store with id {}", id);
        MangaStore mangaStore = mangaStoreService.getMangaStoreById(id);
        log.info("{} manga store found", mangaStore);
        if(mangaStore != null){
            return ResponseEntity.status(200).body(mangaStore);
        }
        else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/manga/{mangaid}/mangastores")
    ResponseEntity<List<MangaStore>> getMangaStoreHavingManga(@PathVariable("mangaid") int mangaid){
        log.info("about to retrive manga store with id {}", mangaid);
        Manga manga = mangaService.getMangaById(mangaid);
        if(manga == null){
            return ResponseEntity.notFound().build();
        }
        else
        {
            List<MangaStore> mangaStores = mangaStoreService.getMangaStoresByManga(manga);
            log.info("{} manga stores found", mangaStores.size());
            return ResponseEntity.ok(mangaStores);
        }
    }

    @PostMapping("/mangastore")
    ResponseEntity<MangaStore> addMangaStore(@RequestBody MangaStore mangaStore) {
        log.info("about to add manga store {}", mangaStore);
        mangaStore = mangaStoreService.addMangaStore(mangaStore);
        log.info("manga store added {}", mangaStore);
        return ResponseEntity.status(HttpStatus.CREATED).body(mangaStore);
    }
}
