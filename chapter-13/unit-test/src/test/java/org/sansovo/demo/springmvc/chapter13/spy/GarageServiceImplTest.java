package org.sansovo.demo.springmvc.chapter13.spy;

import org.junit.Test;
import org.sansovo.demo.springmvc.chapter13.MyUtility;
import org.sansovo.demo.springmvc.chapter13.dao.GarageDAO;
import org.sansovo.demo.springmvc.chapter13.service.GarageService;
import org.sansovo.demo.springmvc.chapter13.service.GarageServiceImpl;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

public class GarageServiceImplTest {

    @Test
    public void testRentCar() {
        GarageDAO garageDAO = new GarageDAOSpy();
        GarageService garageService = new GarageServiceImpl(garageDAO);
        MyUtility car1 = garageService.rent();
        MyUtility car2 = garageService.rent();
        MyUtility car3 = garageService.rent();
        MyUtility car4 = garageService.rent();
        
        assertNotNull(car1);
        assertNotNull(car2);
        assertNotNull(car3);
        assertNull(car4);
    }

}
