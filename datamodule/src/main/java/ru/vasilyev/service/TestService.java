package ru.vasilyev.service;


import ru.vasilyev.dao.StationDao;
import ru.vasilyev.dao.WagonTypeDao;
import ru.vasilyev.model.Station;
import ru.vasilyev.model.WagonType;


import javax.ejb.EJB;
import javax.ejb.Stateless;
import java.util.List;

@Stateless
public class TestService {

    @EJB
    private WagonTypeDao wagonTypeDao;

    @EJB
    private StationDao stationDao;


    public void insertWagonType(WagonType wagonType) {


    }

    public void insertCollectionOfWagonTypes(List<WagonType> wagonTypes) {
        wagonTypeDao.insertCollectionOfEntity(wagonTypes);
    }


    public List<WagonType> getAllWagonTypes() {
        return wagonTypeDao.getAllEntities();
    }

    public List<Station> getAllStations() {
        return stationDao.getAllEntities();
    }

}
