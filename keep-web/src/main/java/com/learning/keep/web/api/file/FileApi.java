package com.learning.keep.web.api.file;

import com.learning.keep.dto.file.OssFileDTO;
import com.learning.keep.service.common.OssHelper;
import com.learning.keep.web.api.file.model.OssFileVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.cxf.jaxrs.ext.multipart.Attachment;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import javax.activation.DataHandler;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by huangdawei on 2017/9/13.
 */
@Path("/file")
@Api(tags = "文件服务模块")
public class FileApi {

    @Autowired
    private OssHelper ossHelper;

    @POST
    @Path("/upload")
    @Consumes({MediaType.MULTIPART_FORM_DATA})
    @Produces({MediaType.APPLICATION_JSON + ";charset=utf-8"})
    @ApiOperation("文件上传")
    public List<OssFileVO> upload(List<Attachment> attachments) throws IOException {
        List<OssFileVO> ossFileVOList = new ArrayList<>();
        if (!CollectionUtils.isEmpty(attachments)) {
            for (Attachment attachment : attachments) {
                DataHandler dataHandler = attachment.getDataHandler();
                String filename = attachment.getContentDisposition().getFilename();
                if (!StringUtils.isEmpty(filename)) {
                    try {
                        filename = new String(filename.getBytes("iso8859-1"), "utf-8");
                        OssFileDTO ossFileDTO = ossHelper.uploadFile(dataHandler.getInputStream(), filename);
                        OssFileVO ossFileVO = new OssFileVO();
                        BeanUtils.copyProperties(ossFileDTO, ossFileVO);
                        ossFileVOList.add(ossFileVO);
                    } catch (UnsupportedEncodingException e) {
                        e.printStackTrace();
                    }
                }

            }

        }

        return ossFileVOList;
    }
}
