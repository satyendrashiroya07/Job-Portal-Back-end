package com.shiroya.Findjob;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.shiroya.Findjob.model.JobPost;
import com.shiroya.Findjob.service.JobService;

@RestController
@CrossOrigin(origins = "http://localhost:3000/")
public class JobController {
	
	@Autowired
	private JobService service;
	
	@GetMapping("jobPosts")
	public List<JobPost> getAllJobs() {
		System.out.println("Hellllllll");
	return  service.getAllJobs();
	}
	
	@GetMapping("JobPost/{Postid}")
	public JobPost getJob(@PathVariable int Postid) {
		return service.getJob(Postid);
		
	}
	
	@PostMapping("jobPost")
	public JobPost addJob(@RequestBody JobPost jobPost) {
		service.addJob(jobPost);
		return service.getJob(jobPost.getPostId());
	}
	
	
	
	@PutMapping("jobPost1")
	public JobPost updateJob(@RequestBody JobPost jobPost) {
		service.updateJob(jobPost);
		return service.getJob(jobPost.getPostId());
	}
	
	
	
	
	@DeleteMapping("jobPost/{postId}")
	public String deleteJob(@PathVariable int postId)
	{
		service.deleteJob(postId);
		return "Deleted";
	}
	
	
	@GetMapping("load")
	public String loadData() {
		service.load();
		return "success";
	}
	
	
	  @GetMapping("JobPost/keyword/{keyword}") 
	  public List<JobPost> searchBykeyword(@PathVariable("keyword") String keyword)
	  { 
	  return service.search(keyword);
	  
	  }
	 

}
