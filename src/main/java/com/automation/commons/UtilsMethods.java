package com.automation.commons;

import com.automation.rest.model.Address;
import com.automation.rest.model.Company;
import com.automation.rest.model.Geo;
import com.automation.rest.model.User;

import java.util.Random;

/**
 * Created by Serhii Starovoit on 2/2/2017. after party)
 */
public class UtilsMethods {

    /**
     * @return String of 20 random letters
     */
    public static String randomStringGenerator() {
        char[] chars = "abcdefghijklmnopqrstuvwxyz".toCharArray();
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < 20; i++) {
            char c = chars[random.nextInt(chars.length)];
            sb.append(c);
        }
        return sb.toString();
    }


    /**
     * @return User with filled fields
     */
    public static User fillUserObject() {

        User user = new User();
        Company company = new Company();
        Address address = new Address();
        Geo geo = new Geo();

        geo.setLat(123.44);
        geo.setLng(12.4);

        address.setCity(randomStringGenerator());
        address.setStreet(randomStringGenerator());
        address.setZipcode(randomStringGenerator());
        address.setGeo(geo);
        address.setSuite(randomStringGenerator());

        company.setBs(randomStringGenerator());
        company.setCatchPhrase(randomStringGenerator());
        company.setName(randomStringGenerator());

        user.setEmail(randomStringGenerator());
        user.setName(randomStringGenerator());
        user.setPhone(randomStringGenerator());
        user.setUsername(randomStringGenerator());
        user.setWebsite(randomStringGenerator());
        user.setAddress(address);
        user.setCompany(company);
        return user;
    }
}
