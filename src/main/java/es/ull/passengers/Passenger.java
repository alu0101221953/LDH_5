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
package es.ull.passengers;

import java.util.Arrays;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import es.ull.flights.Flight;

/**
 * Clase que representa un pasajero
 * 
 * @since 1.0.0
 * @version 1.0.0
 */
public class Passenger {

    // Comentarios tipo doxygen para generar la documentación

    /**
     * Identificador del pasajero
     */
    private String identifier;
    /**
     * Nombre del pasajero
     */
    private String name;
    /**
     * Código de país del pasajero
     */
    private String countryCode;
    /**
     * Vuelo del pasajero
     */
    private Flight flight;

    /**
     * Constructor
     * 
     * @param identifier Identificador del pasajero
     * @param name Nombre del pasajero
     * @param countryCode Código de país del pasajero
     */
    public Passenger(String identifier, String name, String countryCode) {
        if (!Arrays.asList(Locale.getISOCountries()).contains(countryCode)) {
            throw new RuntimeException("Invalid country code");
        }

        this.identifier = identifier;
        this.name = name;
        this.countryCode = countryCode;
    }

    /**
     * Getter del identificador
     * 
     * @return Identificador del pasajero
     */
    public String getIdentifier() {
        return identifier;
    }

    /**
     * Getter del nombre
     * 
     * @return Nombre del pasajero
     */
    public String getName() {
        return name;
    }

    /**
     * Getter del código de país
     * 
     * @return Código de país del pasajero
     */
    public String getCountryCode() {
        return countryCode;
    }

    /**
     * Getter del vuelo
     * 
     * @return Vuelo del pasajero
     */
    public Flight getFlight() {
        return flight;
    }

    /**
     * Función que une un pasajero a un vuelo
     * 
     * @param flight Vuelo al que unir el pasajero
     */
    public void joinFlight(Flight flight) {
        Flight previousFlight = this.flight;
        if (null != previousFlight) {
            if (!previousFlight.removePassenger(this)) {
                throw new RuntimeException("Cannot remove passenger");
            }
        }
        setFlight(flight);
        if (null != flight) {
            if (!flight.addPassenger(this)) {
                throw new RuntimeException("Cannot add passenger");
            }
        }
    }

    /**
     * Setter del vuelo
     * 
     * @param flight Vuelo del pasajero
     */
    public void setFlight(Flight flight) {
        this.flight = flight;
    }

    /**
     * Función que comprueba si dos pasajeros son iguales
     * 
     * @param obj Pasajero a comparar
     * @return true si son iguales
     */
    @Override
    public String toString() {
        return "Passenger " + getName() + " with identifier: " + getIdentifier() + " from " + getCountryCode();
    }
}
