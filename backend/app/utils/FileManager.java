package utils;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import play.Logger;
import play.Play;
import play.i18n.Messages;
import play.libs.Files;

import java.io.*;
import java.util.*;

public class FileManager {

    private static final String FILE_KEY_SEPARATOR = "_";
    private static final String TEMP_FILES_FOLDER_PATH = GlobalReferences.APPLICATION_TEMP_FOLDER;
    private static final long TAMANHO_MAX_ARQUIVO = Long.valueOf(Play.configuration.getProperty("sistema.constTamanhoMaximoArquivoUpload"));

    private static FileManager instance;

    public static FileManager getInstance() {

        if (instance == null) {
            instance = new FileManager();
        }

        return instance;
    }

    private FileManager() {

        if (TEMP_FILES_FOLDER_PATH == null || TEMP_FILES_FOLDER_PATH.trim().equals("")) {

            throw new IllegalStateException("Error to initialize FileManager, the temporary folder was not set.");
        }

        File tempFileFolder = new File(TEMP_FILES_FOLDER_PATH);

        if (!tempFileFolder.exists()) {
            throw new IllegalStateException("Error to initialize FileManager, the temporary folder was not found: " + TEMP_FILES_FOLDER_PATH);
        }

        if (!tempFileFolder.isDirectory()) {
            throw new IllegalStateException("Error to initialize FileManager, the temporary folder path was not a directory: " + TEMP_FILES_FOLDER_PATH);
        }

        if (!tempFileFolder.canWrite()) {
            throw new IllegalStateException("Error to initialize FileManager, write privilegies is missing in the temporary folder: " + TEMP_FILES_FOLDER_PATH);
        }
    }

    public File getTempFilesFolder() {

        return new File(TEMP_FILES_FOLDER_PATH);
    }

    public String createFile(String pathFileGenerated, byte [] fileBytes, String extension) throws IOException {

        String fileName = generateFileName(extension);

        File file = new File(pathFileGenerated, fileName);

        writeFile(file, fileBytes);

        return removerExtension(fileName);
    }

    public String createFile(byte [] fileBytes, String extension) throws IOException {

        String fileName = generateFileName(extension);
        String folderName = getFolderName();

        File file = new File(TEMP_FILES_FOLDER_PATH + folderName, fileName);

        writeFile(file, fileBytes);

        return generateFileKey(fileName, folderName);
    }

