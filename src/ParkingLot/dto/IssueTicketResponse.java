package ParkingLot.dto;

import ParkingLot.models.Ticket;

public class IssueTicketResponse {
      private Ticket ticket;
      private ResponseStatus responseStatus;

    public Ticket getTicket() {
        return ticket;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }

    public ResponseStatus getResponseStatus() {
        return responseStatus;
    }

    public void setResponseStatus(ResponseStatus responseStatus) {
        this.responseStatus = responseStatus;
    }
}
