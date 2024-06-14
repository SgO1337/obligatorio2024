package uy.edu.um.adt.linkedlist;

import uy.edu.um.prog2.adt.circularlinkedlist.MyCircularLinkedList;
import uy.edu.um.prog2.adt.linkedlist.MyLinkedListImpl;
import uy.edu.um.prog2.adt.linkedlist.MyList;
import uy.edu.um.prog2.adt.queue.EmptyQueueException;
import uy.edu.um.prog2.adt.queue.MyQueue;
import uy.edu.um.prog2.adt.stack.EmptyStackException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import uy.edu.um.prog2.adt.stack.MyStack;

public class MyLinkedListImplTest {
    private MyList<Integer> testList;
    private MyQueue<Integer> testQueue;
    private MyStack<Integer> testStack;
    private MyCircularLinkedList<Integer> testCircularLinkedList;

    //El metodo add es verificado como consecuencia de otros tests.

    //Test particulares de lista enlazada

    @Before
    public void setup() {
        testList = new MyLinkedListImpl<>();
        testQueue = new MyLinkedListImpl<>();
        testStack = new MyLinkedListImpl<>();
        testCircularLinkedList = new MyLinkedListImpl<>();
    }


    @Test
    public void getOneElement() {
       testList.add(7);
       testList.add(7);
       testList.add(8);
       testList.add(2);
       Assert.assertEquals(Integer.valueOf(7),testList.get(0));
    }

    @Test
    public void containsMyLinkedList() {
        testList.add(7);
        Assert.assertTrue(testList.contains(7));
    }

    @Test
    public void removeMyLinkedList() {
        testList.add(7);
        testList.remove(7);
        Assert.assertFalse(testList.contains(7));
    }

    @Test
    public void sizeMyLinkedList() {
        testList.add(7);
        Assert.assertEquals(1,testList.size());
    }

    @Test
    public void toArrayCasoVacioMyLinkedList() {
        Assert.assertEquals(0,testList.toArray().length);
    }

    @Test
    public void toArrayCasoNoVacioMyLinkedList() {
        MyList<String> testListString = new MyLinkedListImpl<String>();
        testListString.add("a");
        testListString.add("b");
        Assert.assertArrayEquals(new String[]{"a","b"},testListString.toArray());
    }

    @Test
    public void setByIndexCasoValorIncoherenteMyLinkedList() {
        testList.add(7);
        testList.setByIndex(-1,4);
    }

    @Test
    public void setByIndexCasoVacioMyLinkedList() {
        testList.setByIndex(1,4);
    }

    @Test
    public void setByIndexCasoNoVacioMyLinkedList() {
        testList.add(3);
        testList.add(4);
        testList.add(15);
        Assert.assertEquals(Integer.valueOf(4),testList.get(1));
        testList.setByIndex(1,10);
        Assert.assertEquals(Integer.valueOf(10),testList.get(1));
        Assert.assertEquals(Integer.valueOf(3),testList.get(0));
        Assert.assertEquals(Integer.valueOf(15),testList.get(2));
    }

    @Test
    public void reverseCasoVacioMyLinkedList() {
        testList.reverse();
    }

    @Test
    public void reverseCasoNoVacioMyLinkedList() {
        testList.add(4);
        testList.add(15);
        testList.add(6);
        testList.reverse();
        Assert.assertEquals(Integer.valueOf(6),testList.get(0));
        Assert.assertEquals(Integer.valueOf(15),testList.get(1));
        Assert.assertEquals(Integer.valueOf(4),testList.get(2));
    }

    //Test particulares de queue

    @Test
    public void enqueueCasoVacia() {
        testQueue.enqueue(3);
        Assert.assertTrue(testQueue.contains(3)); //Verifica que se haya agregado
        Assert.assertEquals(1,testQueue.size()); //Verifica que no se hayan agregado cosas de mas
    }

    @Test
    public void enqueueCasoNoVacia() {
        testQueue.enqueue(7);
        testQueue.enqueue(3);
        Assert.assertEquals(Integer.valueOf(3),testQueue.get(0)); //Verifica que se haya agregado al principio de la lista
        Assert.assertEquals(2,testQueue.size()); //Verifica que no se hayan agregado cosas de mas
    }

    @Test(expected = EmptyQueueException.class)
    public void dequeueCasoVacia() throws EmptyQueueException {
        testQueue.dequeue();
    }

    @Test
    public void dequeueCasoNoVacia() throws EmptyQueueException {
        testQueue.enqueue(7);
        Assert.assertEquals(Integer.valueOf(7),testQueue.dequeue());
    }


    //Test particular de MyStack

    @Test
    public void pushCasoVacia() {
        testStack.push(7);
        Assert.assertEquals(Integer.valueOf(7),testStack.peek()); //Verifica que se haya agregado
        Assert.assertEquals(1,testStack.size()); //Verifica que no se hayan agregado cosas de mas
    }

    @Test
    public void pushCasoNoVacia() {
        testStack.push(7);
        testStack.push(3);
        Assert.assertEquals(Integer.valueOf(3),testStack.peek());
    }

    @Test
    public void pushCasoValorVacio() {
        testStack.push(null);
        Assert.assertEquals(0,testStack.size());
    }

    @Test (expected = EmptyStackException.class)
    public void popCasoVacia() throws EmptyStackException {
        testStack.pop();
    }

    @Test
    public void popCasoNoVacia() throws EmptyStackException {
        testStack.push(3);
        testStack.push(7);
        Assert.assertEquals(Integer.valueOf(7),testStack.pop());
    }


    @Test
    public void peek() {
        testStack.push(7);
        testStack.push(3);
        Assert.assertEquals(Integer.valueOf(3),testStack.peek());
    }


    //Test particular de MyCircularLinkedList

    @Test
    public void getCircularLogic() {
        testCircularLinkedList.add(7);
        testCircularLinkedList.add(3);
        testCircularLinkedList.add(5);
        Assert.assertEquals(Integer.valueOf(3),testCircularLinkedList.getCircularLogic(1));
    }

    @Test
    public void getCircularLogicCasoPosicionMayorQueTamanio() {
        testCircularLinkedList.add(7);
        testCircularLinkedList.add(3);
        testCircularLinkedList.add(5);
        Assert.assertEquals(Integer.valueOf(5),testCircularLinkedList.getCircularLogic(5));
    }

    @Test
    public void containsMyCircularLinkedList() {
        testCircularLinkedList.add(7);
        Assert.assertTrue(testCircularLinkedList.contains(7));
    }

    @Test
    public void removeMyCircularLinkedList() {
        testCircularLinkedList.add(7);
        testCircularLinkedList.remove(7);
        Assert.assertFalse(testCircularLinkedList.contains(7));
    }

    @Test
    public void sizeMyCircularLinkedList() {
        testCircularLinkedList.add(7);
        Assert.assertEquals(1,testCircularLinkedList.size());
    }

    @Test
    public void CircularLinkedList() {

    }
}