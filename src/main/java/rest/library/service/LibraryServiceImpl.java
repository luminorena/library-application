package rest.library.service;

import org.springframework.stereotype.Service;
import rest.library.model.Library;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class LibraryServiceImpl implements LibraryService {

    private static final Map<String, Library> BOOK_STORAGE = new HashMap<>();

    // private static final AtomicInteger BOOK_ID = new AtomicInteger();

    UUID BOOK_ID = UUID.randomUUID();

    @Override
    public void create(Library library) {
        final String bookId = BOOK_ID.toString();
        library.setId(bookId);
        BOOK_STORAGE.put(bookId, library);

    }

    @Override
    public List<Library> readAll() {
        return new ArrayList<>(BOOK_STORAGE.values());
    }

    @Override
    public Library read(int id) {
        return BOOK_STORAGE.get(id);
    }

    @Override
    public boolean update(Library library, String id) {
        if (BOOK_STORAGE.containsKey(id)) {
            library.setId(id);
            BOOK_STORAGE.put(id, library);
            return true;
        }

        return false;
    }

    @Override
    public boolean delete(int id) {
        return BOOK_STORAGE.remove(id) != null;
    }
}
