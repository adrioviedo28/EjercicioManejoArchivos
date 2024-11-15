import java.io.*;
import java.util.*;
import java.util.List;

public class ManejoArchivos {

    public static void main(String[] args) {
        String ruta = "C:\\Users\\aovied4\\Documents\\EjercicioManejoArchivos\\Data\\test.txt";

        // 1. se indentifica y Verificar si la ruta es correcta
        File file = new File(ruta);
        System.out.println(file.exists());

        // 2. Leer los números desde el archivo
        List<Integer> numeros = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                try {
                    numeros.add(Integer.parseInt(linea.trim()));  // Convertir cada línea a un número entero
                } catch (NumberFormatException e) {
                    System.out.println("No se puede convertir a número: " + linea);
                }
            }
        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
            return;
        }

        // 3. Calcular el promedio
        double promedio = calcularPromedio(numeros);
        System.out.println("Promedio: " + promedio);

        // 4. Encontrar el número mayor y menor del archivo
        int mayor = Collections.max(numeros);
        int menor = Collections.min(numeros);

        System.out.println("Número mayor: " + mayor);
        System.out.println("Número menor: " + menor);
    }

    // calcular el promedio
    public static double calcularPromedio(List<Integer> numeros) {
        int suma = 0;
        for (int num : numeros) {
            suma += num;
        }
        return (double) suma / numeros.size();
    }
}