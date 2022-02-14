package country;

public class Country implements Comparable<Country> {
    private String name;
    private String continent;
    private String capital;
    private int population;
    private double birthRate;
    private double mortalityRate;

    public Country() {
    }

    public Country(String name, String continent, int population) {
        this.name = name;
        this.continent = continent;
        this.population = population;
    }

    public Country(String name, String continent, int population, double birthRate, double mortalityRate) {
        this.name = name;
        this.continent = continent;
        this.population = population;
        this.birthRate = birthRate;
        this.mortalityRate = mortalityRate;
    }

    public String getName() {
        return name;
    }

    public String getContinent() { return continent; }

    public int compareTo(Country pais) {
        return this.continent.toLowerCase().compareTo(pais.continent.toLowerCase());
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setContinent(String continent) {
        this.continent = continent;
    }

    public String getCapital() {
        return capital;
    }

    public void setCapital(String capital) {
        this.capital = capital;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    public double getBirthRate() {
        return birthRate;
    }

    public void setBirthRate(double birthRate) {
        this.birthRate = birthRate;
    }

    public double getMortalityRate() {
        return mortalityRate;
    }

    public void setMortalityRate(double mortalityRate) {
        this.mortalityRate = mortalityRate;
    }
}
