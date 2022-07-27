package com.bh.vc.s3bucketiampoc.controller;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.bh.vc.s3bucketiampoc.service.S3StorageService;
 
@RestController
public class S3BucketController {
 
  private S3StorageService storageService;
 
  @Autowired
  public S3BucketController(S3StorageService storageService) {
    this.storageService = storageService;
  }
 
  @GetMapping("/")
  @ResponseBody
  public ResponseEntity<Model> listUploadedFiles(Model model) throws IOException {
 
    model.addAttribute("files", storageService.`listFiles()); 
 
    return ResponseEntity.ok(model);
  }
}