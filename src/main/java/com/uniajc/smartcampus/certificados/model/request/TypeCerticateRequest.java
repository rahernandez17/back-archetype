package com.uniajc.smartcampus.certificados.model.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @author Stiven Castro Arias
 * date: 15/05/2020
 * SP-0
 * */
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TypeCerticateRequest {

    private Long tcId;
    private String tcName;
    private Boolean tcState;
    private String tcResponsable;
    private String tcJob;
    private String tcUserFirm;
    private String tcPassFirm;
    private String tcIssuer;

}
