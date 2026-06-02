package com.example.board;

import com.example.board.dto.Member;
import com.example.board.dto.Post;
import com.example.board.mapper.MemberMapper;
import com.example.board.mapper.PostMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class MemberMapperTest {

    @Autowired
    private MemberMapper memberMapper;

    @Autowired
    private PostMapper postMapper;

    @Test
    void 회원가입() {
        Member member1 = new Member();
        member1.setUsername("홍길동");
        member1.setEmail("hong@example.com");
        memberMapper.insert(member1);
        System.out.println("저장된 회원 id: " + member1.getId());

        Member member2 = new Member();
        member2.setUsername("김철수");
        member2.setEmail("kim@example.com");
        memberMapper.insert(member2);
        System.out.println("저장된 회원 id: " + member2.getId());
    }

    @Test
    void 회원_게시글_작성() {
        // 회원 먼저 생성
        Member member = new Member();
        member.setUsername("테스트유저");
        member.setEmail("test@example.com");
        memberMapper.insert(member);

        // 생성된 회원의 id를 바로 사용
        Post post = new Post();
        post.setTitle("회원이 쓴 게시글");
        post.setContent("내용입니다.");
        post.setMemberId(member.getId());  // 자동으로 생성된 id 사용
        postMapper.insert(post);
        System.out.println("저장된 게시글 id: " + post.getId());
        System.out.println("작성자 member_id: " + post.getMemberId());
    }

    @Test
    void 게시글_회원정보_함께_조회() {
        postMapper.findAll(null, null).forEach(post -> {
            System.out.println("게시글: " + post.getTitle());
            if (post.getMember() != null) {
                System.out.println("작성자: " + post.getMember().getUsername());
                System.out.println("이메일: " + post.getMember().getEmail());
            } else {
                System.out.println("작성자: 회원 정보 없음");
            }
            System.out.println("---");
        });
    }
}