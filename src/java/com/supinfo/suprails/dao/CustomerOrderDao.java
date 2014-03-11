/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.supinfo.suprails.dao;

import com.supinfo.suprails.entity.CustomerOrder;
import javax.ejb.Local;

/**
 *
 * @author acuvillier
 */
@Local
public interface CustomerOrderDao {
    public CustomerOrder addCustomerOrder(CustomerOrder customerOrder);
}
