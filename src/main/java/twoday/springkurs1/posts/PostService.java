package twoday.springkurs1.posts;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class PostService {

    public List<Post> getPosts() {
        return posts.values().stream().toList();
    }

    private final Map<Integer, Post> posts = List.of(
            new Post(
                    1,
                    "Hello World",
                    "This is my first post",
                    "John Doe"
            ),
            new Post(
                    2,
                    "Spring Boot",
                    "Learning Spring Boot is fun!",
                    "Jane Doe"
            ),
            new Post(
                    3,
                    "Java Streams",
                    "Streams in Java make data processing easier.",
                    "John Smith"
            )
    ).stream().collect(Collectors.toMap(Post::id, post -> post));
}
