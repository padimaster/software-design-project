package Hospedaje.Habitaciones;

import Hospedaje.Reservas.ReservaHospedaje;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class GestionHabitaciones {
    private List<Habitacion> habitaciones;

    public GestionHabitaciones() {
        this.habitaciones = leer();
    }

    public List<Habitacion> getHabitaciones() {
        return habitaciones;
    }

    public Habitacion getHabitacionById(int id){
        for (Habitacion habitacion : habitaciones) {
            if (habitacion.getHabitacionID() == id) {
                return habitacion;
            }
        }
        return null;
    }

    private void guardar() {
        String basePath = new File("").getAbsolutePath();
        String filePath = basePath.concat("/src/Hospedaje/data/habitaciones.txt");
        try {
            FileOutputStream fos = new FileOutputStream(filePath);
            ObjectOutputStream outputStream = new ObjectOutputStream(fos);
            outputStream.writeObject(this.habitaciones);
            outputStream.close();
            fos.close();
        } catch (IOException ex) {
            System.err.println(ex);
        }
    }

    private List<Habitacion> leer() {
        List<Habitacion> habitacionesGuardadas = null;
        String basePath = new File("").getAbsolutePath();
        String filePath = basePath.concat("/src/Hospedaje/data/habitaciones.txt");
        try {
            FileInputStream fis = new FileInputStream(filePath);
            ObjectInputStream inputStream = new ObjectInputStream(fis);
            habitacionesGuardadas = (List<Habitacion>) inputStream.readObject();
            inputStream.close();
            fis.close();
        } catch (IOException | ClassNotFoundException ex) {
            System.err.println(ex);
        }

        return habitacionesGuardadas;
    }

}
