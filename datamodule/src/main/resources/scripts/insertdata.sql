INSERT INTO Station (Name, Latitude, Longitude) VALUES ('Moscow', 55.755, 37.617);
INSERT INTO Station (Name, Latitude, Longitude) VALUES ('Saint-Petersburg', 59.934, 30.335);
INSERT INTO Station (Name, Latitude, Longitude) VALUES ('Nizniy Novgorod', 56.296, 43.936);


INSERT INTO Wagontype(ClassCode, Description, WagonTypeCoefficient) VALUES ('HE1', 'First class for highspeed trains.Comfortable seats.', 6);
INSERT INTO Wagontype(ClassCode, Description, WagonTypeCoefficient) VALUES ('HE2', 'Bussiness class for highspeed trains.All seats are near table', 3.5);
INSERT INTO Wagontype(ClassCode, Description, WagonTypeCoefficient) VALUES ('HC2', 'Economic class for highspeed trains.', 2.5);
INSERT INTO Wagontype(ClassCode, Description, WagonTypeCoefficient) VALUES ('BE1', 'Bussiness coupe wagon for basic trains', 8.5);
INSERT INTO Wagontype(ClassCode, Description, WagonTypeCoefficient) VALUES ('BE2', 'Coupe wagon for basic train', 4);
INSERT INTO Wagontype(ClassCode, Description, WagonTypeCoefficient) VALUES ('BC2', 'Platzcart wagon for basic train', 1);
INSERT INTO Wagontype(ClassCode, Description, WagonTypeCoefficient) VALUES ('WRS', 'Wagon restaurant', 0);


INSERT INTO Train (Name, Manufacturer, MaxSpeed, IsHighSpeed) VALUES ('Sapsan S1', 'Siemens', 250, 1);
INSERT INTO Train (Name, Manufacturer, MaxSpeed, IsHighSpeed) VALUES ('Sapsan S2', 'Siemens', 250, 1);


INSERT INTO Wagon(WagonNumber, WagonType, Train) VALUES (1, (select WT.Id from WagonType WT where WT.ClassCode = 'HC2'), (select T.Id from Train T where T.Name = 'Sapsan S1'));
INSERT INTO Wagon(WagonNumber, WagonType, Train) VALUES (2, (select WT.Id from WagonType WT where WT.ClassCode = 'HC2'), (select T.Id from Train T where T.Name = 'Sapsan S1'));
INSERT INTO Wagon(WagonNumber, WagonType, Train) VALUES (3, (select WT.Id from WagonType WT where WT.ClassCode = 'HC2'), (select T.Id from Train T where T.Name = 'Sapsan S1'));
INSERT INTO Wagon(WagonNumber, WagonType, Train) VALUES (4, (select WT.Id from WagonType WT where WT.ClassCode = 'HC2'), (select T.Id from Train T where T.Name = 'Sapsan S1'));
INSERT INTO Wagon(WagonNumber, WagonType, Train) VALUES (5, (select WT.Id from WagonType WT where WT.ClassCode = 'HC2'), (select T.Id from Train T where T.Name = 'Sapsan S1'));
INSERT INTO Wagon(WagonNumber, WagonType, Train) VALUES (6, (select WT.Id from WagonType WT where WT.ClassCode = 'WRS'), (select T.Id from Train T where T.Name = 'Sapsan S1'));
INSERT INTO Wagon(WagonNumber, WagonType, Train) VALUES (7, (select WT.Id from WagonType WT where WT.ClassCode = 'HE2'), (select T.Id from Train T where T.Name = 'Sapsan S1'));
INSERT INTO Wagon(WagonNumber, WagonType, Train) VALUES (8, (select WT.Id from WagonType WT where WT.ClassCode = 'HE2'), (select T.Id from Train T where T.Name = 'Sapsan S1'));
INSERT INTO Wagon(WagonNumber, WagonType, Train) VALUES (9, (select WT.Id from WagonType WT where WT.ClassCode = 'HE1'), (select T.Id from Train T where T.Name = 'Sapsan S1'));
INSERT INTO Wagon(WagonNumber, WagonType, Train) VALUES (1, (select WT.Id from WagonType WT where WT.ClassCode = 'HC2'), (select T.Id from Train T where T.Name = 'Sapsan S2'));
INSERT INTO Wagon(WagonNumber, WagonType, Train) VALUES (2, (select WT.Id from WagonType WT where WT.ClassCode = 'HC2'), (select T.Id from Train T where T.Name = 'Sapsan S2'));
INSERT INTO Wagon(WagonNumber, WagonType, Train) VALUES (3, (select WT.Id from WagonType WT where WT.ClassCode = 'HC2'), (select T.Id from Train T where T.Name = 'Sapsan S2'));
INSERT INTO Wagon(WagonNumber, WagonType, Train) VALUES (4, (select WT.Id from WagonType WT where WT.ClassCode = 'HC2'), (select T.Id from Train T where T.Name = 'Sapsan S2'));
INSERT INTO Wagon(WagonNumber, WagonType, Train) VALUES (5, (select WT.Id from WagonType WT where WT.ClassCode = 'HC2'), (select T.Id from Train T where T.Name = 'Sapsan S2'));
INSERT INTO Wagon(WagonNumber, WagonType, Train) VALUES (6, (select WT.Id from WagonType WT where WT.ClassCode = 'WRS'), (select T.Id from Train T where T.Name = 'Sapsan S2'));
INSERT INTO Wagon(WagonNumber, WagonType, Train) VALUES (7, (select WT.Id from WagonType WT where WT.ClassCode = 'HE2'), (select T.Id from Train T where T.Name = 'Sapsan S2'));
INSERT INTO Wagon(WagonNumber, WagonType, Train) VALUES (8, (select WT.Id from WagonType WT where WT.ClassCode = 'HE2'), (select T.Id from Train T where T.Name = 'Sapsan S2'));
INSERT INTO Wagon(WagonNumber, WagonType, Train) VALUES (9, (select WT.Id from WagonType WT where WT.ClassCode = 'HE1'), (select T.Id from Train T where T.Name = 'Sapsan S2'));



INSERT INTO Route(RouteCode) VALUES ('SP 760');
INSERT INTO Route(RouteCode) VALUES ('SP 715');


