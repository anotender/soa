package pl.edu.agh.soa.projekt.pas.service.parkingplace;

import pl.edu.agh.soa.projekt.pas.model.ParkingPlace;
import pl.edu.agh.soa.projekt.pas.model.User;
import pl.edu.agh.soa.projekt.pas.model.dto.ParkingPlaceDTO;
import pl.edu.agh.soa.projekt.pas.repository.ParkingPlaceRepository;
import pl.edu.agh.soa.projekt.pas.util.DTOMapper;
import pl.edu.agh.soa.projekt.pas.util.SecurityUtils;

import javax.ejb.EJB;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.transaction.Transactional;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Singleton
@Startup
@Transactional
public class ParkingPlaceService {

    @EJB
    private ParkingPlaceRepository parkingPlaceRepository;

    public ParkingPlace getParkingPlace(long id) {
        return parkingPlaceRepository
                .findOne(id)
                .orElseThrow(RuntimeException::new);
    }

    public ParkingPlaceDTO getParkingPlaceDTO(long id) {
        return parkingPlaceRepository
                .findOne(id)
                .map(DTOMapper::mapParkingPlaceToParkingPlaceDTO)
                .orElseThrow(RuntimeException::new);
    }

    public ParkingPlaceDTO getParkingPlaceDTOForTicket(Long id) {
        return parkingPlaceRepository
                .findOneByTicketId(id)
                .map(DTOMapper::mapParkingPlaceToParkingPlaceDTO)
                .orElseThrow(RuntimeException::new);
    }

    public List<ParkingPlaceDTO> getParkingPlaceDTOs() {
        return getParkingPlaces()
                .stream()
                .map(DTOMapper::mapParkingPlaceToParkingPlaceDTO)
                .collect(Collectors.toList());
    }

    public List<ParkingPlaceDTO> getParkingPlaceDTOsForStreet(long id) {
        return parkingPlaceRepository
                .findByStreetId(id)
                .stream()
                .map(DTOMapper::mapParkingPlaceToParkingPlaceDTO)
                .collect(Collectors.toList());
    }

    public List<ParkingPlaceDTO> getParkingPlaceDTOsForArea(Long id) {
        return parkingPlaceRepository
                .findByAreaId(id)
                .stream()
                .map(DTOMapper::mapParkingPlaceToParkingPlaceDTO)
                .collect(Collectors.toList());
    }

    public List<ParkingPlace> getParkingPlacesForLoggedUser() {
        Optional<User> userOptional = SecurityUtils.getLoggedUser();

        if (!userOptional.isPresent()) {
            return Collections.emptyList();
        }

        User user = userOptional.get();

        if (SecurityUtils.isAdmin(user)) {
            return getParkingPlaces();
        }

        return getParkingPlaces()
                .stream()
                .filter(p -> p.getStreet().getArea().equals(user.getArea()))
                .collect(Collectors.toList());
    }

    public void updateParkingPlace(ParkingPlace parkingPlace) {
        parkingPlaceRepository.update(parkingPlace);
    }

    private List<ParkingPlace> getParkingPlaces() {
        return parkingPlaceRepository.findAll();
    }
}
