package com.example.board;

import com.example.board.dto.Post;
import com.example.board.mapper.PostMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class PostMapperTest {

    @Autowired
    private PostMapper postMapper;

    @Test
    void 게시글_작성() {
        Post post = new Post();
        post.setTitle("첫 번째 게시글");
        post.setContent("내용입니다.");
        post.setAuthor("홍길동");

        postMapper.insert(post);
        System.out.println("저장된 게시글 id: " + post.getId());
    }

    @Test
    void 게시글_전체조회() {
        postMapper.findAll().forEach(System.out::println);
    }

    @Test
    void 게시글_단건조회() {
        Post post = postMapper.findById(1L);
        System.out.println(post);
    }

    @Test
    void 게시글_수정() {
        Post post = new Post();
        post.setId(1L);
        post.setTitle("수정된 제목");
        post.setContent("수정된 내용");

        postMapper.update(post);
        System.out.println("수정 완료");
    }

    @Test
    void 게시글_삭제() {
        postMapper.delete(1L);
        System.out.println("삭제 완료");
    }
}