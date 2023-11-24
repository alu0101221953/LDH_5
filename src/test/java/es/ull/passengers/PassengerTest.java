package es.ull.passengers;

import org.junit.jupiter.api.*;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class PassengerTest {

    @Nested
    class PassengerConstructorTest {

        private Passenger passenger;

        @BeforeEach
        public void setUp() {
            passenger = new Passenger("12345678A", "John Doe", "ES");
        }

        @Test
        public void testPassengerConstructor() {
            assertEquals("12345678A", passenger.getIdentifier());
            assertEquals("John Doe", passenger.getName());
            assertEquals("ES", passenger.getCountryCode());
        }

        @Test
        public void testPassengerConstructorInvalidCountryCode() {
            assertThrows(RuntimeException.class, () -> {
                new Passenger("12345678A", "John Doe", "XX");
            });
        }

        @Test
        public void testPassengerConstructorInvalidIdentifier() {
            assertThrows(RuntimeException.class, () -> {
                new Passenger("12345678", "John Doe", "ESPAÑA");
            });
        }
    }
    
}