package vod.repository;

import vod.model.Mangaka;

import java.util.List;

public interface MangakaDao {

    List<Mangaka> findAll();

    Mangaka findById(int id);

    Mangaka add(Mangaka d);


}
