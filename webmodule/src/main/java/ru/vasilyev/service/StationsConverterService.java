package ru.vasilyev.service;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import ru.vasilyev.dao.StationDao;
import ru.vasilyev.model.Station;

import javax.ejb.Singleton;
import javax.inject.Inject;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

@Singleton
public class StationsConverterService {

    @Inject
    private StationDao stationDao;


    public void convertStationsToJson() {

        Gson gson = new GsonBuilder().create();

        List<Station> stations = stationDao.getAllEntities();

        try {

            FileWriter writer = new FileWriter("stations.json");

            gson.toJson(stations, writer);

            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