INSERT INTO MinRoute(StationFrom, StationTo, DepartureDate, ArrivalDate, Train, Route, Sequence) VALUES ((Select S.id FROM Station S where S.name = 'Nizniy Novgorod'), (Select S.id FROM Station S where S.name = 'Moscow'), '2017-08-01 07:15:00', '2017-08-01 09:30:00', (select T.Id from Train T where T.Name = 'Sapsan S1'), (select R.id from Route R where R.RouteCode = 'SP 760'), 1);
INSERT INTO MinRoute (StationFrom, StationTo, DepartureDate, ArrivalDate, Train, Route, Sequence) VALUES ((Select S.id FROM Station S where S.name = 'Moscow'), (Select S.id FROM Station S where S.name = 'Saint-Petersburg'), '2017-08-01 09:45:00', '2017-08-01 13:45:00', (select T.Id from Train T where T.Name = 'Sapsan S1'), (select R.id from Route R where R.RouteCode = 'SP 760'), 2);
INSERT INTO MinRoute (StationFrom, StationTo, DepartureDate, ArrivalDate, Train, Route, Sequence) VALUES ((Select S.id FROM Station S where S.name = 'Moscow'), (Select S.id FROM Station S where S.name = 'Saint-Petersburg'), '2017-08-01 19:30:00', '2017-08-01 23:40:00', (select T.Id from Train T where T.Name = 'Sapsan S2'), (select R.id from Route R where R.RouteCode = 'SP 715'), 1);


##
INSERT INTO Seat (Number, NearTable, IsVacant, Wagon)
VALUES (1, 0, 1,
        (select W.Id from Wagon W where W.WagonNumber = 1
                                        and W.WagonType = (select WT.Id from WagonType WT where WT.ClassCode = 'HC2' and W.Train = (select T.Id from Train T where T.Name = 'Sapsan S1'))));

INSERT INTO Seat(Number, NearTable, IsVacant, Wagon)
VALUES (2, 0, 1,
        (select W.Id from Wagon W where W.WagonNumber = 1
                                        and W.WagonType = (select WT.Id from WagonType WT where WT.ClassCode = 'HC2' and W.Train = (select T.Id from Train T where T.Name = 'Sapsan S1'))));

INSERT INTO Seat(Number, NearTable, IsVacant, Wagon)
VALUES (3, 0, 1,
        (select W.Id from Wagon W where W.WagonNumber = 1
                                        and W.WagonType = (select WT.Id from WagonType WT where WT.ClassCode = 'HC2' and W.Train = (select T.Id from Train T where T.Name = 'Sapsan S1'))));

INSERT INTO Seat(Number, NearTable, IsVacant, Wagon)
VALUES (4, 0, 1,
        (select W.Id from Wagon W where W.WagonNumber = 1
                                        and W.WagonType = (select WT.Id from WagonType WT where WT.ClassCode = 'HC2' and W.Train = (select T.Id from Train T where T.Name = 'Sapsan S1'))));

INSERT INTO Seat(Number, NearTable, IsVacant, Wagon)
VALUES (5, 0, 1,
        (select W.Id from Wagon W where W.WagonNumber = 1
                                        and W.WagonType = (select WT.Id from WagonType WT where WT.ClassCode = 'HC2' and W.Train = (select T.Id from Train T where T.Name = 'Sapsan S1'))));

INSERT INTO Seat(Number, NearTable, IsVacant, Wagon)
VALUES (6, 0, 1,
        (select W.Id from Wagon W where W.WagonNumber = 1
                                        and W.WagonType = (select WT.Id from WagonType WT where WT.ClassCode = 'HC2' and W.Train = (select T.Id from Train T where T.Name = 'Sapsan S1'))));

INSERT INTO Seat(Number, NearTable, IsVacant, Wagon)
VALUES (7, 0, 1,
        (select W.Id from Wagon W where W.WagonNumber = 1
                                        and W.WagonType = (select WT.Id from WagonType WT where WT.ClassCode = 'HC2' and W.Train = (select T.Id from Train T where T.Name = 'Sapsan S1'))));

INSERT INTO Seat(Number, NearTable, IsVacant, Wagon)
VALUES (8, 0, 1,
        (select W.Id from Wagon W where W.WagonNumber = 1
                                        and W.WagonType = (select WT.Id from WagonType WT where WT.ClassCode = 'HC2' and W.Train = (select T.Id from Train T where T.Name = 'Sapsan S1'))));

INSERT INTO Seat(Number, NearTable, IsVacant, Wagon)
VALUES (9, 0, 1,
        (select W.Id from Wagon W where W.WagonNumber = 1
                                        and W.WagonType = (select WT.Id from WagonType WT where WT.ClassCode = 'HC2' and W.Train = (select T.Id from Train T where T.Name = 'Sapsan S1'))));

INSERT INTO Seat(Number, NearTable, IsVacant, Wagon)
VALUES (10, 0, 1,
        (select W.Id from Wagon W where W.WagonNumber = 1
                                        and W.WagonType = (select WT.Id from WagonType WT where WT.ClassCode = 'HC2' and W.Train = (select T.Id from Train T where T.Name = 'Sapsan S1'))));

INSERT INTO Seat(Number, NearTable, IsVacant, Wagon)
VALUES (11, 0, 1,
        (select W.Id from Wagon W where W.WagonNumber = 1
                                        and W.WagonType = (select WT.Id from WagonType WT where WT.ClassCode = 'HC2' and W.Train = (select T.Id from Train T where T.Name = 'Sapsan S1'))));

INSERT INTO Seat(Number, NearTable, IsVacant, Wagon)
VALUES (12, 0, 1,
        (select W.Id from Wagon W where W.WagonNumber = 1
                                        and W.WagonType = (select WT.Id from WagonType WT where WT.ClassCode = 'HC2' and W.Train = (select T.Id from Train T where T.Name = 'Sapsan S1'))));

INSERT INTO Seat(Number, NearTable, IsVacant, Wagon)
VALUES (13, 0, 1,
        (select W.Id from Wagon W where W.WagonNumber = 1
                                        and W.WagonType = (select WT.Id from WagonType WT where WT.ClassCode = 'HC2' and W.Train = (select T.Id from Train T where T.Name = 'Sapsan S1'))));

INSERT INTO Seat(Number, NearTable, IsVacant, Wagon)
VALUES (14, 0, 1,
        (select W.Id from Wagon W where W.WagonNumber = 1
                                        and W.WagonType = (select WT.Id from WagonType WT where WT.ClassCode = 'HC2' and W.Train = (select T.Id from Train T where T.Name = 'Sapsan S1'))));

