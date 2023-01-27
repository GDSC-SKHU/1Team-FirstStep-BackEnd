package gdsc.com.firststep.post.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "category")
public class Categories {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // auto increment
    private Long id;
    @OneToMany(mappedBy = "categories", fetch = FetchType.LAZY, cascade = CascadeType.PERSIST, orphanRemoval = true)
    private List<Posts> posts = new ArrayList<>();
    @Column(name = "category_name", nullable = false)
    private String category_name;
}
