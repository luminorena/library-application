package rest.library.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rest.library.model.Library;

import java.util.ArrayList;
import java.util.List;

@RestController
public class LibraryController {

    private final LibraryService libraryService;


    @Autowired
    public LibraryController(LibraryService libraryService) {
        this.libraryService = libraryService;
    }


    @PostMapping(value = "/create_books")
    public ResponseEntity<?> create(@RequestBody Library library) {
        libraryService.create(library);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping(value = "/books")
    public ResponseEntity<List<Library>> read() {
        final List<Library> library = libraryService.readAll();
        final List<Library> emptyList = new ArrayList<>();

        return library != null &&  !library.isEmpty()
                ? new ResponseEntity<>(library, HttpStatus.OK)
                : new ResponseEntity<>(emptyList, HttpStatus.OK);
    }

    @GetMapping(value = "/books/{id}")
    public ResponseEntity<Library> read(@PathVariable(name = "id") int id) {
        final Library library = libraryService.read(id);

        return library != null
                ? new ResponseEntity<>(library, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }


    @PutMapping(value = "/books/{id}")
    public ResponseEntity<?> update(@PathVariable(name = "id") String id,
                                    @RequestBody Library library) {
        final boolean updated = libraryService.update(library, id);
        return updated
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }

    @DeleteMapping(value = "/books/{id}")
    public ResponseEntity<?> delete(@PathVariable(name = "id") int id) {
        final boolean deleted = libraryService.delete(id);

        return deleted
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }
}


