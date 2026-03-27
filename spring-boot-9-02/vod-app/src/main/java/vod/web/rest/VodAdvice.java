package vod.web.rest;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@ControllerAdvice(basePackages = "vod.web.rest")
@RequiredArgsConstructor
public class VodAdvice {

    private final MangaStoreValidator mangaStoreValidator;
    private final MangaValidator mangaValidator;

    @InitBinder("mangaStore")
    void initBinderForMangaStore(WebDataBinder binder) {
        binder.addValidators(mangaStoreValidator);
    }

    @InitBinder("mangaDTO")
    void initBinderForManga(WebDataBinder binder) {
        binder.addValidators(mangaValidator);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    ResponseEntity<?> handleIllegalArgumentException(IllegalArgumentException e){
        log.error("illegal argument provided", e);
        return ResponseEntity.status(HttpStatus.I_AM_A_TEAPOT).body(e.getMessage());
    }

    @ExceptionHandler(Exception.class)
    ResponseEntity<String> handleException(Exception e){
        log.error("generic error", e);
        return ResponseEntity.status(HttpStatus.LOOP_DETECTED).body(e.getMessage());
    }
}
