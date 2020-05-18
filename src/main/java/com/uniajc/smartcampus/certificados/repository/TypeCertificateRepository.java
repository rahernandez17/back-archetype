package com.uniajc.smartcampus.certificados.repository;

import com.uniajc.smartcampus.certificados.model.TypeCertificate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


/**
 * Repositorio del modelo Tipo de cetificado
 *
 * @author <a href="mailto:stivencastroarias2@gmail.com">
 * date: 15/05/2020
 * SP-0
 * */
@Repository
public interface TypeCertificateRepository extends JpaRepository<TypeCertificate, Long> {
}
