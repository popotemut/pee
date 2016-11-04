/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  Khaitong
 * Created: Aug 9, 2016
 */

 CREATE TABLE pokemon (
    id INTEGER NOT NULL, 
    "name" VARCHAR(30) NOT NULL,
    species_id INTEGER, 
    height INTEGER NOT NULL, 
    weight INTEGER NOT NULL, 
    base_experience INTEGER NOT NULL, 
    "order" INTEGER NOT NULL, 
    is_default SMALLINT NOT NULL, 
    PRIMARY KEY (id)) ;