INSERT INTO Seat(Number, NearTable, IsVacant, Wagon)
VALUES (15, 0, 1,
        (select W.Id from Wagon W where W.WagonNumber = 1
                                        and W.WagonType = (select WT.Id from WagonType WT where WT.ClassCode = 'HC2' and W.Train = (select T.Id from Train T where T.Name = 'Sapsan S1'))));

INSERT INTO Seat(Number, NearTable, IsVacant, Wagon)
VALUES (16, 0, 1,
        (select W.Id from Wagon W where W.WagonNumber = 1
                                        and W.WagonType = (select WT.Id from WagonType WT where WT.ClassCode = 'HC2' and W.Train = (select T.Id from Train T where T.Name = 'Sapsan S1'))));

INSERT INTO Seat(Number, NearTable, IsVacant, Wagon)
VALUES (17, 0, 1,
        (select W.Id from Wagon W where W.WagonNumber = 1
                                        and W.WagonType = (select WT.Id from WagonType WT where WT.ClassCode = 'HC2' and W.Train = (select T.Id from Train T where T.Name = 'Sapsan S1'))));

INSERT INTO Seat(Number, NearTable, IsVacant, Wagon)
VALUES (18, 0, 1,
        (select W.Id from Wagon W where W.WagonNumber = 1
                                        and W.WagonType = (select WT.Id from WagonType WT where WT.ClassCode = 'HC2' and W.Train = (select T.Id from Train T where T.Name = 'Sapsan S1'))));

INSERT INTO Seat(Number, NearTable, IsVacant, Wagon)
VALUES (19, 0, 1,
        (select W.Id from Wagon W where W.WagonNumber = 1
                                        and W.WagonType = (select WT.Id from WagonType WT where WT.ClassCode = 'HC2' and W.Train = (select T.Id from Train T where T.Name = 'Sapsan S1'))));

INSERT INTO Seat(Number, NearTable, IsVacant, Wagon)
VALUES (20, 0, 1,
        (select W.Id from Wagon W where W.WagonNumber = 1
                                        and W.WagonType = (select WT.Id from WagonType WT where WT.ClassCode = 'HC2' and W.Train = (select T.Id from Train T where T.Name = 'Sapsan S1'))));

INSERT INTO Seat(Number, NearTable, IsVacant, Wagon)
VALUES (21, 1, 1,
        (select W.Id from Wagon W where W.WagonNumber = 1
                                        and W.WagonType = (select WT.Id from WagonType WT where WT.ClassCode = 'HC2' and W.Train = (select T.Id from Train T where T.Name = 'Sapsan S1'))));

INSERT INTO Seat(Number, NearTable, IsVacant, Wagon)
VALUES (22, 1, 1,
        (select W.Id from Wagon W where W.WagonNumber = 1
                                        and W.WagonType = (select WT.Id from WagonType WT where WT.ClassCode = 'HC2' and W.Train = (select T.Id from Train T where T.Name = 'Sapsan S1'))));

INSERT INTO Seat(Number, NearTable, IsVacant, Wagon)
VALUES (23, 1, 1,
        (select W.Id from Wagon W where W.WagonNumber = 1
                                        and W.WagonType = (select WT.Id from WagonType WT where WT.ClassCode = 'HC2' and W.Train = (select T.Id from Train T where T.Name = 'Sapsan S1'))));

INSERT INTO Seat(Number, NearTable, IsVacant, Wagon)
VALUES (24, 1, 1,
        (select W.Id from Wagon W where W.WagonNumber = 1
                                        and W.WagonType = (select WT.Id from WagonType WT where WT.ClassCode = 'HC2' and W.Train = (select T.Id from Train T where T.Name = 'Sapsan S1'))));

INSERT INTO Seat(Number, NearTable, IsVacant, Wagon)
VALUES (25, 1, 1,
        (select W.Id from Wagon W where W.WagonNumber = 1
                                        and W.WagonType = (select WT.Id from WagonType WT where WT.ClassCode = 'HC2' and W.Train = (select T.Id from Train T where T.Name = 'Sapsan S1'))));

INSERT INTO Seat(Number, NearTable, IsVacant, Wagon)
VALUES (26, 1, 1,
        (select W.Id from Wagon W where W.WagonNumber = 1
                                        and W.WagonType = (select WT.Id from WagonType WT where WT.ClassCode = 'HC2' and W.Train = (select T.Id from Train T where T.Name = 'Sapsan S1'))));

INSERT INTO Seat(Number, NearTable, IsVacant, Wagon)
VALUES (27, 1, 1,
        (select W.Id from Wagon W where W.WagonNumber = 1
                                        and W.WagonType = (select WT.Id from WagonType WT where WT.ClassCode = 'HC2' and W.Train = (select T.Id from Train T where T.Name = 'Sapsan S1'))));

INSERT INTO Seat(Number, NearTable, IsVacant, Wagon)
VALUES (28, 1, 1,
        (select W.Id from Wagon W where W.WagonNumber = 1
                                        and W.WagonType = (select WT.Id from WagonType WT where WT.ClassCode = 'HC2' and W.Train = (select T.Id from Train T where T.Name = 'Sapsan S1'))));

INSERT INTO Seat(Number, NearTable, IsVacant, Wagon)
VALUES (29, 0, 1,
        (select W.Id from Wagon W where W.WagonNumber = 1
                                        and W.WagonType = (select WT.Id from WagonType WT where WT.ClassCode = 'HC2' and W.Train = (select T.Id from Train T where T.Name = 'Sapsan S1'))));

INSERT INTO Seat(Number, NearTable, IsVacant, Wagon)
VALUES (30, 0, 1,
        (select W.Id from Wagon W where W.WagonNumber = 1
                                        and W.WagonType = (select WT.Id from WagonType WT where WT.ClassCode = 'HC2' and W.Train = (select T.Id from Train T where T.Name = 'Sapsan S1'))));

INSERT INTO Seat(Number, NearTable, IsVacant, Wagon)
VALUES (31, 0, 1,
        (select W.Id from Wagon W where W.WagonNumber = 1
                                        and W.WagonType = (select WT.Id from WagonType WT where WT.ClassCode = 'HC2' and W.Train = (select T.Id from Train T where T.Name = 'Sapsan S1'))));

INSERT INTO Seat(Number, NearTable, IsVacant, Wagon)
VALUES (32, 0, 1,
        (select W.Id from Wagon W where W.WagonNumber = 1
                                        and W.WagonType = (select WT.Id from WagonType WT where WT.ClassCode = 'HC2' and W.Train = (select T.Id from Train T where T.Name = 'Sapsan S1'))));

