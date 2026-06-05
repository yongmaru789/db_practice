package com.example.board.service;

import com.example.board.dto.Comment;
import com.example.board.dto.Post;
import com.example.board.dto.PostDetailDto;
import com.example.board.mapper.PostMapper;
import com.example.board.repository.CommentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PostService {

    private final PostMapper postMapper;
    private final CommentRepository commentRepository;

    public PostDetailDto getPostDetail(Long postId) {
        // MySQL에서 게시글 조회
        Post post = postMapper.findById(postId);

        // MongoDB에서 댓글 조회
        List<Comment> comments = commentRepository.findByPostId(postId);

        // 합쳐서 반환
        PostDetailDto dto = new PostDetailDto();
        dto.setPost(post);
        dto.setComments(comments);

        return dto;
    }
}