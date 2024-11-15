package in.ashokit.rest;


import in.ashokit.entity.Book;
import in.ashokit.repo.BookRepo;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class BookRestController {

    @Autowired
    private BookRepo bookRepo;

    @PostMapping("/book")
    public ResponseEntity<Book> saveBook(@RequestBody Book book){
        Book save = bookRepo.save(book);
        return new ResponseEntity<>(save, HttpStatus.CREATED);
    }

    @PutMapping("/book/{bookId}")
    public ResponseEntity<Book> saveBook(@RequestBody Book book, @PathVariable Integer bookId){
        book.setBookId(bookId);
        Book save = bookRepo.save(book);
        return new ResponseEntity<>(save, HttpStatus.OK);
    }

    @GetMapping("/books")
    public ResponseEntity<List<Book>> getBooks(){
        List<Book> all = bookRepo.findAll();
        return new ResponseEntity<>(all, HttpStatus.OK);
    }

    @GetMapping("/book/{bookId}")
    public ResponseEntity<Book> getBook(@PathVariable Integer bookId){
        Optional<Book> byId = bookRepo.findById(bookId);
        if(byId.isPresent()){
            return new ResponseEntity<>(byId.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.OK);

    }

    @DeleteMapping("/book/{bookId}")
    public ResponseEntity<Book> deleteBook(@PathVariable Integer bookId){
        Optional<Book> byId = bookRepo.findById(bookId);

        if(byId.isPresent()){
            bookRepo.deleteById(bookId);
            return new ResponseEntity<>(byId.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.OK);

    }
}
