package study.datajpa.repository;

import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import study.datajpa.entity.Member;

import java.util.List;

@RequiredArgsConstructor
/**
 * 반드시 상속할 인터페이스 이름 뒤에 Impl을 붙여서 클래스 이름을 만들어야 한다.
 * 이렇게 하면 스프링 데이터 JPA가 인식해서 스프링 빈으로 등록한다.
 * 이제 MemberRepository를 사용하는 곳에서는 MemberRepositoryImpl을 직접 사용하지 않고,
 * 스프링 데이터 JPA가 제공하는 인터페이스인 MemberRepository를 통해서 사용한다.
 */
public class MemberRepositoryImpl implements MemberRepositoryCustom{
    private final EntityManager em;
    @Override
    public List<Member> findMemberCustom() {
        return em.createQuery("select m from Member m")
                .getResultList();
    }
}
