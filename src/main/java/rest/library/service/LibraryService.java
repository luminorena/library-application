package rest.library.service;

import rest.library.model.Library;

import java.util.List;

public interface LibraryService {
    // create entity
    void create(Library library);

    // list of books

    List<Library> readAll();

    // book id
    Library read(int id);

    // update entity

    boolean update(Library library, int id);

    // delete entity

    boolean delete (int id);
}
