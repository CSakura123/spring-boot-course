package top.syy.boot.config.service;

import org.springframework.web.multipart.MultipartFile;

/**
 * @author 小c
 */
public interface OssService {
    String upload(MultipartFile file);



}
