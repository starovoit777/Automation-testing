package rest;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Micro on 1/31/2017.
 */
public class RestClient {

    Client client;
    WebResource webResource;

    public RestClient() {
        client = Client.create();
        webResource = client.resource("http://jsonplaceholder.typicode.com");
    }

    public List getComments() {
        try {

            ClientResponse response = webResource.path("comments").accept("application/json").get(ClientResponse.class);

            if (response.getStatus() != 200) {
                throw new RuntimeException("Failed : HTTP error code : " + response.getStatus());
            }

            String output = response.getEntity(String.class);
            System.out.println("Output from Server .... \n");
            System.out.println(output);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return new ArrayList();
    }

    //getPhotoById

    //createUser

    public static void main(String[] args) {
        RestClient restClient = new RestClient();
        restClient.getComments();
    }

}
