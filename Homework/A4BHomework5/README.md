## Zadanie
Zadanie polega na stworzeniu aplikacji z dwoma ekranami. Na pierwszym z nich będzie można wpisać numer pokemona w pokedeksie do pola tekstowego oraz tapnąć przycisk *INFO*. Tapnięcie powinno spowodować pobranie informacji o tym pokemonie z API [Switter](https://github.com/DaftMobile/switter) i wyświetlenie ich na nowym ekranie.

Nie wymagam stosowania komponentów `LiveData` oraz `ViewModel`, choć do tego zachęcam.

## Wskazówki
W projekcie znajdziecie gotowe widoki oraz szkielet `ViewModelu`.

1. Do komunikacji z API wykorzystajcie **Retrofit**. Większość konfiguracji pod Swittera macie już w materiałach z zajęć nr 5. Skorzystajcie z [endpointu](https://github.com/DaftMobile/switter#pokemon-peek-by-number) `/api/pokemon/:number/peek`. Przypominam, że można przekazać parametr do ścieżki, wykorzystując *wildcard* w ścieżce (np. `/api/users/{id}`) oraz w metodzie określając parametr adnotacją `@Path("id")`.
1. W projekcie nie ma zaimportowanych bibliotek do internetów. Zapraszam do pliku `build.gradle` w module `app`.
1. Pamiętajcie, żeby Activity było najprostsze, jak to możliwe. Musi wiedzieć, jak obsłużyć button i jak pokazać informacje o pokemonie.
1. Żeby przekazać klasę w `Intencie` jako *extra*, pamiętajcie, że musi ona implementować interfejs `java.util.Serializable` lub `android.os.Parcelable`.
1. Przypominam, że do komunikacji z Internetem potrzebne jest odpowiednie *permission*.
1. Ponieważ API zwraca dane w formacie JSON, warto wykorzystać **Gson** do deserializacji ([tu](https://github.com/google/gson) przeczytacie więcej). Aby połączyć Gson i Retrofit, zwróćcie uwagę na kod w pakiecie `.joke.gson` przykładu z zajęć. Api używające Gsona powinno zwracać obiekt `Joke` jako response:

```kotlin
@GET("/api/joke")
fun joke(@Header("x-device-uuid") uuid: String): Call<Joke>
```

Zakładam, że możecie mieć w głowach mały mętlik po zajęciach, szczególnie przez problemy techniczne. Praca domowa nie jest trudna i powinna wam poukładać te informacje. Dopiszcie mi proszę w mailach, ile czasu zajęło Wam zrobienie jej. **5pkt** czeka, powodzenia!

PS. Kod z zajęć uruchomiony w domu zadziałał jak marzenie. Nie mogę przestać klikać **call**. Wrzuciłem moje zmiany na repo.

## Termin
Macie czas do **wtorku o 8:00** rano (potrzebuję więcej czasu na sprawdzenie). Jeśli wysyłacie zipy, usuńcie przed spakowaniem folder `/build`.
