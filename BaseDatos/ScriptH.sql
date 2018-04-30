/*==============================================================*/
/* DBMS name:      PostgreSQL 8                                 */
/* Created on:     30/04/2018 11:18:45 a. m.                    */
/*==============================================================*/


drop index OBSERVAR2_FK;

drop index OBSERVAR_FK;

drop index OBSERVAR_PK;

drop table OBSERVAR;

drop index USUARIO_PK;

drop table USUARIO;

drop index VEHICULO_PK;

drop table VEHICULO;

/*==============================================================*/
/* Table: OBSERVAR                                              */
/*==============================================================*/
create table OBSERVAR (
   ID_USUARIO           INT4                 not null,
   ID_VEHICULO          INT4                 not null,
   constraint PK_OBSERVAR primary key (ID_USUARIO, ID_VEHICULO)
);

/*==============================================================*/
/* Index: OBSERVAR_PK                                           */
/*==============================================================*/
create unique index OBSERVAR_PK on OBSERVAR (
ID_USUARIO,
ID_VEHICULO
);

/*==============================================================*/
/* Index: OBSERVAR_FK                                           */
/*==============================================================*/
create  index OBSERVAR_FK on OBSERVAR (
ID_USUARIO
);

/*==============================================================*/
/* Index: OBSERVAR2_FK                                          */
/*==============================================================*/
create  index OBSERVAR2_FK on OBSERVAR (
ID_VEHICULO
);

/*==============================================================*/
/* Table: USUARIO                                               */
/*==============================================================*/
create table USUARIO (
   ID_USUARIO           SERIAL not null,
   USU_NOMBRE           VARCHAR(256)         null,
   USU_CEDULA           INT8                 null,
   USU_TIPO             VARCHAR(50)          null,
   constraint PK_USUARIO primary key (ID_USUARIO)
);

/*==============================================================*/
/* Index: USUARIO_PK                                            */
/*==============================================================*/
create unique index USUARIO_PK on USUARIO (
ID_USUARIO
);

/*==============================================================*/
/* Table: VEHICULO                                              */
/*==============================================================*/
create table VEHICULO (
   ID_VEHICULO          SERIAL not null,
   VEH_MARCA            VARCHAR(100)         null,
   VEH_TIPO             VARCHAR(50)          null,
   VEH_PRECIO           FLOAT8               null,
   constraint PK_VEHICULO primary key (ID_VEHICULO)
);

/*==============================================================*/
/* Index: VEHICULO_PK                                           */
/*==============================================================*/
create unique index VEHICULO_PK on VEHICULO (
ID_VEHICULO
);

alter table OBSERVAR
   add constraint FK_OBSERVAR_OBSERVAR_USUARIO foreign key (ID_USUARIO)
      references USUARIO (ID_USUARIO)
      on delete restrict on update restrict;

alter table OBSERVAR
   add constraint FK_OBSERVAR_OBSERVAR2_VEHICULO foreign key (ID_VEHICULO)
      references VEHICULO (ID_VEHICULO)
      on delete restrict on update restrict;

