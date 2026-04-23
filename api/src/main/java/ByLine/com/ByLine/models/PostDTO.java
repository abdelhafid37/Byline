package ByLine.com.ByLine.models;

public class PostDTO {
    public Long id;
    public String title;
    public String slug;
    public String excerpt;
    public String content;
    public String coverImage;
    public Integer readTime;
    public String createdAt;

    public AuthorDTO author;
    public CategoryDTO category;
}
