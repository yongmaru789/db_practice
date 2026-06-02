package com.example.board.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import java.time.LocalDateTime;

@Getter
@Setter
@ToString
public class Member {
    private Long id;
    private String username;
    private String email;
    private LocalDateTime createdAt;
}
