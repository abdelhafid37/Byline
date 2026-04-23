package ByLine.com.ByLine.models;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String slug;
    
    @Column(columnDefinition = "TEXT")
    private String content;

    private String excerpt;
    private String coverImage;

    private Integer readTime;

    @CreationTimestamp
    private LocalDateTime createdAt;

    @ManyToOne
    private Author author;

    @ManyToOne
    private Category category;
}