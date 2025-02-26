package Reservas;

import java.lang.reflect.Array;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JOptionPane;

import java.time.LocalDate;
import java.text.SimpleDateFormat;
import Tours.Tour;
import Tours.Gestion_Tour;


public class ReservaTour {
    private boolean activado;
    private int numeroPersonas;
    private boolean seguroActivado;
    private String fechaCreacion;
    private String fechaConfirmacion;
    private ArrayList<Tour> toursAgregados;
    private Gestion_Tour gestionTour;

    private SimpleDateFormat format = new SimpleDateFormat("dd/M/yy");
    //TODO ELIMINAR LOS ID's cambiar por login
    private String usuarioID;
    private String reservaID;

    public ReservaTour(String usuarioID, String reservaID, Gestion_Tour gestionTour, String fechaCreacion, int numeroPersonas, boolean seguroActivado, ArrayList<Tour> toursAgregados) {
        this.usuarioID = usuarioID;
        this.reservaID = reservaID;
        this.toursAgregados = new ArrayList<Tour>();
        this.gestionTour = gestionTour;
        this.fechaCreacion = fechaCreacion;
        this.numeroPersonas = numeroPersonas;
        this.seguroActivado = seguroActivado;
        this.activado = true;
    }

    public String getUsuarioID() {
        return usuarioID;
    }

    public String getReservaID() {
        return reservaID;
    }

    public void setNumeroPersonas(int numeroPersonas) {
        this.numeroPersonas = numeroPersonas;
    }

    public void setActivado(boolean activado) { this.activado = activado; }

    public void setSeguroActivado(boolean seguroActivado) { this.seguroActivado = seguroActivado; }

    public void setFechaCreacion(String fechaCreacion) { this.fechaCreacion = fechaCreacion; }

    public void setFechaConfirmacion(String fechaConfirmacion) { this.fechaConfirmacion = fechaConfirmacion; }

    public void setToursAgregados(ArrayList<Tour> toursAgregados) { this.toursAgregados = toursAgregados; }

    public void setGestionTour(Gestion_Tour gestionTour) { this.gestionTour = gestionTour; }

    public int getNumeroPersonas() {
        return numeroPersonas;
    }

    public boolean isActivado() { return activado; }

    public boolean isSeguroActivado() { return seguroActivado; }

    public String getFechaCreacion() { return fechaCreacion; }

    public String getFechaConfirmacion() { return fechaConfirmacion; }

    public Gestion_Tour getGestionTour() { return gestionTour; }

    public void agregarTour(Tour tour){
        if (tour.getDisponibilidad() >= this.numeroPersonas) {
            this.toursAgregados.add(tour);
            JOptionPane.showMessageDialog(null,
                    "El tour se ha agregado correctamente.",
                    "Reserva Tour",
                    JOptionPane.WARNING_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null,
                    "El tour no se puede agregar porque se ha excedido el limite de usuarios.",
                    "Reserva Tour",
                    JOptionPane.WARNING_MESSAGE);
        }
    }

    public void eliminarTour(String nombreTour){
        this.toursAgregados.remove(this.buscarTour(nombreTour));
    }

    public Tour buscarTour(String nombreTour){
        return this.gestionTour.getTour(nombreTour);
    }

    public int tiempoSinConfirmar(){
        LocalDate fecha = LocalDate.now();
        Date fechaActual = null;
        try {
            fechaActual = format.parse(fecha.toString());
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        int milisecondsByDay = 86400000;
        int dias = 10;
        return dias;
    }

    public int tiempoTrasCancelar(){
        LocalDate fecha = LocalDate.now();
        Date fechaActual = null;
        try {
            fechaActual = format.parse(fecha.toString());
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        int milisecondsByDay = 86400000;
        int dias = 10;
        return dias;
    }

    public ArrayList<Tour> getToursAgregados() {
        return toursAgregados;
    }

    public String getPRE_InfoReserva(){
        String info = "";

        for (Tour x: toursAgregados ) {
            info += "\nTour: " + x.getNombre();
            info += "\nPrecio: " + x.getPrecio();
        }

        return info;
    }

    public String getInfoReserva(){
        String info = "";

        for (Tour x: toursAgregados ) {
            info += "\n" + x.toString();
        }

        return info;
    }


    //TODO: implementar su propios metodos de cancelar reserva Y modificación
    public void cancelarReserva() {
        if (this.activado = true){
            this.activado = false;
        }else {
            JOptionPane.showMessageDialog(null, 
                                            "La reserva ya ha sido cancelada", 
                                            "Reserva Tours.Tour",
                                            JOptionPane.WARNING_MESSAGE);
        }
    }


    public void modificarReserva() {
        
    }


    
}
