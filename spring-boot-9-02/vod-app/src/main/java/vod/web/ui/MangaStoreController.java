package vod.web.ui;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import vod.model.MangaStore;
import vod.service.MangaStoreService;

import java.util.List;

@Controller
@RequiredArgsConstructor
@Slf4j
public class MangaStoreController {

    private final MangaStoreService mangaStoreService;

    @GetMapping("/mangastores")
    String getMangaStore(Model model){
        log.info("about to display manga stores list");
        List<MangaStore> mangaStores = mangaStoreService.getAllMangaStores();
        model.addAttribute("mangaStores", mangaStores);
        return "mangaStoresView";

    }
}
