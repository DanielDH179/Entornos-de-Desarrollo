package pruebas;

public class Videojuego implements Entregable {
 
    private final static int HORAS_ESTIMADAS_DEF = 100;
    public final static int MAYOR = 1, IGUAL = 0, MENOR = -1;
    
    private String titulo, genero, compania;
    private int horasEstimadas;
    private boolean entregado;

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getHorasEstimadas() {
        return horasEstimadas;
    }

    public void setHorasEstimadas(int horasEstimadas) {
        this.horasEstimadas = horasEstimadas;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getCompania() {
        return compania;
    }

    public void setCompania(String compania) {
        this.compania = compania;
    }

    @Override
    public void entregar() {
        entregado = true;
    }

    @Override
    public void devolver() {
        entregado = false;
    }

    @Override
    public boolean isEntregado() {
        return entregado;
    }

    @Override
    public int compareTo(Object a) {
        int estado = MENOR;
         Videojuego ref = (Videojuego) a;
        if (horasEstimadas > ref.getHorasEstimadas())
            estado = MAYOR;
        else if (horasEstimadas == ref.getHorasEstimadas())
            estado = IGUAL;
        return estado;
    }

    @Override
    public String toString() {
        return "Informacion del videojuego: \n"
               + "\tTitulo: " + titulo + "\n"
               + "\tHoras estimadas: " + horasEstimadas + "\n"
               + "\tGenero: " + genero + "\n"
               + "\tcompañia: " + compania;
    }

    public boolean equals(Videojuego a) {
        return titulo.equalsIgnoreCase(a.getTitulo()) && compania.equalsIgnoreCase(a.getCompania());
    }

    public Videojuego() {
        this("", HORAS_ESTIMADAS_DEF, "", "");
    }

    public Videojuego(String titulo, String compania) {
        this(titulo, HORAS_ESTIMADAS_DEF, "", compania);
    }

    public Videojuego(String titulo, int horasEstimadas, String genero, String compania) {
        this.titulo = titulo;
        this.horasEstimadas = horasEstimadas;
        this.genero = genero;
        this.compania = compania;
        this.entregado = false;
    }

}