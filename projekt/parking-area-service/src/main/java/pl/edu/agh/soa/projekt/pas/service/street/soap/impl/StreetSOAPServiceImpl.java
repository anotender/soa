package pl.edu.agh.soa.projekt.pas.service.street.soap.impl;

import pl.edu.agh.soa.projekt.pas.model.dto.ParkingPlaceDTO;
import pl.edu.agh.soa.projekt.pas.model.dto.StreetDTO;
import pl.edu.agh.soa.projekt.pas.service.parkingplace.ParkingPlaceService;
import pl.edu.agh.soa.projekt.pas.service.street.StreetService;
import pl.edu.agh.soa.projekt.pas.service.street.soap.api.StreetSOAPService;

import javax.ejb.EJB;
import javax.jws.WebService;
import java.util.List;

@WebService(endpointInterface = "pl.edu.agh.soa.projekt.pas.service.street.soap.api.StreetSOAPService")
public class StreetSOAPServiceImpl implements StreetSOAPService {

    @EJB
    private StreetService streetService;

    @EJB
    private ParkingPlaceService parkingPlaceService;

    @Override
    public List<StreetDTO> getStreets() {
        return streetService.getStreetDTOs();
    }

    @Override
    public long countOccupiedPlacesOnStreet(long id) {
        return parkingPlaceService
                .getParkingPlaceDTOsForStreet(id)
                .stream()
                .filter(ParkingPlaceDTO::isOccupied)
                .count();
    }

    @Override
    public long countFreePlacesOnStreet(long id) {
        return parkingPlaceService
                .getParkingPlaceDTOsForStreet(id)
                .stream()
                .filter(p -> !p.isOccupied())
                .count();
    }
}
