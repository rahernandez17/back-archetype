package com.uniajc.smartcampus.certificados.service;

import com.uniajc.smartcampus.certificados.model.TypeCertificate;
import com.uniajc.smartcampus.certificados.repository.TypeCertificateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TypeCetificateService {

    private final TypeCertificateRepository  typeCertificateRepository;

    @Autowired
    public TypeCetificateService(TypeCertificateRepository typeCertificateRepository) {
        this.typeCertificateRepository = typeCertificateRepository;
    }

    public TypeCertificate saveTypeCertificate(TypeCertificate typeCertificate) {
        return typeCertificateRepository.save(typeCertificate);
    }

    public TypeCertificate updateTypeCertificate(TypeCertificate typeCertificate) {
        return typeCertificateRepository.save(typeCertificate);
    }

    public List<TypeCertificate> getAllTypeCertificate() {
        return typeCertificateRepository.findAll();
    }

    public  void  delectTypeCertificate(Long id) {
        typeCertificateRepository.deleteById(id);
    }

}
