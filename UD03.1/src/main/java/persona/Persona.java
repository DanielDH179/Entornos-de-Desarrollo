package persona;
public class Persona {

    private final static char SEXO_DEF = 'H';
    public static final int INFRAPESO = -1, PESO_IDEAL = 0, SOBREPESO = 1;
    private double peso, altura;
    private String nombre, DNI;
    private char sexo;
    private int edad;

    public Persona() {
        this("", 0, SEXO_DEF, 0, 0);
    }

    public Persona(String nombre, int edad, char sexo) {
        this(nombre, edad, sexo, 0, 0);
    }

    public Persona(String nombre, int edad, char sexo, double peso, double altura) {
        this.nombre = nombre;
        this.edad = edad;
        this.peso = peso;
        this.altura = altura;
        generarDni();
        this.sexo = sexo;
        comprobarSexo();
    }

    private void comprobarSexo() {
        if (sexo != 'H' && sexo != 'M')
            this.sexo = SEXO_DEF;
    }
 
    private void generarDni() {
        final int divisor = 23;
        int numDNI = ((int) Math.floor(Math.random() * 90_000_000 + 10_000_000));
        int res = numDNI - (numDNI / divisor * divisor);
        char letraDNI = generaLetraDNI(res);
        DNI = Integer.toString(numDNI) + letraDNI;
    }
 
    private char generaLetraDNI(int res) {
        char letras[] = {
        	'T', 'R', 'W', 'A', 'G', 'M', 'Y', 'F',
        	'P', 'D', 'X', 'B', 'N', 'J', 'Z', 'S',
        	'Q', 'V', 'H', 'L', 'C', 'K', 'E'
        };
        return letras[res];
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setEdad(int edad) {
    	assert edad >= 0;
        this.edad = edad;
    }

    public void setSexo(char sexo) {
        this.sexo = sexo;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    public int calcularIMC() {
        double pesoActual = peso / (Math.pow(altura, 2));
        if (pesoActual >= 20 && pesoActual <= 25)
            return PESO_IDEAL;
        else if (pesoActual < 20)
            return INFRAPESO;
        else
            return SOBREPESO;
    }

    public boolean esMayorDeEdad() {
        boolean mayor = false;
        if (edad >= 18)
            mayor = true;
        return mayor;
    }

    @Override
    public String toString() {
        String sexo;
        if (this.sexo == 'H') {
            sexo = "hombre";
        } else {
            sexo = "mujer";
        }
        return "Informacion de la persona:\n"
               + "Nombre: " + nombre + "\n"
               + "Sexo: " + sexo + "\n"
               + "Edad: " + edad + " años\n"
               + "DNI: " + DNI + "\n"
               + "Peso: " + peso + " kg\n"
               + "Altura: " + altura + " metros\n";
    }

}