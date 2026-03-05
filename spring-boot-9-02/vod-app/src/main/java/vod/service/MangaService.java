package vod.service;

import vod.model.Mangaka;
import vod.model.Manga;

import java.util.List;

public interface MangaService {


    List<Manga> getAllMangaList();

    List<Manga> getMangaByMangaka(Mangaka mangaka);

    Manga getMangaById(int id);

    Manga addManga(Manga m);


    List<Mangaka> getAllMangakas();

    Mangaka getMangakaById(int id);

    Mangaka addMangaka(Mangaka mangaka);
}