INSERT INTO Seat(Number, NearTable, IsVacant, Wagon)
VALUES (33, 0, 1,
        (select W.Id from Wagon W where W.WagonNumber = 1
                                        and W.WagonType = (select WT.Id from WagonType WT where WT.ClassCode = 'HC2' and W.Train = (select T.Id from Train T where T.Name = 'Sapsan S1'))));

INSERT INTO Seat(Number, NearTable, IsVacant, Wagon)
VALUES (34, 0, 1,
        (select W.Id from Wagon W where W.WagonNumber = 1
                                        and W.WagonType = (select WT.Id from WagonType WT where WT.ClassCode = 'HC2' and W.Train = (select T.Id from Train T where T.Name = 'Sapsan S1'))));

INSERT INTO Seat(Number, NearTable, IsVacant, Wagon)
VALUES (35, 0, 1,
        (select W.Id from Wagon W where W.WagonNumber = 1
                                        and W.WagonType = (select WT.Id from WagonType WT where WT.ClassCode = 'HC2' and W.Train = (select T.Id from Train T where T.Name = 'Sapsan S1'))));

INSERT INTO Seat(Number, NearTable, IsVacant, Wagon)
VALUES (36, 0, 1,
        (select W.Id from Wagon W where W.WagonNumber = 1
                                        and W.WagonType = (select WT.Id from WagonType WT where WT.ClassCode = 'HC2' and W.Train = (select T.Id from Train T where T.Name = 'Sapsan S1'))));

INSERT INTO Seat(Number, NearTable, IsVacant, Wagon)
VALUES (37, 0, 1,
        (select W.Id from Wagon W where W.WagonNumber = 1
                                        and W.WagonType = (select WT.Id from WagonType WT where WT.ClassCode = 'HC2' and W.Train = (select T.Id from Train T where T.Name = 'Sapsan S1'))));

INSERT INTO Seat(Number, NearTable, IsVacant, Wagon)
VALUES (38, 0, 1,
        (select W.Id from Wagon W where W.WagonNumber = 1
                                        and W.WagonType = (select WT.Id from WagonType WT where WT.ClassCode = 'HC2' and W.Train = (select T.Id from Train T where T.Name = 'Sapsan S1'))));

INSERT INTO Seat(Number, NearTable, IsVacant, Wagon)
VALUES (39, 0, 1,
        (select W.Id from Wagon W where W.WagonNumber = 1
                                        and W.WagonType = (select WT.Id from WagonType WT where WT.ClassCode = 'HC2' and W.Train = (select T.Id from Train T where T.Name = 'Sapsan S1'))));

INSERT INTO Seat(Number, NearTable, IsVacant, Wagon)
VALUES (40, 0, 1,
        (select W.Id from Wagon W where W.WagonNumber = 1
                                        and W.WagonType = (select WT.Id from WagonType WT where WT.ClassCode = 'HC2' and W.Train = (select T.Id from Train T where T.Name = 'Sapsan S1'))));


INSERT INTO Seat(Number, NearTable, IsVacant, Wagon)
VALUES (1, 0, 1,
        (select W.Id from Wagon W where W.WagonNumber = 2
                                        and W.WagonType = (select WT.Id from WagonType WT where WT.ClassCode = 'HC2' and W.Train = (select T.Id from Train T where T.Name = 'Sapsan S1'))));

INSERT INTO Seat(Number, NearTable, IsVacant, Wagon)
VALUES (2, 0, 1,
        (select W.Id from Wagon W where W.WagonNumber = 2
                                        and W.WagonType = (select WT.Id from WagonType WT where WT.ClassCode = 'HC2' and W.Train = (select T.Id from Train T where T.Name = 'Sapsan S1'))));

INSERT INTO Seat(Number, NearTable, IsVacant, Wagon)
VALUES (3, 0, 1,
        (select W.Id from Wagon W where W.WagonNumber = 2
                                        and W.WagonType = (select WT.Id from WagonType WT where WT.ClassCode = 'HC2' and W.Train = (select T.Id from Train T where T.Name = 'Sapsan S1'))));

INSERT INTO Seat(Number, NearTable, IsVacant, Wagon)
VALUES (4, 0, 1,
        (select W.Id from Wagon W where W.WagonNumber = 2
                                        and W.WagonType = (select WT.Id from WagonType WT where WT.ClassCode = 'HC2' and W.Train = (select T.Id from Train T where T.Name = 'Sapsan S1'))));

INSERT INTO Seat(Number, NearTable, IsVacant, Wagon)
VALUES (5, 0, 1,
        (select W.Id from Wagon W where W.WagonNumber = 2
                                        and W.WagonType = (select WT.Id from WagonType WT where WT.ClassCode = 'HC2' and W.Train = (select T.Id from Train T where T.Name = 'Sapsan S1'))));

INSERT INTO Seat(Number, NearTable, IsVacant, Wagon)
VALUES (6, 0, 1,
        (select W.Id from Wagon W where W.WagonNumber = 2
                                        and W.WagonType = (select WT.Id from WagonType WT where WT.ClassCode = 'HC2' and W.Train = (select T.Id from Train T where T.Name = 'Sapsan S1'))));

INSERT INTO Seat(Number, NearTable, IsVacant, Wagon)
VALUES (7, 0, 1,
        (select W.Id from Wagon W where W.WagonNumber = 2
                                        and W.WagonType = (select WT.Id from WagonType WT where WT.ClassCode = 'HC2' and W.Train = (select T.Id from Train T where T.Name = 'Sapsan S1'))));

INSERT INTO Seat(Number, NearTable, IsVacant, Wagon)
VALUES (8, 0, 1,
        (select W.Id from Wagon W where W.WagonNumber = 2
                                        and W.WagonType = (select WT.Id from WagonType WT where WT.ClassCode = 'HC2' and W.Train = (select T.Id from Train T where T.Name = 'Sapsan S1'))));

INSERT INTO Seat(Number, NearTable, IsVacant, Wagon)
VALUES (9, 0, 1,
        (select W.Id from Wagon W where W.WagonNumber = 2
                                        and W.WagonType = (select WT.Id from WagonType WT where WT.ClassCode = 'HC2' and W.Train = (select T.Id from Train T where T.Name = 'Sapsan S1'))));

INSERT INTO Seat(Number, NearTable, IsVacant, Wagon)
VALUES (10, 0, 1,
        (select W.Id from Wagon W where W.WagonNumber = 2
                                        and W.WagonType = (select WT.Id from WagonType WT where WT.ClassCode = 'HC2' and W.Train = (select T.Id from Train T where T.Name = 'Sapsan S1'))));

