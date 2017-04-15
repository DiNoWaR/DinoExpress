package ru.vasilyev.service;


import ru.vasilyev.dao.mysqldao.StationMySqlDao;
import ru.vasilyev.dao.mysqldao.TrainMySqlDao;
import ru.vasilyev.dao.mysqldao.WagonTypeMySqlDao;
import ru.vasilyev.model.Station;
import ru.vasilyev.views.TrainsByStationsAndDateView;
import ru.vasilyev.model.WagonType;
import ru.vasilyev.wrappers.TrainsByStationsAndDateWrapper;


import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.List;

@Stateless
public class TestService {

    @Inject
    private WagonTypeMySqlDao wagonTypeMysqlDao;

    @Inject
    private StationMySqlDao stationDao;

    @Inject
    private TrainMySqlDao trainDao;


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

    public List<TrainsByStationsAndDateView> findTrainsByStationsAndDate(TrainsByStationsAndDateWrapper wrapper) {
        return trainDao.findTrainsByStationsAndDate(wrapper);
    }

}
