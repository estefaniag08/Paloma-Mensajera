/*==============================================================*/
/* DBMS name:      PostgreSQL 9.x                               */
/* Created on:     26/11/2017 4:08:48 p. m.                     */
/*==============================================================*/




/*==============================================================*/
/* Table: AGENTE                                                */
/*==============================================================*/
create table AGENTE (
   ID_AGENTE            INT4                 not null,
   NOMBRE_AGENTE        VARCHAR(30)          not null,
   TELEFONO_AGENTE      VARCHAR(12)          null,
   constraint PK_AGENTE primary key (ID_AGENTE)
);

/*==============================================================*/
/* Index: AGENTE_PK                                             */
/*==============================================================*/
create unique index AGENTE_PK on AGENTE (
ID_AGENTE
);

/*==============================================================*/
/* Table: ASEGURADORA                                           */
/*==============================================================*/
create table ASEGURADORA (
   ID_ASEGURADORA       INT4                 not null,
   NOMBRE_ASEGURADORA   VARCHAR(40)          not null,
   TELEFONO_CONTACTO    VARCHAR(12)          null,
   constraint PK_ASEGURADORA primary key (ID_ASEGURADORA)
);

/*==============================================================*/
/* Index: ASEGURADORA_PK                                        */
/*==============================================================*/
create unique index ASEGURADORA_PK on ASEGURADORA (
ID_ASEGURADORA
);

/*==============================================================*/
/* Table: CLIENTE                                               */
/*==============================================================*/
create table CLIENTE (
   CEDULA_CLIENTE       VARCHAR(15)          not null,
   NOMBRE_CLIENTE       VARCHAR(30)          not null,
   APELLIDO_UNO         VARCHAR(30)          not null,
   APELLIDO_DOS         VARCHAR(30)          null,
   TELEFONO_CONTACTO    VARCHAR(12)          null,
   constraint PK_CLIENTE primary key (CEDULA_CLIENTE)
);

/*==============================================================*/
/* Index: CLIENTE_PK                                            */
/*==============================================================*/
create unique index CLIENTE_PK on CLIENTE (
CEDULA_CLIENTE
);

/*==============================================================*/
/* Table: DETALLE_ORDEN_SERVICIO                                */
/*==============================================================*/
create table DETALLE_ORDEN_SERVICIO (
   ID_ORDEN_SERVICIO    INT4                 not null,
   ITEM                 VARCHAR(30)          not null,
   ID_EMBALAJE          INT4                 not null,
   PRECIO_INDIVIDUAL    FLOAT8               not null,
   PESO                 FLOAT(2)              not null,
   ESTADO_GUIA          BOOLEAN               not null,
   constraint PK_DETALLE_ORDEN_SERVICIO primary key (ID_ORDEN_SERVICIO, ITEM)
);

/*==============================================================*/
/* Index: DETALLE_ORDEN_SERVICIO_PK                             */
/*==============================================================*/
create unique index DETALLE_ORDEN_SERVICIO_PK on DETALLE_ORDEN_SERVICIO (
ID_ORDEN_SERVICIO,
ITEM
);

/*==============================================================*/
/* Index: CONTIENE_FK                                           */
/*==============================================================*/
create  index CONTIENE_FK on DETALLE_ORDEN_SERVICIO (
ID_ORDEN_SERVICIO
);


/*==============================================================*/
/* Index: DESCRIBE_FK                                           */
/*==============================================================*/
create  index DESCRIBE_FK on DETALLE_ORDEN_SERVICIO (
ID_EMBALAJE
);

/*==============================================================*/
/* Table: EMPLEADO                                              */
/*==============================================================*/
create table EMPLEADO (
   ID_EMPLEADO          INT4                 not null,
   CEDULA_EMPLEADO      VARCHAR(15)          not null,
   NOMBRE_EMPLEADO      VARCHAR(35)          not null,
   APELLIDO_UNO         VARCHAR(30)          not null,
   APELLIDO_DOS         VARCHAR(30)          null,
   TELEFONO_CONTACTO_E  VARCHAR(12)          null,
   CONTRASENA           VARCHAR(50)          not null,
   constraint PK_EMPLEADO primary key (ID_EMPLEADO)
);

/*==============================================================*/
/* Index: EMPLEADO_PK                                           */
/*==============================================================*/
create unique index EMPLEADO_PK on EMPLEADO (
ID_EMPLEADO
);

/*==============================================================*/
/* Table: GENERACION_SEGUIMIENTO                                */
/*==============================================================*/
create table GENERACION_SEGUIMIENTO (
   CONSECUTIVO          INT4                 not null,
   ID_SEGUIMIENTO       INT4                 not null,
   constraint PK_GENERACION_SEGUIMIENTO primary key (CONSECUTIVO, ID_SEGUIMIENTO)
);

