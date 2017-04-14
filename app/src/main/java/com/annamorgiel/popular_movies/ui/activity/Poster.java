package com.annamorgiel.popular_movies.ui.activity;

import java.net.URL;

/**
 * Created by Anna Morgiel on 14.04.2017.
 * Combining these three parts gives us a final url of:
 * http://image.tmdb.org/t/p/w185//nBNZadXqJSdt05SHLqgT0HuC5Gm.jpg
 */

public class Poster {


    //The base URL will look like: http://image.tmdb.org/t/p/.
    private URL url = null;
    private String url_string = url.toString();
    //recommend using “w185”.
    private final String size = "w185";
    //the poster path returned by the query, in this case “/nBNZadXqJSdt05SHLqgT0HuC5Gm.jpg”
    private String path = null;
}
