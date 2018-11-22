# Praca domowa z zajęć nr 3

Zadanie znów polega na stworzeniu prostej jednoekranowej aplikacji. Layout jest gotowy w dostarczonym projekcie. Kliknięcie buttona na dole ekranu powinno umożliwić użytkownikowi wybór adresu email spośród tych posiadanych w kontaktach. Po wybraniu dowolnego adresu użytkownik powinien zostać przeniesiony do ekranu tworzenia nowego emaila w wybranej przez siebie aplikacji mailowej. Adresat powinien być ustawiony domyślnie na wybrany email, a tytuł wiadomości na *"Wiadomość z pracy domowej"*.
Będziecie musieli połączyć wiedzę z zajęć o wysyłaniu i odbieraniu danych między `Activity` z informacjami o **implicit** [intentach](https://developer.android.com/training/basics/intents/sending). Celowo nie wrzucam na repo przykładu z otwieraniem aplikacji telefonu - zależy mi na waszym zapoznaniu się z docsami (albo stackoverflow 😞).

Po uzyskaniu `Uri` kontaktu użyjcie obiektu `EMAIL_RETRIEVER`, aby uzyskać adres e-mail.

Działanie appki będzie dużo łatwiej testować na podłączonym urządzeniu niż emulatorze, gdyż tam macie więcej kontaktów i skonfigurowane aplikacje mailowe. Zrobienie tego na emulatorze jest drogą przez mękę ;]

UI testy natomiast spokojnie poradzą sobie na emulatorze. Instrukcja ich uruchomienia jest taka, jak poprzednio. Pamiętajcie o wyłączeniu animacji!

Nie wrzucam screenów, bo pochodziłyby z apek systemowych :P

Macie czas do środy o 12:00 (czasu środkowoeuropejskiego zimowego). W razie pytań - piszcie.

Good luck!