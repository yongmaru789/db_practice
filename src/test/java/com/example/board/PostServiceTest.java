package com.example.board;

import com.example.board.dto.PostDetailDto;
import com.example.board.service.PostService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class PostServiceTest {

    @Autowired
    private PostService postService;

    @Test
    void 게시글_상세조회() {
        PostDetailDto detail = postService.getPostDetail(7L);

        System.out.println("=== 게시글 정보 ===");
        System.out.println("제목: " + detail.getPost().getTitle());
        System.out.println("내용: " + detail.getPost().getContent());
        if (detail.getPost().getMember() != null) {
            System.out.println("작성자: " + detail.getPost().getMember().getUsername());
        }

        System.out.println("\n=== 댓글 목록 ===");
        if (detail.getComments().isEmpty()) {
            System.out.println("댓글이 없어요.");
        } else {
            detail.getComments().forEach(comment -> {
                System.out.println("댓글 작성자: " + comment.getAuthor());
                System.out.println("댓글 내용: " + comment.getContent());
                System.out.println("---");
            });
        }
    }
}