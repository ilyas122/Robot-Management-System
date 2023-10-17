-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema ccrs
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema ccrs
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `ccrs` DEFAULT CHARACTER SET utf8 ;
USE `ccrs` ;

-- -----------------------------------------------------
-- Table `ccrs`.`account`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ccrs`.`account` (
  `account_id` VARCHAR(45) NOT NULL,
  `created_at` DATETIME NOT NULL,
  `business_name` VARCHAR(45) NOT NULL,
  `address` VARCHAR(100) NOT NULL,
  `city` VARCHAR(100) NOT NULL,
  `state` VARCHAR(5) NULL,
  `zip` VARCHAR(10) NULL,
  PRIMARY KEY (`account_id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `ccrs`.`business_user`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ccrs`.`business_user` (
  `user_id` BIGINT NOT NULL,
  `account_id` VARCHAR(45) NOT NULL,
  `fname` VARCHAR(45) NOT NULL,
  `lname` VARCHAR(45) NOT NULL,
  `created_at` DATETIME NOT NULL,
  `updated_at` DATETIME NOT NULL,
  PRIMARY KEY (`user_id`),
  INDEX `account_id_idx` (`account_id` ASC) VISIBLE,
  CONSTRAINT `business_user_account_id`
    FOREIGN KEY (`account_id`)
    REFERENCES `ccrs`.`account` (`account_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `ccrs`.`admin`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ccrs`.`admin` (
  `admin_id` BIGINT NOT NULL,
  `fname` VARCHAR(45) NOT NULL,
  `lname` VARCHAR(45) NOT NULL,
  `username` VARCHAR(45) NOT NULL,
  `created_at` DATETIME NOT NULL,
  `updated_at` DATETIME NOT NULL,
  PRIMARY KEY (`admin_id`),
  UNIQUE INDEX `username_UNIQUE` (`username` ASC) VISIBLE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `ccrs`.`robot`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ccrs`.`robot` (
  `robot_id` VARCHAR(45) NOT NULL,
  `account_id` VARCHAR(45) NOT NULL,
  `state` VARCHAR(10) NOT NULL,
  `created_at` DATETIME NOT NULL,
  `updated_at` DATETIME NOT NULL,
  PRIMARY KEY (`robot_id`),
  CONSTRAINT `robot_account_id`
    FOREIGN KEY (`account_id`)
    REFERENCES `ccrs`.`account` (`account_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `ccrs`.`robot_config`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ccrs`.`robot_config` (
  `robot_id` VARCHAR(45) NOT NULL,
  `robot_key` VARCHAR(30) NOT NULL,
  `robot_val` VARCHAR(20) NOT NULL,
  `updated_at` DATETIME NOT NULL,
  PRIMARY KEY (`robot_id`,`robot_key`))
ENGINE = InnoDB;

-- -----------------------------------------------------
-- Table `ccrs`.`customer`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ccrs`.`customer` (
  `customer_id` INT NOT NULL AUTO_INCREMENT,
  `username` VARCHAR(45) NOT NULL,
  `fname` VARCHAR(45) NOT NULL,
  `lname` VARCHAR(45) NOT NULL,
  `created_at` DATETIME NOT NULL,
  `updated_at` DATETIME NOT NULL,
  PRIMARY KEY (`customer_id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `ccrs`.`coffee_order`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ccrs`.`coffee_order` (
  `order_id` INT NOT NULL AUTO_INCREMENT,
  `customer_id` INT NOT NULL,
  `robot_id` VARCHAR(45) NULL,
  `business_id` VARCHAR(45) NOT NULL,
  `coffee_type` VARCHAR(45) NOT NULL,
  `coffee_size` VARCHAR(45) NOT NULL,
  `order_date` DATETIME NOT NULL,
  `order_state` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`order_id`),
  INDEX `customer_id_idx` (`customer_id` ASC) VISIBLE,
  INDEX `robot_id_idx` (`robot_id` ASC) VISIBLE,
  INDEX `account_id_idx` (`business_id` ASC) VISIBLE,
  CONSTRAINT `customer_id`
    FOREIGN KEY (`customer_id`)
    REFERENCES `ccrs`.`customer` (`customer_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `coffee_order_robot_id`
    FOREIGN KEY (`robot_id`)
    REFERENCES `ccrs`.`robot` (`robot_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `coffee_order_account_id`
    FOREIGN KEY (`business_id`)
    REFERENCES `ccrs`.`account` (`account_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `ccrs`.`invoice`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ccrs`.`invoice` (
  `invoice_id` BIGINT NOT NULL AUTO_INCREMENT,
  `account_id` VARCHAR(45) NOT NULL,
  `issued_at` DATETIME NOT NULL,
  `due_date` DATETIME NOT NULL,
  `amount` FLOAT NOT NULL,
  `status` VARCHAR(10) NOT NULL,
  PRIMARY KEY (`invoice_id`),
  INDEX `account_id_idx` (`account_id` ASC) VISIBLE,
  CONSTRAINT `invoice_account_id`
    FOREIGN KEY (`account_id`)
    REFERENCES `ccrs`.`account` (`account_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `ccrs`.`robot_usage`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ccrs`.`robot_usage` (
  `robot_id` VARCHAR(45) NOT NULL,
  `account_id` VARCHAR(45) NOT NULL,
  `start_active_time` INT UNSIGNED NOT NULL,
  `end_active_time` INT UNSIGNED NOT NULL,
  `track_date` DATE NOT NULL,
  `num_orders` INT UNSIGNED NOT NULL,
  PRIMARY KEY (`robot_id`),
  INDEX `account_id_idx` (`account_id` ASC) VISIBLE,
  CONSTRAINT `robot_usage_robot_id`
    FOREIGN KEY (`robot_id`)
    REFERENCES `ccrs`.`robot` (`robot_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `robot_usage_account_id`
    FOREIGN KEY (`account_id`)
    REFERENCES `ccrs`.`account` (`account_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

-- -----------------------------------------------------
-- Table `ccrs`.`users`
-- -----------------------------------------------------
CREATE TABLE `ccrs`.`users` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `email` VARCHAR(50) DEFAULT NULL,
  `password` VARCHAR(120) DEFAULT NULL,
  `username` VARCHAR(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `email` (`email`),
  UNIQUE KEY `username` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


-- -----------------------------------------------------
-- Table `ccrs`.`roles`
-- -----------------------------------------------------
CREATE TABLE `ccrs`.`role` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- -----------------------------------------------------
-- Table `ccrs`.`user_roles`
-- -----------------------------------------------------
CREATE TABLE `ccrs`.`user_role` (
  `user_id` BIGINT NOT NULL,
  `role_id` INT NOT NULL,
  PRIMARY KEY (`user_id`,`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
