-- This file allow to write SQL commands that will be emitted in test and dev.
-- The commands are commented as their support depends of the database
-- insert into myentity (id, field) values(nextval('hibernate_sequence'), 'field-1');
-- insert into myentity (id, field) values(nextval('hibernate_sequence'), 'field-2');
-- insert into myentity (id, field) values(nextval('hibernate_sequence'), 'field-3');
insert into animals (id,name,comment,animal_type,available) values(nextval('hibernate_sequence'), 'Dog', 'A domesticated carnivorous mammal that typically has a long snout, an acute sense of smell, and a barking, howling, or whining voice.', 'DOGGY_DOG',true);
insert into animals (id,name,comment,animal_type,available) values(nextval('hibernate_sequence'), 'Cat', 'A domesticated carnivorous mammal that typically has a long snout, an acute sense of smell, and a barking, howling, or whining voice.', 'CITTY_CAT',false);
insert into animals (id,name,comment,animal_type,available) values(nextval('hibernate_sequence'), 'DropBear', 'Australian bear that drops from trees and slays people', 'DROPBEAR',true);
insert into animals (id,name,comment,animal_type,available) values(nextval('hibernate_sequence'), 'Rupert', 'Markus favorite animal, that drinks daily its coffee with him', 'WALRUS',true);

insert into petholders(id, name, firstname, address, adoptedPets) values (nextval('hibernate_sequence'), 'Lehr-Unger', 'Markus', 'Hinterm Mond, rechts', null);