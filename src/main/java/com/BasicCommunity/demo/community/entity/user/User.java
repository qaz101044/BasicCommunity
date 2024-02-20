package com.BasicCommunity.demo.community.entity.user;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    // null값 없음(해당 열에 빈 값 x) , 해당 열의 값이 고유함(동일 값을 가지지 않음)
    @Column(nullable = false, unique = true)
    private String username;

    // @JsonIgnore다음 메서드가 JSON 직렬화 및 역직렬화 과정에서 무시되도록 지시함.
    @JsonIgnore
    @Column(nullable = false)
    private String  password;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false, unique = true)
    private String nickname;

    // enum 이름을 DB에 저장
    @Enumerated(EnumType.STRING)
    private Authority authority;

    @Builder
    public User(String username, String password, Authority authority) {
        this.username = username;
        this.password = password;
        this.name = name;
        this.nickname = nickname;
        this.authority = authority;
    }


}
