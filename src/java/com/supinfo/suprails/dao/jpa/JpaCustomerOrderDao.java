/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.supinfo.suprails.dao.jpa;

import com.supinfo.suprails.dao.CustomerOrderDao;
import com.supinfo.suprails.entity.CustomerOrder;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author acuvillier
 */
@Stateless
public class JpaCustomerOrderDao implements CustomerOrderDao{
    
    @PersistenceContext(unitName = "SupRails-PU")
    private EntityManager em;
    
    

    @Override
    public CustomerOrder addCustomerOrder(CustomerOrder customerOrder) {
        em.persist(customerOrder);
        return customerOrder;
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

    public void persist(Object object) {
        em.persist(object);
    }
}
