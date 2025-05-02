package sample.ox_for_junior.section3.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import sample.ox_for_junior.section3.service.port.PostRepository;

@Service
@RequiredArgsConstructor
public class PostService {

    private final PostRepository postRepository;


}
