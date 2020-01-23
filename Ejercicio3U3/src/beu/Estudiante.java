/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beu;

import Vargas.Persona;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author labctr
 */
public class Estudiante extends Persona {

    private String carrera;
    private List<String> clubes = new ArrayList<>();

    

    public String getCarrera() {
        return carrera;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }

    public List<String> getClubes() {
        return clubes;
    }

    public void addClub(String club) {
        if (!club.isEmpty()) {
            clubes.add(club);
        }

    }

}
