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

import java.util.List;

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

    @PostMapping("/insert")
    @ApiOperation(value = "Save Type Certificate ", response = TypeCertificate.class)
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Something went wrong"),
            @ApiResponse(code = 401, message = "Access denied"),
            @ApiResponse(code = 404, message = "The table doesn't exist"),
            @ApiResponse(code = 401, message = "Expired or invalid JWT token")})
    public ResponseEntity<SimpleResponse>  saveTypeCertificate(@RequestBody TypeCerticateRequest typeCerticateRequest) {
        TypeCertificate typeCertificate = modelMapper.map(typeCerticateRequest, TypeCertificate.class);
        TypeCertificate result = typeCetificateService.saveTypeCertificate(typeCertificate);
        SimpleResponse response = SimpleResponse.builder().code(200).message("Se ha creado correctamente").value(result).build();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PutMapping("/update")
    @ApiOperation(value = "Update Type Certificate ", response = TypeCertificate.class)
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Something went wrong"),
            @ApiResponse(code = 401, message = "Access denied"),
            @ApiResponse(code = 404, message = "The table doesn't exist"),
            @ApiResponse(code = 401, message = "Expired or invalid JWT token")})
    public TypeCertificate updateTypeCertificate(@RequestBody TypeCerticateRequest typeCerticateRequest) {
        TypeCertificate typeCertificate = modelMapper.map(typeCerticateRequest, TypeCertificate.class);

        return typeCetificateService.updateTypeCertificate(typeCertificate);
    }

    @GetMapping("/all")
    @ApiOperation(value = "Get All Type Certificate ", response = TypeCertificate.class)
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Something went wrong"),
            @ApiResponse(code = 401, message = "Access denied"),
            @ApiResponse(code = 404, message = "The table doesn't exist"),
            @ApiResponse(code = 401, message = "Expired or invalid JWT token")})
    public List<TypeCertificate> getAllTypeCertificate() {
        return typeCetificateService.getAllTypeCertificate();
    }

    @DeleteMapping("/delete/id")
    @ApiOperation(value = "Delete By Id Type Certificate ", response = TypeCertificate.class)
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Something went wrong"),
            @ApiResponse(code = 401, message = "Access denied"),
            @ApiResponse(code = 404, message = "The table doesn't exist"),
            @ApiResponse(code = 401, message = "Expired or invalid JWT token")})
    public void delecteTypeCertificateById(@RequestParam(name = "ud") Long id) {
        typeCetificateService.delectTypeCertificate(id);
    }
}
