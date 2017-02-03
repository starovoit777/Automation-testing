package com.automation.test_suite;

import com.automation.rest.RestClient;
import com.automation.rest.model.Photo;
import com.sun.jersey.api.client.ClientResponse;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.automation.commons.UtilsMethods;
import static org.testng.Assert.*;

/**
 * Created by Serhii Starovoit on  2/2/2017.
 */
public class RestClientTest {

    private static int EXPECTED_COUNT_OF_COMMENTS = 500;
    private static int SUCCESSFUL_CREATION_RESPONSE_CODE = 201;
    private RestClient restClient;

    @BeforeClass
    public void setUp() {
        restClient = new RestClient();
    }

    @Test(groups = { "restTest" , "pageTest" })
    public void testGetComments() {
        assertEquals(restClient.getComments().size(), EXPECTED_COUNT_OF_COMMENTS);
    }

    @Test(groups = { "restTest" })
    public void testGetPhotoById() {
        Photo expectedPhoto = new Photo();
        expectedPhoto.setAlbumId(30);
        expectedPhoto.setId(1492);
        expectedPhoto.setTitle("est facere ut explicabo voluptatum assumenda consequatur");
        expectedPhoto.setUrl("http://placehold.it/600/229602");
        expectedPhoto.setThumbnailUrl("http://placehold.it/150/6b3c53");

        assertEquals(restClient.getPhotoById(1492), expectedPhoto);
    }

    @Test(groups = { "restTest" })
    public void testCreateUser() throws Exception {
        ClientResponse response = restClient.createUser(UtilsMethods.fillUserObject());
        ClientResponse.Status responseStatus = response.getClientResponseStatus();
        assertEquals(responseStatus.getStatusCode(), SUCCESSFUL_CREATION_RESPONSE_CODE, "Expected response code 201");
        assertEquals(responseStatus.getReasonPhrase(), ClientResponse.Status.CREATED.getReasonPhrase(), "Expected reason massage Created");
    }
}