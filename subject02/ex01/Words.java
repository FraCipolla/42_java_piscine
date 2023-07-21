package ex01;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Vector;

public class Words {
    private String dic1 = new String();
    private String dic2 = new String();
    private DictionaryList _list = new DictionaryList();

    public Words(String arg1, String arg2) throws FileNotFoundException, IOException {
        try (FileInputStream fis1 = new FileInputStream(arg1); FileInputStream fis2 = new FileInputStream(arg2)) {
            int i = 0;
            while ((i = fis1.read()) != -1) {
                this.dic1 += (char) i;  
            }
            i = 0;
            while ((i = fis2.read()) != -1) {
                this.dic2 += (char) i;  
            }

            String[] split1 = this.dic1.split(" ");
            String[] split2 = this.dic2.split(" ");
            for (int j = 0; j < split1.length; j++) {
                this._list.insert(split1[j]);
            }
            for (int j = 0; j < split2.length; j++) {
                this._list.insert(split2[j]);
            }
        }
    }

    public void printSimilarity() {
        String[] split1 = this.dic1.split(" ");
        String[] split2 = this.dic2.split(" ");

        int[] vec1 = new int[this._list.getSize()];
        int[] vec2 = new int[this._list.getSize()];

        String[] comp = this._list.toArr();

        for (int j = 0; j < comp.length; j++) {
            int n = 0;
            for (int i = 0; i < split1.length; i++) {
                if (split1[i].equals(comp[j])) {
                    n++;
                }
            }
            vec1[j] = n;
        }
        for (int j = 0; j < comp.length; j++) {
            int n = 0;
            for (int i = 0; i < split2.length; i++) {
                if (split2[i].equals(comp[j])) {
                    n++;
                }
            }
            vec2[j] = n;
        }
        double nominator = 0;
        for (int i = 0; i < vec1.length; i++) {
            nominator += vec1[i] * vec2[i];
        }
        int n1 = 0, n2 = 0;
        for (int i = 0; i < vec1.length; i++) {
            n1 += vec1[i] * vec1[i];
            n2 += vec2[i] * vec2[i];
        }
        double denominator = Math.sqrt(n1) * Math.sqrt(n2);
        double similarity = nominator / denominator;
        System.out.println(similarity);
    }
}
