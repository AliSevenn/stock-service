package com.alis.stockservice.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.alis.stockservice.entity.ProductEntity;

@Repository
public interface ProductRepository extends JpaRepository<ProductEntity, Long> {

	ProductEntity findByProductId(Long id);

	@Query("select m from ProductEntity m where m.productId in( :productIds)  and m.name in ( :names)")
	List<ProductEntity> findByProductIdInAndNameIn(List<Long> productIds, List<String> names);

}
