package vod.web.rest;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import vod.model.Mangaka;
import vod.service.MangaService;
import vod.web.rest.dto.MangaDTO;

@Component
@RequiredArgsConstructor
public class MangaValidator implements Validator {
    private final MangaService mangaService;

    @Override
    public boolean supports(Class<?> clazz) {
        return clazz.isAssignableFrom(MangaDTO.class);
    }

    @Override
    public void validate(Object target, Errors errors) {
        MangaDTO mangaDTO = (MangaDTO) target;
        Mangaka mangaka = mangaService.getMangakaById(mangaDTO.getMangaka());
        if(mangaka == null){
            errors.rejectValue("mangaka", "manga.mangaka.missing");
        }
    }
}
