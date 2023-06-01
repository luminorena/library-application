package rest.library.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Library {
    private int id;
    private String title;
    private String author;
    private String genre;
    private int year;
    private int pages;
}
