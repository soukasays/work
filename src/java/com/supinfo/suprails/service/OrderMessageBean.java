/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.supinfo.suprails.service;

import com.supinfo.suprails.entity.CustomerOrder;
import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.JMSDestinationDefinition;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;

/**
 *
 * @author acuvillier
 */
@JMSDestinationDefinition(name = "jms/SupTrailsMessage", interfaceName = "javax.jms.Queue", resourceAdapter = "jmsra", destinationName = "SupTrailsMessage")
@MessageDriven(activationConfig = {
    @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue"),
    @ActivationConfigProperty(propertyName = "destinationLookup", propertyValue = "jms/SupTrailsMessage")
})
public class OrderMessageBean implements MessageListener {
    
    public OrderMessageBean() {
    }
    
    @Override
    public void onMessage(Message message) {
        ObjectMessage msg = (ObjectMessage)message;
        try {
            CustomerOrder customerOrder = (CustomerOrder)msg.getObject();
            System.out.println(customerOrder.getOrderCustomer().getFirstName() + " " + customerOrder.getOrderCustomer().getLastName() + " has bought a ticket " + customerOrder.getOrderTrip().getPrice().toString() + "€ for the trip : " + customerOrder.getOrderTrip().getDepartureStation().getName() + " -> " + customerOrder.getOrderTrip().getArrivalStation().getName());
        } catch (Exception ex) {
            
        }
    }
    
}
