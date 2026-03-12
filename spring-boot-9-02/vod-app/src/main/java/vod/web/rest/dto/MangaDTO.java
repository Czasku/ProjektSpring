package vod.web.rest.dto;

import lombok.Data;

@Data
public class MangaDTO {
    private String title;
    private String poster;
    private float rating;
    private int mangaka;
}
