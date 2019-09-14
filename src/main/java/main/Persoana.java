package main;

public class Persoana {

    public int id;
    public String name;

    public Persoana(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Persoana{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
