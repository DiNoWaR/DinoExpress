
## Find routes from station to station for certain date
SELECT
  src.RouteCode,
  src.srcStation,
  dest.destStation,
  src.DepartureDate,
  dest.ArrivalDate,
  src.srcSequence,
  destSequence
FROM (
       SELECT
         r.RouteCode,
         s1.Name     AS srcStation,
         mr.DepartureDate,
         mr.ArrivalDate,
         mr.Sequence AS srcSequence
       FROM minroute mr
         JOIN route r ON mr.Route = r.Id
         JOIN station s1 ON mr.StationFrom = s1.Id
         JOIN train t ON mr.Train = t.Id
       WHERE s1.name = 'Nizniy Novgorod') AS src
  JOIN (
         SELECT
           r.RouteCode,
           s2.Name     AS destStation,
           mr.DepartureDate,
           mr.ArrivalDate,
           mr.Sequence AS destSequence
         FROM minroute mr
           JOIN route r ON mr.Route = r.Id
           JOIN station s2 ON mr.StationTo = s2.Id
           JOIN train t ON mr.Train = t.Id
         WHERE s2.name = 'Saint-Petersburg') AS dest
WHERE src.RouteCode = dest.RouteCode;

##Find stations, which certain route passed
SELECT
  r.RouteCode,
  s1.name AS SourceStation,
  s2.name AS DestStation,
  mr.DepartureDate,
  mr.ArrivalDate
FROM minroute mr
  JOIN route r ON mr.Route = r.Id
  JOIN station s1 ON mr.StationFrom = s1.Id
  JOIN station s2 ON mr.StationTo = s2.Id
WHERE r.RouteCode = 'SP 760'
ORDER BY mr.Sequence;

##Find count of available seats in train, grouped by wagon type
SELECT
  t.name,
  w.WagonNumber,
  wt.ClassCode,
  count(CASE WHEN s.IsVacant = 0 THEN 0 ELSE 1 END) AS AvailableSeats
FROM train t
  JOIN wagon w ON w.Train = t.Id
  JOIN seat s ON s.Wagon = w.Id
  JOIN wagontype wt ON wt.Id = w.WagonType
GROUP BY t.Name, w.WagonNumber, wt.ClassCode;

##Find routes, that depart from station on certain time
SELECT
  r.RouteCode,
  s1.name AS SourceStation,
  s2.name AS DestStation,
  mr.DepartureDate
FROM minroute mr
  JOIN route r ON mr.Route = r.Id
  JOIN station s1 ON mr.StationFrom = s1.Id
  JOIN station s2 ON mr.StationTo = s2.Id
  JOIN train t ON mr.Train = t.Id
WHERE s1.name = 'moscow'
AND mr.DepartureDate BETWEEN '2017-07-31 00:00:00' AND '2017-08-02 00:00:00';

##Find routes, that arrive to station on certain time
SELECT
  r.RouteCode,
  s1.name AS SourceStation,
  s2.name AS DestStation,
  mr.ArrivalDate
FROM minroute mr
  JOIN route r ON mr.Route = r.Id
  JOIN station s1 ON mr.StationFrom = s1.Id
  JOIN station s2 ON mr.StationTo = s2.Id
  JOIN train t ON mr.Train = t.Id
WHERE s2.name = 'moscow'
AND mr.DepartureDate BETWEEN '2017-07-31 00:00:00' AND '2017-08-02 00:00:00';

