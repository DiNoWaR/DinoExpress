package ru.vasilyev.util;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;

import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;

import ru.vasilyev.dao.mysqldao.MinRouteDao;
import ru.vasilyev.dao.mysqldao.RouteDao;
import ru.vasilyev.dao.mysqldao.SeatDao;
import ru.vasilyev.dao.mysqldao.StationDao;
import ru.vasilyev.dao.mysqldao.TrainDao;
import ru.vasilyev.dao.mysqldao.WagonDao;
import ru.vasilyev.dao.mysqldao.WagonTypeDao;
import ru.vasilyev.dto.MinRouteDTO;
import ru.vasilyev.model.MinRoute;
import ru.vasilyev.model.Train;
import ru.vasilyev.model.WagonType;

@Singleton
@Startup
@TransactionManagement(TransactionManagementType.CONTAINER)
public class Generator {

    @EJB
    private WagonTypeDao wagonTypeDao;

    @EJB
    private StationDao stationDao;

    @EJB
    private TrainDao trainDao;

    @EJB
    private SeatDao seatDao;

    @EJB
    private WagonDao wagonDao;

    @EJB
    private RouteDao routeDao;

    @EJB
    private MinRouteDao minRouteDao;


    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public void generateTrain(Train train) {
        trainDao.insertEntity(train);
    }

    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public void generateCollectionOfTrains(List<Train> trains) {
        trainDao.insertCollectionOfEntity(trains);
    }

    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public void generateWagonType(WagonType wagonType) {
        wagonTypeDao.insertEntity(wagonType);
    }

    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public void assignTrainToRoute(String routeCode, String trainName, List<MinRouteDTO> minRoutesDTOList) {

        List<MinRoute> minRoutes = new ArrayList<>();

        int routeCodeID = routeDao.findRouteIDByRouteCode(routeCode);
        int trainId = trainDao.findTrainByName(trainName);

        for (MinRouteDTO item : minRoutesDTOList) {

            int stationFromID = stationDao.findStationByName(item.getStationFrom());
            int stationToID = stationDao.findStationByName(item.getStationTo());
            Date departureDate = item.getDepartureDate();
            Date arrivalDate = item.getArrivalDate();
            int sequence = item.getSequence();

            MinRoute minRoute = new MinRoute(stationFromID, stationToID, departureDate, arrivalDate, trainId, routeCodeID, sequence);

            minRoutes.add(minRoute);

        }


        minRouteDao.insertCollectionOfEntity(minRoutes);

    }

}
