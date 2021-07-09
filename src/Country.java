import java.util.ArrayList;

public class Country {
    private int id;
    private String name;
    private String capital;
    private static ArrayList<Country> countries = new ArrayList<>();

    public Country(int id, String country, String capital){
        this.id = id;
        this.name = country;
        this.capital = capital;
    }

    public Country(){

    }

    public String getCountry() {
        return name;
    }
    public String getCapital() {
        return capital;
    }

    public void setCountry(String country){
        this.name = country;
    }
    public void setCapital(String capital){
        this.capital = capital;
    }

    public static void addCountry (Country country){
        countries.add(country);
    }
    @Override
    public String toString(){
        return name;
    }

    public static void showCountry(){
        for(int i = 0; i <  countries.size(); i++){
            System.out.println(countries.get(i));
        }
    }
}