/*==============================================================*/
/* Index: GENERACION_SEGUIMIENTO_PK                             */
/*==============================================================*/
create unique index GENERACION_SEGUIMIENTO_PK on GENERACION_SEGUIMIENTO (
CONSECUTIVO,
ID_SEGUIMIENTO
);

/*==============================================================*/
/* Index: GENERACION_SEGUIMIENTO_FK                             */
/*==============================================================*/
create  index GENERACION_SEGUIMIENTO_FK on GENERACION_SEGUIMIENTO (
CONSECUTIVO
);

/*==============================================================*/
/* Index: GENERACION_SEGUIMIENTO2_FK                            */
/*==============================================================*/
create  index GENERACION_SEGUIMIENTO2_FK on GENERACION_SEGUIMIENTO (
ID_SEGUIMIENTO
);

/*==============================================================*/
/* Table: GUIA                                                  */
/*==============================================================*/
create table GUIA (
   CONSECUTIVO          INT4                 not null,
   ID_EMBALAJE          INT4                 not null,
   ID_ORDEN_SERVICIO    INT4                 null,
   ITEM                 VARCHAR(30)          null,
   ID_ASEGURADORA       INT4                 null,
   ID_ZONA_ENTREGA      INT4                 null,
   ID_EMPLEADO          INT4                 not null,
   PRECIO_TOTAL_ENVIO   FLOAT8               not null,
   FECHA_CREACION       DATE                 not null,
   DELICADO             BOOL                 not null,
   ESTADO_DIST          BOOLEAN              not null,
   constraint PK_GUIA primary key (CONSECUTIVO)
);

/*==============================================================*/
/* Index: GUIA_PK                                               */
/*==============================================================*/
create unique index GUIA_PK on GUIA (
CONSECUTIVO
);

/*==============================================================*/
/* Index: ESTA_EN2_FK                                           */
/*==============================================================*/
create  index ESTA_EN2_FK on GUIA (
ID_ORDEN_SERVICIO,
ITEM
);

/*==============================================================*/
/* Index: GESTIONA_FK                                           */
/*==============================================================*/
create  index GESTIONA_FK on GUIA (
ID_EMPLEADO
);

/*==============================================================*/
/* Index: ASEGURA_FK                                            */
/*==============================================================*/
create  index ASEGURA_FK on GUIA (
ID_ASEGURADORA
);

/*==============================================================*/
/* Index: DESCRIBE_2_FK                                         */
/*==============================================================*/
create  index DESCRIBE_2_FK on GUIA (
ID_EMBALAJE
);

/*==============================================================*/
/* Index: ZONIFICACION_FK                                       */
/*==============================================================*/
create  index ZONIFICACION_FK on GUIA (
ID_ZONA_ENTREGA
);

/*==============================================================*/
/* Table: ORDEN_SERVICIO                                        */
/*==============================================================*/
create table ORDEN_SERVICIO (
   ID_ORDEN_SERVICIO    INT4                 not null,
   CEDULA_CLIENTE       VARCHAR(15)          not null,
   ID_EMPLEADO          INT4                 not null,
   DIRECCION_RECOLECCION VARCHAR(25)          not null,
   FECHA_CREACION       DATE                 not null,
   ESTADO               BOOL                 not null,
   constraint PK_ORDEN_SERVICIO primary key (ID_ORDEN_SERVICIO)
);

/*==============================================================*/
/* Index: ORDEN_SERVICIO_PK                                     */
/*==============================================================*/
create unique index ORDEN_SERVICIO_PK on ORDEN_SERVICIO (
ID_ORDEN_SERVICIO
);

/*==============================================================*/
/* Index: COORDINA_FK                                           */
/*==============================================================*/
create  index COORDINA_FK on ORDEN_SERVICIO (
ID_EMPLEADO
);

/*==============================================================*/
/* Index: SOLICITA_FK                                           */
/*==============================================================*/
create  index SOLICITA_FK on ORDEN_SERVICIO (
CEDULA_CLIENTE
);

/*==============================================================*/
/* Table: RURALURBANO                                           */
/*==============================================================*/
create table RURALURBANO (
   ID_RURAL             CHAR(10)             not null,
   constraint PK_RURALURBANO primary key (ID_RURAL)
);

/*==============================================================*/
/* Index: RURALURBANO_PK                                        */
/*==============================================================*/
create unique index RURALURBANO_PK on RURALURBANO (
ID_RURAL
);

/*==============================================================*/
/* Table: SEGUIMIENTO                                           */
/*==============================================================*/
create table SEGUIMIENTO (
   ID_SEGUIMIENTO       INT4                 not null,
   ID_AUXILIAR_O         INT4                 null,
   ID_TIPO_RESULTADO    INT4                 null,
   ID_TIPO_PROCESO      INT4                 not null,
   ID_MENSAJERO     INT4                 	null,
   ID_AGENTE            INT4                 null,
   constraint PK_SEGUIMIENTO primary key (ID_SEGUIMIENTO)
);

