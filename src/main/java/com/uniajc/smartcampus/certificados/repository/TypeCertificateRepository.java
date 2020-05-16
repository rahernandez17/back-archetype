package com.uniajc.smartcampus.certificados.repository;

import com.uniajc.smartcampus.certificados.model.TypeCertificate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TypeCertificateRepository extends JpaRepository<TypeCertificate, Long> {
}
