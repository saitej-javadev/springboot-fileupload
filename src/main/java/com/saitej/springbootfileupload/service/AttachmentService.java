package com.saitej.springbootfileupload.service;

import com.saitej.springbootfileupload.entity.Attachment;
import org.springframework.web.multipart.MultipartFile;

public interface AttachmentService {
    Attachment saveAttachment(MultipartFile file) throws Exception;

    Attachment getAttachment(String id) throws Exception;
}
