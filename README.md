# TextTransformer
[![Build Status](https://travis-ci.com/Guslarz/TextTransformer.svg?token=peoSjrb9W53DNZFWVoGu&branch=main)](https://travis-ci.com/Guslarz/TextTransformer)

## Opis
Dla osób pracujących z danymi tekstowymi nasza aplikacja Text Transformer umożliwi transformacje danych tekstowych (np. zmiana wielkości liter, eliminacja duplikatów, itd.). Aplikacja będzie dostępna poprzez GUI a także zdalne API dzięki czemu będzie można ją zintegrować z istniejącymi narzędziami.

## UML
![UML diagram](https://github.com/Guslarz/TextTransformer/blob/main/misc/TextTransformer.png)

## REST API
Aplikacja działa na porcie `8080`.

API pod adresem `/api` obsługuje żądania GET i POST, przy czym oba służą jedynie pobraniu danych, 
jednak zastosowanie POSTa pozwala uniknąć ograniaczenia ilości znaków w tekście. 
POST obsługuje zarówno x-www-form-urlencoded jak i json.

Oba żądania posiadają dwa parametry: 
- `text` - string który poddany zostanie transformacji
- `transforms` - tablica stringów określająca kolejne transformacje (nazwy pooddzielane 
średnikami dla x-www-form-urlencoded lub JSONArray w przypadku użycia formatu json)

#### Przykłady
```
curl "http://localhost:8080/api?text=ExAmPle&transforms=lower,upper"
curl -X POST -d "text=ExAmPle&transforms=lower,upper" "http://localhost:8080/api"
curl -X POST -H "Content-type: application/json" -d "@req.json" "http://localhost:8080/api"
```

req.json
```
{
	"text": "AsDf\"&asdx",
	"transforms": ["lower", "latex"]
}
```
