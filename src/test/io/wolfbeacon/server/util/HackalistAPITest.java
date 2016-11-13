package io.wolfbeacon.server.util;

import io.wolfbeacon.server.dao.HackathonDAO;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.net.URL;
import java.net.URLConnection;

/**
 * Created by bholagabbar on 9/11/16.
 */
public class HackalistAPITest {

    @Autowired
    HackathonDAO hackathonDAO;

    @Test
    public void checkIfAPIFetchAndParseIsWorking() throws Exception {
        HackalistAPI hackalistAPI = new HackalistAPI();
//        hackalistAPI.updateHackalistHackathonData();
    }

    @Test
    public void testFacebookImageFetch() throws Exception {
        String facebookLink = "https://www.facebook.com/wellesleyhack/";
        if (facebookLink.contains("https://www.")) {
            facebookLink = facebookLink.replace("https://www.", "https://graph.");
        } else if (facebookLink.contains("https://facebook")) {
            facebookLink = facebookLink.replace("https://facebook", "https://graph.facebook");
        }
        String toAppend = "";
        if (facebookLink.charAt(facebookLink.length() - 1) != '/') {
            toAppend += "/";
        }
        toAppend += "picture?type=normal";
        facebookLink += toAppend;
        URLConnection con = new URL(facebookLink).openConnection();
        con.connect();
        con.getInputStream();
        facebookLink = con.getURL().toString();
        //System.out.println(facebookLink);
    }

    @Test
    public void testTwitterImageFetch() throws Exception {
        String twitterLink = "https://twitter.com/HackerEarth/";
        //returns a redirected URL directly to the image
        if (twitterLink.charAt(twitterLink.length() - 1) != '/') {
            twitterLink += "/";
        }
        twitterLink = twitterLink + "profile_image?size=normal";
        URLConnection con = new URL(twitterLink).openConnection();
        con.connect();
        con.getInputStream();
        twitterLink = con.getURL().toString();
        //System.out.println(twitterLink);
    }

}