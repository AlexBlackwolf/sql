package test2;

public class Studente {
    private Integer ID;
    private String Nome;
    private String Cognome;
    private Integer Eta;

    public Studente(Integer ID, String nome, String cognome, Integer eta) {
        this.ID = ID;
        Nome = nome;
        Cognome = cognome;
        Eta = eta;
    }

    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String nome) {
        Nome = nome;
    }

    public String getCognome() {
        return Cognome;
    }

    public void setCognome(String cognome) {
        Cognome = cognome;
    }

    public Integer getEta() {
        return Eta;
    }

    public void setEta(Integer eta) {
        Eta = eta;
    }

    @Override
    public String toString() {
        return "Studente{" +
                "ID=" + ID +
                ", Nome='" + Nome + '\'' +
                ", Cognome='" + Cognome + '\'' +
                ", Eta='" + Eta + '\'' +
                '}';
    }
}