INSERT INTO Seat(Number, NearTable, IsVacant, Wagon)
VALUES (11, 0, 1,
        (select W.Id from Wagon W where W.WagonNumber = 2
                                        and W.WagonType = (select WT.Id from WagonType WT where WT.ClassCode = 'HC2' and W.Train = (select T.Id from Train T where T.Name = 'Sapsan S1'))));

INSERT INTO Seat(Number, NearTable, IsVacant, Wagon)
VALUES (12, 0, 1,
        (select W.Id from Wagon W where W.WagonNumber = 2
                                        and W.WagonType = (select WT.Id from WagonType WT where WT.ClassCode = 'HC2' and W.Train = (select T.Id from Train T where T.Name = 'Sapsan S1'))));

INSERT INTO Seat(Number, NearTable, IsVacant, Wagon)
VALUES (13, 0, 1,
        (select W.Id from Wagon W where W.WagonNumber = 2
                                        and W.WagonType = (select WT.Id from WagonType WT where WT.ClassCode = 'HC2' and W.Train = (select T.Id from Train T where T.Name = 'Sapsan S1'))));

INSERT INTO Seat(Number, NearTable, IsVacant, Wagon)
VALUES (14, 0, 1,
        (select W.Id from Wagon W where W.WagonNumber = 2
                                        and W.WagonType = (select WT.Id from WagonType WT where WT.ClassCode = 'HC2' and W.Train = (select T.Id from Train T where T.Name = 'Sapsan S1'))));

INSERT INTO Seat(Number, NearTable, IsVacant, Wagon)
VALUES (15, 0, 1,
        (select W.Id from Wagon W where W.WagonNumber = 2
                                        and W.WagonType = (select WT.Id from WagonType WT where WT.ClassCode = 'HC2' and W.Train = (select T.Id from Train T where T.Name = 'Sapsan S1'))));

INSERT INTO Seat(Number, NearTable, IsVacant, Wagon)
VALUES (16, 0, 1,
        (select W.Id from Wagon W where W.WagonNumber = 2
                                        and W.WagonType = (select WT.Id from WagonType WT where WT.ClassCode = 'HC2' and W.Train = (select T.Id from Train T where T.Name = 'Sapsan S1'))));

INSERT INTO Seat(Number, NearTable, IsVacant, Wagon)
VALUES (17, 0, 1,
        (select W.Id from Wagon W where W.WagonNumber = 2
                                        and W.WagonType = (select WT.Id from WagonType WT where WT.ClassCode = 'HC2' and W.Train = (select T.Id from Train T where T.Name = 'Sapsan S1'))));

INSERT INTO Seat(Number, NearTable, IsVacant, Wagon)
VALUES (18, 0, 1,
        (select W.Id from Wagon W where W.WagonNumber = 2
                                        and W.WagonType = (select WT.Id from WagonType WT where WT.ClassCode = 'HC2' and W.Train = (select T.Id from Train T where T.Name = 'Sapsan S1'))));

INSERT INTO Seat(Number, NearTable, IsVacant, Wagon)
VALUES (19, 0, 1,
        (select W.Id from Wagon W where W.WagonNumber = 2
                                        and W.WagonType = (select WT.Id from WagonType WT where WT.ClassCode = 'HC2' and W.Train = (select T.Id from Train T where T.Name = 'Sapsan S1'))));

INSERT INTO Seat(Number, NearTable, IsVacant, Wagon)
VALUES (20, 0, 1,
        (select W.Id from Wagon W where W.WagonNumber = 2
                                        and W.WagonType = (select WT.Id from WagonType WT where WT.ClassCode = 'HC2' and W.Train = (select T.Id from Train T where T.Name = 'Sapsan S1'))));

INSERT INTO Seat(Number, NearTable, IsVacant, Wagon)
VALUES (21, 1, 1,
        (select W.Id from Wagon W where W.WagonNumber = 2
                                        and W.WagonType = (select WT.Id from WagonType WT where WT.ClassCode = 'HC2' and W.Train = (select T.Id from Train T where T.Name = 'Sapsan S1'))));

INSERT INTO Seat(Number, NearTable, IsVacant, Wagon)
VALUES (22, 1, 1,
        (select W.Id from Wagon W where W.WagonNumber = 2
                                        and W.WagonType = (select WT.Id from WagonType WT where WT.ClassCode = 'HC2' and W.Train = (select T.Id from Train T where T.Name = 'Sapsan S1'))));

INSERT INTO Seat(Number, NearTable, IsVacant, Wagon)
VALUES (23, 1, 1,
        (select W.Id from Wagon W where W.WagonNumber = 2
                                        and W.WagonType = (select WT.Id from WagonType WT where WT.ClassCode = 'HC2' and W.Train = (select T.Id from Train T where T.Name = 'Sapsan S1'))));

INSERT INTO Seat(Number, NearTable, IsVacant, Wagon)
VALUES (24, 1, 1,
        (select W.Id from Wagon W where W.WagonNumber = 2
                                        and W.WagonType = (select WT.Id from WagonType WT where WT.ClassCode = 'HC2' and W.Train = (select T.Id from Train T where T.Name = 'Sapsan S1'))));

INSERT INTO Seat(Number, NearTable, IsVacant, Wagon)
VALUES (25, 1, 1,
        (select W.Id from Wagon W where W.WagonNumber = 2
                                        and W.WagonType = (select WT.Id from WagonType WT where WT.ClassCode = 'HC2' and W.Train = (select T.Id from Train T where T.Name = 'Sapsan S1'))));

INSERT INTO Seat(Number, NearTable, IsVacant, Wagon)
VALUES (26, 1, 1,
        (select W.Id from Wagon W where W.WagonNumber = 2
                                        and W.WagonType = (select WT.Id from WagonType WT where WT.ClassCode = 'HC2' and W.Train = (select T.Id from Train T where T.Name = 'Sapsan S1'))));

INSERT INTO Seat(Number, NearTable, IsVacant, Wagon)
VALUES (27, 1, 1,
        (select W.Id from Wagon W where W.WagonNumber = 2
                                        and W.WagonType = (select WT.Id from WagonType WT where WT.ClassCode = 'HC2' and W.Train = (select T.Id from Train T where T.Name = 'Sapsan S1'))));

