package sample.ox_for_junior.section3.infrastructure;

import org.springframework.data.jpa.repository.JpaRepository;
import sample.ox_for_junior.section3.domain.Post;

public interface PostJpaRepository extends JpaRepository<Post, Long>, PostQuerydslRepository {
}
