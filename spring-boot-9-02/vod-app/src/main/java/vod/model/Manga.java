package vod.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Manga {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String title;
    private String poster;

    @ManyToOne
    @JoinColumn(name = "mangaka_id")
    private Mangaka mangaka;
    private float rating;

    @ManyToMany
    @JoinTable(
            name = "manga_manga_store",
            joinColumns = @JoinColumn(name = "manga_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "manga_store_id", referencedColumnName = "id")
    )
    private List<MangaStore> mangaStores = new ArrayList<>(); //relacja wiele do wiele - bidirectional

    public Manga(int id, String title, String poster, Mangaka mangaka, float rating) {
        this.id = id;
        this.title = title;
        this.poster = poster;
        this.mangaka = mangaka;
        this.rating = rating;
    }

    public Manga() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPoster() {
        return poster;
    }

    public void setPoster(String poster) {
        this.poster = poster;
    }

    public Mangaka getMangaka() {
        return mangaka;
    }

    public void setMangaka(Mangaka mangaka) {
        this.mangaka = mangaka;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    public List<MangaStore> getMangaStores() {
        return mangaStores;
    }

    public void setMangaStores(List<MangaStore> mangaStores) {
        this.mangaStores = mangaStores;
    }

    public void addMangaStore(MangaStore store) {
        this.mangaStores.add(store);
    }


   /* @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Manga movie = (Manga) o;

        if (id != movie.id) return false;
        if (Float.compare(movie.rating, rating) != 0) return false;
        if (title != null ? !title.equals(movie.title) : movie.title != null) return false;
        return poster != null ? poster.equals(movie.poster) : movie.poster == null;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (poster != null ? poster.hashCode() : 0);
        result = 31 * result + (rating != +0.0f ? Float.floatToIntBits(rating) : 0);
        return result;
    }*/

    @Override
    public String toString() {
        return "Manga{" +
                "title='" + title + '\'' +
                ", mangaka=" + mangaka +
                ", rating=" + rating +
                '}';
    }
}
