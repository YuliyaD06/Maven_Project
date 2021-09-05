package classWork.http;

import classWork.parses.GsonParser;
import classWork.rest.Search;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.net.URISyntaxException;

public class HttpClientPost {

    static Search search = new Search("", false);

    public void search(Search search) throws IOException, URISyntaxException {
        HttpClient client = HttpClientBuilder.create().build();
        URIBuilder builder = new URIBuilder("http://178.124.206.46:8001/app/ws/");
        HttpPost request = new HttpPost(builder.build());
        request.setEntity(new StringEntity(GsonParser.fromGson(search)));
        HttpResponse response = client.execute(request);
        System.out.println(EntityUtils.toString(response.getEntity()));

    }

    public static void main(String[] args) throws IOException, URISyntaxException {
        HttpClientPost clientPost = new HttpClientPost();
        clientPost.search(search);
    }
}
