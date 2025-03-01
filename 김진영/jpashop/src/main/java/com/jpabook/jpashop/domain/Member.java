package com.jpabook.jpashop.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
public class Member {
    @Id @GeneratedValue
    @Column(name="member_id") //컬럼명 지정 (안하면 그냥 id됨)
    private Long id;
    private String name;

    @Embedded //내장 타입을 포함하고 있음을 알 수 있음
    private Address address;

    @JsonIgnore
    @OneToMany(mappedBy = "member") //매핑된 거울이라는 의미
    private List<Order> orders = new ArrayList<>();
}
