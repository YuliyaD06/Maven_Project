package steps;

import classWork.rest.Data;
import classWork.rest.User;
import gherkin.deps.com.google.gson.Gson;
import gherkin.deps.com.google.gson.stream.JsonReader;

import java.io.FileNotFoundException;
import java.io.FileReader;

public class RestSearchSteps {

    private static final String JSON = "src/test/resources/json/users.json";

    public User getUserFull(String name) throws FileNotFoundException {
        Gson gson = new Gson();
        Data data = gson.fromJson(new JsonReader(new FileReader(JSON)), Data.class);
        return data.data.stream().filter(user -> user.username.equals(name)).findAny().get();
    }

    public User getUserPartial(String name) throws FileNotFoundException {
        Gson gson = new Gson();
        Data data = gson.fromJson(new JsonReader(new FileReader(JSON)), Data.class);
        return data.data.stream().filter(user -> user.username.contains(name)).findAny().get();
    }

}
