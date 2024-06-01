
package VaoRaFile;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Collections;
import test.Pair;

public class LietKeCapSo_1 {

    public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
        FileInputStream file = new FileInputStream("DATA.in");
        ObjectInputStream is = new ObjectInputStream(file);
        ArrayList<Pair> a = (ArrayList<Pair>) is.readObject();
        Collections.sort(a);
        for(Pair i : a)
            if(i.getFirst()<i.getSecond())
                System.out.println(i);
    }
    
}
