package com.my.blog.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.my.blog.entity.HeadLine;

public interface IHeadLineRepository extends JpaRepository<HeadLine, Integer>{

	
	
	@Query(value = " SELECT * "
			+ " FROM "
			+ "    headline "
			+ " ORDER BY id DESC "
			+ " LIMIT 1 ", nativeQuery = true)
	HeadLine findByLastDto();

	
}
