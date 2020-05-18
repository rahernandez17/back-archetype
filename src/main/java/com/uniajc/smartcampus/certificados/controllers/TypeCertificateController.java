package com.uniajc.smartcampus.certificados.controllers;

import com.uniajc.smartcampus.certificados.model.TypeCertificate;
import com.uniajc.smartcampus.certificados.model.request.TypeCerticateRequest;
import com.uniajc.smartcampus.certificados.responses.SimpleResponse;
import com.uniajc.smartcampus.certificados.service.TypeCetificateService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.awt.image.SampleModel;
import java.util.List;

/**
 * Controlador de tipo de certificado 
 *
 * @author <a href="mailto:stivencastroarias2@gmail.com">
 * date: 15/05/2020
 * SP-0
 * */
@RestController
@RequestMapping("/type/certificate")
@Api(tags = "Type Certificate")
public class TypeCertificateController {

    private static final ModelMapper modelMapper = new ModelMapper();

    private final TypeCetificateService typeCetificateService;

    @Autowired
    public TypeCertificateController(TypeCetificateService typeCetificateService) {
        this.typeCetificateService = typeCetificateService;
    }

    /**
     * Metodo encargado de guardar el tipo de certificado
     *
     * @author <a href="mailto:stivencastroarias2@gmail.com">
     * @return SimpleResponse {@link ResponseEntity}
     * date: 15/05/2020
     * SP-0
     * */
    @PostMapping("/insert")
    @ApiOperation(value = "Save Type Certificate ", response = TypeCertificate.class)
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Something went wrong"),
            @ApiResponse(code = 401, message = "Access denied"),
            @ApiResponse(code = 404, message = "The table doesn't exist"),
            @ApiResponse(code = 401, message = "Expired or invalid JWT token")})
    public ResponseEntity<SimpleResponse>  saveTypeCertificate(@RequestBody TypeCerticateRequest typeCerticateRequest) {
        SimpleResponse response = null;
        try{
            TypeCertificate typeCertificate = modelMapper.map(typeCerticateRequest, TypeCertificate.class);
            TypeCertificate result = typeCetificateService.saveTypeCertificate(typeCertificate);
            response = SimpleResponse.builder().code(200).message("Se ha creado correctamente").value(result).build();
        }catch (Exception e) {

        }
        return new ResponseEntity<>(response, HttpStatus.OK);

    }

    /**
     * Metodo encargado de actualizar el tipo de certificado
     *
     * @author <a href="mailto:stivencastroarias2@gmail.com">
     * @return SimpleResponse {@link ResponseEntity}
     * date: 15/05/2020
     * SP-0
     * */
    @PutMapping("/update")
    @ApiOperation(value = "Update Type Certificate ", response = TypeCertificate.class)
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Something went wrong"),
            @ApiResponse(code = 401, message = "Access denied"),
            @ApiResponse(code = 404, message = "The table doesn't exist"),
            @ApiResponse(code = 401, message = "Expired or invalid JWT token")})
    public ResponseEntity<SimpleResponse> updateTypeCertificate(@RequestBody TypeCerticateRequest typeCerticateRequest) {
        SimpleResponse response =  null;
        try {
            TypeCertificate typeCertificate = modelMapper.map(typeCerticateRequest, TypeCertificate.class);
            TypeCertificate result = typeCetificateService.updateTypeCertificate(typeCertificate);
            response = SimpleResponse.builder().code(200).message("Se han actualizado los datos con exito").value(result).build();
        }catch (Exception e){

            }

        return new ResponseEntity<>(response,HttpStatus.OK);
    }

    /**
     * Metodo encargado de obtener el modelo de tipo de certificado
     *
     * @author <a href="mailto:stivencastroarias2@gmail.com">
     * @return SimpleResponse {@link ResponseEntity}
     * date: 15/05/2020
     * SP-0
     * */
    @GetMapping("/all")
    @ApiOperation(value = "Get All Type Certificate ", response = TypeCertificate.class)
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Something went wrong"),
            @ApiResponse(code = 401, message = "Access denied"),
            @ApiResponse(code = 404, message = "The table doesn't exist"),
            @ApiResponse(code = 401, message = "Expired or invalid JWT token")})
    public ResponseEntity<SimpleResponse>  getAllTypeCertificate() {
        List<TypeCertificate> result = typeCetificateService.getAllTypeCertificate();
        SimpleResponse response = SimpleResponse.builder().code(200).message("Se obtuvieron los resultados esperados").value(result).build();

        return new ResponseEntity<>(response,HttpStatus.OK) ;
    }

    /**
     * Metodo encargado de Borrar el modelo de tipo de certificado por id
     *
     * @author <a href="mailto:stivencastroarias2@gmail.com">
     * @param id id del usuario que va a ser eliminado
     * date: 15/05/2020
     * SP-0
     * */
    @DeleteMapping("/delete/id")
    @ApiOperation(value = "Delete By Id Type Certificate ", response = TypeCertificate.class)
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Something went wrong"),
            @ApiResponse(code = 401, message = "Access denied"),
            @ApiResponse(code = 404, message = "The table doesn't exist"),
            @ApiResponse(code = 401, message = "Expired or invalid JWT token")})
    public void  delecteTypeCertificateById(@RequestParam(name = "id") Long id) {
        typeCetificateService.delectTypeCertificate(id);
    }
}
