package com.shanghai.service;

import org.springframework.web.multipart.commons.CommonsMultipartFile;

import java.util.Map;

/**
 * Created by 陈涛 on 2017/5/26.
 */
public interface TransferUploadService {

    Map<String, String> importExcel(CommonsMultipartFile file, String realPath);
}
