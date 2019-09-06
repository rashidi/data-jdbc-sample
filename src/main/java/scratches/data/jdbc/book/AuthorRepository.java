package scratches.data.jdbc.book;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

/**
 * @author Rashidi Zin
 */
public interface AuthorRepository extends CrudRepository<Author, Long> {

    @Query("SELECT * FROM author WHERE upper(name) = upper(:name)")
    Author findByName(@Param("name") String name);

}
