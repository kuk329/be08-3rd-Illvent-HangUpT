package illvent.backend.post.domain;

import illvent.backend.comment.domain.Comment;
import illvent.backend.member.domain.Member;
import illvent.backend.post.dto.PostUpdateRequestDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Table(name = "Post")
public class Post{

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "no")
    private Long no;

    @Column(nullable = false, length = 255)
    private String title;

    @Column(nullable = false, length = 1023)
    private String content;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_no", nullable = false)
    private Member member;

    @CreationTimestamp
    @Column(name = "created_date", nullable = false)
    private LocalDateTime createDate;

    @UpdateTimestamp
    @Column(name = "updated_date")
    private LocalDateTime updateDate;

    @OneToMany(mappedBy = "post")
    private List<Comment> comments = new ArrayList<>();

    public void update(PostUpdateRequestDTO postUpdateRequestDTO) {
        Optional.ofNullable(postUpdateRequestDTO.getTitle()).ifPresent(title -> this.title = title);
        Optional.ofNullable(postUpdateRequestDTO.getContent()).ifPresent(content -> this.content = content);
        Optional.ofNullable(postUpdateRequestDTO.getUpdateDate()).ifPresent(updateDate -> this.updateDate = updateDate);
    }
}
