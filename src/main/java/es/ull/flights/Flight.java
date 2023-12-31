/*
 * ========================================================================
 *
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 * ========================================================================
 */
package es.ull.flights;

import java.util.HashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import es.ull.passengers.Passenger;

/**
 * Clase que representa un vuelo
 * 
 * @since 1.0.0
 * @version 1.0.0
 */

public class Flight {

    /**
     * Número de vuelo
     */
    private String flightNumber;
    /**
     * Número de asientos
     */
    private int seats;
    /**
     * Pasajeros
     */
    private Set<Passenger> passengers = new HashSet<>();


    private static String flightNumberRegex = "^[A-Z]{2}\\d{3,4}$";
    private static Pattern pattern = Pattern.compile(flightNumberRegex);

    /**
     * Constructor
     * 
     * @param flightNumber Número de vuelo
     * @param seat Número de asientos
     */
    public Flight(String flightNumber, int seat) {
        Matcher matcher = pattern.matcher(flightNumber);
        if (!matcher.matches()) {
            throw new IllegalArgumentException("Invalid flight number");
        }
        this.flightNumber = flightNumber;
        if (seat < 0) {
            throw new IllegalArgumentException("Invalid number of seats");
        }
        this.seats = seat;
    }

    /**
     * Getter del número de vuelo
     * 
     * @return Número de vuelo
     */
    public String getFlightNumber() {
        return flightNumber;
    }

    /**
     * Getter del número de asientos
     * 
     * @return Número de asientos
     */
    public int getSeats() {
        return seats;
    }

    /**
     * Getter de los pasajeros
     * 
     * @return Pasajeros
     */
    public int getNumberOfPassengers() {
        return passengers.size();
    }

    /**
     * Función que añade un pasajero
     * 
     * @param passenger Pasajero
     * @return true si se ha añadido correctamente
     */
    public boolean addPassenger(Passenger passenger) {
        if (getNumberOfPassengers() >= seats) {
            throw new RuntimeException("Not enough seats for flight " + getFlightNumber());
        }
        passenger.setFlight(this);
        return passengers.add(passenger);
    }

    /**
     * Función que elimina un pasajero
     * 
     * @param passenger Pasajero
     * @return true si se ha eliminado correctamente
     */
    public boolean removePassenger(Passenger passenger) {
        passenger.setFlight(null);
        return passengers.remove(passenger);
    }
}
