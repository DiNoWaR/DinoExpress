package ru.vasilyev.service;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.inject.Inject;

import ru.vasilyev.dao.MinRouteDao;
import ru.vasilyev.dao.RouteDao;
import ru.vasilyev.dao.SeatDao;
import ru.vasilyev.dao.StationDao;
import ru.vasilyev.dao.TrainDao;
import ru.vasilyev.dao.WagonDao;
import ru.vasilyev.dao.WagonTypeDao;
import ru.vasilyev.dto.MinRouteDTO;
import ru.vasilyev.model.MinRoute;
import ru.vasilyev.model.Train;
import ru.vasilyev.model.WagonType;

@Singleton
@Startup
@TransactionManagement(TransactionManagementType.CONTAINER)
public class GeneratorService {

    @Inject
    private WagonTypeDao wagonTypeMysqlDao;

    @Inject
    private StationDao stationDao;

    @Inject
    private TrainDao trainDao;

    @Inject
    private SeatDao seatDao;

    @Inject
    private WagonDao wagonDao;

    @Inject
    private RouteDao routeDao;

    @Inject
    private MinRouteDao minRouteDao;


    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public void generateTrain(Train train) {

    }

    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public void generateCollectionOfTrains(List<Train> trains) {

    }

    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public void generateWagonType(WagonType wagonType) {
        wagonTypeMysqlDao.insertEntity(wagonType);
    }

    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public void assignTrainToRoute(String routeCode, String trainName, List<MinRouteDTO> minRoutesDTOList) {

        List<MinRoute> minRoutes = new ArrayList<>();

        int routeCodeID = routeDao.findRouteIDByRouteCode(routeCode);
        int trainId = trainDao.findTrainByName(trainName);

        for (MinRouteDTO item : minRoutesDTOList) {

            int stationFromID = stationDao.findStationIdByName(item.getStationFrom());
            int stationToID = stationDao.findStationIdByName(item.getStationTo());
            Date departureDate = item.getDepartureDate();
            Date arrivalDate = item.getArrivalDate();
            int sequence = item.getSequence();

            MinRoute minRoute = new MinRoute(stationFromID, stationToID, departureDate, arrivalDate, trainId, routeCodeID, sequence);

            minRoutes.add(minRoute);

        }


        minRouteDao.insertCollectionOfEntity(minRoutes);

    }

}
