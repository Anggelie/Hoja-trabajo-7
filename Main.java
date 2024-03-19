package Traductor;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) {
        // Crear un árbol binario para almacenar el diccionario
        BST<String> dictionary = new BST<>(null);

        // Leer el archivo diccionario.txt y construir el árbol binario
        try (BufferedReader br = new BufferedReader(new FileReader("diccionario.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                // Dividir la línea en palabras inglesas y españolas
                StringTokenizer tokenizer = new StringTokenizer(line, ",()");
                String englishWord = tokenizer.nextToken().trim();
                String spanishWord = tokenizer.nextToken().trim();
                // Crear una conexion y agregarla al diccionario
                Connection<<String, String> connection = new Connection<<>(englishWord, spanishWord);
                dictionary.insert(connection);
            }
        } catch (IOException e) {
            // Manejar la excepción de manera adecuada, como registrarla o mostrar un mensaje al usuario
            System.err.println("Error al leer el archivo del diccionario: " + e.getMessage());
        }

        // Mostrar la colección de palabras ordenadas por inglés
        System.out.print("Palabras ordenadas por inglés: ");
        dictionary.inOrderTraversal();
        System.out.println(); // Agregar un salto de línea después de imprimir las palabras ordenadas

        // Leer el archivo texto.txt y traducir cada palabra al español
        try (BufferedReader br = new BufferedReader(new FileReader("texto.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                // Dividir la línea en palabras
                StringTokenizer tokenizer = new StringTokenizer(line);
                while (tokenizer.hasMoreTokens()) {
                    String word = tokenizer.nextToken().toLowerCase();
                    // Buscar la traducción en el diccionario
                    String translation = dictionary.search(word);
                    if (translation != null) {
                        System.out.print(translation + " ");
                    } else {
                        // Si no se encuentra la traducción, imprimir la palabra original
                        System.out.print("*" + word + "* ");
                    }
                }
            }
        } catch (IOException e) {
            // Manejar la excepción de manera adecuada, como registrarla o mostrar un mensaje al usuario
            System.err.println("Error al leer el archivo de texto: " + e.getMessage());
        }
    }
}
