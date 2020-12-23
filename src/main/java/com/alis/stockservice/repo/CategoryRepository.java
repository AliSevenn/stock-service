package com.alis.stockservice.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.alis.stockservice.entity.CategoryEntity;

@Repository
public interface CategoryRepository extends JpaRepository<CategoryEntity, Long> {

	CategoryEntity findByCategoryId(Long id);

	List<CategoryEntity> findByCategoryIdInAndNameIn(List<Long> categoryIds, List<String> names);

}
