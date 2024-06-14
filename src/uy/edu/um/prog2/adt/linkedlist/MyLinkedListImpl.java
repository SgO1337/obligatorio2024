package uy.edu.um.prog2.adt.linkedlist;

import uy.edu.um.prog2.adt.queue.*;
import uy.edu.um.prog2.adt.stack.*;
import uy.edu.um.prog2.adt.circularlinkedlist.*;
import uy.edu.um.prog2.adt.circularlinkedlist.MyCircularLinkedList;
import uy.edu.um.prog2.adt.queue.EmptyQueueException;
import uy.edu.um.prog2.adt.queue.MyQueue;
import uy.edu.um.prog2.adt.stack.EmptyStackException;
import uy.edu.um.prog2.adt.stack.MyStack;

public class MyLinkedListImpl<T> implements MyList<T>, MyQueue<T>, MyStack<T>, MyCircularLinkedList<T> {

    private Node<T> first;

    private Node<T> last;

    public MyLinkedListImpl() {
        this.first = null;
        this.last = null;
    }

    @Override
    public void add(T value) {
        addToTheEnd(value);
    }

    @Override
    public void addToBeginning(T value) {
        if (value != null) {

            Node<T> elementToAdd = new Node<>(value);

            if (this.first == null) { // si la lista es vacia

                this.first = elementToAdd;
                this.last = elementToAdd;

            } else { // en caso de no ser vacia se agrega al comienzo

                elementToAdd.setNext(this.first);
                this.first = elementToAdd;
            }

        } else {
            // si el elemento es vacio se ignora
        }
    }

    @Override
    public void addToTheEnd(T value) {
        if (value != null) {

            Node<T> elementToAdd = new Node<>(value);

            if (this.first == null) { // si la lista es vacia

                this.first = elementToAdd;
                this.last = elementToAdd;

            } else { // en caso de no ser vacia se agrega al final

                this.last.setNext(elementToAdd);
                this.last = elementToAdd;
            }

        } else {
            // si el elemento es vacio se ignora
        }
    }

    @Override
    public T get(int position) {
        T valueToReturn = null;
        int tempPosition = 0;
        Node<T> temp = this.first;

        // Se busca el nodo que corresponde con la posicion
        while (temp != null && tempPosition != position) {

            temp = temp.getNext();
            tempPosition++;

        }

        // si se encontro la posicion se retorna el valor
        // en caso que se haya llegado al final y no se llego a la posicion se retorna null
        if (tempPosition == position) {


            valueToReturn = temp.getValue();

        }

        return valueToReturn;
    }

    @Override
    public boolean contains(T value) {
        boolean contains = false;
        Node<T> temp = this.first;

        while (temp != null && !temp.getValue().equals(value)) {

            temp = temp.getNext();

        }

        if (temp != null) { // Si no se llego al final de la lista, se encontro el valor

            contains = true;

        }

        return contains;
    }

    @Override
    public void remove(T value) {
        Node<T> beforeSearchValue = null;
        Node<T> searchValue = this.first;

        // Busco el elemento a eliminar teniendo en cuenta mantener una referencia al elemento anterior
        while (searchValue != null && !searchValue.getValue().equals(value)) {

            beforeSearchValue = searchValue;
            searchValue = searchValue.getNext();

        }

        if (searchValue != null) { // si encontre el elemento a eliminar

            // Verifico si es el primer valor (caso borde) y no es el ultimo
            if (searchValue == this.first && searchValue != this.last) {

                Node<T> temp = this.first;
                this.first = this.first.getNext(); // salteo el primero

                temp.setNext(null); // quito referencia del elemento eliminado al siguiente.

                // Verifico si es el primer valor (caso borde) y no el primero
            } else if (searchValue == this.last && searchValue != this.first) {

                beforeSearchValue.setNext(null);
                this.last = beforeSearchValue;

                // Si es el primer valor y el ultimo (lista de un solo valor)
            } else if (searchValue == this.last && searchValue == this.first) {

                this.first = null;
                this.last = null;

            } else { // resto de los casos

                beforeSearchValue.setNext(searchValue.getNext());
                searchValue.setNext(null);

            }

        } else {

            // Si no es encuentra el valor a eliminar no se realiza nada

        }

    }

    @Override
    public T removeLast() { // esta operación remueve el último elemento y retorna el elemento eliminado
        T valueToRemove = null;

        if (this.last != null) {
            valueToRemove = this.last.getValue();

            remove(valueToRemove);
        }

        return valueToRemove;
    }

    @Override
    public int size() {
        int size = 0;

        Node<T> temp = this.first;

        while (temp != null) {

            temp = temp.getNext();
            size++;

        }

        return size;
    }

    @Override
    public Node<T> getFirst() {
        return this.first;
    }

    // Operaciones particulares a Queue

    public void enqueue(T value) {
        addToBeginning(value);
    }

    public T dequeue() throws EmptyQueueException {
        if (this.last == null) { // si la queue esta vacia

            throw new EmptyQueueException();
        }

        return removeLast();
    }

    // Operaciones particulares a Stack

    @Override
    public void push(T value) {
        addToTheEnd(value);
    }

    public T pop() throws EmptyStackException {
        if (this.last == null) { // si la pila esta vacia

            throw new EmptyStackException();
        }

        return removeLast();
    }

    public T peek() {
        T valueToReturn = null;

        if (this.last != null) {
            valueToReturn = this.last.getValue();
        }

        return valueToReturn;
    }

    public boolean isEmpty() {
        return (this.first == null && this.last==null);
    }

    // Operaciones particulares a CircularLinkedList
    @Override
    public T getCircularLogic(int position) {
        if (size() == 0) {
            return null;
        }
        return get(position % size());
    }

    //Override del metodo toString para imprimir el TAD
    @Override
    public String toString() {
        StringBuilder stringTemporal = new StringBuilder();
        Node<T> current = this.first;
        if(this.size() == 0 || current.getValue() == null) {
            return "[]";
        }
        stringTemporal.append("[");
        stringTemporal.append(current.getValue().toString());
        while(current.getNext() != null) {
            if(current.getNext() != null) {
                stringTemporal.append(", ");
                current = current.getNext();
            }
            stringTemporal.append(current.getValue().toString());
        }
        stringTemporal.append("]");
        return stringTemporal.toString();
    }

    public String[] toArray() {
        String[] array = new String[size()];
        Node<T> current = this.first;
        int index = 0;
        while (current != null) {
            array[index++] = (String) current.getValue();
            current = current.getNext();
        }
        return array;
    }

    public void setByIndex(int position, T value) {
        int tempPosition = 0;
        Node<T> temp = this.first;

        while (temp != null && tempPosition != position) {
            temp = temp.getNext();
            tempPosition++;
        }

        if (tempPosition == position) {
            temp.setValue(value);
        }
    }
}
