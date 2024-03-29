package com.supinfo.suprails.dao.jpa;

import com.supinfo.suprails.dao.TripDao;
import com.supinfo.suprails.entity.TrainStation_;
import com.supinfo.suprails.entity.Trip;
import com.supinfo.suprails.entity.Trip_;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

/**
 *
 * @author bargenson
 */
@Stateless
public class JpaTripDao implements TripDao {

    @PersistenceContext(unitName = "SupRails-PU")
    private EntityManager em;

    
    @Override
    public Trip addTrip(Trip trip) {
        em.persist(trip);
        return trip;
    }

    @Override
    public List<Trip> getAllTrips() {
        return em.createQuery("SELECT t FROM Trip t").getResultList();
    }

    @Override
    public List<Trip> getFilteredTrips(Long pDeparture, Long pArrival, BigDecimal pPrice) {
        
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Trip> query = cb.createQuery(Trip.class);
        Root<Trip> trip = query.from(Trip.class);
        
        List<Predicate> predicates = new ArrayList<Predicate>();
        if (pDeparture != null) {
            predicates.add(cb.equal(trip.get(Trip_.departureStation).get(TrainStation_.id), pDeparture));
        }
        if (pArrival != null) {
            predicates.add(cb.equal(trip.get(Trip_.arrivalStation).get(TrainStation_.id), pArrival));
        }
        if (pPrice != null) {
            predicates.add(cb.lt(trip.get(Trip_.price), pPrice));
        }
        
        query.where(predicates.toArray(new Predicate[predicates.size()]));

        return em.createQuery(query).getResultList();
    }

    @Override
    public Trip findTripById(Long tripId) {
        return em.find(Trip.class, tripId);
    }

    @Override
    public void removeTrip(Trip trip) {
        em.remove(trip);
    }
    
}
