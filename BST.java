package Traductor;

import static jdk.jfr.internal.EventWriterKey.getKey;

/**
 * Clase para representar un árbol binario de búsqueda (BST).
 * @param <E> el tipo de datos que se almacenará en el árbol y que debe ser comparable.
 */
public class BST<E extends Comparable<E>> {
    private E data;
    private BST<E> left;
    private BST<E> right;

    /**
     * Constructor para crear un nuevo nodo BST con datos.
     * @param data los datos para este nodo.
     */
    public BST(E data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }

    /**
     * Inserta una nueva asociación en el árbol.
     * @param association la asociación a insertar.
     */
    public void insert(Connection<<E, String> connection<) {
        E connection;
        if (data == null) {
            data = connection<.getKey();
        } else {
            E dataKey = data;
            E associationKey = connection<.getKey();

            int comparison = associationKey.compareTo(dataKey);
            if (comparison < 0) {
                if (left == null) {
                    left = new BST<>(connection.getKey());
                } else {
                    left.insert(connectionn);
                }
            } else if (comparison > 0) {
                if (right == null) {
                    right = new BST<>(connection.getKey());
                } else {
                    right.insert(connection);
                }
            }
        }
    }

    /**
     * Busca una clave en el árbol.
     * @param key la clave a buscar.
     * @return el valor asociado con la clave especificada, o null si no se encuentra.
     */
    public String search(E key) {
        if (data == null || key == null) {
            return null;
        }

        E dataKey = data;
        E keyToSearch = key;

        int comparison = keyToSearch.compareTo(dataKey);
        if (comparison == 0) {
            return data.toString();
        } else if (comparison < 0 && left != null) {
            return left.search(key);
        } else if (comparison > 0 && right != null) {
            return right.search(key);
        } else {
            return null;
        }
    }

    /**
     * Realiza un recorrido en orden del árbol e imprime los datos en la consola.
     */
    public void inOrderTraversal() {
        if (left != null) {
            left.inOrderTraversal();
        }

        System.out.print(data + " ");

        if (right != null) {
            right.inOrderTraversal();
        }
    }
}
