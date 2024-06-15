package uy.edu.um.adt.heap;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import uy.edu.um.prog2.adt.heap.MyHeapImpl;

public class MyHeapImplTest {

    private MyHeapImpl<String, Integer> minHeap;
    private MyHeapImpl<String, Integer> maxHeap;

    @Before
    public void setUp() {
        minHeap = new MyHeapImpl<>(true);
        maxHeap = new MyHeapImpl<>(false);

        minHeap.insert("a", 5);
        minHeap.insert("b", 3);
        minHeap.insert("c", 8);
        minHeap.insert("d", 1);

        maxHeap.insert("a", 5);
        maxHeap.insert("b", 3);
        maxHeap.insert("c", 8);
        maxHeap.insert("d", 1);
    }

    @Test
    public void testInsertMinHeap() {
        minHeap.insert("e", 0);
        Assert.assertEquals(Integer.valueOf(0), minHeap.get().getValue());
    }

    @Test
    public void testInsertMaxHeap() {
        maxHeap.insert("e", 10);
        Assert.assertEquals(Integer.valueOf(10), maxHeap.get().getValue());
    }

    @Test
    public void testDeleteMinHeap() {
        Assert.assertEquals(Integer.valueOf(1), minHeap.delete());
        Assert.assertEquals(Integer.valueOf(3), minHeap.get().getValue());
    }

    @Test
    public void testDeleteMaxHeap() {
        Assert.assertEquals(Integer.valueOf(8), maxHeap.delete());
        Assert.assertEquals(Integer.valueOf(5), maxHeap.get().getValue());
    }

    @Test
    public void testGetMinHeap() {
        Assert.assertEquals(Integer.valueOf(1), minHeap.get().getValue());
    }

    @Test
    public void testGetMaxHeap() {
        Assert.assertEquals(Integer.valueOf(8), maxHeap.get().getValue());
    }

    @Test(expected = RuntimeException.class)
    public void testDeleteEmptyHeap() {
        MyHeapImpl<String, Integer> emptyHeap = new MyHeapImpl<>(true);
        emptyHeap.delete();
    }

    @Test(expected = RuntimeException.class)
    public void testGetEmptyHeap() {
        MyHeapImpl<String, Integer> emptyHeap = new MyHeapImpl<>(true);
        emptyHeap.get();
    }

    @Test
    public void testSize() {
        Assert.assertEquals(4, minHeap.size());
        minHeap.insert("e", 2);
        Assert.assertEquals(5, minHeap.size());
    }

    @Test
    public void testToString() {
        String expectedMinHeapStr = "1 3 8 5 ";
        Assert.assertEquals(expectedMinHeapStr, minHeap.toString());
    }

    @Test
    public void testBuildHeapFromArrayMinHeap() {
        Integer[] array = {4, 2, 7, 1, 9};
        MyHeapImpl<String, Integer> heapFromArray = new MyHeapImpl<>(array, true);
        Assert.assertEquals(Integer.valueOf(1), heapFromArray.get().getValue());
    }

    @Test
    public void testBuildHeapFromArrayMaxHeap() {
        Integer[] array = {4, 2, 7, 1, 9};
        MyHeapImpl<String, Integer> heapFromArray = new MyHeapImpl<>(array, false);
        Assert.assertEquals(Integer.valueOf(9), heapFromArray.get().getValue());
    }
}
