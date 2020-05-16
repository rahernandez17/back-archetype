package com.uniajc.smartcampus.certificados.model;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tipo_certificado")
@ApiModel(description = "Entidad JPA para tipos de certificado")
public class TypeCertificate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "tc_id")
    @ApiModelProperty(notes = "ID del tipo de certificado", required = true)
    private  Long tcId;

    @Column(name = "tc_nombre")
    private String tcName;

    @Column(name = "tc_estado")
    private Boolean tcState;

    @Column(name = "tc_responsable")
    private String tcResponsable;

    @Column(name = "tc_cargo_responsable")
    private String tcJob;

    @Column(name = "tc_usuario_firma")
    private String tcUserFirm;

    @Column(name = "tc_pass_firma")
    private String tcPassFirm;

    @Column(name = "tc_issuer")
    private  String tcIssuer;


}
