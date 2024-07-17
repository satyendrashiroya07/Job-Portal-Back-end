package com.shiroya.Findjob.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.shiroya.Findjob.model.JobPost;

import jakarta.transaction.Transactional;

@Repository
public interface JobRepo extends JpaRepository<JobPost, Integer> {

	
	 @Query("SELECT jp FROM JobPost jp WHERE jp.postProfile LIKE %:keyword% OR jp.postDesc LIKE %:keyword1%")
	  List<JobPost> findByPostProfileContainingOrPostdescContaining(String keyword, String keyword1 );
	
	 
	 @Transactional
	 @Modifying
	 @Query("update JobPost jp set jp.postProfile = :postProfile where jp.postId = :postId")
	 List<JobPost> save(int postId, String postProfile);
	 
}