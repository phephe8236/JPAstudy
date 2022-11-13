package jpabook.jpashop.repository;

import jpabook.jpashop.domain.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class MemberRepository {
    
    //@PersistenceContext //JPA가 제공하는 표준 어노테이션
    private final EntityManager em;

    //회원 저장
    public void save(Member member) {
        em.persist(member); //JPA가 저장하는 로직
    }
    
    //단건 조회
    public Member findOne(Long id) {
        return em.find(Member.class, id);  //JPA가 제공하는 find 메서드
    }
    
    //리스트 조회 , // (JPQL, 반환타입) , member를 리스트로만들어줌
    public List<Member> findAll() {  //jpql - from의 대상이 table이 아니라 entity
        return em.createQuery("select m from Member m", Member.class).getResultList();
    }

    //이름으로 회원 검색
    public List<Member> findByName(String name) {
        return em.createQuery("select m from Member m where m.name = :name", Member.class)
                .setParameter("name", name)
                .getResultList();
    }
}
