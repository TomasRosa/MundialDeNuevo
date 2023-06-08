import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Federacion federacionArgentina = new Federacion<>("AFA","20/02/1983",5);

        Futbolista f1 = new Futbolista("Romario","Lopez",35,9);
        boolean flag = true;

        do {
            try
            {
                System.out.println("Ingresa el puesto para el f1. ARQUERO-DEFENSOR-MEDIOCAMPISTA-DELANTERO. ");
                String puesto = scan.nextLine();
                puesto = puesto.toUpperCase();
                Futbolista.Puesto puestoEnum = Futbolista.Puesto.valueOf(puesto);
                f1.setPuesto(puesto);
                flag = true;
            }
            catch(IllegalArgumentException e)
            {
                System.out.printf(e.getMessage());
                flag = false;
            }
        }while (flag == false);


        Futbolista f2 = new Futbolista("Romaria","Lopeza",36,7);
        f2.setPuesto("DEFENSOR");
        Entrenador e1 = new Entrenador("Guardiola","Guardiolita",53,433,"Ofensivo");
        Masajista m1 = new Masajista("Masajeador","DePierna",21,"Bobo",5);
        AyudanteDeCampo a1 = new AyudanteDeCampo("Ayudador","DeCamp",24,"Buena");

        ArrayList<Integrante> listaAdd = new ArrayList<>();

        listaAdd.add(f1);
        listaAdd.add(f2);
        listaAdd.add(e1);
        listaAdd.add(m1);
        listaAdd.add(a1);

        for(Integrante elemento: listaAdd)
        {
            try
            {
                federacionArgentina.agregar(elemento);
            }
            catch (MasDe23JugadoresException e)
            {
                System.out.println(e.getMessage());
            }
            catch (YaHayEntrenadorException e)
            {
                System.out.println(e.getMessage());
            }
        }
        System.out.println("Antes de borrar:");
        federacionArgentina.mostrarListaIntegrantes();
        System.out.println("Luego de borrar a Romario: ");
        federacionArgentina.quitar(f1);
        federacionArgentina.mostrarListaIntegrantes();

        System.out.println("Exportando json...");
        try
        {
            federacionArgentina.exportarAJson("mi_archivo.json",federacionArgentina);
        }
        catch (IOException e)
        {
            System.out.println(e.getMessage());
        }
        System.out.println("Mostrando federacion en archivo json...");

        try
        {
            federacionArgentina.mostrarEnJson("mi_archivo.json");
        }
        catch (IOException e)
        {
            System.out.println(e.getMessage());
        }

    }
}