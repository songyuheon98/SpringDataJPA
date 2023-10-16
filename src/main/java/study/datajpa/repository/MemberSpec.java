package study.datajpa.repository;

import jakarta.persistence.criteria.*;
import org.springframework.data.jpa.domain.Specification;
import study.datajpa.entity.Member;
import study.datajpa.entity.Team;

public class MemberSpec {
    public static Specification<Member> teamName(final String teamName){

        return (Specification<Member>) (root, query, builder) -> {
            if(teamName == null){
                return null;
            }
            Join<Member, Team> t = root.join("team", JoinType.INNER);
            return builder.equal(t.get("name"), teamName);
        };
    }
    public static Specification<Member> username(final String username){

        return (Specification<Member>) (root, query, builder) ->
             builder.equal(root.get("username"), username);

    }
}
