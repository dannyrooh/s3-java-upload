package com.dannyrooh.s3upload.infra;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;

@Component
public class AmazonS3Repository {

    private final AmazonS3 clientS3;
    private final String bucket;

    public AmazonS3Repository(
            @Value("${app.s3.access.key}") String accessKey, 
            @Value("${app.s3.secret.key}") String secretKey,
            @Value("${app.s3.bucket}") String bucket) {

        this.bucket = bucket;
             
        var credentials = new BasicAWSCredentials(accessKey, secretKey);

        this.clientS3 = AmazonS3ClientBuilder
            .standard()
            .withCredentials(new AWSStaticCredentialsProvider(credentials))     
            .withRegion(Regions.US_EAST_1)
            .build();

        if(!clientS3.doesBucketExistV2(this.bucket)) {
            new Exception("Bucket " + this.bucket + " não existe");
        }
    }

    public void sendFile(String destinyFile, String orginFile) {
        
        clientS3.putObject(this.bucket, destinyFile, new File(orginFile));
    }

    public void sendStream(String destinyFile, InputStream inputStream ) {

        try {
            File tempFile = File.createTempFile("tempFile", null);

            try (FileOutputStream fos = new FileOutputStream(tempFile)) {
                byte[] buffer = new byte[1024];
                int bytesRead;
                while ((bytesRead = inputStream.read(buffer)) != -1) {
                    fos.write(buffer, 0, bytesRead);
                }
            }

            clientS3.putObject(this.bucket, destinyFile, tempFile);

            tempFile.delete();
        } catch (IOException e) {
            e.printStackTrace();
        }
        
    }
    
}
