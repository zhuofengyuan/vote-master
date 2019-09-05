package com.zhuofengyuan.mlszm.vote.service;

import com.zhuofengyuan.mlszm.vote.entity.File;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.http.codec.multipart.FilePart;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author fengtoos
 * @since 2019-08-27
 */
public interface IFileService extends IService<File> {

    File uploadReactive(FilePart filePart) throws IOException;

    File upload(MultipartFile file) throws IOException;
}
