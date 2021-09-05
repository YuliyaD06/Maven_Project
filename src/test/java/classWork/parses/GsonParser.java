package classWork.parses;

import classWork.rest.Search;
import gherkin.deps.com.google.gson.Gson;
import gherkin.deps.com.google.gson.GsonBuilder;
import gherkin.deps.com.google.gson.stream.JsonReader;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class GsonParser {
    private static final String JSON = "src/test/resources/json/recipe.json";
    private static final String JSON_1 = "src/test/resources/json/recipe1.json";

    public void parseJSON() throws FileNotFoundException {
        Gson gson = new Gson();
        Recipe recipe = gson.fromJson(new JsonReader(new FileReader(JSON)), Recipe.class);
        System.out.println("GSON Parser: " + recipe.recipename);
    }

    public void fromGSON() throws IOException {
        Gson gson = new Gson();
        Recipe recipe = new Recipe ("Borsch", new Ingredient[]{}, 120);
        System.out.println(gson.toJson(recipe));
        Files.write(Paths.get(JSON_1), gson.toJson(recipe).getBytes());
    }

    public void gsonWriterFormatted() throws IOException {
        Gson gson;
        Recipe recipe = new Recipe ("Borsch", new Ingredient[]{}, 120);
        gson = new GsonBuilder().setPrettyPrinting().create();
        Files.write(Paths.get(JSON_1), gson.toJson(recipe).getBytes());

    }

    public static String fromGson(Search search){
        Gson gson = new Gson();
        return gson.toJson(search);
    }
}

