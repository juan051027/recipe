package dev;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RepApplication {

	public static void main(String[] args) {
		SpringApplication.run(RepApplication.class, args);
	}

}
// 10월 7일 모든 게시물 조회 bean 작성
// 10월 9일 특정 게시물, user의 모든 게시물 조회 bean 작성 및 service 와 controller 작성
// 10월 10일 List<PostDAO> 관련 response 문제 fix
// 10월 11일 response api 수정
