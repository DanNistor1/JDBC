package masina_proprietar;

public class Proprietar {

    int cnp_proprietar;
    String nume;
    int count;

    public Proprietar(int cnp_proprietar, String nume, int count) {
        this.cnp_proprietar = cnp_proprietar;
        this.nume = nume;
        this.count = count;
    }

    public Proprietar(int cnp_proprietar, String nume) {
        this.cnp_proprietar = cnp_proprietar;
        this.nume = nume;
    }

    @Override
    public String toString() {
        return "Proprietar{" +
                "nume='" + nume + '\'' +
                '}';
    }
}
