package jpabook.jpashop.domain.item;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("B") //싱글테이블에 구분해서 넣는 값
@Getter @Setter
public class Book extends Item{

    private String author;
    private String isbn;
}
