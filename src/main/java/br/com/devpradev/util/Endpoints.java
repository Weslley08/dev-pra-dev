package br.com.devpradev.util;

public abstract class Endpoints {

    Endpoints() {}

    public static final String CROSS_ORIGINS_FRONT = "https://dev-pra-dev-front.herokuapp.com/";

    public static final String REQUEST_POST = "api/blog/request";

    public static final String REQUEST_CREATE = "/create";
    
    public static final String REQUEST_POST_FIND_BY_ID = "/{id}";

    public static final String REQUEST_POST_UPDATE = "/update/{id}";

    public static final String REQUEST_DELETE = "/delete/{id}";
    
}
