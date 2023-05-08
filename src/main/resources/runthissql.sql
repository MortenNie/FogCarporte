-- MySQL Workbench Synchronization
-- Generated: 2023-05-03 12:45
-- Model: New Model
-- Version: 1.0
-- Project: Name of the project
-- Author: sonig

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

CREATE TABLE IF NOT EXISTS `fogcarporte`.`order` (
    `order_id` INT(11) NOT NULL AUTO_INCREMENT,
    `date` TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP,
    `name` VARCHAR(45) NULL DEFAULT NULL,
    `adress` VARCHAR(45) NULL DEFAULT NULL,
    `username` VARCHAR(45) NULL DEFAULT NULL,
    PRIMARY KEY (`order_id`),
    INDEX `fk_table1_user_idx` (`username` ASC) VISIBLE,
    CONSTRAINT `fk_table1_user`
    FOREIGN KEY (`username`)
    REFERENCES `fogcarporte`.`user` (`username`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
    ENGINE = InnoDB
    DEFAULT CHARACTER SET = utf8mb4
    COLLATE = utf8mb4_0900_ai_ci;

CREATE TABLE IF NOT EXISTS `fogcarporte`.`carport` (
    `carport_id` INT(11) NOT NULL AUTO_INCREMENT,
    `width` INT(11) NULL DEFAULT NULL,
    `length` INT(11) NULL DEFAULT NULL,
    `height` INT(11) NULL DEFAULT NULL,
    `shed` TINYINT(4) NULL DEFAULT '0',
    `spaer_id` INT(11) NULL DEFAULT NULL,
    `rem_id` INT(11) NULL DEFAULT NULL,
    `stolpe_id` INT(11) NULL DEFAULT NULL,
    `tag_id` INT(11) NULL DEFAULT NULL,
    `order_id` INT(11) NULL DEFAULT NULL,
    PRIMARY KEY (`carport_id`),
    INDEX `fk_carport_order1_idx` (`order_id` ASC) VISIBLE,
    INDEX `fk_carport_spaer1_idx` (`spaer_id` ASC) VISIBLE,
    INDEX `fk_carport_rem1_idx` (`rem_id` ASC) VISIBLE,
    INDEX `fk_carport_stolpe1_idx` (`stolpe_id` ASC) VISIBLE,
    INDEX `fk_carport_tag1_idx` (`tag_id` ASC) VISIBLE,
    CONSTRAINT `fk_carport_order1`
    FOREIGN KEY (`order_id`)
    REFERENCES `fogcarporte`.`order` (`order_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
    CONSTRAINT `fk_carport_spaer1`
    FOREIGN KEY (`spaer_id`)
    REFERENCES `fogcarporte`.`spaer` (`spaer_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
    CONSTRAINT `fk_carport_rem1`
    FOREIGN KEY (`rem_id`)
    REFERENCES `fogcarporte`.`rem` (`rem_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
    CONSTRAINT `fk_carport_stolpe1`
    FOREIGN KEY (`stolpe_id`)
    REFERENCES `fogcarporte`.`stolpe` (`stolpe_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
    CONSTRAINT `fk_carport_tag1`
    FOREIGN KEY (`tag_id`)
    REFERENCES `fogcarporte`.`tag` (`tag_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
    ENGINE = InnoDB
    DEFAULT CHARACTER SET = utf8mb4
    COLLATE = utf8mb4_0900_ai_ci;

CREATE TABLE IF NOT EXISTS `fogcarporte`.`spaer` (
    `spaer_id` INT(11) NOT NULL,
    `spaer_name` VARCHAR(45) NULL DEFAULT NULL,
    `length` INT(11) NULL DEFAULT NULL,
    `price` INT(11) NULL DEFAULT NULL,
    `quantity` INT(11) NULL DEFAULT NULL,
    PRIMARY KEY (`spaer_id`))
    ENGINE = InnoDB
    DEFAULT CHARACTER SET = utf8mb4
    COLLATE = utf8mb4_0900_ai_ci;

CREATE TABLE IF NOT EXISTS `fogcarporte`.`rem` (
    `rem_id` INT(11) NOT NULL,
    `rem_name` VARCHAR(45) NULL DEFAULT NULL,
    `length` INT(11) NULL DEFAULT NULL,
    `price` INT(11) NULL DEFAULT NULL,
    `quantity` INT(11) NULL DEFAULT NULL,
    PRIMARY KEY (`rem_id`))
    ENGINE = InnoDB
    DEFAULT CHARACTER SET = utf8mb4
    COLLATE = utf8mb4_0900_ai_ci;

CREATE TABLE IF NOT EXISTS `fogcarporte`.`stolpe` (
    `stolpe_id` INT(11) NOT NULL,
    `stolpe_name` VARCHAR(45) NULL DEFAULT NULL,
    `length` INT(11) NULL DEFAULT NULL,
    `price` INT(11) NULL DEFAULT NULL,
    `quantity` INT(11) NULL DEFAULT NULL,
    PRIMARY KEY (`stolpe_id`))
    ENGINE = InnoDB
    DEFAULT CHARACTER SET = utf8mb4
    COLLATE = utf8mb4_0900_ai_ci;

CREATE TABLE IF NOT EXISTS `fogcarporte`.`tag` (
    `tag_id` INT(11) NOT NULL,
    `tag_name` VARCHAR(45) NULL DEFAULT NULL,
    `length` INT(11) NULL DEFAULT NULL,
    `price` INT(11) NULL DEFAULT NULL,
    `quantity` INT(11) NULL DEFAULT NULL,
    PRIMARY KEY (`tag_id`))
    ENGINE = InnoDB
    DEFAULT CHARACTER SET = utf8mb4
    COLLATE = utf8mb4_0900_ai_ci;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
