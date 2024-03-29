package com.supinfo.suprails.dao;

import com.supinfo.suprails.entity.Trip;
import java.math.BigDecimal;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author bargenson
 */
@Local
public interface TripDao {
    
    Trip addTrip(Trip trip);
    
    List<Trip> getAllTrips();
    
    List<Trip> getFilteredTrips(Long departure, Long arrival, BigDecimal price);

    public Trip findTripById(Long tripId);

    public void removeTrip(Trip findTripById);
    
}
