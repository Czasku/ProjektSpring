package vod.Configuration;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.actuate.info.Info;
import org.springframework.boot.actuate.info.InfoContributor;
import org.springframework.stereotype.Component;
import vod.service.MangaService;

@Component
@RequiredArgsConstructor
public class VodInfoContributor implements InfoContributor {

    private final MangaService mangaService;

    @Override
    public void contribute(Info.Builder builder) {
        builder.withDetail("mangas", mangaService.getAllMangaList().size() );
    }

}
