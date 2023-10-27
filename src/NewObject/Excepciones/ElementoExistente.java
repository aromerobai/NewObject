package NewObject.Excepciones;

public class ElementoExistente extends Exception {
    public ElementoExistente() {
        super("Este elemento ya existe en el sistema. \n======================================================================================================================\n");
    }
}


