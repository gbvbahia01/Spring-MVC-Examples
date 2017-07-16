/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  Guilherme
 * Created: Jul 2, 2017
 */

CREATE TABLE holiday_month_day
(
   day integer NOT NULL, 
   month integer NOT NULL, 
   PRIMARY KEY (day, month)
);

CREATE TABLE counterparty (
	customer varchar(50) NOT NULL,
	CONSTRAINT pk_counterparty PRIMARY KEY (customer)
);

CREATE TABLE iso_4217 (
	code varchar(3) NOT NULL,
	country varchar(100) NOT NULL,
	CONSTRAINT iso_pk PRIMARY KEY (code)
);

