package ucf.assignments;

/*
 *  UCF COP3330 Summer 2021 Assignment 4 Solution
 *  Copyright 2021 Ursula Shaw
 */

import java.io.*;

public class ItemSerializer {
    private static final String DATA_PATH = "data.bin";

    public static void serialize(Object[] items) throws IOException {
        try(var serializer = new ObjectOutputStream((new FileOutputStream(DATA_PATH)))) {
            serializer.writeObject(items);
        }
    }

    public static Item[] deserialize() throws IOException, ClassNotFoundException {
        try(var deserializer = new ObjectInputStream(new FileInputStream(DATA_PATH))) {
            Object[] item = (Object[]) deserializer.readObject();
            Item[] arr = new Item[item.length];
            for(int i = 0; i < item.length; i++) {
                arr[i] = (Item) item[i];
            }

            return arr;
        }
    }

    private ItemSerializer() {

    }
}
