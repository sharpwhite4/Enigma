package enigma;

import java.util.HashMap;

import static enigma.Rotor.ALPHABET;

public class Reflector {

    private final HashMap<Integer, Integer> map = new HashMap<>();

    public Reflector(String wiring) {
        for (int i = 0; i < 26; i++) {
            map.put(i, ALPHABET.indexOf(wiring.charAt(i)));
        }
    }

    public int reflect(int letterindex) {
        return map.get(letterindex);
    }


}
