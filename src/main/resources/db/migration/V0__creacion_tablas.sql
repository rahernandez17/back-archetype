CREATE TABLE recibo (
    re_num_pedido  SERIAL NOT NULL,
    re_referencia CHARACTER VARYING(100) NOT NULL,
    re_codigo_interno NUMBER NOT NULL,
    re_producto CHARACTER VARYING(100) NOT NULL,
    re_cantidad NUMBER NOT NULL,
    re_valor NUMBER NOT NULL,
    re_valor_iva NUMBER NOT NULL,
    re_total NUMBER NOT NULL,
    re_total_iva NUMBER NOT NULL,
    re_total_descuento NUMBER NOT NULL,
    re_total_pagar NUMBER NOT NULL,
    re_estado_academusoft CHARACTER VARYING(50),
    re_estado CHARACTER VARYING(30),
    re_url CHARACTER VARYING(250),
    re_fecha_creacion CHARACTER VARYING(50),
    re_fecha_limite_pago CHARACTER VARYING(50) NOT NULL,
    re_fecha_pago CHARACTER VARYING(50),
    re_solicitud_id NUMBER NOT NULL,
    PRIMARY KEY (re_num_pedido)
);

CREATE TABLE certificado (
    ce_id  SERIAL NOT NULL,
    ce_codigo CHARACTER VARYING(50) NOT NULL,
    ce_nombre CHARACTER VARYING(100) NOT NULL,
    ce_estado BOOLEAN NOT NULL,
    ce_tipo_certificado_id NUMBER NOT NULL,
    PRIMARY KEY (ce_id)
);

CREATE TABLE solicitud (
    so_id  SERIAL NOT NULL,
    so_fecha CHARACTER VARYING (100) NOT NULL,
    so_estado BOOLEAN NOT NULL,
    so_usuario_id NUMBER NOT NULL,
    PRIMARY KEY (so_id)
);

CREATE TABLE tipo_certificado (
    tc_id SERIAL NOT NULL,
    tc_nombre CHARACTER VARYING(50) NOT NULL,
    tc_estado BOOLEAN NOT NULL,
    tc_responsable CHARACTER VARYING(150) NOT NULL,
    tc_cargo_responsable CHARACTER VARYING(100) NOT NULL,
    tc_usuario_firma CHARACTER VARYING(50) NOT NULL,
    tc_pass_firma CHARACTER VARYING(100) NOT NULL,
    tc_issuer CHARACTER VARYING(250) NOT NULL,
    PRIMARY KEY (tc_id)
);

CREATE TABLE parametros (
    pa_id  SERIAL NOT NULL,
    pa_nombre CHARACTER VARYING(50) NOT NULL,
    pa_descripcion CHARACTER VARYING(100) NOT NULL,
    pa_valor CHARACTER VARYING(100) NOT NULL,
    pa_modulo CHARACTER VARYING(50) NOT NULL,
    PRIMARY KEY (pa_id)
);

CREATE TABLE usuario (
    usu_id  SERIAL NOT NULL,
    usu_usuario CHARACTER VARYING (20) NOT NULL,
    usu_token_notify CHARACTER VARYING(255) NOT NULL,
    usu_estado BOOLEAN NOT NULL,
    usu_tipo_dispositivo CHARACTER VARYING(100) NOT NULL,
    usu_pege_id NUMBER NOT NULL,
    PRIMARY KEY (usu_id)
);

CREATE TABLE certificado_generado (
    cg_id  SERIAL NOT NULL,
    cg_url CHARACTER VARYING(100) NOT NULL,
    cg_programa CHARACTER VARYING(50) NOT NULL,
    cg_periodo CHARACTER VARYING(10) NOT NULL,
    cg_certificado_id NUMBER NOT NULL,
    cg_recibo_id NUMBER NOT NULL,
    PRIMARY KEY (cg_id)
);

ALTER TABLE recibo ADD CONSTRAINT FKrecibo_solicitud FOREIGN KEY (re_solicitud_id) REFERENCES solicitud (so_id);
ALTER TABLE certificado ADD CONSTRAINT FKcertificado_tipocert FOREIGN KEY (ce_tipo_certificado_id) REFERENCES tipo_certificado (tc_id);
ALTER TABLE certificado_generado ADD CONSTRAINT FKcertificadogen_cert FOREIGN KEY (cg_certificado_id) REFERENCES certificado (ce_id);
ALTER TABLE solicitud ADD CONSTRAINT FKsolicitud_usuario FOREIGN KEY (so_usuario_id) REFERENCES usuario (usu_id);
ALTER TABLE certificado_generado ADD CONSTRAINT FKcertificadogen_recibo FOREIGN KEY (cg_recibo_id) REFERENCES recibo (re_num_pedido);
