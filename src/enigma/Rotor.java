package enigma;

import java.util.HashMap;
import java.util.Map;

public class Rotor {

    public static final String ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final int SIZE = 26;

    private final HashMap<Integer, Integer> map = new HashMap<>();
    private int position;

    public Rotor(String wiring, int position) {
        this.position = position;
        for (int i = 0; i < SIZE; i++) {
            map.put(i, ALPHABET.indexOf(wiring.charAt(i)));
        }
    }

    public int encoding(int letterindex) {
        letterindex += this.position;
        if (letterindex > SIZE - 1) letterindex -= SIZE;

        letterindex = map.get(letterindex);

        letterindex -= this.position;
        if (letterindex < 0) letterindex += SIZE;

        return letterindex;
    }

    public int decoding(int letterindex) {
        letterindex += this.position;
        if (letterindex > SIZE - 1) letterindex -= SIZE;

        // шукаємо ключ, якому відповідає це значення
        for (Map.Entry<Integer, Integer> pair : map.entrySet()) {
            if (pair.getValue() == letterindex) {
                letterindex = pair.getKey();
                break;
            }
        }

        letterindex -= this.position;
        if (letterindex < 0) letterindex += SIZE;

        return letterindex;
    }

    public boolean step() {
        position++;
        if (position == SIZE) {
            position = 0;
            return true;
        }
        return false;
    }

    public int getPosition() {
        return position;
    }
}