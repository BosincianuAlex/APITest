package resources;

public enum APIPaths {

    pokemon("/pokemon/"),
    berry("/berry/");

    private final String resource;

    private APIPaths(String resource) {
        this.resource = resource;
    }

    public String getPath() {
        return this.resource;
    }


}
