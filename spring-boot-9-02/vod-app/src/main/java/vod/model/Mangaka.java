package vod.model;

import java.util.ArrayList;
import java.util.List;

public class Mangaka {

    private int id;
    private String firstName;
    private String lastName;
    private List<Manga> mangaList = new ArrayList<>();//relacja 1 do wielu
//listy zeby przey przełączniu na SpringDate nie było komplikacji
//lista od seta różni się tym że są w niej powtórzenia oraz trzymamy kolejność wrzucania
    //struktury danych wazna rzecz w zachowaniu spójności danych w warstwie aplikacyjnej
    public Mangaka(int id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Mangaka() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
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
        return "Mangaka{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}