/*==============================================================*/
/* Index: SEGUIMIENTO_PK                                        */
/*==============================================================*/
create unique index SEGUIMIENTO_PK on SEGUIMIENTO (
ID_SEGUIMIENTO
);

/*==============================================================*/
/* Index: ENVIO_FK                                              */
/*==============================================================*/
create  index ENVIO_FK on SEGUIMIENTO (
ID_AGENTE
);

/*==============================================================*/
/* Index: PROCESO_FK                                            */
/*==============================================================*/
create  index PROCESO_FK on SEGUIMIENTO (
ID_TIPO_PROCESO
);

/*==============================================================*/
/* Index: RESULTADO_FK                                          */
/*==============================================================*/
create  index RESULTADO_FK on SEGUIMIENTO (
ID_TIPO_RESULTADO
);

/*==============================================================*/
/* Index: SEGUIMIENTO_AUXO                                      */
/*==============================================================*/
create  index SEGUIMIENTO_AUXO on SEGUIMIENTO (
ID_MENSAJERO
);

/*==============================================================*/
/* Index: MENSAJERO_FK                                          */
/*==============================================================*/
create  index MENSAJERO_FK on SEGUIMIENTO (
ID_AUXILIAR_O
);

/*==============================================================*/
/* Table: TIPO_EMBALAJE                                         */
/*==============================================================*/
create table TIPO_EMBALAJE (
   ID_EMBALAJE          INT4                 not null,
   NOMBRE_EMBALAJE      VARCHAR(15)          not null,
   constraint PK_TIPO_EMBALAJE primary key (ID_EMBALAJE)
);

/*==============================================================*/
/* Index: TIPO_EMBALAJE_PK                                      */
/*==============================================================*/
create unique index TIPO_EMBALAJE_PK on TIPO_EMBALAJE (
ID_EMBALAJE
);

/*==============================================================*/
/* Table: TIPO_PROCESO                                          */
/*==============================================================*/
create table TIPO_PROCESO (
   ID_TIPO_PROCESO      INT4                 not null,
   NOMBRE_PROCESO       VARCHAR(50)          not null,
   constraint PK_TIPO_PROCESO primary key (ID_TIPO_PROCESO)
);

/*==============================================================*/
/* Index: TIPO_PROCESO_PK                                       */
/*==============================================================*/
create unique index TIPO_PROCESO_PK on TIPO_PROCESO (
ID_TIPO_PROCESO
);

/*==============================================================*/
/* Table: TIPO_RESULTADO                                        */
/*==============================================================*/
create table TIPO_RESULTADO (
   ID_TIPO_RESULTADO    INT4                 not null,
   NOMBRE_RESULTADO     VARCHAR(50)          null,
   DESCRIPCION_RESULTADO VARCHAR(80)          null,
   constraint PK_TIPO_RESULTADO primary key (ID_TIPO_RESULTADO)
);

/*==============================================================*/
/* Index: TIPO_RESULTADO_PK                                     */
/*==============================================================*/
create unique index TIPO_RESULTADO_PK on TIPO_RESULTADO (
ID_TIPO_RESULTADO
);

/*==============================================================*/
/* Table: TIPO_ZONA                                             */
/*==============================================================*/
create table TIPO_ZONA (
   ID_TIPO_ZONA         CHAR(10)             not null,
   NOMBRE_TIPO_ZONA     CHAR(30)             not null,
   constraint PK_TIPO_ZONA primary key (ID_TIPO_ZONA)
);

/*==============================================================*/
/* Index: TIPO_ZONA_PK                                          */
/*==============================================================*/
create unique index TIPO_ZONA_PK on TIPO_ZONA (
ID_TIPO_ZONA
);

/*==============================================================*/
/* Table: ZONA                                                  */
/*==============================================================*/
create table ZONA (
   ID_ZONA      integer                 not null,
   ID_ZONA_SUPERIOR  integer NULL,
   ID_TIPO_ZONA         VARCHAR(10) not null,
   NOMBRE VARCHAR(40) NOT NULL,
   ID_RURAL             VARCHAR(10) NULL,
   LATITUD              VARCHAR(30)               null,
   LONGITUD             VARCHAR(30)               null,
   constraint PK_ZONA primary key (ID_ZONA)
);

/*==============================================================*/
/* Index: ZONA_PK                                               */
/*==============================================================*/
create unique index ZONA_PK on ZONA (
ID_ZONA
);


/*==============================================================*/
/* Index: TIPO2_FK                                              */
/*==============================================================*/
create  index TIPO2_FK on ZONA (
ID_RURAL
);

