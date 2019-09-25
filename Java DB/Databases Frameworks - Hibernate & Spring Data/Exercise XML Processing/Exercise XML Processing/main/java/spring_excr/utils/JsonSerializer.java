package spring_excr.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import org.springframework.stereotype.Component;

import java.io.*;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class JsonSerializer  {

    private Gson gson;

    private FileIO fileIO;


    public JsonSerializer() {
        gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().setPrettyPrinting().create();

        fileIO = new FileIO();
    }

    public <T> void serializeList(List<T> t, String fileName) throws Exception {
        Type type = new TypeToken<List<T>>() {}.getType();

        String json = this.gson.toJson(t, type);

        writeFileJson(json, fileName);
    }


    public <T> void serialize(T t, String fileName) throws Exception {

        String json = gson.toJson(t);
        writeFileJson(json, fileName);
    }

    public <T> T deserialize(Class<T> classObj, String fileName) throws Exception {

        try {
            String json = fileIO.read(fileName);
            return gson.fromJson(json, classObj);
        } catch (IOException e) {
            e.printStackTrace();
            throw new Exception(fileName + " cannot be read and nothing is deserialized to " + fileName + ".\n" + "Message: " + e.getMessage() + ".\n" + " Cause: " + e.getCause() + ".\n", e);
        }

    }


    public <T> List<T> importJsonList(Class<T> classObj, String fileName) throws IOException {
        Type type = new TypeToken<ArrayList<T>>() {
        }.getType();
        String json = this.fileIO.read(fileName);
        return this.gson.fromJson(json, type);
    }



    public void writeFileJson(String json, String fileName) throws Exception {

        String path = System.getProperty("user.dir") + File.separator + fileName;
        File f = new File(path);
        if (!f.exists()) {
            f.getParentFile().mkdirs();
            try {
                f.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        try (OutputStream os = new FileOutputStream(fileName); BufferedWriter bfw = new BufferedWriter(new OutputStreamWriter(os))) {

            bfw.write(json);
            bfw.flush();

        } catch (IOException e) {
            e.printStackTrace();
            throw new Exception(json + " was not serialized to " + fileName + ".\n" + "Message: " + e.getMessage() + ".\n" + " Cause: " + e.getCause() + ".\n");
        }
    }



    public String readFileJson(String fileName) throws IOException {
        StringBuilder fileContent = new StringBuilder();
        try (
                InputStream is = getClass().getResourceAsStream(fileName);
                BufferedReader bfr = new BufferedReader(new InputStreamReader(is))
        ) {
            String line = null;
            while ((line = bfr.readLine()) != null) {
                fileContent.append(line);
            }
        }

        return fileContent.toString();
    }


}
