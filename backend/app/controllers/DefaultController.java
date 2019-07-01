package controllers;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import flexjson.JSONSerializer;
import play.Play;
import play.libs.Time;
import play.mvc.Controller;

import java.io.File;
import java.io.IOException;
import java.util.Collection;


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

	protected static boolean isPublicResource() {
		return request.path.indexOf(Play.configuration.getProperty("authentication.url.public")) != -1;
	}

	protected static boolean isExternalResource() {
		return request.path.indexOf(Play.configuration.getProperty("authentication.url.external")) != -1;
	}

	protected static void setCache(String expiration) {
		Integer seconds = Time.parseDuration(expiration);
		//response.setHeader("Cache-Control", "max-age="+seconds);
        response.setHeader("Cache-Control","");
	}
	
	/**
	 * Renderiza um JSON utilizando o serializador informado.
	 */
    protected static void renderJSON(Object model, JSONSerializer js) {

    	String json = js.serialize(model);

		renderJSON(json);
    }
    
    protected static void renderJSON(Object model) {

    	renderJSON(gson.toJson(model));
    }

    /*
	 * Renderiza um JSON utilizando o serializador informado.
	 */
    protected static void renderJSON(Collection<Object> models, JSONSerializer js) {

    	String json = js.serialize(models);

		renderJSON(json);
    }
    
    /**
     * Caso algum dos objetos passados como parâmetro forem null, retorna 404.
     */
    protected static void returnIfNotFound(Object model, Object ... models) {
		
		if (model == null) {
			
			response.status = 404;

		    renderText("O id informado não foi encontrado.");
		}
		
		if (models != null && models.length > 0) {

		    for (int i = 0; i < models.length; i++) {

		        if (models[i] == null) {

		        	response.status = 404;

				    renderText("O id informado não foi encontrado.");
		        }
		    }
		}
	}
    
    protected static void returnIfNull(Object model, String tipo, Object ... models) {

    	if (model == null) {
            renderError("É necessário informar um objeto do tipo " + tipo);
        }
        
        if (models != null && models.length > 0) {
         
            for (int i = 0; i < models.length; i++) {
            
                if (models[i] == null) {
                        renderError("O id informado não foi encontrado.");
                        return;
                }
            }
        }

    }

    protected static void renderError(String ... messages) {

    	StringBuilder sb = new StringBuilder();

    	for (int i = 0; i < messages.length; i++) {

    		sb.append(messages[i]);

    		if (i != messages.length - 1) {

    			sb.append(";");
    		}
    	}

    	error(sb.toString());

    }
    
    protected static void renderFile(File file) throws IOException {
		
		if(file != null && (file.exists() || file.getAbsoluteFile().exists())) {

			String path = file.getAbsolutePath();

			renderBinary(file.getAbsoluteFile(), file.getName());
		}

	}

    protected static void renderFile(String nomeFile, String pathFile) throws IOException {
		
		File file = new File(pathFile);
		
		file.createNewFile();
		
		if(file.exists() || file.getAbsoluteFile().exists()) {

			response.setHeader("Content-Disposition", "attachment; filename=" + nomeFile);
			response.setHeader("Content-Transfer-Encoding", "binary");
			response.setHeader("Content-Type", "application/download");

			renderBinary(file);
		}
	}
    
    protected static void renderImage(String pathFile) throws IOException {
		
		File file = new File(pathFile);
		
		file.createNewFile();
		
		if(file.exists() || file.getAbsoluteFile().exists()) {

			response.setHeader("Cache-Control","");
			response.setHeader("Content-Type", "image/jpg");

			renderBinary(file);
		}
	}

}
