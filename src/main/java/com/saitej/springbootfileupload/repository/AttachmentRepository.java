package com.saitej.springbootfileupload.repository;

import com.saitej.springbootfileupload.entity.Attachment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AttachmentRepository extends JpaRepository<Attachment,String> {
}
