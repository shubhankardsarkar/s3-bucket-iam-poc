package com.bh.vc.s3bucketiampoc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.bh.vc.s3bucketiampoc.service.S3StorageService;

@SpringBootApplication
public class S3BucketIamPocApplication {

	public static void main(String[] args) {
		SpringApplication.run(S3BucketIamPocApplication.class, args);
	}

	@Bean
	S3StorageService createStorageService() {
		S3StorageService storageService = new S3StorageService();
		storageService.init();

		return storageService;
	}
}
