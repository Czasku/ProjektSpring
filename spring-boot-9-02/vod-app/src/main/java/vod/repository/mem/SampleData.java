package vod.repository.mem;

import vod.model.Manga;
import vod.model.MangaStore;
import vod.model.Mangaka;

import java.util.ArrayList;
import java.util.List;

class SampleData {

    static List<MangaStore> mangaStores = new ArrayList<>();

    static List<Mangaka> mangakas = new ArrayList<>();

    static List<Manga> mangaList = new ArrayList<>();

    static {

        Mangaka oda = new Mangaka(1, "Eiichiro", "Oda");
        Mangaka kishimoto = new Mangaka(2, "Masashi", "Kishimoto");
        Mangaka toriyama = new Mangaka(3, "Akira", "Toriyama");
        Mangaka isayama = new Mangaka(4, "Hajime", "Isayama");

        Manga onePiece = new Manga(1, "One Piece", "https://upload.wikimedia.org/wikipedia/en/2/2c/OnePiece61Cover.png", oda, (float) 4.9);
        Manga naruto = new Manga(2, "Naruto", "https://upload.wikimedia.org/wikipedia/en/9/94/NarutoCoverTankobon1.jpg", kishimoto, (float) 4.8);

        Manga boruto = new Manga(3, "Boruto", "https://upload.wikimedia.org/wikipedia/en/9/94/Boruto_manga_vol_1.jpg", kishimoto, (float) 3.9);
        Manga dragonBall = new Manga(4, "Dragon Ball", "https://upload.wikimedia.org/wikipedia/en/c/c9/DB_Tankobon.png", toriyama, (float) 4.7);

        Manga dragonBallSuper = new Manga(5, "Dragon Ball Super", "https://upload.wikimedia.org/wikipedia/en/7/72/Dragon_Ball_Super_Volume_1.png", toriyama, (float) 4.5);
        Manga attackOnTitan = new Manga(6, "Attack on Titan", "https://upload.wikimedia.org/wikipedia/en/7/70/Attack_on_Titan_cover.jpg", isayama, (float) 4.9);

        Manga aotFinal = new Manga(7, "Attack on Titan Final Season", "https://upload.wikimedia.org/wikipedia/en/7/7a/Attack_on_Titan_volume_34_cover.jpg", isayama, (float) 4.8);
        Manga wanted = new Manga(8, "Wanted!", "https://upload.wikimedia.org/wikipedia/en/7/7d/Wanted_Eiichiro_Oda.png", oda, (float) 4.2);

        bind(onePiece, oda);
        bind(naruto, kishimoto);

        bind(boruto, kishimoto);
        bind(dragonBall, toriyama);

        bind(dragonBallSuper, toriyama);
        bind(attackOnTitan, isayama);

        bind(aotFinal, isayama);
        bind(wanted, oda);

        MangaStore tokyoStore = new MangaStore(1, "Tokyo Manga Store", "https://upload.wikimedia.org/wikipedia/commons/6/6f/Tokyo_Tower.jpg");
        MangaStore otakuShop = new MangaStore(2, "Otaku Shop", "https://upload.wikimedia.org/wikipedia/commons/3/3e/Akihabara.jpg");
        MangaStore mangaWorld = new MangaStore(3, "Manga World", "https://upload.wikimedia.org/wikipedia/commons/0/0c/Manga_shop.jpg");
        MangaStore animeZone = new MangaStore(4, "Anime Zone", "https://upload.wikimedia.org/wikipedia/commons/2/2e/Anime_store.jpg");

        bind(tokyoStore, onePiece);
        bind(mangaWorld, onePiece);
        bind(mangaWorld, naruto);
        bind(mangaWorld, boruto);

        bind(tokyoStore, dragonBallSuper);
        bind(animeZone, dragonBallSuper);
        bind(animeZone, attackOnTitan);
        bind(otakuShop, attackOnTitan);
        bind(otakuShop, boruto);

        mangaList.add(onePiece);
        mangaList.add(naruto);
        mangaList.add(boruto);
        mangaList.add(dragonBall);
        mangaList.add(dragonBallSuper);
        mangaList.add(attackOnTitan);
        mangaList.add(aotFinal);
        mangaList.add(wanted);

        mangakas.add(oda);
        mangakas.add(kishimoto);
        mangakas.add(toriyama);
        mangakas.add(isayama);

        mangaStores.add(tokyoStore);
        mangaStores.add(otakuShop);
        mangaStores.add(mangaWorld);
        mangaStores.add(animeZone);

    }

    private static void bind(MangaStore c, Manga m) {
        c.addManga(m);
        m.addMangaStore(c);
    }

    private static void bind(Manga m, Mangaka d) {
        d.addManga(m);
        m.setMangaka(d);
    }

}