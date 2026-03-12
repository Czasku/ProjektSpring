package vod.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.ArrayList;
import java.util.List;

public class MangaStore {

    private int id;
    @NotNull
    @Size(min = 2, max = 20)
    private String name;
    private String logo; //url logo w przypadku UI będzie zaciągany dynamicznie
    @JsonIgnore
    private List<Manga> mangaList = new ArrayList<>();
//relacja wiele do wiele
    public MangaStore(int id, String name, String logo) {//konsturktor
        this.id = id;
        this.name = name;
        this.logo = logo;
    }

    public MangaStore() {//bezparametrowy
    }
//settery, gettery i to String - później będziemy korzystać z wynalazku Lombok
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public List<Manga> getMangaList() {
        return mangaList;
    }

    public void setMangaList(List<Manga> mangaList) {
        this.mangaList = mangaList;
    }

    public void addManga(Manga m) {
        this.mangaList.add(m);
    }

    @Override
    public String toString() {
        return "MangaStore{" +
                "name='" + name + '\'' +
                ", logo='" + logo + '\'' +
                '}';
    }
}
