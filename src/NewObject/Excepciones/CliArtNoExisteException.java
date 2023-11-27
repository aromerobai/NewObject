package NewObject.Excepciones;

public class CliArtNoExisteException extends Exception{
    public CliArtNoExisteException() {
        super("Este Cliente o Articulo no existe en el sistema. \n======================================================================================================================\n");
    }
}
