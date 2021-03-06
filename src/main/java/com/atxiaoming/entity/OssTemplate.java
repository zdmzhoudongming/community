package com.atxiaoming.entity;

import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.io.InputStream;

@Data
@Component
public class OssTemplate {
    //@Value("${oss.endpoint}")
    // 域名
    String endpoint = "oss-accelerate.aliyuncs.com" ;
    // 云账号AccessKey有所有API访问权限，建议遵循阿里云安全最佳实践，创建并使用RAM子账号进行API访问或日常运维，请登录
    // https://ram.console.aliyun.com 创建。
    String accessKeyId = "LTAI4G9ddDon4Lcx2R4fHkEo";
    String accessKeySecret = "HGcYPn6Z9LMfIOf1Ql7i0IaYNCXZiL" ;
    String bucketName = "xmcommunity" ;
    String path="/pic" ;

    public String upload(InputStream inputStream, String filename) {
        try {

            // 创建OSSClient实例。
            OSS ossClient = new OSSClientBuilder().build(endpoint, accessKeyId, accessKeySecret);

            // 上传文件流。
            //InputStream inputStream = new FileInputStream("D:/temp/p2.jpg");
            ossClient.putObject(bucketName, "pic/"+filename, inputStream);

            // 关闭OSSClient。
            ossClient.shutdown();
            return "https://"+bucketName+"."+endpoint+path+"/"+filename ;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    public String delete(String filename) {
        try {

            // 创建OSSClient实例。
            OSS ossClient = new OSSClientBuilder().build(endpoint, accessKeyId, accessKeySecret);

            ossClient.deleteObject(bucketName, filename);
            // 关闭OSSClient。
            ossClient.shutdown();
            return "success" ;
        } catch (Exception e) {
            e.printStackTrace();
            return "error";
        }

    }
}
