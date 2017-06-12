package pl.edu.agh.soa.projekt.pas.model.dto;

import lombok.Data;

@Data
public class TicketDTO {
    private Long id;
    private Long expirationTime;
    private Integer duration;
    private Long parkingPlaceId;
    private Long parkingMeterId;
}
