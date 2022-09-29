package com.wak.igo.domain;

import com.wak.igo.dto.request.PostRequestDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.util.List;



@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Post extends Timestamped {

    //Json형식으로 받기
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false) //
    private String title;

    @Column(nullable = false) //
    private String content;



    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Comment> comments;
    //
    @JoinColumn(name = "member_id", nullable = false)
    @ManyToOne(fetch = FetchType.LAZY)
    private Member member;


    @Column
    private int viewCount;

    @Column
    private String tag;

    @Column
    private int heartNum;

    @Column(nullable = false)
    private int amount;

    public void add_viewCount() {
        this.viewCount++;}

    public void addHeart() {
        this.heartNum++;
    }

    public void removeHeart() {
        int tempHeart = this.heartNum - 1;
        if (tempHeart < 0) {
            return;
        }
        this.heartNum = tempHeart;
    }

    public void update(PostRequestDto postRequestDto) {
        this.title = postRequestDto.getTitle();
        this.content = postRequestDto.getContent();
        this.amount = postRequestDto.getAmount();

    }
}











