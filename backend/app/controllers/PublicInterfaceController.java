package controllers;

import org.apache.tika.Tika;
import play.data.Upload;
import play.i18n.Messages;
import play.libs.IO;
import utils.FileManager;
import utils.GlobalReferences;

import java.io.File;
import java.io.IOException;

public class PublicInterfaceController extends DefaultController {

	/**
	 * Upload de arquivos, copia o arquivo enviado para uma área temporária
	 * do sistema e gera uma chave de retorno para que seja possível obter o arquivo
	 * quando necessário.
	 * @param file
	 * @throws IOException
	 */
	public static void upload(Upload file) throws IOException {

    	returnIfNotFound(file);

		String realType = null;

		// Detecta o tipo de arquivo pela assinatura (Magic)
		Tika tika = new Tika();
		realType = tika.detect(file.asFile());

		returnIfNotFound(realType);

		// Verifica se a extensão do arquivo é compatível com o tipo detectado,
		// com exceção de arquivos BMP
		if(!realType.contains("bmp") && !file.getContentType().contains("application/octet-stream"))
			if(!realType.contentEquals(file.getContentType()))
				renderError(Messages.get(Messages.get("erro.upload.arquivomodificado")));

		if(realType.contains("application/pdf") ||
				realType.contains("application/zip") ||
				realType.contains("image/jpeg") ||
				realType.contains("image/jpg") ||
				realType.contains("image/png") ||
				realType.contains("bmp")) {

			byte[] data = IO.readContent(file.asFile());
			String extension = FileManager.getInstance().getFileExtention(file.getFileName());
			String key = FileManager.getInstance().createFile(data, extension);

			renderText(key);
		}
		else {

			renderError(Messages.get(Messages.get("erro.upload.documento")));
		}

	}

	/**
	 * Upload de arquivos pdf, copia o arquivo enviado para uma área temporária
	 * do sistema e gera uma chave de retorno para que seja possível obter o arquivo
	 * quando necessário.
	 * @param file
	 * @throws IOException
	 */
	public static void uploadArquivoPdf(Upload file) throws IOException {

		returnIfNotFound(file);

		String realType = null;

		// Detecta o tipo de arquivo pela assinatura (Magic)
		Tika tika = new Tika();
		realType = tika.detect(file.asFile());

		returnIfNotFound(realType);

		// Verifica se a extensão do arquivo é compatível com o tipo detectado,
		// com exceção de arquivos BMP
		if(!realType.contains("bmp") && !file.getContentType().contains("application/octet-stream"))
			if(!realType.contentEquals(file.getContentType()))
				renderError(Messages.get(Messages.get("erro.upload.arquivomodificado")));

		if(realType.contains("application/pdf")) {

			byte[] data = IO.readContent(file.asFile());
			String extension = FileManager.getInstance().getFileExtention(file.getFileName());
			String key = FileManager.getInstance().createFile(data, extension);

			renderText(key);
		}
		else {

			renderError(Messages.get(Messages.get("erro.upload.arquivo.pdf")));
		}

	}

	/**
	 * Upload de arquivos de imagem, copia o arquivo enviado para uma área temporária
	 * do sistema e gera uma chave de retorno para que seja possível obter o arquivo
	 * quando necessário.
	 * @param file
	 * @throws IOException
	 */
	public static void uploadImage(Upload file) throws IOException {

		returnIfNotFound(file);

		String realType = null;

		// Detecta o tipo de arquivo pela assinatura (Magic)
		Tika tika = new Tika();
		realType = tika.detect(file.asFile());

		returnIfNotFound(realType);

		// Verifica se a extensão do arquivo é compatível com o tipo detectado,
		// com exceção de arquivos BMP
		if(!realType.contains("bmp") && !file.getContentType().contains("application/octet-stream"))
			if(!realType.contentEquals(file.getContentType()))
				renderError(Messages.get(Messages.get("erro.upload.arquivomodificado")));

		if(realType.contains("image/jpeg") ||
				realType.contains("image/jpg") ||
				realType.contains("image/png") ||
				realType.contains("bmp")) {

			byte[] data = IO.readContent(file.asFile());
			String extension = FileManager.getInstance().getFileExtention(file.getFileName());
			String key = FileManager.getInstance().createFile(data, extension);
			renderText(key);
		}
		else {

			renderError(Messages.get(Messages.get("erro.upload.image")));
		}

	}

	/**
	 * Download de arquivos enviados enviados pela rota /upload, utiliza o parâmetro key que é
	 * a chave gerada ao realizar o upload.
	 * @param key
	 */
	public static void download(String key) throws IOException {

		returnIfNotFound(key);

		FileManager fileManager = FileManager.getInstance();

		File arquivoTemporario = fileManager.getFile(key, GlobalReferences.APPLICATION_TEMP_FOLDER);

		returnIfNotFound(arquivoTemporario);

		String realType = null;

		// Detecta o tipo de arquivo pela assinatura (Magic)
		Tika tika = new Tika();
		realType = tika.detect(arquivoTemporario);

		// Verifica se o arquivo é do tipo imagem conhecido
		if(realType.contains("image/jpeg") ||
			realType.contains("image/jpg") ||
			realType.contains("image/png") ||
			realType.contains("bmp")) {

			// Imagem
			renderImage(arquivoTemporario.getAbsolutePath());
		}
		else {

			renderFile(arquivoTemporario);
		}

	}
}
