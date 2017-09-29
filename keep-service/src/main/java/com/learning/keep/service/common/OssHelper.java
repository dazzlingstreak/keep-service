package com.learning.keep.service.common;

import com.aliyun.oss.OSSClient;
import com.aliyun.oss.model.PutObjectResult;
import com.learning.keep.dto.file.OssFileDTO;
import com.learning.keep.properties.OssSettings;
import org.apache.commons.lang3.RandomUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by huangdawei on 2017/9/13.
 */
@Service
public class OssHelper {

    @Autowired
    private OssSettings ossSettings;

    private static SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmssSSS");
    private static final Logger logger = LoggerFactory.getLogger(OssHelper.class);

    public OssFileDTO uploadFile(InputStream stream, String fileName) {
        OssFileDTO ossFileDTO = new OssFileDTO();
        String newFileName = dateFormat.format(new Date()) + RandomUtils.nextInt(10000, 99999) + "-" + fileName;

        OSSClient ossClient = new OSSClient(ossSettings.getEndpoint(), ossSettings.getAccessKeyId(), ossSettings.getAccessKeySecret());
        String key = ossSettings.getKeyPrefix() + newFileName;
        String bucketName = ossSettings.getBucketName();
        PutObjectResult putObjectResult = null;
        try {
            putObjectResult = ossClient.putObject(bucketName, key, stream);
            if (putObjectResult != null) {
                ossFileDTO.setKey(key);

                Date expiration = new Date(new Date().getTime() + ossSettings.getExpires() * 60 * 1000);
                URL url = ossClient.generatePresignedUrl(bucketName, key, expiration);
                ossFileDTO.setPresignedUri(url.toString());
            }
        } catch (Exception ex) {
            logger.error("上传失败：{}", ex.getMessage());
        }finally {
            ossClient.shutdown();
        }
        return ossFileDTO;
    }
}
