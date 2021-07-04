-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema newlecture
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema newlecture
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `newlecture` DEFAULT CHARACTER SET utf8 ;
-- -----------------------------------------------------
-- Schema newlecture
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema newlecture
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `newlecture` DEFAULT CHARACTER SET utf8 COLLATE utf8_unicode_ci ;
USE `newlecture` ;

-- -----------------------------------------------------
-- Table `newlecture`.`member`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `newlecture`.`member` ;

CREATE TABLE IF NOT EXISTS `newlecture`.`member` (
  `id` INT NOT NULL,
  `name` VARCHAR(45) NULL,
  `pwd` VARCHAR(45) NULL,
  `email` VARCHAR(100) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `newlecture`.`notice`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `newlecture`.`notice` ;

CREATE TABLE IF NOT EXISTS `newlecture`.`notice` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `title` VARCHAR(100) NULL DEFAULT NULL,
  `content` TEXT(5000) NULL DEFAULT NULL,
  `regdate` DATETIME NULL DEFAULT NULL,
  `hit` INT NULL DEFAULT NULL,
  `pub` BIT(1) NULL DEFAULT NULL,
  `memberId` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_notice_member_idx` (`memberId` ASC) VISIBLE,
  CONSTRAINT `fk_notice_member`
    FOREIGN KEY (`memberId`)
    REFERENCES `newlecture`.`member` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_unicode_ci;


-- -----------------------------------------------------
-- Table `newlecture`.`comment`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `newlecture`.`comment` ;

CREATE TABLE IF NOT EXISTS `newlecture`.`comment` (
  `id` INT NOT NULL,
  `content` VARCHAR(1000) NULL,
  `regdate` DATETIME NULL,
  `noticeId` INT NOT NULL,
  `memberId` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_comment_notice_idx` (`noticeId` ASC) VISIBLE,
  INDEX `fk_comment_member1_idx` (`memberId` ASC) VISIBLE,
  CONSTRAINT `fk_comment_notice`
    FOREIGN KEY (`noticeId`)
    REFERENCES `newlecture`.`notice` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_comment_member1`
    FOREIGN KEY (`memberId`)
    REFERENCES `newlecture`.`member` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `newlecture`.`role`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `newlecture`.`role` ;

CREATE TABLE IF NOT EXISTS `newlecture`.`role` (
  `id` INT NOT NULL,
  `name` VARCHAR(45) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `newlecture`.`member_role`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `newlecture`.`member_role` ;

CREATE TABLE IF NOT EXISTS `newlecture`.`member_role` (
  `memberId` INT NULL,
  `roleId` INT NULL,
  CONSTRAINT `fk_member_role_member1`
    FOREIGN KEY (`memberId`)
    REFERENCES `newlecture`.`member` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_member_role_role1`
    FOREIGN KEY (`roleId`)
    REFERENCES `newlecture`.`role` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

USE `newlecture` ;

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
