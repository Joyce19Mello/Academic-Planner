package utils;

import play.Play;

import java.util.Date;
import java.util.Locale;

public class GlobalReferences {

    public static final String DIRETORIO_BASE = Play.configuration.getProperty("sistema.diretorioBase");

    public static final String BASE_URL = Play.configuration.getProperty("sistema.baseUrl");

    public static final Integer TAMANHO_PAGINA = Integer.parseInt(Play.configuration.getProperty("filtros.tamanhoPagina"));

    public static final String PATH_PDF = Play.configuration.getProperty("path.arquivos.pdf");

    public static final String PATH_ARQUIVOS = Play.configuration.getProperty("path.arquivos.upload");

    public static final Locale LOCALE_PT_BR = new Locale("pt", "BR");

    public static final String APPLICATION_TEMP_FOLDER = Play.applicationPath + "/tmp/";

    public static final String GOOGLE_API_DIRECTIONS_KEY = Play.configuration.getProperty("google.api.directions.key");

}
