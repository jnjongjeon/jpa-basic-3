package jpql;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

public class jpaMain {
    public static void main(String[] args) {
        EntityManagerFactory emf =
                Persistence.createEntityManagerFactory("aa");

        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try {
            Team team = new Team();
            team.setName("TeamA");
            em.persist(team);


            Team team2 = new Team();
            team.setName("TeamA");
            em.persist(team2);

            Team team3 = new Team();
            team.setName("TeamC");
            em.persist(team3);

            Member member = new Member();
            //member.setUsername("member1");
            member.setAge(10);
            member.setUsername("member1");
            member.setTeam(team);

            em.persist(member);

            Member member2 = new Member();
            //member.setUsername("member1");
            member2.setAge(20);
            member2.setUsername("member2.");
            member2.setTeam(team3);

            em.persist(member2);

            Member member3 = new Member();
            //member.setUsername("member1");
            member3.setAge(20);
            member3.setUsername("member3.");
            member3.setTeam(team);

            em.persist(member3);

            String query2 = "update Member m set m.username='asd'";
            //flush
            em.createQuery(query2)
                    .executeUpdate();


            Member findMember = em.find(Member.class, member.getId());

            System.out.println(findMember.getAge());

            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }
        emf.close();

    }
}
