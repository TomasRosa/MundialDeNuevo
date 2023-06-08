public class MasDe23JugadoresException extends RuntimeException
{
    public MasDe23JugadoresException()
    {
        super("No pueden agregarse mas de 23 jugadores. ");
    }
}
