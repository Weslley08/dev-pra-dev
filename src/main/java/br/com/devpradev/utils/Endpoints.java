package br.com.devpradev.utils;

public abstract class Endpoints {

    private Endpoints() {
    }

    public static final String CROSS_ORIGINS_FRONT = "https://weslley08.github.io/dev-pra-dev-front/";

    /* ENDPOINTS POST */
    public static final String REQUEST_POST = "api/blog/post";
    public static final String REQUEST_POST_CREATE = "/create";
    public static final String REQUEST_POST_FIND_BY_ID = "/{id}";
    public static final String REQUEST_POST_UPDATE = "/update/{id}";
    public static final String REQUEST_POST_DELETE = "/delete/{id}";

    /* ENDPOINTS PESSOA */
    public static final String REQUEST_PESSOA = "api/blog/pessoa";
    public static final String REQUEST_PESSOA_CREATE = "/create";
    public static final String REQUEST_PESSOA_FIND_BY_ID = "/{id}";
    public static final String REQUEST_PESSOA_UPDATE = "/update/{id}";
    public static final String REQUEST_PESSOA_DELETE = "/delete/{id}";

    /* ENDPOINTS USUARIO */
    public static final String REQUEST_USUARIO = "api/blog/usuario";
    public static final String REQUEST_USUARIO_CREATE = "/create";
    public static final String REQUEST_USUARIO_FIND_BY_ID = "/{id}";
    public static final String REQUEST_USUARIO_UPDATE = "/update/{id}";
    public static final String REQUEST_USUARIO_DELETE = "/delete/{id}";


}
