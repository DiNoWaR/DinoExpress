-- -----------------------------------------------------
-- Schema DiNoExpress
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS DiNoExpressTest ;

-- -----------------------------------------------------
-- Schema DiNoExpress
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS DiNoExpressTest DEFAULT CHARACTER SET utf8 ;
USE DiNoExpressTest ;

-- -----------------------------------------------------
-- Table `DiNoExpress`.`Train`
-- -----------------------------------------------------
DROP TABLE IF EXISTS DiNoExpressTest.`Train` ;

CREATE TABLE IF NOT EXISTS DiNoExpressTest.`Train` (
  `Id` INT NOT NULL AUTO_INCREMENT,
  `Name` VARCHAR(100) NOT NULL,
  `Manufacturer` VARCHAR(50) NOT NULL,
  `MaxSpeed` INT NOT NULL,
  `IsHighSpeed` TINYINT NOT NULL DEFAULT 0,
  PRIMARY KEY (`Id`))
ENGINE = InnoDB;

CREATE UNIQUE INDEX `Id_UNIQUE` ON DiNoExpressTest.`Train` (`Id` ASC);


-- -----------------------------------------------------
-- Table `DiNoExpress`.`WagonType`
-- -----------------------------------------------------
DROP TABLE IF EXISTS DiNoExpressTest.`WagonType` ;

