package enigma;

public class EnigmaTables {

    // ротори I-V: по 26 літер, кожна літера рівно один раз
    public static final String I   = "EKMFLGDQVZNTOWYHXUSPAIBRCJ";
    public static final String II  = "AJDKSIRUXBLHWTMCQGZNPYFVOE";
    public static final String III = "BDFHJLCPRTXVZNYEIWGAKMUSQO";
    public static final String IV  = "ESOVPZJAYQUIRHXLNFTGKDCMWB";
    public static final String V   = "VZBRGITYUPSDNHLXAWMJQOFECK";

    // рефлектори B і C: по 13 пар
    public static final String REFLECTOR_B = "YRUHQSLDPXNGOKMIEBFZCWVJAT";
    public static final String REFLECTOR_C = "FVPJIAOYEDRZXWGCTKUQSBNMHL";

    // таблиця ротора за номером (1-5)
    public static String getRotor(int number) {
        switch (number) {
            case 1: return I;
            case 2: return II;
            case 3: return III;
            case 4: return IV;
            case 5: return V;
            default: throw new IllegalArgumentException("Номер ротора має бути від 1 до 5");
        }
    }

    // таблиця рефлектора за назвою ("B" або "C")
    public static String getReflector(String name) {
        switch (name) {
            case "B": return REFLECTOR_B;
            case "C": return REFLECTOR_C;
            default: throw new IllegalArgumentException("Рефлектор має бути B або C");
        }
    }
}