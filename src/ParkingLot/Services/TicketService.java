package ParkingLot.Services;

import ParkingLot.Repositories.GateRepository;
import ParkingLot.models.Gate;
import ParkingLot.models.Ticket;
import ParkingLot.models.VehicleType;

import java.util.Date;

public class TicketService {
    private GateRepository gateRepository;
    public Ticket issueTicket(String VehicleNumber,
                              String VehicleOwner,
                              VehicleType VehicleType,
                              Long gateId){

        Ticket ticket = new Ticket();
        ticket.setEntryTime(new Date());

        Gate gate  = gateRepository.findGateById(gateId) ;
        return null;
    }
}
