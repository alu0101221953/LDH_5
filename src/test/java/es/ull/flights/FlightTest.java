package es.ull.flights;

import org.junit.jupiter.api.*;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

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
    }
}