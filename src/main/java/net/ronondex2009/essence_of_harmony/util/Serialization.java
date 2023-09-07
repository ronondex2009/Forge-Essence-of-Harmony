package net.ronondex2009.essence_of_harmony.util;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Serialization {
        public static byte[] convertObjectToBytes(Object obj) {
        ByteArrayOutputStream boas = new ByteArrayOutputStream();
        try (ObjectOutputStream ois = new ObjectOutputStream(boas)) {
            ois.writeObject(obj);
            return boas.toByteArray();
        } catch (IOException e) { return null; }
    }

    @SuppressWarnings("unchecked")
    public static <T extends Object> T convertBytesToObject(byte[] bytes) {
        InputStream is = new ByteArrayInputStream(bytes);
        try (ObjectInputStream ois = new ObjectInputStream(is)) {
            return (T) ois.readObject();
        } catch (IOException e) { return null; } catch (ClassNotFoundException e) { return null; }
    }
}
