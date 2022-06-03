package com.saitej.springbootfileupload.service;


import com.saitej.springbootfileupload.entity.Attachment;
import com.saitej.springbootfileupload.repository.AttachmentRepository;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

@Service
public class AttachmentServiceImpl implements AttachmentService {

    private final AttachmentRepository attachmentRepository;

    public AttachmentServiceImpl(AttachmentRepository attachmentRepository) {
        this.attachmentRepository = attachmentRepository;
    }

    @Override
    public Attachment saveAttachment(MultipartFile file) throws Exception {
       String fileName = StringUtils.cleanPath(file.getOriginalFilename());
       try {
           if (fileName.contains("..")){
               throw new Exception("Filename contains invalid path sequence "+fileName);
           }
           Attachment attachment = new Attachment(fileName,file.getContentType(),file.getBytes());
           return attachmentRepository.save(attachment);
       }catch (Exception e){
           throw new Exception("Could not save File"+ fileName);
       }
    }

    @Override
    public Attachment getAttachment(String id) throws Exception {

        return attachmentRepository.findById(id).orElseThrow(() -> new Exception("File not found with Id: " + id));
    }
}
