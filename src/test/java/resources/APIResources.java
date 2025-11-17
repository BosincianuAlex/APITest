package resources;

public enum APIResources {

    pokemon("/pokemon/"),
    berry("/berry/");

    private final String resource;

    private APIResources(String resource) {
        this.resource = resource;
    }

    public String getPath() {
        return this.resource;
    }


}
