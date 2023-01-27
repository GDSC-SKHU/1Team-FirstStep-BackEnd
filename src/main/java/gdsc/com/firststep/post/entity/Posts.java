package gdsc.com.firststep.post.entity;


import gdsc.com.firststep.login.domain.User;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
@Table(name = "posts")
public class Posts {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // auto increment
    private Long id;

    @Column(length = 500, nullable = false)
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    @ManyToOne
    @JoinColumn(name = "nickname") // 외래키
    private User users;


    private String author;

    @ManyToOne(targetEntity = Categories.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "categories_id") // 외래키
    private Categories categories;
    @Builder
    public Posts(String title, String content, String author) {
        this.title = title;
        this.content = content;
        this.author = author;
    }

    public void update(String title , String content) {
        this.title = title;
        this.content = content;
    }
}