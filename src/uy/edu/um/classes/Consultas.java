package uy.edu.um.classes;
import uy.edu.um.prog2.adt.closedhash.ClosedHashImpl;
import uy.edu.um.prog2.adt.closedhash.DuplicateKey;
import uy.edu.um.prog2.adt.heap.MyHeapImpl;
import uy.edu.um.prog2.adt.linkedlist.MyLinkedListImpl;
import uy.edu.um.entities.Cancion;
import uy.edu.um.exceptions.InformacionInvalida;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class Consultas {
    ClosedHashImpl<String, MyLinkedListImpl<Cancion>> cancionesPorFecha;
    MyLinkedListImpl<String> fechasUnicas;
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");//para la funcion del final
    public Consultas() {
        MyLinkedListImpl<Object> canciones = CSVImport.importData("universal_top_spotify_songs.csv", 748804);
        this.cancionesPorFecha = (ClosedHashImpl<String, MyLinkedListImpl<Cancion>>) canciones.get(0);
        this.fechasUnicas = (MyLinkedListImpl<String>) canciones.get(1);
        this.fechasUnicas.reverse(); //necesitamos las fechas de menor a mayor, pero en el archivo estan de mayor a menor
    }
    public void primeraConsulta(String pais, String fecha) { //faltan devolver algunas cosas
        int i = 0;
        int j = 1;
        MyLinkedListImpl<Cancion> listaCancionesEnFecha = cancionesPorFecha.getValue(fecha);
        Cancion cancionActual;
        do {
            cancionActual = listaCancionesEnFecha.get(i);
            if (cancionActual.getCountry().equals(pais) && cancionActual.getDaily_rank() < 11) {
                if(cancionActual.getArtists().size() > 1) {
                    System.out.print(Integer.toString(j) + ". " + cancionActual.getName() + ", por los artistas ");
                    for(int k = 0;k<cancionActual.getArtists().size();k++) {
                        if(k == cancionActual.getArtists().size()-1) {
                            System.out.print(cancionActual.getArtists().get(k));
                        } else {
                            System.out.print(cancionActual.getArtists().get(k)+", ");
                        }
                    }
                    System.out.println(" en el top "+cancionActual.getDaily_rank()+".");
                } else {
                    System.out.println(Integer.toString(j) + ". " + cancionActual.getName()+", por "+cancionActual.getArtists().get(0)+" en el top "+cancionActual.getDaily_rank()+".");
                }
                j++;
            }
            i++;
        } while (j < 11 && i < listaCancionesEnFecha.size());
    }

    public void segundaConsulta(String fecha) throws DuplicateKey {
        int i = 0;
        MyLinkedListImpl<Cancion> listaCancionesEnFecha = cancionesPorFecha.getValue(fecha);
        Cancion cancionActual;
        ClosedHashImpl<String, Integer> cancionesOcurrencias = new ClosedHashImpl<>(100);
        MyLinkedListImpl<String> nombresCanciones = new MyLinkedListImpl<>();
        MyHeapImpl<String, Integer> top5 = new MyHeapImpl<String, Integer>(false);
        ClosedHashImpl<String, String> idNombre = new ClosedHashImpl<>(100);
        do {
            cancionActual = listaCancionesEnFecha.get(i);
            if(cancionActual.getDaily_rank() < 51) {
                if (cancionesOcurrencias.getValue(cancionActual.getSpotify_id()) != null) {
                    if(!nombresCanciones.contains(cancionActual.getSpotify_id())) {
                        idNombre.insertar(cancionActual.getSpotify_id(),cancionActual.getName());
                        nombresCanciones.add(cancionActual.getSpotify_id());
                    }
                    cancionesOcurrencias.changeValue(cancionActual.getSpotify_id(), cancionesOcurrencias.getValue(cancionActual.getSpotify_id()) + 1);
                } else {
                    if(!nombresCanciones.contains(cancionActual.getSpotify_id())) {
                        idNombre.insertar(cancionActual.getSpotify_id(),cancionActual.getName());
                        nombresCanciones.add(cancionActual.getSpotify_id());
                    }
                    cancionesOcurrencias.insertar(cancionActual.getSpotify_id(), 1);
                }
            }
            i++;
        } while (i < listaCancionesEnFecha.size());
        for(int j = 0;j<nombresCanciones.size();j++) {
            top5.insert(nombresCanciones.get(j),cancionesOcurrencias.getValue(nombresCanciones.get(j)));
        }
        System.out.println("TOP 5: ");
        for(int j = 0;j<5;j++) {
            System.out.println((j+1)+". "+idNombre.getValue(top5.get().getKey())+" con "+top5.get().getValue()+" ocurrencias.");
            top5.delete();
        }
    }

    public void terceraConsulta(String fechaInicial, String fechaFinal) throws DuplicateKey, InformacionInvalida {
        if(cancionesPorFecha.getValue(fechaInicial) == null || cancionesPorFecha.getValue(fechaFinal) == null) {
            throw new InformacionInvalida();
        }
        MyLinkedListImpl<String> fechas = fechasEntreDosFechas(fechaInicial, fechaFinal);
        if(fechas == null) {
            throw new InformacionInvalida();
        }
        int i = 0;
        MyLinkedListImpl<Cancion> listaCancionesEnFecha = cancionesPorFecha.getValue(fechaInicial);
        Cancion cancionActual;
        ClosedHashImpl<String, Integer> artistasOcurrencias = new ClosedHashImpl<>(10);
        MyLinkedListImpl<String> artistasSingulares = new MyLinkedListImpl<String>();
        MyHeapImpl<String, Integer> top7 = new MyHeapImpl<String, Integer>(false);
        for(int k = 0;k<fechas.size();k++) {
            i = 0;
            listaCancionesEnFecha = cancionesPorFecha.getValue(fechas.get(k));
            do {
                cancionActual = listaCancionesEnFecha.get(i);
                for (int j = 0; j < cancionActual.getArtists().size(); j++) {
                    if (!artistasSingulares.contains(cancionActual.getArtists().get(j))) {
                        artistasSingulares.add(cancionActual.getArtists().get(j));
                    }
                    if (artistasOcurrencias.getValue(cancionActual.getArtists().get(j)) != null) {
                        artistasOcurrencias.changeValue(cancionActual.getArtists().get(j), artistasOcurrencias.getValue(cancionActual.getArtists().get(j)) + 1);
                    } else {
                        artistasOcurrencias.insertar(cancionActual.getArtists().get(j), 1);
                    }
                }
                i++;
            } while (i < listaCancionesEnFecha.size());
        }
        for(int j = 0;j<artistasSingulares.size();j++) {
            top7.insert(artistasSingulares.get(j),artistasOcurrencias.getValue(artistasSingulares.get(j)));
        }
        System.out.println("TOP 7: ");
        for(int j = 0;j<7;j++) {
            System.out.println((j+1)+". "+top7.get().getKey()+" con "+top7.get().getValue()+" ocurrencias.");
            top7.delete();
        }
    }

    public void cuartaConsulta(String nombreArtista, String fecha) {
        int cantidadOcurrencias = 0;
        int i = 0;
        MyLinkedListImpl<Cancion> listaCancionesEnFecha = cancionesPorFecha.getValue(fecha);
        boolean encontro = false;
        Cancion cancionActual;
        do {
            cancionActual = listaCancionesEnFecha.get(i);
                if (cancionActual.getDaily_rank() < 51 && cancionActual.getArtists().contains(nombreArtista)) {
                    cantidadOcurrencias++;
                }
            i++;
        } while (i < listaCancionesEnFecha.size());
        System.out.println("Ese/a artista aparece "+cantidadOcurrencias+" veces en el top 50 en la fecha ingresada.");
    }

    public void quintaConsulta(double tempo1, double tempo2, String fechaInicial, String fechaFinal) {
        int cantidadCanciones = 0;
        MyLinkedListImpl<String> cancionesUnicas = new MyLinkedListImpl<>();
        MyLinkedListImpl<String> fechas = fechasEntreDosFechas(fechaInicial, fechaFinal);
        Cancion cancionActual;
        MyLinkedListImpl<Cancion> listaCancionesEnFecha;
        int i = 0;
        for(int k = 0;k<fechas.size();k++) {
            i = 0;
            listaCancionesEnFecha = cancionesPorFecha.getValue(fechas.get(k));
            do {
                cancionActual = listaCancionesEnFecha.get(i);
                if (!cancionesUnicas.contains(cancionActual.getSpotify_id()) && cancionActual.getTempo() >= tempo1 && cancionActual.getTempo() <= tempo2) {
                    cancionesUnicas.add(cancionActual.getSpotify_id());
                    cantidadCanciones++;
                }
                i++;
            } while (i < listaCancionesEnFecha.size());
        }
        System.out.println("Hay "+cantidadCanciones+" canciones entre "+fechaInicial+" y "+fechaFinal+" en ese rango de tempo.");
    }

    public MyLinkedListImpl<String> fechasEntreDosFechas(String fechaInicial, String fechaFinal) {
        LocalDate fechaInicio = LocalDate.parse(fechaInicial, formatter);
        LocalDate fechaFin = LocalDate.parse(fechaFinal, formatter);
        if(ChronoUnit.DAYS.between(fechaInicio, fechaFin) > 0) {
            MyLinkedListImpl<String> fechas = new MyLinkedListImpl<>();
            boolean encontro = false;
            for(int i = 0;i<fechasUnicas.size();i++) {
                if(encontro) {
                    if(fechasUnicas.get(i).equals(fechaFinal)) {
                        fechas.add(fechasUnicas.get(i));
                        break;
                    }
                    fechas.add(fechasUnicas.get(i));
                }
                if(fechasUnicas.get(i).equals(fechaInicial)) {
                    encontro = true;
                    fechas.add(fechasUnicas.get(i));
                }
            }
            return fechas;
        }
        return null;
    }
}