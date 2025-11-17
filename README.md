# Wzorce wspomagające tworzenie obiektów i zarządzenie nimi
Przykład ilustrujący budowę i wykorzystanie podstawowej wersji wzorca _Factory Method_
oraz _Object Pool_.


## Zadanie
Zadanie polega na przygotowaniu struktury dostarczającej obiekty wybranej rodziny według
ustalonych zasad.

Rodzina klas to żetony w grze planszowej. Na czele rodziny stoi abstrakcyjna klasa
`Token`, której jedyną właściwością jest etykietka (`label`). Klasa udostępnia getter
do etykietki i konstruktor przyjmujący jeden parametr: etykietkę.

Na bazie klasy `Token` są definiowane klasy kolejnych żetonów: złota (`GoldToken`),
pożywienia (`FoodToken`), łopaty (`ShovelToken`) oraz pusty żeton (`EmptyToken`).
**Uwaga:** obiekty żetonów mają być niemutowalne.

Charakterystyka poszczególnych żetonów:
- **pusty żeton** nie ma żadnych właściwości; nie ma sensu, żeby istniało wiele
  jego instancji, wystarczy jedna;
- **żetony złota i pożywienia** mają właściwość `amount` typu `int` opisującą
  ilość złota/jedzenia; trzeba stworzyć pulę tych żetonów, tak żeby nie były powielane
  żetony o tej samej wartości `amount`;
- **żeton łopaty** reprezentuje narzędzie, które gracz może wykorzystać do realizacji
  zadań w grze; łopata ma właściwość `durability` określającą wytrzymałość; 
  żeton nie jest przechowywany w puli -- za każdym razem jest tworzona nowa instancja. 

Kluczowym elementem zadania jest opracowanie mechanizmu dostarczającego obiekty żetonów zgodnie z opisaną wyżej
charakterystyką. Należy zdefiniować klasę `TokenFactory` z metodami:
- `createEmptyToken()`,
- `createGoldToken()` i `createGoldToken(amount)`,
- `createFoodToken()` i `createFoodToken(amount)`,
- `createShovelToken()` i `createShovelToken(durability)`.


## Wymagania

**Poziom 3**
- przygotowanie rodziny klas żetonów, zaimplementowanie ich właściwości,
- zdefiniowanie klasy `TokenFactory` i zaimplementowanie jej metod `create*`
  tworzących obiekty o domyślnych ilościach, czyli bez parametru `amount`
  (na tym poziomie samo tworzenie instancji, bez puli obiektów, bez dbania
  o liczbę instancji).

**Poziom 4**
- uzupełnienie listy metod `create*` o te, które przyjmują ilość (parametry `amount`
  i `durablity`), 
- wprowadzenie kontroli pojedynczej instancji żetonów klasy `EmptyToken`,
- wprowadzenie puli żetonów złota i pożywienia (zgodnie z wcześniejszym opisem),
- napisanie testów dla klasy `TokenFactory` sprawdzających działanie puli obiektów.

**Poziom 5**
- utworzenie alternatywnej wersji klasy `TokenFactory`, która oferuje dwie metody
  tworzące żetony: `createToken(type)` i `createToken(type, amount)`.
- dodanie metody zwracającej losową wartość amount, tak by można było wygodnie
  tworzyć żetony z przypadkową wartością, np.
  `TokenFactory.createToken(Type.GOLD, TokenFactory.randomAmount)`,
- napisanie testów dla nowej wersji klasy `TokenFactory`.