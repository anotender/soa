package pl.edu.agh.soa.projekt.pas.service.soap.impl;

import pl.edu.agh.soa.projekt.pas.repository.ParkingPlaceRepository;
import pl.edu.agh.soa.projekt.pas.service.soap.api.ParkingPlaceService;

import javax.ejb.EJB;
import javax.jws.WebService;

@WebService(endpointInterface = "pl.edu.agh.soa.projekt.pas.service.soap.api.ParkingPlaceService")
public class ParkingPlaceServiceImpl implements ParkingPlaceService {

    @EJB
    private ParkingPlaceRepository parkingPlaceRepository;

    public void takePlace(long id) {
        setParkingPlaceOccupied(id, true);
    }

    public void leavePlace(long id) {
        setParkingPlaceOccupied(id, false);
    }

    private void setParkingPlaceOccupied(long id, boolean occupied) {
        parkingPlaceRepository
                .findOne(id)
                .map(p -> {
                    p.setOccupied(occupied);
                    return p;
                })
                .ifPresent(p -> parkingPlaceRepository.update(id, p));
    }
}
