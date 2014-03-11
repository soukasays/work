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
public class FreihtTrain extends Train implements Serializable {

    public Long getMaxWeight() {
        return maxWeight;
    }

    public void setMaxWeight(Long maxWeight) {
        this.maxWeight = maxWeight;
    }
    
    @Column(name="maxweight")
    private Long maxWeight;


    @Override
    public String toString() {
        return "com.supinfo.suprails.entity.FreihtTrain[ id=" + super.getId() + " ]";
    }
    
}
