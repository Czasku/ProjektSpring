package vod.web.rest;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import vod.model.MangaStore;
import vod.service.MangaStoreService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Slf4j
public class MangaStoreRest {

    private final MangaStoreService mangaStoreService;

    @GetMapping("/mangastores")
    List<MangaStore> getMangaStores(){
        log.info("about to retrive all manga stores");
        List<MangaStore> mangaStores = mangaStoreService.getAllMangaStores();
        log.info("{} manga stores found", mangaStores.size());
        return mangaStores;
    }
}
