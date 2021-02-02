IF NOT EXISTS(SELECT * FROM sys.databases WHERE name = 'store_challenge')
  BEGIN

    CREATE DATABASE store_challenge;
  END
GO
USE [store_challenge]


IF NOT EXISTS (SELECT * FROM sysobjects WHERE name='Province' and xtype='U')
  BEGIN
    create table Province(
      id int IDENTITY (1, 1) PRIMARY KEY,
      fullname varchar(100) not null,
      state varchar(2) not null
    )

    insert into Province(fullname, state)
    values('Acre','AC'),
          ('Alagoas','AL'),
          ('Amapá','AP'),
          ('Amazonas','AM'),
          ('Bahia','BA'),
          ('Ceará','CE'),
          ('Espírito Santo','ES'),
          ('Goiás','GO'),
          ('Maranhão','MA'),
          ('Mato Grosso','MT'),
          ('Mato Grosso do Sul','MS'),
          ('Minas Gerais','MG'),
          ('Pará','PA'),
          ('Paraíba','PB'),
          ('Paraná','PR'),
          ('Pernambuco','PE'),
          ('Piauí','PI'),
          ('Rio de Janeiro','RJ'),
          ('Rio Grande do Norte','RN'),
          ('Rio Grande do Sul','RS'),
          ('Rondônia','RO'),
          ('Roraima','RR'),
          ('Santa Catarina','SC'),
          ('São Paulo','SP'),
          ('Sergipe','SE'),
          ('Tocantins','TO'),
          ('Distrito Federal','DF');
  END