INSERT INTO Seat(Number, NearTable, IsVacant, Wagon)
VALUES (28, 1, 1,
        (select W.Id from Wagon W where W.WagonNumber = 2
                                        and W.WagonType = (select WT.Id from WagonType WT where WT.ClassCode = 'HC2' and W.Train = (select T.Id from Train T where T.Name = 'Sapsan S1'))));

INSERT INTO Seat(Number, NearTable, IsVacant, Wagon)
VALUES (29, 0, 1,
        (select W.Id from Wagon W where W.WagonNumber = 2
                                        and W.WagonType = (select WT.Id from WagonType WT where WT.ClassCode = 'HC2' and W.Train = (select T.Id from Train T where T.Name = 'Sapsan S1'))));

INSERT INTO Seat(Number, NearTable, IsVacant, Wagon)
VALUES (30, 0, 1,
        (select W.Id from Wagon W where W.WagonNumber = 2
                                        and W.WagonType = (select WT.Id from WagonType WT where WT.ClassCode = 'HC2' and W.Train = (select T.Id from Train T where T.Name = 'Sapsan S1'))));

INSERT INTO Seat(Number, NearTable, IsVacant, Wagon)
VALUES (31, 0, 1,
        (select W.Id from Wagon W where W.WagonNumber = 2
                                        and W.WagonType = (select WT.Id from WagonType WT where WT.ClassCode = 'HC2' and W.Train = (select T.Id from Train T where T.Name = 'Sapsan S1'))));

INSERT INTO Seat(Number, NearTable, IsVacant, Wagon)
VALUES (32, 0, 1,
        (select W.Id from Wagon W where W.WagonNumber = 2
                                        and W.WagonType = (select WT.Id from WagonType WT where WT.ClassCode = 'HC2' and W.Train = (select T.Id from Train T where T.Name = 'Sapsan S1'))));

INSERT INTO Seat(Number, NearTable, IsVacant, Wagon)
VALUES (33, 0, 1,
        (select W.Id from Wagon W where W.WagonNumber = 2
                                        and W.WagonType = (select WT.Id from WagonType WT where WT.ClassCode = 'HC2' and W.Train = (select T.Id from Train T where T.Name = 'Sapsan S1'))));

INSERT INTO Seat(Number, NearTable, IsVacant, Wagon)
VALUES (34, 0, 1,
        (select W.Id from Wagon W where W.WagonNumber = 2
                                        and W.WagonType = (select WT.Id from WagonType WT where WT.ClassCode = 'HC2' and W.Train = (select T.Id from Train T where T.Name = 'Sapsan S1'))));

INSERT INTO Seat(Number, NearTable, IsVacant, Wagon)
VALUES (35, 0, 1,
        (select W.Id from Wagon W where W.WagonNumber = 2
                                        and W.WagonType = (select WT.Id from WagonType WT where WT.ClassCode = 'HC2' and W.Train = (select T.Id from Train T where T.Name = 'Sapsan S1'))));

INSERT INTO Seat(Number, NearTable, IsVacant, Wagon)
VALUES (36, 0, 1,
        (select W.Id from Wagon W where W.WagonNumber = 2
                                        and W.WagonType = (select WT.Id from WagonType WT where WT.ClassCode = 'HC2' and W.Train = (select T.Id from Train T where T.Name = 'Sapsan S1'))));

INSERT INTO Seat(Number, NearTable, IsVacant, Wagon)
VALUES (37, 0, 1,
        (select W.Id from Wagon W where W.WagonNumber = 2
                                        and W.WagonType = (select WT.Id from WagonType WT where WT.ClassCode = 'HC2' and W.Train = (select T.Id from Train T where T.Name = 'Sapsan S1'))));

INSERT INTO Seat(Number, NearTable, IsVacant, Wagon)
VALUES (38, 0, 1,
        (select W.Id from Wagon W where W.WagonNumber = 2
                                        and W.WagonType = (select WT.Id from WagonType WT where WT.ClassCode = 'HC2' and W.Train = (select T.Id from Train T where T.Name = 'Sapsan S1'))));

INSERT INTO Seat(Number, NearTable, IsVacant, Wagon)
VALUES (39, 0, 1,
        (select W.Id from Wagon W where W.WagonNumber = 2
                                        and W.WagonType = (select WT.Id from WagonType WT where WT.ClassCode = 'HC2' and W.Train = (select T.Id from Train T where T.Name = 'Sapsan S1'))));

INSERT INTO Seat(Number, NearTable, IsVacant, Wagon)
VALUES (40, 0, 1,
        (select W.Id from Wagon W where W.WagonNumber = 2
                                        and W.WagonType = (select WT.Id from WagonType WT where WT.ClassCode = 'HC2' and W.Train = (select T.Id from Train T where T.Name = 'Sapsan S1'))));


INSERT INTO Seat(Number, NearTable, IsVacant, Wagon)
VALUES (1, 0, 1,
        (select W.Id from Wagon W where W.WagonNumber = 3
                                        and W.WagonType = (select WT.Id from WagonType WT where WT.ClassCode = 'HC2' and W.Train = (select T.Id from Train T where T.Name = 'Sapsan S1'))));

INSERT INTO Seat(Number, NearTable, IsVacant, Wagon)
VALUES (2, 0, 1,
        (select W.Id from Wagon W where W.WagonNumber = 3
                                        and W.WagonType = (select WT.Id from WagonType WT where WT.ClassCode = 'HC2' and W.Train = (select T.Id from Train T where T.Name = 'Sapsan S1'))));

INSERT INTO Seat(Number, NearTable, IsVacant, Wagon)
VALUES (3, 0, 1,
        (select W.Id from Wagon W where W.WagonNumber = 3
                                        and W.WagonType = (select WT.Id from WagonType WT where WT.ClassCode = 'HC2' and W.Train = (select T.Id from Train T where T.Name = 'Sapsan S1'))));

INSERT INTO Seat(Number, NearTable, IsVacant, Wagon)
VALUES (4, 0, 1,
        (select W.Id from Wagon W where W.WagonNumber = 3
                                        and W.WagonType = (select WT.Id from WagonType WT where WT.ClassCode = 'HC2' and W.Train = (select T.Id from Train T where T.Name = 'Sapsan S1'))));

INSERT INTO Seat(Number, NearTable, IsVacant, Wagon)
VALUES (5, 0, 1,
        (select W.Id from Wagon W where W.WagonNumber = 3
                                        and W.WagonType = (select WT.Id from WagonType WT where WT.ClassCode = 'HC2' and W.Train = (select T.Id from Train T where T.Name = 'Sapsan S1'))));

