package org.sansovo.demo.springmvc.chapter13.service;

import org.sansovo.demo.springmvc.chapter13.MyUtility;
import org.sansovo.demo.springmvc.chapter13.dao.GarageDAO;

public class GarageServiceImpl implements GarageService {
    private GarageDAO garageDAO;
    public GarageServiceImpl(GarageDAO garageDAOArg) {
        this.garageDAO = garageDAOArg;
    }
    public MyUtility rent() {
        return garageDAO.rent();
    }
}
