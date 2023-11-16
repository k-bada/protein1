package protein.proteinspring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import protein.proteinspring.entity.Posting;

@Repository
public interface PostingRepository extends JpaRepository<Posting, Long> {

}
