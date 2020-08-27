package recolap.rest_api.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import recolap.rest_api.model.Member;


@Repository
public interface MemberRepository extends JpaRepository<Member, Long> { }