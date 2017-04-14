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

import ru.vasilyev.dao.mysqldao.MinRouteMySqlDao;
import ru.vasilyev.dao.mysqldao.RouteMySqlDao;
import ru.vasilyev.dao.mysqldao.SeatMySqlDao;
import ru.vasilyev.dao.mysqldao.StationMySqlDao;
import ru.vasilyev.dao.mysqldao.TrainMySqlDao;
import ru.vasilyev.dao.mysqldao.WagonMysqlDao;
import ru.vasilyev.dao.mysqldao.WagonTypeMySqlDao;
import ru.vasilyev.dto.MinRouteDTO;
import ru.vasilyev.model.MinRoute;
import ru.vasilyev.model.Train;
import ru.vasilyev.model.WagonType;

@Singleton
@Startup
@TransactionManagement(TransactionManagementType.CONTAINER)
public class Generator {

    @EJB
    private WagonTypeMySqlDao wagonTypeMysqlDao;

    @EJB
    private StationMySqlDao stationDao;

    @EJB
    private TrainMySqlDao trainDao;

    @EJB
    private SeatMySqlDao seatDao;

    @EJB
    private WagonMysqlDao wagonDao;

    @EJB
    private RouteMySqlDao routeDao;

    @EJB
    private MinRouteMySqlDao minRouteDao;


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
