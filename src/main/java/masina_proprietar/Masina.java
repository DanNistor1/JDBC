package masina_proprietar;

public class Masina {

    int id;
    String culoare;
    String marca;
    int cnp_proprietar;

    public Masina(int id, String culoare, String marca, int cnp_proprietar) {
        this.id = id;
        this.culoare = culoare;
        this.marca = marca;
        this.cnp_proprietar = cnp_proprietar;
    }

    @Override
    public String toString() {
        return "Masina{" +
                "marca='" + marca + '\'' +
                '}';
    }
}
