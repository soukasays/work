package com.supinfo.suprails.web.servlet;

import com.supinfo.suprails.entity.TrainStation;
import com.supinfo.suprails.entity.Trip;
import com.supinfo.suprails.service.TrainStationService;
import com.supinfo.suprails.service.TripService;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author bargenson
 */
@WebServlet(urlPatterns="/trips")
public class ListTripsServlet extends HttpServlet {
    @EJB
    private TrainStationService trainStationService;

    @EJB
    private TripService tripService;
    
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Trip> trips = tripService.getAllTrips();
        List<TrainStation> stations = trainStationService.getAllTrainStations();
        
        req.setAttribute("trips", trips);
        req.setAttribute("stations", stations);
        req.getRequestDispatcher("/jsp/listTrips.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        String departureParam = req.getParameter("filterdeparture");
        String arrivalParam = req.getParameter("filterarrival");
        String priceParam = req.getParameter("filterhighestprice");
        
        Long departureId = null;
        if(!departureParam.trim().equals("")) {
            departureId = Long.valueOf(departureParam);
        }
        
        Long arrivalId = null;
        if(!arrivalParam.trim().equals("")) {
            arrivalId = Long.valueOf(arrivalParam);
        }
        
        BigDecimal highestPrice = null;
        try {
            highestPrice = new BigDecimal(priceParam);
        } catch(Exception ex) {
            highestPrice = null;
        }
        
        
        
        List<Trip> trips = tripService.getFilteredTrips(departureId, arrivalId, highestPrice);
        List<TrainStation> stations = trainStationService.getAllTrainStations();
        
        req.setAttribute("filterdeparture", departureParam);
        req.setAttribute("filterarrival", arrivalParam);
        req.setAttribute("filterhighestprice", priceParam);
        
        req.setAttribute("trips", trips);
        req.setAttribute("stations", stations);
        req.getRequestDispatcher("/jsp/listTrips.jsp").forward(req, resp);
    }
    
    

}
