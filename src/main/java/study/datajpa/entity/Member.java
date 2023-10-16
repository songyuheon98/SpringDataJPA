package study.datajpa.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter @Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString(of = {"id", "username", "age"})
public class Member {

    @Id @GeneratedValue
    @Column(name = "member_id")
    private Long id;

    private String username;

    private int age;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "team_id")
    private Team team;


    /**
     * JPA에서는 기본 생성자가 필수이다.
     * 그래서 protected로 막아놓고, Member를 생성할 때는
     * Member(String memberA)를 사용한다.
     */
    public Member(String memberA) {
        this.username = memberA;
    }

    public Member(String username, int i, Team team) {
        this.username =  username;
        this.age = i;
        if (team != null) {
            changeTeam(team);
        }
    }

    public Member(String aaa, int i) {
        this.username = aaa;
        this.age = i;
    }

    public void changeUsername(String username) {
        this.username = username;
    }

    public void changeTeam(Team team) {
        this.team = team;
        team.getMembers().add(this);
    }
}
