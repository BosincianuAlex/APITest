package pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Moves {

    private Move move;

    // Getter & Setter
    public Move getMove() { return move; }
    public void setMove(Move move) { this.move = move; }


    public static class Move{

        private String name;
        private String url;

        // Getters & Setters
        public String getName() { return name; }
        public void setName(String name) { this.name = name; }

        public String getUrl() { return url; }
        public void setUrl(String url) { this.url = url; }
    }

}