alter table DETALLE_ORDEN_SERVICIO
   add constraint FK_DETALLE__CONTIENE_ORDEN_SE foreign key (ID_ORDEN_SERVICIO)
      references ORDEN_SERVICIO (ID_ORDEN_SERVICIO)
      on delete restrict on update restrict;

alter table DETALLE_ORDEN_SERVICIO
   add constraint FK_DETALLE__DESCRIBE_TIPO_EMB foreign key (ID_EMBALAJE)
      references TIPO_EMBALAJE (ID_EMBALAJE)
      on delete restrict on update restrict;

alter table GENERACION_SEGUIMIENTO
   add constraint FK_GENERACI_GENERACIO_GUIA foreign key (CONSECUTIVO)
      references GUIA (CONSECUTIVO)
      on delete restrict on update restrict;

alter table GENERACION_SEGUIMIENTO
   add constraint FK_GENERACI_GENERACIO_SEGUIMIE foreign key (ID_SEGUIMIENTO)
      references SEGUIMIENTO (ID_SEGUIMIENTO)
      on delete restrict on update restrict;

alter table GUIA
   add constraint FK_GUIA_ASEGURA_ASEGURAD foreign key (ID_ASEGURADORA)
      references ASEGURADORA (ID_ASEGURADORA)
      on delete restrict on update restrict;

alter table GUIA
   add constraint FK_GUIA_DESCRIBE__TIPO_EMB foreign key (ID_EMBALAJE)
      references TIPO_EMBALAJE (ID_EMBALAJE)
      on delete restrict on update restrict;

alter table GUIA
   add constraint FK_GUIA_ESTA_EN2_DETALLE_ foreign key (ID_ORDEN_SERVICIO, ITEM)
      references DETALLE_ORDEN_SERVICIO (ID_ORDEN_SERVICIO, ITEM)
      on delete restrict on update restrict;

alter table GUIA
   add constraint FK_GUIA_GESTIONA_EMPLEADO foreign key (ID_EMPLEADO)
      references EMPLEADO (ID_EMPLEADO)
      on delete restrict on update restrict;

alter table GUIA
   add constraint FK_GUIA_ZONIFICAC_ZONA foreign key (ID_ZONA_ENTREGA)
      references ZONA (ID_ZONA)
      on delete restrict on update restrict;

alter table ORDEN_SERVICIO
   add constraint FK_ORDEN_SE_COORDINA_EMPLEADO foreign key (ID_EMPLEADO)
      references EMPLEADO (ID_EMPLEADO)
      on delete restrict on update restrict;

alter table ORDEN_SERVICIO
   add constraint FK_ORDEN_SE_SOLICITA_CLIENTE foreign key (CEDULA_CLIENTE)
      references CLIENTE (CEDULA_CLIENTE)
      on delete restrict on update restrict;

alter table SEGUIMIENTO
   add constraint FK_SEGUIMIE_ENVIO_AGENTE foreign key (ID_AGENTE)
      references AGENTE (ID_AGENTE)
      on delete restrict on update restrict;

alter table SEGUIMIENTO
   add constraint FK_SEGUIMIE_HACE_SEGU_EMPLEADO foreign key (ID_AUXILIAR_O)
      references EMPLEADO (ID_EMPLEADO)
      on delete restrict on update restrict;

alter table SEGUIMIENTO
   add constraint FK_SEGUIMIE_MENSAJERO_EMPLEADO foreign key (ID_MENSAJERO)
      references EMPLEADO (ID_EMPLEADO)
      on delete restrict on update restrict;

alter table SEGUIMIENTO
   add constraint FK_SEGUIMIE_PROCESO_TIPO_PRO foreign key (ID_TIPO_PROCESO)
      references TIPO_PROCESO (ID_TIPO_PROCESO)
      on delete restrict on update restrict;

alter table SEGUIMIENTO
   add constraint FK_SEGUIMIE_RESULTADO_TIPO_RES foreign key (ID_TIPO_RESULTADO)
      references TIPO_RESULTADO (ID_TIPO_RESULTADO)
      on delete restrict on update restrict;

alter table ZONA
   add constraint FK_ZONA_PERTENECE_ZONA foreign key (ID_ZONA_SUPERIOR)
      references ZONA (ID_ZONA)
      on delete restrict on update restrict;

alter table ZONA
   add constraint FK_ZONA_TIPO_TIPO_ZON foreign key (ID_TIPO_ZONA)
      references TIPO_ZONA (ID_TIPO_ZONA)
      on delete restrict on update restrict;

alter table ZONA
   add constraint FK_ZONA_TIPO2_RURALURB foreign key (ID_RURAL)
      references RURALURBANO (ID_RURAL)
      on delete restrict on update restrict;

