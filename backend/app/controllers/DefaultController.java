package controllers;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import play.mvc.Controller;

public class DefaultController extends Controller {

    protected static Gson gson;

    public DefaultController() {

        super();
    }

    static {

        GsonBuilder builder = new GsonBuilder()
                .setDateFormat("dd/MM/yyyy HH:mm:ss")
                .serializeSpecialFloatingPointValues();

        gson = builder.create();
    }
}
