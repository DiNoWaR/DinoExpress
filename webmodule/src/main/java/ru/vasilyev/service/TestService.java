package ru.vasilyev.service;


import ru.vasilyev.dao.RouteDao;
import ru.vasilyev.dao.StationDao;
import ru.vasilyev.dao.TrainDao;
import ru.vasilyev.dao.WagonTypeDao;
import ru.vasilyev.model.Station;
import ru.vasilyev.views.RoutesByStationsAndDateView;
import ru.vasilyev.model.WagonType;
import ru.vasilyev.wrappers.RoutesByStationsAndDateWrapper;


import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.List;

@Stateless
public class TestService {

    @Inject
    private WagonTypeDao wagonTypeMysqlDao;

    @Inject
    private StationDao stationDao;

    @Inject
    private TrainDao trainDao;

    @Inject
    private RouteDao routeDao;

    public void insertWagonType(WagonType wagonType) {

    }

    public void insertCollectionOfWagonTypes(List<WagonType> wagonTypes) {
        wagonTypeMysqlDao.insertCollectionOfEntity(wagonTypes);
    }

    public List<WagonType> getAllWagonTypes() {
        return wagonTypeMysqlDao.getAllEntities();
    }

    public List<Station> getAllStations() {
        return stationDao.getAllEntities();
    }

    public List<RoutesByStationsAndDateView> findTrainsByStationsAndDate(RoutesByStationsAndDateWrapper wrapper) {
        return routeDao.findTrainsByStationsAndDate(wrapper);
    }

}
