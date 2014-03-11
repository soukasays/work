/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.supinfo.suprails.ws;

import com.supinfo.suprails.dao.CustomerOrderDao;
import com.supinfo.suprails.dao.TripDao;
import com.supinfo.suprails.entity.CustomerOrder;
import com.supinfo.suprails.entity.Trip;
import java.util.List;
import javax.ejb.EJB;
import javax.jws.WebMethod;
import javax.jws.WebService;

/**
 *
 * @author acuvillier
 */
@WebService(serviceName = "NewWebService")
public class NewWebService {
    @EJB
    private CustomerOrderDao jpaCustomerOrderDao;
    @EJB
    private TripDao ejbRef;// Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Web Service Operation")


    @WebMethod(operationName = "getAllTrips")
    public List<Trip> getAllTrips() {
        return ejbRef.getAllTrips();
    }
    

    @WebMethod(operationName = "addCustomerOrder")
    public CustomerOrder addCustomerOrder(CustomerOrder pParam) {
        return jpaCustomerOrderDao.addCustomerOrder(pParam);
    }
    
    
    
}
