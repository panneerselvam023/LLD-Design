package ParkingLot.Controller;

import ParkingLot.Services.TicketService;
import ParkingLot.dto.IssueTicketRequest;
import ParkingLot.dto.IssueTicketResponse;
import ParkingLot.dto.ResponseStatus;
import ParkingLot.models.Ticket;

public class TicketController {

       private TicketService ticketService;

       public TicketController(TicketService ticketService){
           this.ticketService = ticketService;
       }
       public IssueTicketResponse issueTicket(IssueTicketRequest request){

           IssueTicketResponse response = new IssueTicketResponse();
           try{
               Ticket ticket = ticketService.issueTicket(request.getVehicleNumber(),
                       request.getVehicleOwner(),request.getVehicleType(),request.getGateId());
               response.setTicket(ticket);
               response.setResponseStatus(ResponseStatus.SUCCESS);
           } catch (Exception e) {
               response.setResponseStatus(ResponseStatus.FAILURE);
           }
           return response;
       }
}
