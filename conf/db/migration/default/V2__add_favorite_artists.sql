-- MySQL Workbench Synchronization
-- Generated: 2016-09-28 22:18
-- Model: New Model
-- Version: 1.0
-- Project: Name of the project
-- Author: Fumiyasu

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL';

ALTER SCHEMA `ticketman`  DEFAULT COLLATE utf8mb4_general_ci ;

ALTER TABLE `ticketman`.`TICKETS` 
DROP FOREIGN KEY `fk_TICKETS_GROUPS1`,
DROP FOREIGN KEY `fk_TICKETS_USERS1`;

ALTER TABLE `ticketman`.`ARTISTS` 
COLLATE = utf8mb4_general_ci ;

ALTER TABLE `ticketman`.`USERS` 
COLLATE = utf8mb4_general_ci ;

ALTER TABLE `ticketman`.`PLACES` 
COLLATE = utf8mb4_general_ci ;

ALTER TABLE `ticketman`.`LIVES` 
COLLATE = utf8mb4_general_ci ,
ADD INDEX `fk_LIVES_PLACES1_idx` (`PLACES_place_name` ASC)  COMMENT '',
DROP INDEX `fk_LIVES_PLACES1_idx` ;

ALTER TABLE `ticketman`.`TICKETS` 
COLLATE = utf8mb4_general_ci ,
DROP COLUMN `owner_id`,
DROP COLUMN `group_id`,
ADD COLUMN `group_id` BIGINT(20) NOT NULL COMMENT '' AFTER `status`,
ADD COLUMN `owner_id` BIGINT(20) NOT NULL COMMENT '' AFTER `group_id`,
ADD INDEX `fk_TICKETS_GROUPS1_idx` (`group_id` ASC)  COMMENT '',
ADD INDEX `fk_TICKETS_USERS1_idx` (`owner_id` ASC)  COMMENT '',
DROP INDEX `fk_TICKETS_USERS1_idx` ,
DROP INDEX `fk_TICKETS_GROUPS1_idx` ;

ALTER TABLE `ticketman`.`GROUPS` 
COLLATE = utf8mb4_general_ci ,
ADD INDEX `fk_GROUPS_LIVES1_idx` (`LIVES_live_id` ASC)  COMMENT '',
DROP INDEX `fk_GROUPS_LIVES1_idx` ;

ALTER TABLE `ticketman`.`ARTISTS_has_LIVES` 
COLLATE = utf8mb4_general_ci ,
ADD INDEX `fk_ARTISTS_has_LIVES_LIVES1_idx` (`LIVES_live_id` ASC)  COMMENT '',
ADD INDEX `fk_ARTISTS_has_LIVES_ARTISTS1_idx` (`ARTISTS_artist_id` ASC)  COMMENT '',
DROP INDEX `fk_ARTISTS_has_LIVES_ARTISTS1_idx` ,
DROP INDEX `fk_ARTISTS_has_LIVES_LIVES1_idx` ;

ALTER TABLE `ticketman`.`GROUPS_has_USERS` 
COLLATE = utf8mb4_general_ci ,
ADD INDEX `fk_GROUPS_has_USERS_USERS1_idx` (`USERS_user_id` ASC)  COMMENT '',
ADD INDEX `fk_GROUPS_has_USERS_GROUPS1_idx` (`GROUPS_group_id` ASC, `GROUPS_LIVES_live_id` ASC)  COMMENT '',
DROP INDEX `fk_GROUPS_has_USERS_GROUPS1_idx` ,
DROP INDEX `fk_GROUPS_has_USERS_USERS1_idx` ;

CREATE TABLE IF NOT EXISTS `ticketman`.`FAVORITE_ARTISTS` (
  `USERS_user_id` BIGINT(20) NOT NULL COMMENT '',
  `ARTISTS_artist_id` BIGINT(20) NOT NULL COMMENT '',
  INDEX `fk_FAVORITE_ARTISTS_USERS1_idx` (`USERS_user_id` ASC)  COMMENT '',
  INDEX `fk_FAVORITE_ARTISTS_ARTISTS1_idx` (`ARTISTS_artist_id` ASC)  COMMENT '',
  CONSTRAINT `fk_FAVORITE_ARTISTS_USERS1`
    FOREIGN KEY (`USERS_user_id`)
    REFERENCES `ticketman`.`USERS` (`user_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_FAVORITE_ARTISTS_ARTISTS1`
    FOREIGN KEY (`ARTISTS_artist_id`)
    REFERENCES `ticketman`.`ARTISTS` (`artist_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4;

ALTER TABLE `ticketman`.`TICKETS` 
ADD CONSTRAINT `fk_TICKETS_GROUPS1`
  FOREIGN KEY (`group_id`)
  REFERENCES `ticketman`.`GROUPS` (`group_id`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION,
ADD CONSTRAINT `fk_TICKETS_USERS1`
  FOREIGN KEY (`owner_id`)
  REFERENCES `ticketman`.`USERS` (`user_id`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
