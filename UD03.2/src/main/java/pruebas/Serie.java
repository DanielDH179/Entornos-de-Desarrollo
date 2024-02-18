package pruebas;

public class Serie implements Entregable {

    private final static int NUM_TEMPORADAS_DEF = 3;
    public final static int MAYOR = 1, IGUAL = 0, MENOR = -1;

    private String titulo, genero, creador;
    private int numeroTemporadas;
    private boolean entregado;

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getNumeroTemporadas() {
        return numeroTemporadas;
    }

    public void setNumeroTemporadas(int numeroTemporadas) {
        this.numeroTemporadas = numeroTemporadas;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getCreador() {
        return creador;
    }

    public void setCreador(String creador) {
        this.creador = creador;
    }

    public void entregar() {
        entregado = true;
    }

    public void devolver() {
        entregado = false;
    }

    public boolean isEntregado() {
        return entregado;
    }

    public int compareTo(Object a) {
        int estado = MENOR;
        Serie ref = (Serie) a;
        if (numeroTemporadas > ref.getNumeroTemporadas())
            estado = MAYOR;
        else if (numeroTemporadas == ref.getNumeroTemporadas())
            estado = IGUAL;
        return estado;
    }

    public String toString() {
        return "Informacion de la Serie: \n"
               + "\tTitulo: " + titulo + "\n"
               + "\tNumero de temporadas: " + numeroTemporadas + "\n"
               + "\tGenero: " + genero + "\n"
               + "\tCreador: " + creador;
    }

    public boolean equals(Serie a) {
        return titulo.equalsIgnoreCase(a.getTitulo()) && creador.equalsIgnoreCase(a.getCreador());
    }


    public Serie() {
        this("", NUM_TEMPORADAS_DEF, "", "");
    }

    public Serie(String titulo, String creador) {
        this(titulo, NUM_TEMPORADAS_DEF, "", creador);
    }

    public Serie(String titulo, int numeroTemporadas, String genero, String creador) {
        this.titulo = titulo;
        this.numeroTemporadas = numeroTemporadas;
        this.genero = genero;
        this.creador = creador;
        this.entregado = false;
    }
  
}