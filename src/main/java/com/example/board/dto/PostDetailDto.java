package com.example.board.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import java.util.List;

@Getter
@Setter
@ToString
public class PostDetailDto {
    private Post post;
    private List<Comment> comments;
}