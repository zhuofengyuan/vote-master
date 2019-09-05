package com.zhuofengyuan.mlszm.vote.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zhuofengyuan.mlszm.vote.entity.File;
import com.zhuofengyuan.mlszm.vote.mapper.FileMapper;
import com.zhuofengyuan.mlszm.vote.security.UserInstance;
import com.zhuofengyuan.mlszm.vote.service.IFileService;
import com.zhuofengyuan.mlszm.vote.util.keygen.KeyGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.buffer.DataBufferUtils;
import org.springframework.http.codec.multipart.FilePart;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.channels.AsynchronousFileChannel;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author fengtoos
 * @since 2019-08-27
 */
@Service
public class FileServiceImpl extends ServiceImpl<FileMapper, File> implements IFileService {

    private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
    @Value("${file.temppath}")
    public String tempPath;
    @Autowired
    KeyGenerator<String> keygen;
    @Autowired
    UserInstance userInstance;

    @Override
    public File uploadReactive(FilePart filePart) throws IOException {
        Path tempFile = Files.createTempFile(tempPath, keygen.generateKey());
        AsynchronousFileChannel channel = AsynchronousFileChannel.open(tempFile, StandardOpenOption.WRITE);
        File entity = new File();
        entity.setCreateTime(new Date());
        entity.setFilename(filePart.filename());
        entity.setPath(tempFile.toString());
        entity.setCreateUser(this.userInstance.getCurrentUser().getId());
        entity.setType(1);
        DataBufferUtils.write(filePart.content(), channel, 0)
                .doOnComplete(() -> {
                    this.save(entity);
                }).subscribe();
        return entity;
    }

    @Override
    public File upload(MultipartFile file) throws IOException {
        //创建存储路径
        Path path = Paths.get(String.format("upload%s%s%s%s.jpeg",
                java.io.File.separator,
                this.sdf.format(new Date()),
                java.io.File.separator,
                this.keygen.generateKey()));

        //判断父目录是否存在并创建
        if(!path.getParent().isAbsolute()){
            Files.createDirectories(path.getParent());
        }

        File entity = new File();
        entity.setCreateTime(new Date());
        entity.setFilename(file.getName());
        entity.setPath(path.toUri().getPath());
        entity.setCreateUser(this.userInstance.getCurrentUser().getId());
        entity.setType(1);

        //保存文件
        file.transferTo(Files.createFile(path));
        this.save(entity);
        return entity;
    }


}
