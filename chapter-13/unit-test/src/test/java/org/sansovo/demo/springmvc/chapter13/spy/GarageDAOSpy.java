package org.sansovo.demo.springmvc.chapter13.spy;

import org.sansovo.demo.springmvc.chapter13.MyUtility;
import org.sansovo.demo.springmvc.chapter13.dao.GarageDAO;

public class GarageDAOSpy implements GarageDAO {
    private int carCount = 3;
    
    @Override
    public MyUtility rent() {
        if (carCount == 0) {
            return null;
        } else {
            carCount--;
            return new MyUtility();
        }   
    }
}
