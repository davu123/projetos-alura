import java.util.Scanner;

public class SenoTaylorIntermediario {

    private static final double PI = Math.PI;

    public static double grausParaRadianos(double graus) {
        return graus * PI / 180;
    }

    public static double fatorial(int n) {
        double resultado = 1;
        for (int i = 2; i <= n; i++) {
            resultado *= i;
        }
        return resultado;
    }
  
    public static double calcularSeno(double radianos) {
        double seno = radianos;
        seno -= Math.pow(radianos, 3) / fatorial(3);
        seno += Math.pow(radianos, 5) / fatorial(5);
        seno -= Math.pow(radianos, 7) / fatorial(7);
        return seno;
    }

    public static void exibirResultados(double[] angulos) {
        for (double angulo : angulos) {
            double radianos = grausParaRadianos(angulo);
            double seno = calcularSeno(radianos);
            System.out.printf("Seno de %.0f graus: %.6f%n", angulo, seno);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        double[] angulosPadrao = {0, 30, 45, 60, 90};

        System.out.println("Cálculo do seno usando a fórmula de Taylor:");
        exibirResultados(angulosPadrao);

        scanner.close();
    }
}
