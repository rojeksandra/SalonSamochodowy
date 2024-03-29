# SalonSamochodowy
# Projekt Bazy Danych i Big Data

## Cel projektu
Projekt składał się z dwóch głównych etapów:
1. Stworzenie bazy danych oraz wypełnienie jej abstrakcyjnymi danymi.
2. Stworzenie strony internetowej, która współpracuje z wcześniej stworzoną bazą danych.

Projekt był realizowany w ramach przedmiotu Bazy Danych i Big Data na studiach, w zespołach dwuosobowych.

## Narzędzia
- **Toad Data Modeler 7.2:** Projekt bazy danych.
- **Oracle Database 19c:** Lokalna baza danych.
- **SQL Developer:** GUI do pracy z bazami danych SQL.
- **Java Oracle JDK 17**
- **Java Spring**

## Projekt bazy danych
Baza danych została zaprojektowana przy użyciu programu Toad Data Modeler. Składa się z dwóch głównych modeli:
- **Model Konceptualny:** ![link](images_readme/model_konceptualny.jpg)
- **Model Logiczny:** ![link](images_readme/model_logiczny.jpg)

## Przykładowe zapytania SQL 

- pracownicy którzy dostają pensję podstawową większą od 6000
  
  ![link](images_readme/zapytanie1.jpg)
  
- ilość pracowników biurowych
  
  ![link](images_readme/zapytanie2.jpg)

- wyszukiwanie pojazdów których rok produkcji zawiera się pomiędzy 2019 i 2022 rokiem ,rodzajem paliwa  jest Benzyna  a model auta to Tipo

  ![link](images_readme/zapytanie3.jpg)

- wyszukiwanie pracowników pracujących jako sprzedawcy którzy znają dowolny język na poziomie C2

  ![link](images_readme/zapytanie4.jpg)

- wyszukiwanie klientów zamieszkałych w mieście Warszawa

  ![link](images_readme/zapytanie5.jpg)

## Opis
Projekt składa się z dwóch perspektyw: administratora z rozszerzonymi uprawnieniami do zarządzania, takimi jak modyfikacja, dodawanie i usuwanie pojazdów, oraz użytkownika, który po rejestracji lub zalogowaniu może przeglądać oferty oraz umawiać się na wizytę w salonie lub rezerwować dostępne auto. Bez konieczności logowania możliwe jest jedynie przeglądanie ofert salonu, strony głównej oraz zakładki kontakt.

## Prezentacja Wyglądu Strony

- Strona główna
  
  ![link](images_readme/main.jpg)

- Oferta
  
  ![link](images_readme/oferta.jpg)
  
- Logowanie
  
  ![link](images_readme/log.jpg)

- Perspektywa użytkownika

  ![link](images_readme/user.jpg)

- Kalendarz - umówienie spotkania 

  ![link](images_readme/kalendarz.jpg)

- Perspektywa Administratora 

  ![link](images_readme/modyfikacja.jpg)

- Kontakt

  ![link](images_readme/contact.jpg)

- Obsługa błędów 

  ![link](images_readme/error.jpg)


