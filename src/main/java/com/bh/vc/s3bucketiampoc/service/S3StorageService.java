package com.bh.vc.s3bucketiampoc.service;

import java.util.List;
import java.util.stream.Collectors;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.ObjectListing;
import com.amazonaws.services.s3.model.S3ObjectSummary;
import com.bh.vc.s3bucketiampoc.exception.StorageException;

public class S3StorageService {

	AmazonS3 s3;

	public void init() {
		s3 = AmazonS3ClientBuilder.standard().build();
	}

	public List<String> listFiles() {
		List<S3ObjectSummary> summaries = null;
		String bucketName = "mybucket";

		try {
			ObjectListing objectListing = s3.listObjects(bucketName);
			summaries = objectListing.getObjectSummaries();
		} catch (Exception e) {
			throw new StorageException("Failed to list objects for buckert", e);
		}

		return summaries.stream().map(S3ObjectSummary::getKey).collect(Collectors.toList());
	}
}