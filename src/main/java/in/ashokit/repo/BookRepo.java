package in.ashokit.repo;

import in.ashokit.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepo extends JpaRepository<Book, Integer> {
//=================================================================
}