CREATE TABLE IF NOT EXISTS DiNoExpressTest.`WagonType` (
  `Id` INT NOT NULL AUTO_INCREMENT,
  `ClassCode` VARCHAR(45) NOT NULL,
  `Description` VARCHAR(200) NOT NULL,
  `WagonTypeCoefficient` DECIMAL(3,2) NOT NULL,
  PRIMARY KEY (`Id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `DiNoExpress`.`Wagon`
-- -----------------------------------------------------
DROP TABLE IF EXISTS DiNoExpressTest.`Wagon` ;

CREATE TABLE IF NOT EXISTS DiNoExpressTest.`Wagon` (
  `Id` INT NOT NULL AUTO_INCREMENT,
  `WagonNumber` INT NOT NULL,
  `WagonType` INT NULL,
  `Train` INT NOT NULL,
  PRIMARY KEY (`Id`),
  CONSTRAINT `WagonWagonTypeKey`
    FOREIGN KEY (`WagonType`)
    REFERENCES DiNoExpressTest.`WagonType` (`Id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `WagonTrainKey`
    FOREIGN KEY (`Train`)
    REFERENCES DiNoExpressTest.`Train` (`Id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE INDEX `fk_Wagon_WagonClass_idx` ON DiNoExpressTest.`Wagon` (`WagonType` ASC);

CREATE INDEX `fk_Wagon_Train1_idx` ON DiNoExpressTest.`Wagon` (`Train` ASC);


-- -----------------------------------------------------
-- Table `DiNoExpress`.`Station`
-- -----------------------------------------------------
DROP TABLE IF EXISTS DiNoExpressTest.`Station` ;

CREATE TABLE IF NOT EXISTS DiNoExpressTest.`Station` (
  `Id` INT NOT NULL AUTO_INCREMENT,
  `Name` VARCHAR(100) NOT NULL,
  `Latitude` DECIMAL(5,3) NOT NULL,
  `Longitude` DECIMAL(5,3) NOT NULL,
  PRIMARY KEY (`Id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `DiNoExpress`.`Route`
-- -----------------------------------------------------
DROP TABLE IF EXISTS DiNoExpressTest.`Route` ;

CREATE TABLE IF NOT EXISTS DiNoExpressTest.`Route` (
  `Id` INT NOT NULL AUTO_INCREMENT,
  `RouteCode` VARCHAR(20) NOT NULL,
  PRIMARY KEY (`Id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `DiNoExpress`.`MinRoute`
-- -----------------------------------------------------
DROP TABLE IF EXISTS DiNoExpressTest.`MinRoute` ;

CREATE TABLE IF NOT EXISTS DiNoExpressTest.`MinRoute` (
  `Id` INT NOT NULL AUTO_INCREMENT,
  `StationFrom` INT NOT NULL,
  `StationTo` INT NOT NULL,
  `DepartureDate` DATETIME NOT NULL,
  `ArrivalDate` DATETIME NOT NULL,
  `Train` INT NOT NULL,
  `Route` INT NOT NULL,
  `Sequence` INT NOT NULL,
  PRIMARY KEY (`Id`),
  CONSTRAINT `MinRouteStationFromKey`
    FOREIGN KEY (`StationFrom`)
    REFERENCES DiNoExpressTest.`Station` (`Id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `MinRouteStationToKey`
    FOREIGN KEY (`StationTo`)
    REFERENCES DiNoExpressTest.`Station` (`Id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `MinRouteTrainKey`
    FOREIGN KEY (`Train`)
    REFERENCES DiNoExpressTest.`Train` (`Id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `MinRouteRouteKey`
    FOREIGN KEY (`Route`)
    REFERENCES DiNoExpressTest.`Route` (`Id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE INDEX `StationFrom_idx` ON DiNoExpressTest.`MinRoute` (`StationFrom` ASC);

CREATE INDEX `StationTo_idx` ON DiNoExpressTest.`MinRoute` (`StationTo` ASC);

CREATE INDEX `Train_idx` ON DiNoExpressTest.`MinRoute` (`Train` ASC);

CREATE INDEX `Route_idx` ON DiNoExpressTest.`MinRoute` (`Route` ASC);


-- -----------------------------------------------------
-- Table `DiNoExpress`.`User`
-- -----------------------------------------------------
DROP TABLE IF EXISTS DiNoExpressTest.`User` ;

CREATE TABLE IF NOT EXISTS DiNoExpressTest.`User` (
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
DROP TABLE IF EXISTS DiNoExpressTest.`Ticket` ;

CREATE TABLE IF NOT EXISTS DiNoExpressTest.`Ticket` (
  `Id` INT NOT NULL AUTO_INCREMENT,
  `User` INT NOT NULL,
  `Price` INT NOT NULL,
  PRIMARY KEY (`Id`),
  CONSTRAINT `TicketUserKey`
    FOREIGN KEY (`User`)
    REFERENCES DiNoExpressTest.`User` (`Id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE INDEX `User_idx` ON DiNoExpressTest.`Ticket` (`User` ASC);


-- -----------------------------------------------------
-- Table `DiNoExpress`.`Seat`
-- -----------------------------------------------------
DROP TABLE IF EXISTS DiNoExpressTest.`Seat` ;

CREATE TABLE IF NOT EXISTS DiNoExpressTest.`Seat` (
  `Id` INT NOT NULL AUTO_INCREMENT,
  `Number` INT NOT NULL,
  `NearTable` TINYINT NOT NULL,
  `IsVacant` TINYINT NOT NULL DEFAULT 1,
  `Wagon` INT NOT NULL,
  PRIMARY KEY (`Id`),
  CONSTRAINT `SeatWagonKey`
    FOREIGN KEY (`Wagon`)
    REFERENCES DiNoExpressTest.`Wagon` (`Id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE INDEX `Wagon_idx` ON DiNoExpressTest.`Seat` (`Wagon` ASC);


-- -----------------------------------------------------
-- Table `DiNoExpress`.`TicketMinRoute`
-- -----------------------------------------------------
DROP TABLE IF EXISTS DiNoExpressTest.`TicketMinRoute` ;

CREATE TABLE IF NOT EXISTS DiNoExpressTest.`TicketMinRoute` (
  `Id` INT NOT NULL AUTO_INCREMENT,
  `TicketId` INT NOT NULL,
  `MinRouteId` INT NOT NULL,
  PRIMARY KEY (`Id`),
  CONSTRAINT `TicketMinRouteMinRouteKey`
    FOREIGN KEY (`MinRouteId`)
    REFERENCES DiNoExpressTest.`MinRoute` (`Id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `TicketMinRouteTicketKey`
    FOREIGN KEY (`TicketId`)
    REFERENCES DiNoExpressTest.`Ticket` (`Id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE INDEX `TicketMinRouteMinRouteKey_idx` ON DiNoExpressTest.`TicketMinRoute` (`MinRouteId` ASC);

CREATE INDEX `TicketMinRouteTicketKey_idx` ON DiNoExpressTest.`TicketMinRoute` (`TicketId` ASC);