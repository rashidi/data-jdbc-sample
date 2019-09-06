package scratches.data.jdbc.book;

import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.util.Assert;

/**
 * @author Rashidi Zin
 */
@Data
@RequiredArgsConstructor
public class Author {

    @Id
    private Long id;

    @NonNull
    private String name;

    public String getName() {
        Assert.hasText(name, "name must contain text");
        return name;
    }

}
