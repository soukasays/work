/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.supinfo.suprails.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
/**
 *
 * @author acuvillier
 */
@Entity
public class PassengerTrain extends Train implements Serializable {
    

    public Integer getSeatQuantity() {
        return seatQuantity;
    }

    public void setSeatQuantity(Integer seatQuantity) {
        this.seatQuantity = seatQuantity;
    }
    
    @Column(name="seatquantity")
    private Integer seatQuantity;

    @Override
    public String toString() {
        return "com.supinfo.suprails.entity.PassengerTrain[ id=" + super.getId() + " ]";
    }
    
}
