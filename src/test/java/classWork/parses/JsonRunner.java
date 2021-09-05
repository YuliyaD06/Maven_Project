package classWork.parses;

import java.io.IOException;

public class JsonRunner {

    public static void main(String[] args) throws IOException {
        JsonParser jsonParser = new JsonParser();
        jsonParser.parseJSON();

        GsonParser gsonParser = new GsonParser();
        gsonParser.parseJSON();
        gsonParser.fromGSON();
        gsonParser.gsonWriterFormatted();

/*        JacksonParser jacksonParser = new JacksonParser();
        jacksonParser.parseJackson();*/
    }
}
