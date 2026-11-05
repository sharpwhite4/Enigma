package enigma;

public class RotorTables {
    // п'ять таблиць роторів: по 33 літери, кожна літера рівно один раз
    public static final String I   = "вєїнтчяґзкпфщбеімсцюгжйоушадилрхь";
    public static final String II  = "іохяейрчбжлтщгинфюдїпцаєксшвзмуьґ";
    public static final String III = "жсбкчєрайцепяїхдоюіфґньиугмщзтвлш";
    public static final String IV  = "лзербптущоасигмьвхєшіфцчйґжнїкядю";
    public static final String V   = "шґюдвізьйфлаеиєгцощїнхкбусяпмчтжр";

    // повертає таблицю за номером ротора (1-5)
    public static String get(int number) {
        switch (number) {
            case 1: return I;
            case 2: return II;
            case 3: return III;
            case 4: return IV;
            case 5: return V;
            default: throw new IllegalArgumentException("Номер ротора має бути від 1 до 5");
        }
    }
}
