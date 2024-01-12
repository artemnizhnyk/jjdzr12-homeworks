# Spring Data

## Zadanie 10 - Spring Data

### Zakres: Spring Web, Spring Data, JPA, Hibernate

**Cel:**  
Zadanie polega na poprawnym zaimplementowaniu w aplikacji warstwy repozytorium oraz serwisów, żeby wszystkie dane były zapisywane w bazie MySQL.

**Założenia:**  
1. Należy dodać implementacje interfejsu `BaseJpaRepository` (ze wszystkimi metodami), które będą odpowiedzialne za komunikację z bazą danych.
2. Należy dodać min. dwie encje (`Book`, `Author`) dla mapowania danych z tabel (`book` i `author`).
3. Pomiędzy encjami `Author` i `Book` ma być relacja _jeden-do-wielu_ (dla uproszczenia przyjmujemy, że książka ma jednego autora, a jeden autor mógł napisać wiele książek).
4. Kategoria ma być zapisywana w bazie danych jako tekst.
5. Dodanie nowej książki poprzez formularz na stronie web powinno skutkować zapisaniem wszystkich danych do tabel w bazie MySQL.
6. Należy pamiętać o zasadach `clean code`.

---

## Instrukcja

1. Uruchom IntelliJ i otwórz swój projekt `jjdzr12-homeworks`.
2. Utwórz nowy branch (np. `Ex10_Bookcase_2`), na którym znajdzie się rozwiązanie zadania.
3. Do swojego projektu `jjdzr12-homeworks` skopiuj cały moduł `Ex10` z tego repozytorium `homeworks`. Po skopiowaniu całego folderu `Ex10` i dodaniu wszystkich nowych plików do gita, kliknij na plik `pom.xml` i wybierz z menu opcję _Add as Maven Project_. Od tego momentu folder `Ex10` będzie nowym modułem w Twoim repozytorium i będzie można uruchomić z niego aplikację `Bookcase` w Spring Boot.
4. Przeczytaj i wykonaj poniższą instrukcję, jak uruchomić bazę danych MySQL w kontenerze dockerowym, której działanie jest niezbędne, żeby uruchomić aplikację `Bookcase`.
5. Zaimplementuj rozwiązanie zadania.
6. Commituj często swoje zmiany w kodzie. Pamiętaj, żeby pracować i commitować na branchu dedykowanym pod to zadanie, **nie na branchu `main`**.
7. Wysyłaj zmiany do zdalnego repozytorium na GitHuba poprzez `git push`.
8. Gdy zadanie będzie ukończone, utwórz pull request.
9. Jeśli coś będzie niezrozumiałe — napisz na Slacku do trenera wspierającego.

---

## Korzystanie z docker-compose

W module `Ex10` jest przygotowany plik `docker-compose.yml`, dzięki któremu możemy szybko uruchomić bazę danych MySQL w kontenerze dockerowym.  
W tym celu należy użyć komendy:
```
docker-compose up db
```

Kontener z bazą danych można zatrzymać za pomocą komendy:
```
docker-compose down
```

Załączony plik `docker-compose.yml` pozwala również na uruchomienie jednocześnie aplikacji webowej `Bookcase` i bazy danych.  
Przed zbudowaniem obrazu należy zmienić konfigurację w pliku `application.properties` (w tej chwili jest ustawiona konfiguracja do komunikacji z osobno uruchomioną bazą danych).  
Żeby po raz pierwszy uruchomić **jednocześnie** kontener aplikacji webowej `Bookcase` i kontener bazy danych, należy użyć komendy:
```
docker-compose up --build
```
Komenda ta buduje obraz dockerowy aplikacji `Bookcase` według instrukcji zamieszczonej w pliku `Dockerfile` (pierwszy proces budowy jest dłuższy ze względu na pobieranie plików), a następnie uruchamia kontener z tą aplikacją.

Uruchomione kontenery (`bookcase_app` i `bookcase_mysql_db`) można zatrzymać za pomocą komendy:
```
docker-compose stop
```
i ponownie uruchomić za pomocą komendy:
```
docker-compose start
```
Komendę `docker-compose up --build` należy wykonać tylko wówczas, jeśli nanieśliśmy w kodzie jakieś zmiany i należy przebudować obraz dockerowy.  
Jeśli zmian nie było, to do uruchomienia kontenerów wystarczy komenda:
```
docker-compose up
```
a do ich usunięcia komenda `docker-compose down`.

Warto zauważyć, że plik `docker-compose.yml` ma również konfigurację `volume`, dzięki której nie stracimy danych w bazie po usunięciu kontenera.  
Jeśli chcielibyśmy usunąć razem z kontenerem wszystkie zapisane w bazie dane, to wystarczy użyć jednej z komend:
```
docker-compose down --volumes
docker-compose down -v
```

---

## Forma oddania zadania

Rozwiązanie zadania powinno się znaleźć w prywatnym repozytorium `jjdzr12-homeworks` na GitHubie.  
Utwórz branch o jednoznacznej nazwie, np. `Ex10_Bookcase_2`.  
Pamiętaj, żeby nowy branch, utworzyć wychodząc z aktualnego brancha `main`.  
Wykonaj zadanie na podanym branchu.  
Utwórz Pull Request z brancha `Ex10_Bookcase_2` na branch `main`.  
Dopiero tak zgłoszone zadanie podlega ocenie.  
Napisz prywatną wiadomość na Slacku do trenera wspierającego, że zadanie jest gotowe do sprawdzenia.

W bieżącej implementacji można dokonywać swoich zmian.  
Został użyty Lombok, dzięki któremu można uniknąć pisania wielu linii kodu.  
Tworzone repozytoria powinny rozszerzać `BaseJpaRepository`, do którego można dopisać własne metody, które będą używane w konkretnych repozytoriach. Takim repozytorium jest np. `BookRepository`. 
W nim również można dopisać własne metody, najlepiej posługując się konwencjami ze `Spring Data`.  
Została również stworzona abstrakcyjna encja, która posiada pole `id`.  

Jeśli **nie** chcesz korzystać z przygotowanej aplikacji `Bookcase` w module `Ex10`, tylko wolisz rozwijać swoje rozwiązanie z zadania `Ex6`, to nowy branch należy utworzyć, wychodząc z brancha, na którym masz rozwiązane zadanie `Ex6`.  
W tym wypadku utwórz Pull Request **nie na branch main**, tylko na tzw. feature branch `Ex6`.  
Przykład Pull Requesta na GitHubie: `Ex6_Bookcase` :arrow_left: `Ex10_Bookcase_2`.

Nie trzeba tworzyć nowego projektu pod to zadanie.

---

## Punktacja

Do zdobycia jest **5** pkt.  
Zadanie oddane po terminie oceniane jest na maksymalnie połowę punktów.

#### Powodzenia!

---

### Termin oddania:
## Poniedziałek, 29.01.2024 godz. 23:59