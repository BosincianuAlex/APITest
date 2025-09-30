package pojo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Pokemon {

    List<Stats> stats;

    public List<Stats> getStats() { return stats; }
    public void setStats(List<Stats> stats) { this.stats = stats; }

    List<Moves> move;

    public List<Moves> getMoves() { return move; }
    public void setMoves(List<Moves> moves) { this.move = moves; }

    String name;

    public String getName(){ return name; }
    public void setName(String name){ this.name=name; }





}
