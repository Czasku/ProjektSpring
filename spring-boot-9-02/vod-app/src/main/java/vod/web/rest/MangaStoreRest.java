package vod.web.rest;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import vod.model.Manga;
import vod.model.MangaStore;
import vod.service.MangaService;
import vod.service.MangaStoreService;

import java.util.List;
import java.util.Locale;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/webapi")
public class MangaStoreRest {

    private final MangaStoreService mangaStoreService;
    private final MangaService mangaService;
    private final MessageSource messageSource;
    private final LocaleResolver localeResolver;
    private final MangaStoreValidator validator;

//    @InitBinder
//    void initBinder(WebDataBinder binder){
//        binder.addValidators(validator);
//    }

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

        if(phrase != null && phrase.equals("foo")){
            throw new IllegalArgumentException("Foo!");
        }
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
    ResponseEntity<?> addMangaStore(@Validated @RequestBody MangaStore mangaStore, Errors errors, HttpServletRequest request) {
        log.info("about to add manga store {}", mangaStore);

        if(errors.hasErrors()){
            Locale locale = localeResolver.resolveLocale(request);
            String errorMsg = errors.getAllErrors().stream()
                    .map(e->messageSource.getMessage(e.getCode(), new Object[0], locale))
                    .reduce("errors:\n", (accu, e)->accu+e+"\n");
            return ResponseEntity.badRequest().body(errorMsg);

        }

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        log.info("authentication: {}", authentication);
        log.info("authentication name {}", authentication.getName());

        mangaStore = mangaStoreService.addMangaStore(mangaStore);
        log.info("manga store added {}", mangaStore);
        return ResponseEntity.status(HttpStatus.CREATED).body(mangaStore);
    }
}
