package es.ull.flights;

import org.junit.jupiter.api.*;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

import es.ull.passengers.Passenger;

public class FlightTest {

    @Nested
    class FlightConstructorTest {

        private Flight flight;

        @BeforeEach
        public void setUp() {
            flight = new Flight("IB1234", 10);
        }

        @Test
        public void testFlightConstructor() {
            assertEquals("IB1234", flight.getFlightNumber());
            assertEquals(10, flight.getSeats());
        }

        @Test
        public void testFlightConstructorInvalidFlightNumber() {
            assertThrows(RuntimeException.class, () -> {
                new Flight("IB", 10);
            });
        }

        @Test
        public void testFlightConstructorInvalidSeats() {
            assertThrows(RuntimeException.class, () -> {
                new Flight("IB1234", -10);
            });
        }

        @Test
        public void testFlightAddPassenger() {
            Passenger passenger = new Passenger("12345678A", "John Doe", "ES");
            assertTrue(flight.addPassenger(passenger));
            assertEquals(1, flight.getNumberOfPassengers());
        }

        @Test
        public void testFlightAddPassengerNoSeats() {
            Flight flight = new Flight("IB1234", 0);
            Passenger passenger = new Passenger("12345678A", "John Doe", "ES");
            assertThrows(RuntimeException.class, () -> {
                flight.addPassenger(passenger);
            });
        }

        @Test
        public void testRemovePassenger() {
            Passenger passenger = new Passenger("12345678A", "John Doe", "ES");
            flight.addPassenger(passenger);
            assertTrue(flight.removePassenger(passenger));
            assertEquals(0, flight.getNumberOfPassengers());
        }
    }
}