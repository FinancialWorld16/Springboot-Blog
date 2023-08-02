package com.cos.blog.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Board {

    @Id @GeneratedValue
    @Column(name="board_id")
    private Long id;

    @Column(nullable = false, length = 100)
    private String title;

    @Lob //대용량 데이터를 쓸 때 사용
    private String content; //섬머노트 라이브러리 사용 예정...

    @ColumnDefault("0")
    private int count; //조회수

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    @OneToMany(mappedBy = "board")
    private List<Reply> replyList=new ArrayList<>();

    @CreationTimestamp
    private Timestamp createDate;
}
