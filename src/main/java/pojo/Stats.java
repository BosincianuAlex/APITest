package pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Stats {

    public Stats(){
    }

    public Stats(String baseStat, String name, String url){
        this.baseStat=baseStat;
        this.stat = new Stat(name, url);

    }

    @JsonProperty("base_stat")
    String baseStat;

    public String getBaseStat() { return baseStat; }
    public void setBaseStat(String baseStat) { this.baseStat = baseStat; }

    Stat stat;

    public Stat getStat() { return stat; }
    public void setStat(Stat stat) { this.stat = stat; }


    public static class Stat{

        public Stat(){

        }

        public Stat(String name, String url){
            this.name=name;
            this.url=url;
        }

        String name;

        public String getName() {  return name; }
        public void setName(String name) { this.name = name; }

        String url;

        public String getUrl() { return url; }
        public void setUrl(String url) { this.url = url;}



    }

}