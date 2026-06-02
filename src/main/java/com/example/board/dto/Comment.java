package com.example.board.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@Document(collection = "comments")
public class Comment {
    @Id
    private String id;
    private Long postId;
    private String content;
    private String author;
    private LocalDateTime createdAt;
}