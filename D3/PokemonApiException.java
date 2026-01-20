package D3;

/**
 * Custom Exception für Fehler bei der Pokémon API-Kommunikation
 **/
public class PokemonApiException extends Exception {

    public PokemonApiException(String message) {
        super(message);
    }

    public PokemonApiException(String message, Throwable cause) {
        super(message, cause);
    }

    public PokemonApiException(Throwable cause) {
        super(cause);
    }
}
