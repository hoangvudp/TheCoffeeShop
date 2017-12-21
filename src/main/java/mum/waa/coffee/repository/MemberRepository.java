package mum.waa.coffee.repository;

import mum.waa.coffee.domain.Member;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MemberRepository extends CrudRepository<Member, Long> {
	public List<Member> findByEmail(String email);

}
