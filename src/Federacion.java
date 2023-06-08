import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class Federacion <T>
{
    private String nombre;
    private String fecha;
    private int cantMundiales;
    private boolean hayEntrenador = false;
    private int cantJugadores = 0;

    private ArrayList<T> integrantes;

    public Federacion (String nombre, String fecha, int cantMundiales)
    {
        this.nombre = nombre;
        this.fecha = fecha;
        this.cantMundiales = cantMundiales;
        this.integrantes = new ArrayList<T>();
    }
    public Federacion ()
    {

    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public int getCantMundiales() {
        return cantMundiales;
    }

    public void setCantMundiales(int cantMundiales) {
        this.cantMundiales = cantMundiales;
    }

    public ArrayList<T> getIntegrantes() {
        return integrantes;
    }

    public void setIntegrantes(ArrayList<T> integrantes) {
        this.integrantes = integrantes;
    }

    @Override
    public String toString() {
        return "Federacion{" +
                "nombre='" + nombre + '\'' +
                ", fecha='" + fecha + '\'' +
                ", cantMundiales=" + cantMundiales +
                ", integrantes=" + integrantes +
                '}';
    }
    public void agregar (T miembro) throws MasDe23JugadoresException,YaHayEntrenadorException
    {
        if(miembro instanceof Futbolista || miembro instanceof Entrenador)
        {
            if(miembro instanceof Futbolista && this.cantJugadores == 23)
            {
                throw new MasDe23JugadoresException();
            }
            else if (miembro instanceof Futbolista && this.cantJugadores < 23)
            {
                this.integrantes.add(miembro);
                this.cantJugadores++;
            }
            if(miembro instanceof Entrenador && this.hayEntrenador == true)
            {
                throw new YaHayEntrenadorException();
            }
            else if(miembro instanceof Entrenador && this.hayEntrenador == false)
            {
                this.integrantes.add(miembro);
                this.hayEntrenador = true;
            }
        }
        else if (miembro instanceof Masajista || miembro instanceof AyudanteDeCampo)
        {
            this.integrantes.add(miembro);
        }
    }
    public boolean quitar (T miembro)
    {
        if(this.integrantes.contains(miembro))
        {
            return this.integrantes.remove(miembro);
        }
        else
        {
            System.out.println("NO EXISTE EL MIEMBRO.");
            return false;
        }
    }
    public void mostrarListaIntegrantes ()
    {
        for(T elemento: this.integrantes)
        {
            System.out.println(elemento.toString());
        }
    }
    public void exportarAJson (String name, Federacion fed) throws IOException
    {
        File file = new File(name);

        ObjectMapper objectMapper = new ObjectMapper();

        if(!file.exists()) throw new IOException();

        try
        {
            objectMapper.writeValue(file,fed);
        }
        catch (IOException e)
        {
            System.out.println(e.getMessage());
        }
    }
    public void mostrarEnJson (String name) throws IOException
    {
        File file = new File(name);

        ObjectMapper objectMapper = new ObjectMapper();

        if(!file.exists()) throw new IOException();

        try
        {
            Federacion fed = objectMapper.readValue(file,Federacion.class);
            System.out.println(fed);
        }
        catch (IOException e)
        {
            System.out.printf(e.getMessage());
        }
    }
}
