package com.alis.stockservice.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.alis.stockservice.entity.UserEntity;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {

	UserEntity findByName(String name);

	UserEntity findByPhoneNumber(Long name);

	@Query("select m from UserEntity m where m.userId in( :userIds)  and m.phoneNumber in ( :phoneNumbers)")
	List<UserEntity> findByUserIdInAndPhoneNumberIn(List<Long> userIds, List<Long> phoneNumbers);

	UserEntity findByUserId(Long userId);

}
