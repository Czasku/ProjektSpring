package vod.web.ui;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import vod.model.Manga;
import vod.model.MangaStore;
import vod.model.Mangaka;
import vod.service.MangaService;
import vod.service.MangaStoreService;

import java.util.List;

@Controller
@RequiredArgsConstructor
@Slf4j
public class MangaController {

    private final MangaService mangaService;
    private final MangaStoreService mangaStoreService;

    @GetMapping("/manga")
    String getManga(
            Model model,
            @RequestParam(value = "mangastoreId", required = false) Integer mangaStoreId,
            @RequestParam(value = "mangakaId", required = false) Integer mangakaId) {
        log.info("about to display manga list");
        if (mangaStoreId != null) {
            MangaStore mangaStore = mangaStoreService.getMangaStoreById(mangaStoreId);
            List<Manga> mangaList = mangaStoreService.getMangaListInMangaStore(mangaStore);
            model.addAttribute("manga", mangaService.getMangaById(mangaStoreId));
            model.addAttribute("title", "Manga in Manga Store '" + mangaStoreId + "'");
        } else if (mangakaId != null) {
            Mangaka mangaka = mangaService.getMangakaById(mangakaId);
            List<Manga> mangaList = mangaService.getMangaByMangaka(mangaka);
            model.addAttribute("manga", mangaList);
            model.addAttribute("title", "Manga by '" + mangaka.getLastName() + " " + mangaka.getFirstName() + "'");
        } else {
            List<Manga> mangaList = mangaService.getAllMangaList();
            model.addAttribute("manga", mangaList);
            model.addAttribute("title", "Manga List");
        }
        return "mangaView";
    }
}