INSERT INTO Seat(Number, NearTable, IsVacant, Wagon)
VALUES (6, 0, 1,
        (select W.Id from Wagon W where W.WagonNumber = 3
                                        and W.WagonType = (select WT.Id from WagonType WT where WT.ClassCode = 'HC2' and W.Train = (select T.Id from Train T where T.Name = 'Sapsan S1'))));

INSERT INTO Seat(Number, NearTable, IsVacant, Wagon)
VALUES (7, 0, 1,
        (select W.Id from Wagon W where W.WagonNumber = 3
                                        and W.WagonType = (select WT.Id from WagonType WT where WT.ClassCode = 'HC2' and W.Train = (select T.Id from Train T where T.Name = 'Sapsan S1'))));

INSERT INTO Seat(Number, NearTable, IsVacant, Wagon)
VALUES (8, 0, 1,
        (select W.Id from Wagon W where W.WagonNumber = 3
                                        and W.WagonType = (select WT.Id from WagonType WT where WT.ClassCode = 'HC2' and W.Train = (select T.Id from Train T where T.Name = 'Sapsan S1'))));

INSERT INTO Seat(Number, NearTable, IsVacant, Wagon)
VALUES (9, 0, 1,
        (select W.Id from Wagon W where W.WagonNumber = 3
                                        and W.WagonType = (select WT.Id from WagonType WT where WT.ClassCode = 'HC2' and W.Train = (select T.Id from Train T where T.Name = 'Sapsan S1'))));

INSERT INTO Seat(Number, NearTable, IsVacant, Wagon)
VALUES (10, 0, 1,
        (select W.Id from Wagon W where W.WagonNumber = 3
                                        and W.WagonType = (select WT.Id from WagonType WT where WT.ClassCode = 'HC2' and W.Train = (select T.Id from Train T where T.Name = 'Sapsan S1'))));

INSERT INTO Seat(Number, NearTable, IsVacant, Wagon)
VALUES (11, 0, 1,
        (select W.Id from Wagon W where W.WagonNumber = 3
                                        and W.WagonType = (select WT.Id from WagonType WT where WT.ClassCode = 'HC2' and W.Train = (select T.Id from Train T where T.Name = 'Sapsan S1'))));

INSERT INTO Seat(Number, NearTable, IsVacant, Wagon)
VALUES (12, 0, 1,
        (select W.Id from Wagon W where W.WagonNumber = 3
                                        and W.WagonType = (select WT.Id from WagonType WT where WT.ClassCode = 'HC2' and W.Train = (select T.Id from Train T where T.Name = 'Sapsan S1'))));

INSERT INTO Seat(Number, NearTable, IsVacant, Wagon)
VALUES (13, 0, 1,
        (select W.Id from Wagon W where W.WagonNumber = 3
                                        and W.WagonType = (select WT.Id from WagonType WT where WT.ClassCode = 'HC2' and W.Train = (select T.Id from Train T where T.Name = 'Sapsan S1'))));

INSERT INTO Seat(Number, NearTable, IsVacant, Wagon)
VALUES (14, 0, 1,
        (select W.Id from Wagon W where W.WagonNumber = 3
                                        and W.WagonType = (select WT.Id from WagonType WT where WT.ClassCode = 'HC2' and W.Train = (select T.Id from Train T where T.Name = 'Sapsan S1'))));

INSERT INTO Seat(Number, NearTable, IsVacant, Wagon)
VALUES (15, 0, 1,
        (select W.Id from Wagon W where W.WagonNumber = 3
                                        and W.WagonType = (select WT.Id from WagonType WT where WT.ClassCode = 'HC2' and W.Train = (select T.Id from Train T where T.Name = 'Sapsan S1'))));

INSERT INTO Seat(Number, NearTable, IsVacant, Wagon)
VALUES (16, 0, 1,
        (select W.Id from Wagon W where W.WagonNumber = 3
                                        and W.WagonType = (select WT.Id from WagonType WT where WT.ClassCode = 'HC2' and W.Train = (select T.Id from Train T where T.Name = 'Sapsan S1'))));

INSERT INTO Seat(Number, NearTable, IsVacant, Wagon)
VALUES (17, 0, 1,
        (select W.Id from Wagon W where W.WagonNumber = 3
                                        and W.WagonType = (select WT.Id from WagonType WT where WT.ClassCode = 'HC2' and W.Train = (select T.Id from Train T where T.Name = 'Sapsan S1'))));

INSERT INTO Seat(Number, NearTable, IsVacant, Wagon)
VALUES (18, 0, 1,
        (select W.Id from Wagon W where W.WagonNumber = 3
                                        and W.WagonType = (select WT.Id from WagonType WT where WT.ClassCode = 'HC2' and W.Train = (select T.Id from Train T where T.Name = 'Sapsan S1'))));

INSERT INTO Seat(Number, NearTable, IsVacant, Wagon)
VALUES (19, 0, 1,
        (select W.Id from Wagon W where W.WagonNumber = 3
                                        and W.WagonType = (select WT.Id from WagonType WT where WT.ClassCode = 'HC2' and W.Train = (select T.Id from Train T where T.Name = 'Sapsan S1'))));

INSERT INTO Seat(Number, NearTable, IsVacant, Wagon)
VALUES (20, 0, 1,
        (select W.Id from Wagon W where W.WagonNumber = 3
                                        and W.WagonType = (select WT.Id from WagonType WT where WT.ClassCode = 'HC2' and W.Train = (select T.Id from Train T where T.Name = 'Sapsan S1'))));

INSERT INTO Seat(Number, NearTable, IsVacant, Wagon)
VALUES (21, 1, 1,
        (select W.Id from Wagon W where W.WagonNumber = 3
                                        and W.WagonType = (select WT.Id from WagonType WT where WT.ClassCode = 'HC2' and W.Train = (select T.Id from Train T where T.Name = 'Sapsan S1'))));

INSERT INTO Seat(Number, NearTable, IsVacant, Wagon)
VALUES (22, 1, 1,
        (select W.Id from Wagon W where W.WagonNumber = 3
                                        and W.WagonType = (select WT.Id from WagonType WT where WT.ClassCode = 'HC2' and W.Train = (select T.Id from Train T where T.Name = 'Sapsan S1'))));

