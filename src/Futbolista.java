public class Futbolista extends Integrante implements Jugar
{
    private String puesto;
    private int nCamiseta;
    enum Puesto
    {
        ARQUERO,
        DEFENSOR,
        MEDIOCAMPISTA,
        DELANTERO
    }
    public Futbolista(String nombre, String apellido, int edad,int nCamiseta)
    {
        super(nombre, apellido, edad);
        this.nCamiseta = nCamiseta;
    }

    public Futbolista()
    {

    }

    public String getPuesto() {
        return puesto;
    }

    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }

    public int getnCamiseta() {
        return nCamiseta;
    }

    public void setnCamiseta(int nCamiseta) {
        this.nCamiseta = nCamiseta;
    }

    @Override
    public String toString() {
        return super.toString() +
                "puesto='" + puesto + '\'' +
                ", nCamiseta=" + nCamiseta +
                '}';
    }

    @Override
    public void viajar()
    {
        System.out.println("Futbolista viajando...");
    }

    @Override
    public void concentrar()
    {
        System.out.println("Futbolista concentrando...");
    }

    @Override
    public void jugar()
    {
        System.out.println("Futbolista jugando...");
    }
}
