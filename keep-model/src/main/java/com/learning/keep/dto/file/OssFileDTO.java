package com.learning.keep.dto.file;

/**
 * Created by huangdawei on 2017/9/13.
 */
public class OssFileDTO {

    /**
     * 文件存储路径
     */
    private String key;

    /**
     * 文件授权访问uri
     */
    private String presignedUri;

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getPresignedUri() {
        return presignedUri;
    }

    public void setPresignedUri(String presignedUri) {
        this.presignedUri = presignedUri;
    }
}
