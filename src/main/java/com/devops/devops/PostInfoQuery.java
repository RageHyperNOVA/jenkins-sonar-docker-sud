package com.devops.devops;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClient;

@RestController
public class PostInfoQuery {
	
	@GetMapping("/myposts/{uid}")
	public PostMessage get(@PathVariable("uid") String uid) {
		
	String URL = "https://jsonplaceholder.typicode.com/posts/"+uid;	
		
	RestClient rc = RestClient.builder().build();
	
	PostMessage result = rc.get()
	.uri(URL)
	.retrieve()
	.body(PostMessage.class);
	System.out.println(result);
	//http://localhost:8080/myposts/1
	//0d123eb4d93e4f87ab8eab93fc3f40ba
	return result;
		
	}

}
