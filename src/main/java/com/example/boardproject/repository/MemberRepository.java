package com.example.boardproject.repository;

import com.example.boardproject.entity.Member;
import org.springframework.data.repository.CrudRepository;

public interface MemberRepository extends CrudRepository<Member, Long> {
}
