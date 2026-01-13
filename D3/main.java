package D3;

class main {
    public static void main(String[] args) {
        PokemonSelector selector = new PokemonSelector();
        String url = selector.selectPokemon();

        request pokemon = new request();
        pokemon.setUrl(url);
        pokemon.buildconnection();
    }
}
