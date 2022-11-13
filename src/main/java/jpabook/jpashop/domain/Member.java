package jpabook.jpashop.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
public class Member {

    @Id //기본키 매핑
    @GeneratedValue
    @Column(name = "member_id") //테이블명 지정
    private Long id;

    private String name;

    //내장타입을 포함했다는 어노테이션
    @Embedded
    private Address address;

    //1대다관계 멤버입장 하나의 회원이 물건 여러개
    @OneToMany(mappedBy = "member")  //연관관계 주인x ,  mappedBy - Order 테이블에 있는 member필드 위에서 맵핑된 거울일 뿐
    private List<Order> orders = new ArrayList<>();

}
