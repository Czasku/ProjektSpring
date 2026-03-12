package vod.web.rest;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.LocaleResolver;;
import org.springframework.context.MessageSource;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import vod.model.Manga;
import vod.model.MangaStore;
import vod.service.MangaService;
import vod.service.MangaStoreService;
import vod.web.rest.dto.MangaDTO;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/webapi")
public class MangaRest {

    private final MangaService mangaService;
    private final MangaStoreService mangaStoreService;
    private final MessageSource messageSource;
    private final LocaleResolver localeResolver;
    private final MangaStoreValidator validator;

//    @InitBinder
//    void initBinder(WebDataBinder binder){
//        binder.addValidators(validator);
//    }

    @GetMapping("/mangas")
    List<Manga> getMangas(){
        log.info("about to retrive all mangas");
        List<Manga> mangas = mangaService.getAllMangaList();
        log.info("{} mangas found", mangas.size());
        return mangas;
    }

    @GetMapping("/mangas/{id}")
    ResponseEntity<Manga> getManga(@PathVariable("id") int id){
        log.info("about to retrive manga with id {}", id);
        Manga manga = mangaService.getMangaById(id);
        log.info("manga found: {}", manga);
        if(manga != null){
            return ResponseEntity.ok(manga);
        }
        else {
            return ResponseEntity.status(404).build();
        }
    }

    @GetMapping("/mangastore/{mangaId}/mangas")
    ResponseEntity<List<Manga>> getMangasAtMangaStore(@PathVariable("mangaId") int mangaId){
        log.info("about to retrive mangas at manga store {}", mangaId);
        MangaStore mangaStore = mangaStoreService.getMangaStoreById(mangaId);
        if(mangaStore == null){
            return ResponseEntity.notFound().build();
        }
        else
        {
            List<Manga> mangas = mangaStoreService.getMangaListInMangaStore(mangaStore);
            log.info("there's {} mangas at manga store {}", mangas.size(), mangaId);
            return ResponseEntity.ok(mangas);
        }
    }

    @PostMapping("/mangas")
    ResponseEntity<?> addManga(@RequestBody MangaDTO mangaDTO){
        log.info("about to add manga {}", mangaDTO);
        Manga manga = new Manga();
        manga.setTitle(mangaDTO.getTitle());
        manga.setPoster(mangaDTO.getPoster());
        manga.setRating(mangaDTO.getRating());
        manga.setMangaka(mangaService.getMangakaById(mangaDTO.getMangaka()));

        manga = mangaService.addManga(manga);
        log.info("manga added {}", manga);
        return ResponseEntity
                .created(
                        ServletUriComponentsBuilder
                                .fromCurrentRequest()
                                .path("/" + manga.getId())
                                .build()
                                .toUri())
                .body(manga);
    }
}
