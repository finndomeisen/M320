# Pokémon Selector - D3

## Übersicht
Dieses Programm ist eine interaktive Anwendung, die den Benutzer ein Pokémon-Ei auswählen lässt und dann Informationen über ein zufälliges Pokémon von der [Pokémon API](https://pokeapi.co/) abruft.

## Funktionsweise
1. **PokemonSelector**: Präsentiert dem Benutzer ein Menü mit 3 Ei-Optionen zur Auswahl
2. **Zufällige Pokémon-Auswahl**: Nach der Eingabe wird eine Zufallszahl (1-101) generiert
3. **API-Anfrage**: Die `request`-Klasse baut eine HTTP-Verbindung zur Pokémon API auf
4. **Ausgabe**: Der Name des zufällig ausgewählten Pokémon wird in der Konsole angezeigt

## Technologie
- **API**: https://pokeapi.co/api/v2/pokemon-form/
- **HTTP**: GET-Anfragen über HttpURLConnection
- **Parsing**: Reguläre Ausdrücke für JSON-Extraktion

## Komponenten
- `main.java`: Einstiegspunkt
- `PokemonSelector.java`: Benutzerinteraktion und URL-Generierung
- `request.java`: HTTP-Anfrage und JSON-Parsing
