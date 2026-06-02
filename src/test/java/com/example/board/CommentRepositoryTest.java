package com.example.board;

import com.example.board.dto.Comment;
import com.example.board.repository.CommentRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import java.time.LocalDateTime;
import java.util.List;

@SpringBootTest
public class CommentRepositoryTest {

    @Autowired
    private CommentRepository commentRepository;

    @Test
    void 댓글_작성() {
        Comment comment = new Comment();
        comment.setPostId(7L);
        comment.setContent("첫 번째 댓글");
        comment.setAuthor("홍길동");
        comment.setCreatedAt(LocalDateTime.now());

        Comment saved = commentRepository.save(comment);
        System.out.println("저장된 댓글 id: " + saved.getId());
    }

    @Test
    void 댓글_전체조회() {
        commentRepository.findAll().forEach(System.out::println);
    }

    @Test
    void 게시글별_댓글조회() {
        List<Comment> comments = commentRepository.findByPostId(7L);
        comments.forEach(System.out::println);
    }

    @Test
    void 댓글_삭제() {
        commentRepository.deleteByPostId(7L);
        System.out.println("삭제 완료");
    }
}