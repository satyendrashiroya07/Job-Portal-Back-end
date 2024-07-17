package com.shiroya.Findjob.model;

import java.util.List;

import org.springframework.stereotype.Component;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Component
@Entity
public class JobPost {
	
	@Id
	private int postId;
	private String postProfile; 
	private String postDesc;
	private Integer reqExperience;
	private List<String> postTechStack;
	
	public JobPost() {
	      
	}
	
		
	public JobPost(int i, String string, String string2, int j, List<String> of) {
	      postId = i;
	      postProfile = string; 
	      postDesc = string2;
	      reqExperience = j;
	      postTechStack = of;
	}
	
	public int getPostId() {
		return postId;
	}
	public void setPostId(int postId) {
		this.postId = postId;
	}
	public String getPostProfile() {
		return postProfile;
	}
	public void setPostProfile(String postProfile) {
		this.postProfile = postProfile;
	}
	public String getPostDesc() {
		return postDesc;
	}
	public void setPostDesc(String postDesc) {
		this.postDesc = postDesc;
	}
	public Integer getReqExperience() {
		return reqExperience;
	}
	public void setReqExperience(Integer reqExperience) {
		this.reqExperience = reqExperience;
	}
	public List<String> getPostTechStack() {
		return postTechStack;
	}
	public void setPostTechStack(List<String> postTechStack) {
		this.postTechStack = postTechStack;
	}
	
	@Override
    public String toString() {
        return "JobPost{" +
               "id=" + postId +
               ", title='" + postProfile + '\'' +
               ", description='" + postDesc + '\'' +
               ", experienceYears=" + reqExperience +
               ", skillsRequired='" + postTechStack + '\'' +
               '}';
    }

}
