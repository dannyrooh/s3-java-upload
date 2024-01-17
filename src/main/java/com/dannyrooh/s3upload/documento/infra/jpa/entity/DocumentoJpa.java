package com.dannyrooh.s3upload.documento.infra.jpa.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "Documento")
public class DocumentoJpa implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id", nullable = false)
    private Integer id;
    
    @Column(name = "Nome", nullable = false , length = 250)
    private String nome;
    
    @Column(name = "Extensao", nullable = true , length = 10)
    private String extensao;
    
    @Column(name = "Caminho", nullable = false , length = 500)
    private String caminho;
    
    @Column(name = "Checksum", nullable = true , length = 64)
    private String checksum;
    
    

}