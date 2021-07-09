import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class President {
    private int id;
    private String name;
    private int country;

    public President(){

    }

    public President(int id, String name, int country){
        this.id = id;
        this.name = name;
        this.country = country;
    }

    private static ArrayList<President> presidents = new ArrayList<>();

    public int getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public int getCountry() {
        return country;
    }
    public void setId(int id){
        this.id = id;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setCountry(int country) {
        this.country = country;
    }

    public static void addPresident(President president){
        presidents.add(president);
    }

    @Override
    public String toString (){
        return this.id + " " + this.name + " " + this.country;
    }

    public static void showPresidents(List<President> presidentsToPrint){
        for(President president : presidentsToPrint){
            System.out.println(president.toString());
        }
    }

    public static List<President> nameLengthOver11 (){
        List<President> results = presidents.stream().filter(p -> p.name.length() > 11).collect(Collectors.toList());
        return results;
    }
}
