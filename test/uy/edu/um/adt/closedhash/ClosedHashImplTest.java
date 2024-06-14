package uy.edu.um.adt.closedhash;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import uy.edu.um.prog2.adt.closedhash.ClosedHashImpl;
import uy.edu.um.prog2.adt.closedhash.DuplicateKey;

public class ClosedHashImplTest {
    private ClosedHashImpl<Integer,String> testClosedHashInteger;
    private ClosedHashImpl<String,String> testClosedHashString;

    @Before
    public void setUp() throws Exception {
        testClosedHashInteger = new ClosedHashImpl<>(10);
        testClosedHashInteger.insertar(100,"Bob Esponja");
        testClosedHashInteger.insertar(123,"Patricio Estrella");
        testClosedHashInteger.insertar(321,"Calamardo");
        testClosedHashInteger.insertar(555,"Homero Simpson");
        testClosedHashInteger.insertar(777,"Agente P");

        testClosedHashString = new ClosedHashImpl<>(10);         //Codigo ASCII
        testClosedHashString.insertar("a","Bob Esponja");           //a = 97
        testClosedHashString.insertar("b","Patricio Estrella");     //b = 98
        testClosedHashString.insertar("c","Calamardo");             //c = 99
        testClosedHashString.insertar("k","Homero Simpson");        //k = 107
        testClosedHashString.insertar("m","Agente P");              //m = 109



    }

    //Estos tests son para keys Integer
    @Test
    public void testInsertarNoColision() throws DuplicateKey {
        testClosedHashInteger.insertar(124,"Samuel De Luque");
        Assert.assertEquals("Samuel De Luque", testClosedHashInteger.getValue(124));
    }

    @Test
    public void testInsertarColision() throws DuplicateKey {
        testClosedHashInteger.insertar(223,"Ruben Doblas");
        Assert.assertEquals("Ruben Doblas", testClosedHashInteger.getValue(223));
    }

    @Test
    public void testInsertarVacio() throws DuplicateKey {
        ClosedHashImpl<Integer, String> testClosedHashVacio = new ClosedHashImpl<>(10);
        testClosedHashVacio.insertar(100, "Guillermo Diaz");
        Assert.assertEquals("Guillermo Diaz", testClosedHashVacio.getValue(100));
    }

    @Test (expected = DuplicateKey.class)
    public void testInsertarKeyDuplicada() throws DuplicateKey {
        testClosedHashInteger.insertar(124,"Samuel De Luque");
        testClosedHashInteger.insertar(124,"El Santi");
    }

    @Test
    public void testGetValue() {
        Assert.assertEquals("Agente P", testClosedHashInteger.getValue(777));
    }

    @Test
    public void testGetValueNotFound() {
        Assert.assertNull(testClosedHashInteger.getValue(125));
    }

    @Test
    public void testGetValueVacio() {
        ClosedHashImpl<Integer, String> testClosedHashVacio = new ClosedHashImpl<>(10);
        Assert.assertNull(testClosedHashVacio.getValue(777));
    }

    @Test
    public void testDelete() {
        testClosedHashInteger.delete(777);
        Assert.assertNull(testClosedHashInteger.getValue(777));
    }

    @Test
    public void testDeleteNotFound() {
        testClosedHashInteger.delete(125);
        Assert.assertEquals(5,testClosedHashInteger.getSize()); //El tamanio original es 5
    }

    @Test
    public void testDeleteVacio() {
        ClosedHashImpl<Integer, String> testClosedHashVacio = new ClosedHashImpl<>(10);
        testClosedHashVacio.delete(777);
        Assert.assertEquals(0,testClosedHashVacio.getSize());
    }


    @Test
    public void testGetSize() {
        Assert.assertEquals(5,testClosedHashInteger.getSize());
    }

    @Test
    public void testGetSizeVacio() {
        ClosedHashImpl<Integer, String> testClosedHashVacio = new ClosedHashImpl<>(10);
        Assert.assertEquals(0,testClosedHashVacio.getSize());
    }

    //Estos tests son para keys String
    //Los comentarios al lado de algunas inserciones son para facilitar la lectura y pasaje a ASCII de las keys.
    @Test
    public void testStringInsertarNoColision() throws Exception {
        testClosedHashString.insertar("d","Samuel De Luque"); //d = 100
        Assert.assertEquals("Samuel De Luque", testClosedHashString.getValue("d"));
    }

    @Test
    public void testStringInsertarColision() throws Exception {
        testClosedHashString.insertar("u","Ruben Doblas"); //u = 117
        Assert.assertEquals("Ruben Doblas", testClosedHashString.getValue("u"));
    }

    @Test
    public void testStringInsertarVacio() throws DuplicateKey {
        ClosedHashImpl<String, String> testClosedHashVacio = new ClosedHashImpl<>(10);
        testClosedHashVacio.insertar("W", "Guillermo Diaz"); //W = 87
        Assert.assertEquals("Guillermo Diaz", testClosedHashVacio.getValue("W"));
    }

    @Test (expected = DuplicateKey.class)
    public void testStringInsertarKeyDuplicada() throws DuplicateKey {
        testClosedHashString.insertar("W","Samuel De Luque"); //W = 87
        testClosedHashString.insertar("W","El Santi");
    }

    @Test
    public void testStringGetValue() {
        Assert.assertEquals("Agente P", testClosedHashString.getValue("m")); //m = 109
    }

    @Test
    public void testStringGetValueNotFound() {
        Assert.assertNull(testClosedHashString.getValue("p")); //p = 112
    }

    @Test
    public void testStringGetValueVacio() {
        ClosedHashImpl<String, String> testClosedHashVacio = new ClosedHashImpl<>(10);
        Assert.assertNull(testClosedHashVacio.getValue("m")); //m = 109
    }

    @Test
    public void testStringDelete() {
        testClosedHashString.delete("m");
        Assert.assertNull(testClosedHashString.getValue("m")); //m = 109
    }

    @Test
    public void testStringDeleteNotFound() {
        testClosedHashString.delete("t"); //t = 116
        Assert.assertEquals(5,testClosedHashString.getSize()); //El tamanio original es 5
    }

    @Test
    public void testStringDeleteVacio() {
        ClosedHashImpl<String, String> testClosedHashVacio = new ClosedHashImpl<>(10);
        testClosedHashVacio.delete("m"); //m = 109
        Assert.assertEquals(0,testClosedHashVacio.getSize());
    }


    @Test
    public void testStringGetSize() {
        Assert.assertEquals(5,testClosedHashString.getSize());
    }

    @Test
    public void testStringGetSizeVacio() {
        ClosedHashImpl<String, String> testClosedHashVacio = new ClosedHashImpl<>(10);
        Assert.assertEquals(0,testClosedHashVacio.getSize());
    }
}