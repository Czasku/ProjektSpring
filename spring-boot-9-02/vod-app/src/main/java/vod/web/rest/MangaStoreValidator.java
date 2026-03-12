package vod.web.rest;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import vod.model.MangaStore;
import vod.service.MangaStoreService;

@Component
@RequiredArgsConstructor
public class MangaStoreValidator implements Validator {

    public final MangaStoreService mangaStoreService;

    @Override
    public boolean supports(Class<?> clazz) {
        return MangaStore.class.isAssignableFrom(MangaStore.class);
    }

    @Override
    public void validate(Object target, Errors errors) {
        MangaStore validatedMangaStore = (MangaStore) target;

        boolean duplicated = mangaStoreService.getAllMangaStores().stream()
                .anyMatch(m -> m.getName().equals(validatedMangaStore.getName()));

        if(duplicated){
            errors.rejectValue("name", "mangastore.name.duplicated");
        }
    }


}