INSERT INTO Seat(Number, NearTable, IsVacant, Wagon)
VALUES (23, 1, 1,
        (select W.Id from Wagon W where W.WagonNumber = 3
                                        and W.WagonType = (select WT.Id from WagonType WT where WT.ClassCode = 'HC2' and W.Train = (select T.Id from Train T where T.Name = 'Sapsan S1'))));

INSERT INTO Seat(Number, NearTable, IsVacant, Wagon)
VALUES (24, 1, 1,
        (select W.Id from Wagon W where W.WagonNumber = 3
                                        and W.WagonType = (select WT.Id from WagonType WT where WT.ClassCode = 'HC2' and W.Train = (select T.Id from Train T where T.Name = 'Sapsan S1'))));

INSERT INTO Seat(Number, NearTable, IsVacant, Wagon)
VALUES (25, 1, 1,
        (select W.Id from Wagon W where W.WagonNumber = 3
                                        and W.WagonType = (select WT.Id from WagonType WT where WT.ClassCode = 'HC2' and W.Train = (select T.Id from Train T where T.Name = 'Sapsan S1'))));

INSERT INTO Seat(Number, NearTable, IsVacant, Wagon)
VALUES (26, 1, 1,
        (select W.Id from Wagon W where W.WagonNumber = 3
                                        and W.WagonType = (select WT.Id from WagonType WT where WT.ClassCode = 'HC2' and W.Train = (select T.Id from Train T where T.Name = 'Sapsan S1'))));

INSERT INTO Seat(Number, NearTable, IsVacant, Wagon)
VALUES (27, 1, 1,
        (select W.Id from Wagon W where W.WagonNumber = 3
                                        and W.WagonType = (select WT.Id from WagonType WT where WT.ClassCode = 'HC2' and W.Train = (select T.Id from Train T where T.Name = 'Sapsan S1'))));

INSERT INTO Seat(Number, NearTable, IsVacant, Wagon)
VALUES (28, 1, 1,
        (select W.Id from Wagon W where W.WagonNumber = 3
                                        and W.WagonType = (select WT.Id from WagonType WT where WT.ClassCode = 'HC2' and W.Train = (select T.Id from Train T where T.Name = 'Sapsan S1'))));

INSERT INTO Seat(Number, NearTable, IsVacant, Wagon)
VALUES (29, 0, 1,
        (select W.Id from Wagon W where W.WagonNumber = 3
                                        and W.WagonType = (select WT.Id from WagonType WT where WT.ClassCode = 'HC2' and W.Train = (select T.Id from Train T where T.Name = 'Sapsan S1'))));

INSERT INTO Seat(Number, NearTable, IsVacant, Wagon)
VALUES (30, 0, 1,
        (select W.Id from Wagon W where W.WagonNumber = 3
                                        and W.WagonType = (select WT.Id from WagonType WT where WT.ClassCode = 'HC2' and W.Train = (select T.Id from Train T where T.Name = 'Sapsan S1'))));

INSERT INTO Seat(Number, NearTable, IsVacant, Wagon)
VALUES (31, 0, 1,
        (select W.Id from Wagon W where W.WagonNumber = 3
                                        and W.WagonType = (select WT.Id from WagonType WT where WT.ClassCode = 'HC2' and W.Train = (select T.Id from Train T where T.Name = 'Sapsan S1'))));

INSERT INTO Seat(Number, NearTable, IsVacant, Wagon)
VALUES (32, 0, 1,
        (select W.Id from Wagon W where W.WagonNumber = 3
                                        and W.WagonType = (select WT.Id from WagonType WT where WT.ClassCode = 'HC2' and W.Train = (select T.Id from Train T where T.Name = 'Sapsan S1'))));

INSERT INTO Seat(Number, NearTable, IsVacant, Wagon)
VALUES (33, 0, 1,
        (select W.Id from Wagon W where W.WagonNumber = 3
                                        and W.WagonType = (select WT.Id from WagonType WT where WT.ClassCode = 'HC2' and W.Train = (select T.Id from Train T where T.Name = 'Sapsan S1'))));

INSERT INTO Seat(Number, NearTable, IsVacant, Wagon)
VALUES (34, 0, 1,
        (select W.Id from Wagon W where W.WagonNumber = 3
                                        and W.WagonType = (select WT.Id from WagonType WT where WT.ClassCode = 'HC2' and W.Train = (select T.Id from Train T where T.Name = 'Sapsan S1'))));

INSERT INTO Seat(Number, NearTable, IsVacant, Wagon)
VALUES (35, 0, 1,
        (select W.Id from Wagon W where W.WagonNumber = 3
                                        and W.WagonType = (select WT.Id from WagonType WT where WT.ClassCode = 'HC2' and W.Train = (select T.Id from Train T where T.Name = 'Sapsan S1'))));

INSERT INTO Seat(Number, NearTable, IsVacant, Wagon)
VALUES (36, 0, 1,
        (select W.Id from Wagon W where W.WagonNumber = 3
                                        and W.WagonType = (select WT.Id from WagonType WT where WT.ClassCode = 'HC2' and W.Train = (select T.Id from Train T where T.Name = 'Sapsan S1'))));

INSERT INTO Seat(Number, NearTable, IsVacant, Wagon)
VALUES (37, 0, 1,
        (select W.Id from Wagon W where W.WagonNumber = 3
                                        and W.WagonType = (select WT.Id from WagonType WT where WT.ClassCode = 'HC2' and W.Train = (select T.Id from Train T where T.Name = 'Sapsan S1'))));

INSERT INTO Seat(Number, NearTable, IsVacant, Wagon)
VALUES (38, 0, 1,
        (select W.Id from Wagon W where W.WagonNumber = 3
                                        and W.WagonType = (select WT.Id from WagonType WT where WT.ClassCode = 'HC2' and W.Train = (select T.Id from Train T where T.Name = 'Sapsan S1'))));

INSERT INTO Seat(Number, NearTable, IsVacant, Wagon)
VALUES (39, 0, 1,
        (select W.Id from Wagon W where W.WagonNumber = 3
                                        and W.WagonType = (select WT.Id from WagonType WT where WT.ClassCode = 'HC2' and W.Train = (select T.Id from Train T where T.Name = 'Sapsan S1'))));

INSERT INTO Seat(Number, NearTable, IsVacant, Wagon)
VALUES (40, 0, 1,
        (select W.Id from Wagon W where W.WagonNumber = 3
                                        and W.WagonType = (select WT.Id from WagonType WT where WT.ClassCode = 'HC2' and W.Train = (select T.Id from Train T where T.Name = 'Sapsan S1'))));
















































