package bada_bdbt_proj;

public class Klienci {
    private int id_klienta;
    private String imie;
    private String nazwisko;
    private String drugie_imie;
    private String pesel;
    private String numer_telefonu;
    private String email;
    private int id_salonu;
    private int numer_adresu;

    public Klienci() {

    }

    public int getId_klienta() {
        return id_klienta;
    }

    public void setId_klienta(int id_klienta) {
        this.id_klienta = id_klienta;
    }

    public String getImie() {
        return imie;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }

    public String getDrugie_imie() {
        return drugie_imie;
    }

    public void setDrugie_imie(String drugie_imie) {
        this.drugie_imie = drugie_imie;
    }

    public String getPesel() {
        return pesel;
    }

    public void setPesel(String pesel) {
        this.pesel = pesel;
    }

    public String getNumer_telefonu() {
        return numer_telefonu;
    }

    public void setNumer_telefonu(String numer_telefonu) {
        this.numer_telefonu = numer_telefonu;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getId_salonu() {
        return id_salonu;
    }

    public void setId_salonu(int id_salonu) {
        this.id_salonu = id_salonu;
    }

    public int getNumer_adresu() {
        return numer_adresu;
    }

    public void setNumer_adresu(int numer_adresu) {
        this.numer_adresu = numer_adresu;
    }

    @Override
    public String toString() {
        return "Klienci{" +
                "id_klienta=" + id_klienta +
                ", imie='" + imie + '\'' +
                ", nazwisko='" + nazwisko + '\'' +
                ", drugie_imie='" + drugie_imie + '\'' +
                ", pesel='" + pesel + '\'' +
                ", numer_telefonu='" + numer_telefonu + '\'' +
                ", email='" + email + '\'' +
                ", id_salonu=" + id_salonu +
                ", numer_adresu=" + numer_adresu +
                '}';
    }

    public Klienci(int id_klienta, String imie, String drugie_imie, String nazwisko, String pesel, String numer_telefonu, String email,int id_salonu,int numer_adresu)
    {
        super();
        this.id_klienta=id_klienta;
        this.imie=imie;
        this.drugie_imie=drugie_imie;
        this.nazwisko=nazwisko;
        this.pesel=pesel;
        this.numer_telefonu=numer_telefonu;
        this.email=email;
        this.id_salonu=id_salonu;
        this.numer_adresu=numer_adresu;
    }
}
