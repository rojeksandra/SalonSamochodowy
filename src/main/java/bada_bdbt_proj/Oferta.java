package bada_bdbt_proj;

public class Oferta {
    private int id_pojazdu;
    private String numer_vin;
    private String marka;
    private String model;
    private int rok_produkcji;
    private String numer_rejestracyjny;
    private int przebieg;
    private String rodzaj_paliwa;
    private String kolor;
    private int moc_silnika;
    private int pojemnosc_bagaznika;
    private int cena;
    private int id_salonu;

    public Oferta() {

    }

    public int getId_pojazdu() {
        return id_pojazdu;
    }

    public void setId_pojazdu(int id_pojazdu) {
        this.id_pojazdu = id_pojazdu;
    }

    public String getNumer_vin() {
        return numer_vin;
    }

    public void setNumer_vin(String numer_vin) {
        this.numer_vin = numer_vin;
    }

    public String getMarka() {
        return marka;
    }

    public void setMarka(String marka) {
        this.marka = marka;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getRok_produkcji() {
        return rok_produkcji;
    }

    public void setRok_produkcji(int rok_produkcji) {
        this.rok_produkcji = rok_produkcji;
    }

    public String getNumer_rejestracyjny() {
        return numer_rejestracyjny;
    }

    public void setNumer_rejestracyjny(String numer_rejestracyjny) {
        this.numer_rejestracyjny = numer_rejestracyjny;
    }

    public int getPrzebieg() {
        return przebieg;
    }

    public void setPrzebieg(int przebieg) {
        this.przebieg = przebieg;
    }

    public String getRodzaj_paliwa() {
        return rodzaj_paliwa;
    }

    public void setRodzaj_paliwa(String rodzaj_paliwa) {
        this.rodzaj_paliwa = rodzaj_paliwa;
    }

    public String getKolor() {
        return kolor;
    }

    public void setKolor(String kolor) {
        this.kolor = kolor;
    }

    public int getMoc_silnika() {
        return moc_silnika;
    }

    public void setMoc_silnika(int moc_silnika) {
        this.moc_silnika = moc_silnika;
    }

    public int getPojemnosc_bagaznika() {
        return pojemnosc_bagaznika;
    }

    public void setPojemnosc_bagaznika(int pojemnosc_bagaznika) {
        this.pojemnosc_bagaznika = pojemnosc_bagaznika;
    }

    public int getCena() {
        return cena;
    }

    public void setCena(int cena) {
        this.cena = cena;
    }

    public int getId_salonu() {
        return id_salonu;
    }

    public void setId_salonu(int id_salonu) {
        this.id_salonu = id_salonu;
    }

    @Override
    public String toString() {
        return "Oferta{" +
                "id_pojazdu=" + id_pojazdu +
                ", numer_vin='" + numer_vin + '\'' +
                ", marka='" + marka + '\'' +
                ", model='" + model + '\'' +
                ", rok_produkcji=" + rok_produkcji +
                ", numer_rejestracyjny='" + numer_rejestracyjny + '\'' +
                ", przebieg=" + przebieg +
                ", rodzaj_paliwa='" + rodzaj_paliwa + '\'' +
                ", kolor='" + kolor + '\'' +
                ", moc_silnika=" + moc_silnika +
                ", pojemnosc_bagaznika=" + pojemnosc_bagaznika +
                ", cena=" + cena +
                ", id_salonu=" + id_salonu +
                '}';
    }

    //public Oferta(){
//
    //}


    public Oferta(int id_pojazdu,String numer_vin,String marka,String model,int rok_produkcji,String numer_rejestracyjny,int przebieg,String rodzaj_paliwa,String kolor,int moc_silnika,int pojemnosc_bagaznika,int cena,int id_salonu)
    {
        super();
        this.id_pojazdu=id_pojazdu;
        this.numer_vin=numer_vin;
        this.marka=marka;
        this.model=model;
        this.rok_produkcji=rok_produkcji;
        this.numer_rejestracyjny=numer_rejestracyjny;
        this.przebieg=przebieg;
        this.rodzaj_paliwa=rodzaj_paliwa;
        this.kolor=kolor;
        this.moc_silnika=moc_silnika;
        this.pojemnosc_bagaznika=pojemnosc_bagaznika;
        this.cena=cena;
        this.id_salonu=id_salonu;
    }
}
