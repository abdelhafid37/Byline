package ByLine.com.ByLine.Service;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import ByLine.com.ByLine.models.AuthorDTO;
import ByLine.com.ByLine.models.CategoryDTO;
import ByLine.com.ByLine.models.Post;
import ByLine.com.ByLine.models.PostDTO;
import ByLine.com.ByLine.repo.PostRepo;

@Service
public class PostService {

    @Autowired
    private PostRepo repo;

    // 🔥 GET ALL POSTS
    public List<PostDTO> getAllPosts() {
        return repo.findAll()
                .stream()
                .map(this::mapToDTO)
                .toList();
    }

    // 🔥 GET POST BY SLUG
    public PostDTO getBySlug(String slug) {
        Post post = repo.findBySlug(slug)
                .orElseThrow(() ->
                        new ResponseStatusException(HttpStatus.NOT_FOUND, "Post not found")
                );

        return mapToDTO(post);
    }

    // 🔥 SAFE MAPPING (NO NULL CRASH)
    private PostDTO mapToDTO(Post p) {

        PostDTO dto = new PostDTO();

        dto.id = p.getId();
        dto.title = p.getTitle();
        dto.slug = p.getSlug();
        dto.excerpt = p.getExcerpt();
        dto.content = p.getContent();
        dto.coverImage = p.getCoverImage();
        dto.readTime = p.getReadTime();

        // ✅ FIXED: createdAt safe handling
        dto.createdAt = (p.getCreatedAt() != null)
                ? p.getCreatedAt().toString()
                : null;

        // 🔹 AUTHOR (safe check optional)
        if (p.getAuthor() != null) {
            AuthorDTO author = new AuthorDTO();
            author.name = p.getAuthor().getName();
            author.avatar = p.getAuthor().getAvatar();
            dto.author = author;
        }

        // 🔹 CATEGORY (safe check optional)
        if (p.getCategory() != null) {
            CategoryDTO category = new CategoryDTO();
            category.name = p.getCategory().getName();
            category.slug = p.getCategory().getSlug();
            dto.category = category;
        }

        return dto;
    }
}