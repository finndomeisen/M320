package D3;

class main {
    public static void main(String[] args) {
        try {
            PokemonSelector selector = new PokemonSelector();
            String url = selector.selectPokemon();

            Request pokemon = new Request();
            pokemon.setUrl(url);
            pokemon.buildconnection();
        } catch (PokemonApiException e) {
            System.err.println("Pokemon API Fehler: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
