/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.supinfo.suprails.service;

import com.supinfo.suprails.dao.CustomerOrderDao;
import com.supinfo.suprails.entity.CustomerOrder;
import javax.ejb.Asynchronous;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author acuvillier
 */
@Stateless
public class CustomerOrderService {
    
    @EJB
    private CustomerOrderDao jpaCustomerOrderDao;

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    public CustomerOrder processCustomerOrder(CustomerOrder p) {
        System.out.println("EMAIL");
        return jpaCustomerOrderDao.addCustomerOrder(p);
    }
    
    
}
