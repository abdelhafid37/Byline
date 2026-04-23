package ByLine.com.ByLine.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import ByLine.com.ByLine.models.Post;

public interface PostRepo extends JpaRepository<Post, Long>{
    Optional<Post> findBySlug(String slug);
    List<Post> findByCategory_Slug(String slug);
}
