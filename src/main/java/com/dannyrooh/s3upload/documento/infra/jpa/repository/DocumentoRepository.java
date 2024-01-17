package com.dannyrooh.s3upload.documento.infra.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dannyrooh.s3upload.documento.infra.jpa.entity.DocumentoJpa;

@Repository
public interface DocumentoRepository  extends JpaRepository<DocumentoJpa, Integer> {

}