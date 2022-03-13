package data;

import java.io.*;

/**
 * Clasa generica pentru serializator
 * @param <T> tipul obiectului de serializat
 * @author Dragos-Bogdan Lazea, CTI-UTCN, 30223
 * @since May 2021
 */
public class Serializator<T> {

    /**
     * Serializare
     * @param filename numele fisierului in care se vor stoca informatiile
     * @param object obiectul de serializat
     * @throws IOException exceptie
     */
    public void serializeObject(String filename, T object) throws IOException {
        FileOutputStream outFile = new FileOutputStream(filename);
        ObjectOutputStream outObject = new ObjectOutputStream(outFile);
        outObject.writeObject(object);
        outFile.close();
        outObject.close();
    }

    /**
     * Deserializare
     * @param filename numele fisierului de unde se vor prelua informatiile
     * @return obiectul deserializat
     * @throws ClassNotFoundException exceptie
     * @throws IOException exceptie
     */
    public T deserializeObject(String filename) throws ClassNotFoundException, IOException {
        FileInputStream inFile = new FileInputStream(filename);
        ObjectInputStream inObject = new ObjectInputStream(inFile);
        T obj = (T) inObject.readObject();
        inFile.close();
        inObject.close();
        return obj;
    }



}
