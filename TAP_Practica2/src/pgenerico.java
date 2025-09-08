public class pgenerico {
    public static <T> void m_imprimir(T elemento) {
        System.out.println("Elemento: " + elemento);
    }

    public static void main(String[] args) {
        Caja<Integer> cajaEntero = new Caja<>(123);
        Caja<String> cajaTexto = new Caja<>("Hola Genericos");

        System.out.println("Contenido de cajaEntero: " + cajaEntero.m_getObjeto());
        System.out.println("Contenido de cajaTexto: " + cajaTexto.m_getObjeto());

        m_imprimir(3.14);
        m_imprimir("Generico");
        m_imprimir(true);
    }
}

class Caja<T> {
    private T a_objeto;

    public Caja(T objeto) {
        this.a_objeto = objeto;
    }

    public T m_getObjeto() {
        return a_objeto;
    }

    public void m_setObjeto(T objeto) {
        this.a_objeto = objeto;
    }
}
