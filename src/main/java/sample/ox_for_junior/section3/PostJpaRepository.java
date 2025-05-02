package sample.ox_for_junior.section3;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PostJpaRepository extends JpaRepository<Post, Long>, PostQuerydslRepository {
}
