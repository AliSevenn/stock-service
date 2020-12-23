package com.alis.stockservice.repo;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.alis.stockservice.entity.CartEntity;

@Repository
public interface CartRepository extends JpaRepository<CartEntity, Long> {
	CartEntity findByCartId(Long id);

	CartEntity findByUserId(Long id);

	CartEntity findByUserIdAndActive(Long id, boolean isActive);

}
