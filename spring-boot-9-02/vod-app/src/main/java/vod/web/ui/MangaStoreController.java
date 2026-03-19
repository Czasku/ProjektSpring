package vod.web.ui;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import vod.model.Manga;
import vod.model.MangaStore;
import vod.service.MangaService;
import vod.service.MangaStoreService;

import java.util.List;

@Controller
@RequiredArgsConstructor
@Slf4j
public class MangaStoreController {

    private final MangaStoreService mangaStoreService;
    private final MangaService mangaService;

    @GetMapping("/mangastores")
    String getMangaStore(
            Model model,
            @RequestParam(value = "mangaId", required = false) Integer mangaId) {
        log.info("about to display manga stores list");
        if (mangaId != null) {
            Manga manga = mangaService.getMangaById(mangaId);
            List<MangaStore> mangaStores = mangaStoreService.getMangaStoresByManga(manga);
            model.addAttribute("mangaStores", mangaStores);
            model.addAttribute("title", "Manga Stores with '" + manga.getTitle() + "'");
        } else {
            List<MangaStore> mangaStores = mangaStoreService.getAllMangaStores();
            model.addAttribute("mangaStores", mangaStores);
            model.addAttribute("manga", null);
        }

        return "mangaStoresView";
    }
}
