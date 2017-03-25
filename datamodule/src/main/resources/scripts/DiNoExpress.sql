-- Schema DiNoExpress
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `DiNoExpress` ;

-- -----------------------------------------------------
-- Schema DiNoExpress
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `DiNoExpress` DEFAULT CHARACTER SET utf8 ;
USE `DiNoExpress` ;

-- -----------------------------------------------------
-- Table `DiNoExpress`.`Train`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `DiNoExpress`.`Train` ;

CREATE TABLE IF NOT EXISTS `DiNoExpress`.`Train` (
  `Id` INT NOT NULL AUTO_INCREMENT,
  `Name` VARCHAR(100) NOT NULL,
  `Manufacturer` VARCHAR(50) NOT NULL,
  `MaxSpeed` INT NOT NULL,
  `IsHighSpeed` TINYINT NOT NULL DEFAULT 0,
  PRIMARY KEY (`Id`),
  UNIQUE INDEX `Id_UNIQUE` (`Id` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `DiNoExpress`.`WagonType`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `DiNoExpress`.`WagonType` ;

CREATE TABLE IF NOT EXISTS `DiNoExpress`.`WagonType` (
  `Id` INT NOT NULL AUTO_INCREMENT,
  `ClassCode` VARCHAR(45) NOT NULL,
  `Description` VARCHAR(200) NOT NULL,
  `WagonTypeCoefficient` DECIMAL NOT NULL,
  PRIMARY KEY (`Id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `DiNoExpress`.`Wagon`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `DiNoExpress`.`Wagon` ;

CREATE TABLE IF NOT EXISTS `DiNoExpress`.`Wagon` (
  `Id` INT NOT NULL AUTO_INCREMENT,
  `WagonNumber` INT NOT NULL,
  `WagonType` INT NULL,
  `Train` INT NULL,
  PRIMARY KEY (`Id`),
  INDEX `fk_Wagon_WagonClass_idx` (`WagonType` ASC),
  INDEX `fk_Wagon_Train1_idx` (`Train` ASC),
  CONSTRAINT `WagonWagonTypeKey`
    FOREIGN KEY (`WagonType`)
    REFERENCES `DiNoExpress`.`WagonType` (`Id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `WagonTrainKey`
    FOREIGN KEY (`Train`)
    REFERENCES `DiNoExpress`.`Train` (`Id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `DiNoExpress`.`Station`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `DiNoExpress`.`Station` ;

CREATE TABLE IF NOT EXISTS `DiNoExpress`.`Station` (
  `Id` INT NOT NULL AUTO_INCREMENT,
  `Name` VARCHAR(100) NOT NULL,
  `Latitude` DECIMAL(5,3) NOT NULL,
  `Longitude` DECIMAL(5,3) NOT NULL,
  PRIMARY KEY (`Id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `DiNoExpress`.`Route`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `DiNoExpress`.`Route` ;

CREATE TABLE IF NOT EXISTS `DiNoExpress`.`Route` (
  `Id` INT NOT NULL AUTO_INCREMENT,
  `RouteCode` VARCHAR(20) NOT NULL,
  PRIMARY KEY (`Id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `DiNoExpress`.`User`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `DiNoExpress`.`User` ;

CREATE TABLE IF NOT EXISTS `DiNoExpress`.`User` (
  `Id` INT NOT NULL AUTO_INCREMENT,
  `Name` VARCHAR(100) NOT NULL,
  `LastName` VARCHAR(100) NOT NULL,
  `BirthDate` DATE NOT NULL,
  `Email` VARCHAR(100) NOT NULL,
  `Gender` ENUM('F', 'M') NOT NULL,
  `IsAdmin` TINYINT NULL DEFAULT 0,
  `Password` VARCHAR(15) NOT NULL,
  PRIMARY KEY (`Id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `DiNoExpress`.`Ticket`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `DiNoExpress`.`Ticket` ;

CREATE TABLE IF NOT EXISTS `DiNoExpress`.`Ticket` (
  `Id` INT NOT NULL AUTO_INCREMENT,
  `User` INT NOT NULL,
  `Price` INT NOT NULL,
  PRIMARY KEY (`Id`),
  INDEX `User_idx` (`User` ASC),
  CONSTRAINT `TicketUserKey`
    FOREIGN KEY (`User`)
    REFERENCES `DiNoExpress`.`User` (`Id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `DiNoExpress`.`MinRoute`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `DiNoExpress`.`MinRoute` ;

CREATE TABLE IF NOT EXISTS `DiNoExpress`.`MinRoute` (
  `Id` INT NOT NULL AUTO_INCREMENT,
  `StationFrom` INT NOT NULL,
  `StationTo` INT NOT NULL,
  `DepartureDate` DATETIME NOT NULL,
  `ArrivalDate` DATETIME NOT NULL,
  `Train` INT NOT NULL,
  `Route` INT NOT NULL,
  `Sequence` INT NOT NULL,
  `Ticket_Id` INT NULL,
  PRIMARY KEY (`Id`),
  INDEX `StationFrom_idx` (`StationFrom` ASC),
  INDEX `StationTo_idx` (`StationTo` ASC),
  INDEX `Train_idx` (`Train` ASC),
  INDEX `Route_idx` (`Route` ASC),
  INDEX `fk_MinRoute_Ticket1_idx` (`Ticket_Id` ASC),
  CONSTRAINT `MinRouteStationFromKey`
    FOREIGN KEY (`StationFrom`)
    REFERENCES `DiNoExpress`.`Station` (`Id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `MinRouteStationToKey`
    FOREIGN KEY (`StationTo`)
    REFERENCES `DiNoExpress`.`Station` (`Id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `MinRouteTrainKey`
    FOREIGN KEY (`Train`)
    REFERENCES `DiNoExpress`.`Train` (`Id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `MinRouteRouteKey`
    FOREIGN KEY (`Route`)
    REFERENCES `DiNoExpress`.`Route` (`Id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `MinRouteRuketKey`
    FOREIGN KEY (`Ticket_Id`)
    REFERENCES `DiNoExpress`.`Ticket` (`Id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `DiNoExpress`.`Seat`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `DiNoExpress`.`Seat` ;

CREATE TABLE IF NOT EXISTS `DiNoExpress`.`Seat` (
  `Id` INT NOT NULL AUTO_INCREMENT,
  `Number` INT NOT NULL,
  `NearTable` TINYINT NOT NULL,
  `IsVacant` TINYINT NOT NULL DEFAULT 1,
  `Wagon` INT NOT NULL,
  PRIMARY KEY (`Id`),
  INDEX `Wagon_idx` (`Wagon` ASC),
  CONSTRAINT `SeatWagonKey`
    FOREIGN KEY (`Wagon`)
    REFERENCES `DiNoExpress`.`Wagon` (`Id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;