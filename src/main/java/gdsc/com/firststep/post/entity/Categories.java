package gdsc.com.firststep.post.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "category")
public class Categories {
    @Id
    private String id;

    @Column(name = "category_name", nullable = false)
    private String categoryName;
}
