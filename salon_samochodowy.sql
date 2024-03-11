/*
Created: 11.11.2022
Modified: 26.11.2022
Project: BDBT_SalonSamochodowy
Model: Salon samochodowy
Database: MySQL
*/
CREATE DATABASE baza_danych_salon_samochodowy;
USE baza_danych_salon_samochodowy;
-- Create tables section -------------------------------------------------

-- Table salony_samochodowe

CREATE TABLE salony_samochodowe (
  id_salonu INT NOT NULL,
  nazwa VARCHAR(30) NOT NULL,
  data_otwarcia DATE,
  numer_telefonu VARCHAR(12) NOT NULL,
  email VARCHAR(30) NOT NULL,
  numer_adresu INT NOT NULL,
  PRIMARY KEY (id_salonu)
);

-- Table pojazdy
CREATE TABLE pojazdy (
  id_pojazdu INT NOT NULL,
  numer_vin CHAR(17) NOT NULL,
  marka VARCHAR(20) NOT NULL,
  model VARCHAR(20) NOT NULL,
  rok_produkcji INT NOT NULL,
  numer_rejestracyjny VARCHAR(7) NOT NULL,
  przebieg INT NOT NULL,
  rodzaj_paliwa ENUM('Benzyna', 'Diesel', 'Lpg') NOT NULL,
  kolor VARCHAR(20),
  moc_silnika INT NOT NULL,
  pojemnosc_bagaznika INT,
  cena DECIMAL(10, 2) NOT NULL,
  id_salonu INT NOT NULL,
  PRIMARY KEY (id_pojazdu),
  FOREIGN KEY (id_salonu) REFERENCES salony_samochodowe(id_salonu)
);

-- Table pracownicy
CREATE TABLE pracownicy (
  id_pracownika INT NOT NULL,
  imie VARCHAR(20) NOT NULL,
  drugie_imie VARCHAR(20),
  nazwisko VARCHAR(30) NOT NULL,
  data_urodzenia DATE NOT NULL,
  numer_telefonu VARCHAR(12) NOT NULL,
  email VARCHAR(30) NOT NULL,
  data_zatrudnienia DATE NOT NULL,
  stanowisko ENUM('S', 'B') NOT NULL,
  id_salonu INT NOT NULL,
  numer_adresu INT NOT NULL,
  PRIMARY KEY (id_pracownika),
  FOREIGN KEY (id_salonu) REFERENCES salony_samochodowe(id_salonu)
);

-- Table uslugi
CREATE TABLE uslugi (
  id_uslugi INT NOT NULL,
  data DATE NOT NULL,
  cena DECIMAL(10, 2) NOT NULL,
  rodzaj_uslugi ENUM('S', 'L') NOT NULL,
  id_salonu INT NOT NULL,
  PRIMARY KEY (id_uslugi),
  FOREIGN KEY (id_salonu) REFERENCES salony_samochodowe(id_salonu)
);

-- Table klienci
CREATE TABLE klienci (
  id_klienta INT NOT NULL,
  imie VARCHAR(20) NOT NULL,
  drugie_imie VARCHAR(20),
  nazwisko VARCHAR(30) NOT NULL,
  pesel CHAR(11),
  numer_telefonu VARCHAR(12) NOT NULL,
  email VARCHAR(30) NOT NULL,
  id_salonu INT NOT NULL,
  numer_adresu INT NOT NULL,
  PRIMARY KEY (id_klienta),
  FOREIGN KEY (id_salonu) REFERENCES salony_samochodowe(id_salonu)
);

-- Table pracownicy_biurowi
CREATE TABLE pracownicy_biurowi (
  id_pracownika INT NOT NULL,
  numer_biurka INT NOT NULL,
  znajomosc_msoffice ENUM('Y', 'N') NOT NULL,
  czy_studia ENUM('Y', 'N') NOT NULL,
  PRIMARY KEY (id_pracownika)
);

-- Table sprzedawcy
CREATE TABLE sprzedawcy (
  id_pracownika INT NOT NULL,
  prawo_jazdy_katb ENUM('Y', 'N') NOT NULL,
  czy_szkolenie ENUM('Y', 'N') NOT NULL,
  PRIMARY KEY (id_pracownika),
  FOREIGN KEY (id_pracownika) REFERENCES pracownicy_biurowi(id_pracownika)
);

-- Table leasingi
CREATE TABLE leasingi (
  id_uslugi INT NOT NULL,
  czas_trwania INT NOT NULL,
  kwota_wykupu DECIMAL(10, 2) NOT NULL,
  pakiet_serwisowy ENUM('Y', 'N') NOT NULL,
  PRIMARY KEY (id_uslugi),
  FOREIGN KEY (id_uslugi) REFERENCES uslugi(id_uslugi)
);

-- Table sprzedaze
CREATE TABLE sprzedaze (
  id_uslugi INT NOT NULL,
  czy_dodatkowe_opony ENUM('Y', 'N') NOT NULL,
  czy_ubezpieczenie ENUM('Y', 'N') NOT NULL,
  PRIMARY KEY (id_uslugi),
  FOREIGN KEY (id_uslugi) REFERENCES uslugi(id_uslugi)
);

-- Table obsluga_uslug
CREATE TABLE obsluga_uslug (
  id_pracownika INT NOT NULL,
  id_uslugi INT NOT NULL,
  PRIMARY KEY (id_pracownika, id_uslugi),
  FOREIGN KEY (id_pracownika) REFERENCES pracownicy(id_pracownika),
  FOREIGN KEY (id_uslugi) REFERENCES uslugi(id_uslugi)
);

