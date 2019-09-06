package scratches.data.jdbc.book;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.jdbc.DataJdbcTest;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author Rashidi Zin
 */
@DataJdbcTest
class AuthorRepositoryTests {

    @Autowired
    private AuthorRepository repository;

    @Test
    void save() {
        repository.save(new Author("Rudyard Kipling"));

        assertThat(repository.count()).isEqualTo(1L);
    }

    @Test
    @DisplayName("Find an author by name with case insensitive")
    void findByName() {
        var name = "Rudyard Kipling";

        repository.save(new Author(name));

        var savedAuthor = repository.findByName(name.toLowerCase());

        assertThat(savedAuthor).isNotNull();
    }

}