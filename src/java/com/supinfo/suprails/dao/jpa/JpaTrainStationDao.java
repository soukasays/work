package com.supinfo.suprails.dao.jpa;

import com.supinfo.suprails.dao.TrainStationDao;
import com.supinfo.suprails.entity.TrainStation;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author bargenson
 */
@Stateless
public class JpaTrainStationDao implements TrainStationDao {

    @PersistenceContext(unitName = "SupRails-PU")
    private EntityManager em;
    
    
    @Override
    public TrainStation addTrainStation(TrainStation station) {
        em.persist(station);
        return station;
    }

    @Override
    public List<TrainStation> getAllTrainStations() {
        return em.createQuery("SELECT ts FROM TrainStation ts").getResultList();
        /*int id = 1;
        List<TrainStation> trains = new ArrayList<TrainStation>();
        trains.add(em.find(TrainStation.class, id));
        return trains;*/
        /*javax.persistence.criteria.CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
        cq.select(cq.from(TrainStation.class));
        return em.createQuery(cq).getResultList();*/
    }

    @Override
    public TrainStation findTrainStationById(Long departureId) {
        return em.find(TrainStation.class, departureId);
    }
    
}
