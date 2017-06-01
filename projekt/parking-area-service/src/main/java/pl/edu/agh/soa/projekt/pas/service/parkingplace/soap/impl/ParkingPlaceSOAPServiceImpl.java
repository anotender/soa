package pl.edu.agh.soa.projekt.pas.service.parkingplace.soap.impl;

import pl.edu.agh.soa.projekt.pas.model.ParkingPlace;
import pl.edu.agh.soa.projekt.pas.repository.ParkingPlaceRepository;
import pl.edu.agh.soa.projekt.pas.service.parkingplace.ParkingPlaceService;
import pl.edu.agh.soa.projekt.pas.service.parkingplace.soap.api.ParkingPlaceSOAPService;

import javax.ejb.EJB;
import javax.jws.WebService;

@WebService(endpointInterface = "pl.edu.agh.soa.projekt.pas.service.parkingplace.soap.api.ParkingPlaceSOAPService")
public class ParkingPlaceSOAPServiceImpl implements ParkingPlaceSOAPService {

    @EJB
    private ParkingPlaceService parkingPlaceService;

    public void takePlace(long id) {
        setParkingPlaceOccupied(id, true);
    }

    public void leavePlace(long id) {
        setParkingPlaceOccupied(id, false);
    }

    private void setParkingPlaceOccupied(long id, boolean occupied) {
        ParkingPlace parkingPlace = parkingPlaceService.getParkingPlace(id);
        parkingPlace.setOccupied(occupied);
        parkingPlace.setTicket(null);
        parkingPlaceService.updateParkingPlace(parkingPlace);
    }
}
