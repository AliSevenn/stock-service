package com.alis.stockservice.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.alis.stockservice.entity.AddressEntity;

@Repository
public interface AddressRepository extends JpaRepository<AddressEntity, Long> {

	AddressEntity findByAddressId(Long id);

	List<AddressEntity> findByRegionIn(List<Long> regionIds);

}
