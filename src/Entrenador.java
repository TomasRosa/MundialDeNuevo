public class Entrenador extends Integrante implements Jugar,PrepararEntrenamiento
{
    private int sistemaJuego;
    private String estilo;

    public Entrenador(String nombre, String apellido, int edad, int sistemaJuego, String estilo)
    {
        super(nombre, apellido, edad);
        this.sistemaJuego = sistemaJuego;
        this.estilo = estilo;
    }
    public Entrenador ()
    {

    }
    public int getSistemaJuego()
    {
        return sistemaJuego;
    }

    public void setSistemaJuego(int sistemaJuego)
    {
        this.sistemaJuego = sistemaJuego;
    }

    public String getEstilo()
    {
        return estilo;
    }

    public void setEstilo(String estilo)
    {
        this.estilo = estilo;
    }

    @Override
    public String toString()
    {
        return super.toString() + "Entrenador{" +
                "sistemaJuego=" + sistemaJuego +
                ", estilo='" + estilo + '\'' +
                '}';
    }

    @Override
    public void viajar()
    {
        System.out.println("Entrenador viajando...");
    }

    @Override
    public void concentrar()
    {
        System.out.println("Entrenador concentrando...");
    }

    @Override
    public void jugar()
    {
        System.out.println("Entrenador jugando...");
    }

    @Override
    public void prepararEntrenamiento()
    {
        System.out.println("Preparando entrenamiento entrenador...");
    }
}
