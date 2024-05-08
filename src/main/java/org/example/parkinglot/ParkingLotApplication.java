package org.example.parkinglot;

import org.example.parkinglot.controllers.TicketController;
import org.example.parkinglot.dtos.IssueTicketRequestDto;
import org.example.parkinglot.dtos.IssueTicketResponseDto;
import org.example.parkinglot.factories.ParkingSpotAssignmentStrategyFactory;
import org.example.parkinglot.models.ParkingSpotStrategyType;
import org.example.parkinglot.models.Ticket;
import org.example.parkinglot.repositories.GateRepository;
import org.example.parkinglot.repositories.VehicleRepository;
import org.example.parkinglot.services.TicketService;
import org.example.parkinglot.strategies.ParkingSpotAssignmentStrategy;

public class ParkingLotApplication {
    public static void main(String[] args) {
        GateRepository gateRepository = new GateRepository();
        VehicleRepository vehicleRepository = new VehicleRepository();
        ParkingSpotAssignmentStrategy parkingSpotAssignmentStrategy =
                ParkingSpotAssignmentStrategyFactory.getParkingLotStrategy(ParkingSpotStrategyType.NEAREST);

        TicketService ticketService = new TicketService(gateRepository,
                                                        vehicleRepository,
                                                        parkingSpotAssignmentStrategy);

        TicketController ticketController = new TicketController(ticketService);

        IssueTicketRequestDto requestDto = new IssueTicketRequestDto();
        requestDto.setGateId(123L);
        requestDto.setOperatorId(345L);
        requestDto.setOwnerName("Shivam");
        requestDto.setVehicleNumber("KA01X1111");

        IssueTicketResponseDto responseDto = ticketController.issueTicket(requestDto);
        Ticket ticket = responseDto.getTicket();
    }
}
