-- This file allow to write SQL commands that will be emitted in test and dev.
-- The commands are commented as their support depends of the database
-- insert into myentity (id, field) values(nextval('hibernate_sequence'), 'field-1');
-- insert into myentity (id, field) values(nextval('hibernate_sequence'), 'field-2');
-- insert into myentity (id, field) values(nextval('hibernate_sequence'), 'field-3');
insert into animals (id,name,comment,animal_type) values(nextval('hibernate_sequence'), 'Dog', 'A domesticated carnivorous mammal that typically has a long snout, an acute sense of smell, and a barking, howling, or whining voice.', 'DOGGY_DOG');
insert into animals (id,name,comment,animal_type) values(nextval('hibernate_sequence'), 'Cat', 'A domesticated carnivorous mammal that typically has a long snout, an acute sense of smell, and a barking, howling, or whining voice.', 'CITTY_CAT');
insert into animals (id,name,comment,animal_type) values(nextval('hibernate_sequence'), 'DropBear', 'Australian bear that drops from trees and slays people', 'DROPBEAR');
insert into animals (id,name,comment,animal_type) values(nextval('hibernate_sequence'), 'Rupert', 'Markus favorite animal, that drinks daily its coffee with him', 'WALRUS');

insert into petholders(id, name, firstname, address) values (1, 'Lehr-Unger', 'Markus', 'Hinterm Mond, rechts');

insert into petholders(id, name, firstname, address) values (2, 'Bunnies', 'Daddy Of', 'Im Moehrchenfeld');
insert into animals (id,name,comment,animal_type, PET_HOLDER_ID) values(nextval('hibernate_sequence'), 'Bugs Bunny', 'Der naechtliche Kuschelhase und ausserdem der Schnellste in Trier', 'RABBY_RABBIT', 2);

