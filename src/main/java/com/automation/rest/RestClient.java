package com.automation.rest;

import com.automation.rest.model.Comment;
import com.automation.rest.model.Photo;
import com.automation.rest.model.User;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import org.apache.http.client.HttpResponseException;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Serhii Starovoit on 1/31/2017.
 */
public class RestClient {

    private Logger logger = Logger.getLogger(RestClient.class);
    private static final String WEB_RESOURCE_URL = "http://jsonplaceholder.typicode.com";
    private Client client;
    private WebResource webResource;

    /**
     * Default constructor.
     */
    public RestClient() {
        client = Client.create();
        webResource = client.resource(WEB_RESOURCE_URL);
    }

    /**
     * @return list of comments.
     */
    public List getComments() {
        ArrayList<Comment> listComments = new ArrayList<>();
        try {
            ClientResponse response = webResource.path("comments").accept("application/json").get(ClientResponse.class);
            if (response.getStatus() != 200) {
                throw new RuntimeException("Failed : HTTP error code : " + response.getStatus());
            }
            String responseResult = response.getEntity(String.class);
            ObjectMapper mapper = new ObjectMapper();
            listComments = mapper.readValue(responseResult, new TypeReference<ArrayList<Comment>>() {
            });
        } catch (Exception e) {
            logger.info("Exception during rest call for get list of comments:" + e.getMessage());
        }
        return listComments;
    }

    /**
     * @return Photo
     */
    public Photo getPhotoById(int id) {
        ArrayList<Photo> listPhotos = new ArrayList<>();
        Photo photo;
        try {
            ClientResponse response = webResource.path("photos").queryParam("id", String.valueOf(id)).accept("application/json").get(ClientResponse.class);
            if (response.getStatus() != 200) {
                throw new RuntimeException("Failed : HTTP error code : " + response.getStatus());
            }
            String responseResult = response.getEntity(String.class);
            ObjectMapper mapper = new ObjectMapper();
            listPhotos = mapper.readValue(responseResult, new TypeReference<ArrayList<Photo>>() {
            });
        } catch (Exception e) {
            logger.info("Exception during rest call for get photo by id:" + e.getMessage());
        }
        photo = listPhotos.get(0);
        return photo;
    }

    /**
     * Sends an object of type user with fields to fill following link.
     * @return object type WebResource
     */
    public ClientResponse createUser(User user) {
        ClientResponse response = null;
        try {
            WebResource webResource = client.resource(WEB_RESOURCE_URL).path("users");
            ObjectMapper mapper = new ObjectMapper();
            String jsonInString = mapper.writeValueAsString(user);
            response = webResource.accept("application/json")
                    .type("application/json").post(ClientResponse.class, jsonInString);
            if (response.getStatus() != 201) {
                throw new HttpResponseException(response.getStatus(), "Could not create object.");
            }
        } catch (Exception e) {
            logger.info("Exception during rest call for creating user:" + e.getMessage());
        }
        return response;
    }
}
