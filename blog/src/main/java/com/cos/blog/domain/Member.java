package com.cos.blog.domain;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.DynamicInsert;


import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;


//@DynamicInsert //column default 들어가게 하려고 ㅇㅇ
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Member {

    @Id @GeneratedValue
    @Column(name="member_id")
    private Long id;

    @Column(nullable = false, length=30, unique = true)
    private String memberName; //아이디

    @Column(nullable = false, length=100) //암호화할거기때문에 길이 넉넉히...
    private String password;

    @Column(nullable = false, length=50)
    private String email;

    @Enumerated(EnumType.STRING) //DB는 RoleType 이라는게 없다
    private RoleType role;

    @CreationTimestamp //시간이 자동으로 입력 됨
    private Timestamp createDate;

    @OneToMany(mappedBy = "member")
    private List<Board> boards=new ArrayList<>();

    @OneToMany(mappedBy = "member")
    private List<Reply> replyList=new ArrayList<>();


}
