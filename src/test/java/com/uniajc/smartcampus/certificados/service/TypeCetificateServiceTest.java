package com.uniajc.smartcampus.certificados.service;

import com.uniajc.smartcampus.certificados.model.TypeCertificate;
import com.uniajc.smartcampus.certificados.model.request.TypeCerticateRequest;
import com.uniajc.smartcampus.certificados.repository.TypeCertificateRepository;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.rules.ExpectedException;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.when;

/**
 * Test de servicio del modelo tipo de certificado
 *
 * @author <a href="mailto:stivencastroarias2@gmail.com">
 * date: 15/05/2020
 * SP-0
 * */
class TypeCetificateServiceTest {

    @Rule
    public ExpectedException throwm = ExpectedException.none();
    @Mock
    private TypeCertificateRepository typeCertificateRepository;

    @InjectMocks
    private TypeCetificateService typeCetificateService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    public static TypeCertificate getTypeCetificateModel() {

        TypeCertificate typecetificate =  new TypeCertificate();
        typecetificate.setTcId(1L);
        typecetificate.setTcName("test");
        typecetificate.setTcJob("test");
        typecetificate.setTcIssuer("test");
        typecetificate.setTcPassFirm("test");
        typecetificate.setTcResponsable("test");
        typecetificate.setTcState(true);
        typecetificate.setTcUserFirm("test");

        return typecetificate;
    }

    private List<TypeCertificate> getTypeCertificate() {
        List<TypeCertificate> listTypeCertificate = new ArrayList<>();
        listTypeCertificate.add(getTypeCetificateModel());
        return  listTypeCertificate;
    }

    @Test
    void saveTypeCertificate() {
        //Preparar
        when(typeCertificateRepository.save(any(TypeCertificate.class))).thenReturn(getTypeCetificateModel());
        //Actuar
        TypeCertificate typeCertificate = typeCetificateService.saveTypeCertificate(getTypeCetificateModel());
        //afirmar
        Assert.assertNotNull(typeCertificate);
    }

    @Test
    void updateTypeCertificate() {
        //Preparar
        when(typeCertificateRepository.save(any(TypeCertificate.class))).thenReturn(getTypeCetificateModel());
        //Actuar
        TypeCertificate typeCertificate = typeCetificateService.updateTypeCertificate(getTypeCetificateModel());
        //afirmar
        Assert.assertNotNull(typeCertificate);
    }

    @Test
    void getAllTypeCertificate() {
        //preparar
        when(typeCertificateRepository.findAll()).thenReturn(getTypeCertificate());
        //Actuar
        List<TypeCertificate> result = typeCetificateService.getAllTypeCertificate();
        //Afirmar
        Assert.assertTrue(!result.isEmpty());
    }

    @Test
    void delectTypeCertificate() {
        typeCetificateService.delectTypeCertificate(1L);
    }
}