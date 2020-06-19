package com.app.agritech.service.impl;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;

import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.app.agritech.service.CloudinaryService;
import com.cloudinary.Cloudinary;

@Service
public class CloudinaryServiceImpl implements CloudinaryService {

  @Value("${sarvika.cloudinary.api.id}")
  private Long id;

  @Value("${sarvika.cloudinary.api.apiKey}")
  private String apiKey;

  @Value("${sarvika.cloudinary.api.apiSecret}")
  private String apiSecret;

  @Value("${sarvika.cloudinary.api.cloudName}")
  private String cloudName;

  @Value("${sarvika.cloudinary.api.folderName}")
  private String folderName;

  Map<String, String> map;

  Cloudinary cloudinary;

  void setUpCloudinary() {
    map = new HashMap<>();
    map.put("cloud_name", cloudName);
    map.put("api_key", apiKey);
    map.put("api_secret", apiSecret);
    map.put("folder_name", folderName);
    cloudinary = new Cloudinary(map);
  }

  public String uploadImage(MultipartFile file, String folderName) {
    String uploadedFileUrl = null;
    if (file != null && !(file.getOriginalFilename().isEmpty())) {

      try {
        File tempfile = File.createTempFile(folderName.toLowerCase() + "_", "");
        InputStream inputStream = file.getInputStream();
        OutputStream outputStream = new FileOutputStream(tempfile);
        IOUtils.copy(inputStream, outputStream);
        setUpCloudinary();
        @SuppressWarnings("unchecked")
        Map<String, String> fileDetailMap = cloudinary.uploader().upload(tempfile, map);
        if (!fileDetailMap.isEmpty()) {
          uploadedFileUrl = fileDetailMap.get("url");
        }
        tempfile.delete();
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
    return uploadedFileUrl;
  }

}
