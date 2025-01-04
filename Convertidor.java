import java.util.Map;
import java.util.Scanner;

public class Convertidor {
    public static void convertir(ConsultaTasas consulta, String monedaOrigen, String monedaDestino, Scanner teclado) {
        try {
            TasasDeCambio tasas = consulta.obtenerTasas(monedaOrigen);

            Map<String, Double> conversionRates = tasas.conversion_rates;

            if (conversionRates.containsKey(monedaDestino)) {
                System.out.print("Ingrese el monto en " + monedaOrigen + ": ");
                double monto = teclado.nextDouble();

                double tasa = conversionRates.get(monedaDestino);
                double resultado = monto * tasa;

                System.out.printf("El monto equivalente en %s es: %.2f%n", monedaDestino, resultado);
            } else {
                System.out.println("No se encontró la tasa de cambio para la moneda seleccionada.");
            }
        } catch (Exception e) {
            throw new RuntimeException("Ocurrió un error durante la conversión.", e);
        }
    }
}