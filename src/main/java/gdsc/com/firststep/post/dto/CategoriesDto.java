package gdsc.com.firststep.post.dto;
import lombok.*;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CategoriesDto {
    private long id;
    private String category_name;
}
