import java.io.IOException;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        ConsultaTasas consulta = new ConsultaTasas();
        int opcion = 0;
        String menu = """
                ******************************************
                
                Sea bienvenido al conversor de monedas
                1- Dólar >>>> Peso Mexicano
                2- Peso Mexicano >>>> Dólar
                3- Dólar >>>> Peso Argentino
                4- Peso Argentino >>>> Dólar
                5- Dólar >>>> Real Brasileño
                6- Real Brasileño >>>> Dólar
                7- Dólar >>>> Peso Colombiano
                8- Peso Colombiano >>>> Dólar
                9- Salir
                
                ******************************************
                """;
        Scanner teclado = new Scanner(System.in);
        while (opcion != 9){
            System.out.println(menu);
            opcion = teclado.nextInt();
            try {
                switch (opcion) {
                    case 1 -> Convertidor.convertir(consulta, "USD", "MXN", teclado);
                    case 2 -> Convertidor.convertir(consulta, "MXN", "USD", teclado);
                    case 3 -> Convertidor.convertir(consulta, "USD", "ARS", teclado);
                    case 4 -> Convertidor.convertir(consulta, "ARS", "USD", teclado);
                    case 5 -> Convertidor.convertir(consulta, "USD", "BRL", teclado);
                    case 6 -> Convertidor.convertir(consulta, "BRL", "USD", teclado);
                    case 7 -> Convertidor.convertir(consulta, "USD", "COP", teclado);
                    case 8 -> Convertidor.convertir(consulta, "COP", "USD", teclado);
                    case 9 -> System.out.println("¡Gracias por usar el conversor de monedas!");
                    default -> System.out.println("Opción inválida. Intente nuevamente.");
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
        teclado.close();
    }
}
