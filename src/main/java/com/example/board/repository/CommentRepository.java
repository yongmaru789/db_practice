package com.example.board.repository;

import com.example.board.dto.Comment;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.List;

public interface CommentRepository extends MongoRepository<Comment, String> {
    // 특정 게시글의 댓글 전체 조회
    List<Comment> findByPostId(Long postId);

    // 특정 게시글의 댓글 삭제
    void deleteByPostId(Long postId);
}