package com.example.board.mapper;

import com.example.board.dto.Member;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;

@Mapper
public interface MemberMapper {
    // 회원 전체 조회
    List<Member> findAll();

    // 회원 단건 조회
    Member findById(Long id);

    // 회원 가입
    void insert(Member member);

    // 회원 삭제
    void delete(Long id);
}