    private void writeFile(File file, byte[] fileBytes) throws IOException {

        BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(file));
        stream.write(fileBytes);
        stream.close();
    }

    public File createFile(String filename) {

        return new File(TEMP_FILES_FOLDER_PATH + filename);
    }

    public String removerExtension(String fileName) {

        return fileName.substring(0, fileName.lastIndexOf("."));
    }

    public File getFile(String fileKey, String diretorio) {

        String fileName = getFileNameByKey(fileKey);
        String folderName = getFolderNameByKey(fileKey, diretorio);

        if (fileName == null || folderName == null) {
            return null;
        }

        File file = new File (folderName, fileName);

        if (file.exists()) {
            return file;
        }

        return null;
    }

    public byte [] getFileBytes(String fileKey) {

        try {

            String diretorio = GlobalReferences.APPLICATION_TEMP_FOLDER;

            File file = getFile(fileKey,diretorio);

            if (file != null) {
                return getFileBytes(file);
            } else {
                return null;
            }

        } catch (IOException ex) {
            throw new RuntimeException (ex);
        }
    }

    public void deleteFile(String fileKey) {

        String diretorio = GlobalReferences.APPLICATION_TEMP_FOLDER;

        File file = getFile(fileKey,diretorio);

        if (file != null && file.exists()) {
            file.delete();
        }
    }

    public Map<String,File> createEmptyFiles(int numberOfFiles, String extension) throws IOException {

        if (numberOfFiles > 0) {

            String folderName = getFolderName();

            Map<String, File> files = new HashMap<String, File>();

            for (int i = 0; i < numberOfFiles; i++) {

                String fileName = generateFileName(extension);
                File file = new File(TEMP_FILES_FOLDER_PATH + folderName, fileName);

                files.put(generateFileKey(fileName, folderName), file);
            }

            return files;

        }

        return null;
    }

    private String generateFileKey(String fileName, String folderName) {
        return folderName + FILE_KEY_SEPARATOR + fileName;
    }

    public String getFileNameByKey(String key) {

        try {
            return key.substring(key.indexOf(FILE_KEY_SEPARATOR) + FILE_KEY_SEPARATOR.length());
        } catch (Exception e) {
            return null;
        }
    }

    private String getFolderNameByKey(String key, String diretorio) {

        try {
            return diretorio + key.substring(0, key.indexOf(FILE_KEY_SEPARATOR));
        } catch (Exception e) {
            return null;
        }
    }

    public File getFolderByKey(String key) {

        try {
            return new File(TEMP_FILES_FOLDER_PATH + key.substring(0, key.indexOf(FILE_KEY_SEPARATOR)));
        } catch (Exception e) {
            return null;
        }
    }

    public String generateFileName(String extension) {

        return UUID.randomUUID().toString() + ((extension != null) ? "." + extension : "");
    }

    public String getFolderName() throws IOException {

        String folderName = UUID.randomUUID().toString();
        File folder = new File(TEMP_FILES_FOLDER_PATH + folderName);

        this.createFolderIfNotExists(folder);

        return folderName;
    }

    private void createFolderIfNotExists(File folder) throws IOException {

        if (!folder.exists() && !folder.mkdir()) {
            throw new IOException("Não foi possível criar a pasta temporária.");
        }
    }

    public void cleanUpTemporaryFiles(String folderPath, long prazo) throws IOException {

        File tempFolder = new File(folderPath);

        Logger.info("Apagando arquivos da pasta : " + folderPath);
        if (tempFolder != null && tempFolder.exists() && tempFolder.isDirectory()) {

            Date current = new Date();
            Date lastModified = null;

            for (File file : tempFolder.listFiles()) {

                lastModified = new Date(file.lastModified());
                long diffInDays = ((current.getTime() - lastModified.getTime()) / (1000 * 60 * 60 * 24));

                if (diffInDays >= prazo) {

                    if (file.isDirectory()) {
                        Files.deleteDirectory(file);
                    } else {
                        Files.delete(file);
                    }
                }
            }
        }
    }

    public void copyFile(File origem, File destino) throws IOException  {

        if (!origem.exists()) {
            throw new FileNotFoundException("Arquivo de origem não existe: " + origem);
        }

        InputStream in = new FileInputStream(origem);

        OutputStream out = new FileOutputStream(destino);

        byte[] buf = new byte[1024];
        int len;

        while ((len = in.read(buf)) > 0) {
            out.write(buf, 0, len);
        }

        in.close();
        out.close();
    }

    public byte [] getFileBytes(File file) throws IOException {

        ByteArrayOutputStream ous = null;
        InputStream ios = null;

        try {

            byte [] buffer = new byte[4096];
            ous = new ByteArrayOutputStream();
            ios = new FileInputStream(file);
            int read = 0;

            while ( (read = ios.read(buffer)) != -1 ) {
                ous.write(buffer, 0, read);
            }

        } finally {

            try {

                if (ous != null) {
                    ous.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

            try {

                if (ios != null) {
                    ios.close();
                }
            } catch ( IOException e) {
                e.printStackTrace();
            }
        }

        return ous.toByteArray();
    }

    public String getFileExtention(String completeName) {

        int dotIndex = completeName.lastIndexOf(".");

        if (dotIndex > 0) {

            return completeName.substring(dotIndex + 1);

        } else {

            return "";
        }
    }

    public boolean validateExtention(String completeName, String ... validFormats) {

        String extention = getFileExtention(completeName);

        if (extention != null && !extention.isEmpty()) {

            for (String validFormat : validFormats) {

                if (extention.equalsIgnoreCase(validFormat))
                    return true;
            }
        }

        return false;
    }

    public InputStream byteArrayToInputStream(byte[] dados){

        if (dados == null)
            throw new RuntimeException(Messages.get("erro.upload.documento"));

        InputStream is = new ByteArrayInputStream(dados);

        return is;
    }

    public static File moveFileToDir(String pathArquivo, String diretorioMover) throws IOException {

        File filePath = new File(pathArquivo);

        String nomeArquivo = Calendar.getInstance().getTimeInMillis() + "." + FilenameUtils.getExtension(filePath.getPath());

        File diretorioFinal = new File(diretorioMover);

        if(!diretorioFinal.exists())
            diretorioFinal.mkdirs();

        File fileFinal = new File(diretorioFinal.getPath() + File.separator + nomeArquivo);

        FileUtils.moveFile(filePath, fileFinal);

        return fileFinal;

    }

    public static boolean validaArquivo(File file){
        ArrayList<String> extensoes = new ArrayList<String>();
        extensoes.add("png");
        extensoes.add("jpg");
        extensoes.add("jpeg");
        extensoes.add("pdf");

        if(file.length() < TAMANHO_MAX_ARQUIVO && extensoes.contains(FilenameUtils.getExtension(file.getPath()))){
            System.out.println(FilenameUtils.getExtension(file.getPath()));
            return true;
        }
        return false;
    }

}
