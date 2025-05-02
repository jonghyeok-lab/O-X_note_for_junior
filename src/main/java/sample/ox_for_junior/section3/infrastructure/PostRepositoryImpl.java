package sample.ox_for_junior.section3.infrastructure;

import lombok.RequiredArgsConstructor;
import sample.ox_for_junior.section3.infrastructure.PostJpaRepository;
import sample.ox_for_junior.section3.service.port.PostRepository;

@RequiredArgsConstructor
public class PostRepositoryImpl implements PostRepository {

    private final PostJpaRepository postJpaRepository;
}