-- Table transakcje
CREATE TABLE transakcje (
  id_klienta INT NOT NULL,
  id_uslugi INT NOT NULL,
  data DATE NOT NULL,
  cena DECIMAL(10, 2) NOT NULL,
  PRIMARY KEY (id_klienta, id_uslugi),
  FOREIGN KEY (id_klienta) REFERENCES klienci(id_klienta),
  FOREIGN KEY (id_uslugi) REFERENCES uslugi(id_uslugi)
);

-- Table obsluga_pojazdow
CREATE TABLE obsluga_pojazdow (
  id_pracownika INT NOT NULL,
  id_pojazdu INT NOT NULL,
  PRIMARY KEY (id_pracownika, id_pojazdu),
  FOREIGN KEY (id_pracownika) REFERENCES pracownicy(id_pracownika),
  FOREIGN KEY (id_pojazdu) REFERENCES pojazdy(id_pojazdu)
);

-- Table przedmioty_uslug
CREATE TABLE przedmioty_uslug (
  id_pojazdu INT NOT NULL,
  id_uslugi INT NOT NULL,
  PRIMARY KEY (id_pojazdu, id_uslugi),
  FOREIGN KEY (id_pojazdu) REFERENCES pojazdy(id_pojazdu),
  FOREIGN KEY (id_uslugi) REFERENCES uslugi(id_uslugi)
);

-- Table adresy
CREATE TABLE adresy (
  numer_adresu INT NOT NULL AUTO_INCREMENT,
  miasto VARCHAR(20) NOT NULL,
  ulica VARCHAR(30) NOT NULL,
  numer_lokalu VARCHAR(5) NOT NULL,
  kod_pocztowy CHAR(6) NOT NULL,
  PRIMARY KEY (numer_adresu)
);

-- Table wlasciciele
CREATE TABLE wlasciciele (
  id_wlasciciela INT NOT NULL AUTO_INCREMENT,
  imie VARCHAR(20) NOT NULL,
  nazwisko VARCHAR(30) NOT NULL,
  numer_adresu INT NOT NULL,
  id_salonu INT NOT NULL,
  PRIMARY KEY (id_wlasciciela),
  FOREIGN KEY (numer_adresu) REFERENCES adresy(numer_adresu),
  FOREIGN KEY (id_salonu) REFERENCES salony_samochodowe(id_salonu)
);

-- Table wynagrodzenia
CREATE TABLE wynagrodzenia (
  id_wynagrodzenia INT NOT NULL AUTO_INCREMENT,
  data DATE NOT NULL,
  pensja_podstawowa DECIMAL(10, 2) NOT NULL,
  premia DECIMAL(10, 2),
  id_pracownika INT NOT NULL,
  PRIMARY KEY (id_wynagrodzenia),
  FOREIGN KEY (id_pracownika) REFERENCES pracownicy(id_pracownika)
);

-- Table znajomosc_jezykow
CREATE TABLE znajomosc_jezykow (
  kod_poziomu VARCHAR(2) NOT NULL,
  id_pracownika INT NOT NULL,
  attribute1 INT NOT NULL,
  PRIMARY KEY (id_pracownika, attribute1),
  FOREIGN KEY (id_pracownika) REFERENCES pracownicy(id_pracownika)
);

-- Table jezyki_obce
CREATE TABLE jezyki_obce (
  id_jezyka INT NOT NULL AUTO_INCREMENT,
  kod_jezyka VARCHAR(3) NOT NULL UNIQUE,
  nazwa_jezyka VARCHAR(20) NOT NULL,
  PRIMARY KEY (id_jezyka)
);

-- Create foreign keys (relationships) section -------------------------------------------------

ALTER TABLE pojazdy
ADD CONSTRAINT posiada FOREIGN KEY (id_salonu) REFERENCES salony_samochodowe(id_salonu);

ALTER TABLE pracownicy
ADD CONSTRAINT zatrudnia FOREIGN KEY (id_salonu) REFERENCES salony_samochodowe(id_salonu);

ALTER TABLE uslugi
ADD CONSTRAINT oferuje FOREIGN KEY (id_salonu) REFERENCES salony_samochodowe(id_salonu);

ALTER TABLE klienci
ADD CONSTRAINT gosci FOREIGN KEY (id_salonu) REFERENCES salony_samochodowe(id_salonu);

ALTER TABLE salony_samochodowe
ADD CONSTRAINT salon_ma_adres FOREIGN KEY (numer_adresu) REFERENCES adresy(numer_adresu);

ALTER TABLE pracownicy
ADD CONSTRAINT pracownik_ma_adres FOREIGN KEY (numer_adresu) REFERENCES adresy(numer_adresu);

ALTER TABLE klienci
ADD CONSTRAINT klient_ma_adres FOREIGN KEY (numer_adresu) REFERENCES adresy(numer_adresu);

ALTER TABLE wlasciciele
ADD CONSTRAINT wlasciciel_ma_adres FOREIGN KEY (numer_adresu) REFERENCES adresy(numer_adresu);

ALTER TABLE wynagrodzenia
ADD CONSTRAINT pracownik_dostaje_wynagrodzenie FOREIGN KEY (id_pracownika) REFERENCES pracownicy(id_pracownika);

ALTER TABLE wlasciciele
ADD CONSTRAINT wlasciciel_ma_salon FOREIGN KEY (id_salonu) REFERENCES salony_samochodowe(id_salonu);

ALTER TABLE znajomosc_jezykow
ADD CONSTRAINT sprzedawca_zna_jezyk FOREIGN KEY (id_pracownika) REFERENCES sprzedawcy(id_pracownika);

ALTER TABLE znajomosc_jezykow
ADD CONSTRAINT jezyk_jest_znany FOREIGN KEY (attribute1) REFERENCES jezyki_obce(id_jezyka);
