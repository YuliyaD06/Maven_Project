package classWork.parses;

public class Recipe {

    public String recipename;
    public Ingredient[] ingredlist;
    public int preptime;

    public Recipe(String recipename, Ingredient[] ingredlist, int preptime) {
        this.recipename = recipename;
        this.ingredlist = ingredlist;
        this.preptime = preptime;
    }
}
