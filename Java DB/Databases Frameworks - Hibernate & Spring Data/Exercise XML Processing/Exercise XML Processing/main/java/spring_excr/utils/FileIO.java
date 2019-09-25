package spring_excr.utils;

import org.springframework.stereotype.Component;

import java.io.*;

@Component
public class FileIO {

    public String read(String fileName) throws IOException {
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


    public void write(String content, String fileName) throws FileNotFoundException {
        OutputStream os = new FileOutputStream(fileName);
        try  {
            BufferedWriter bfw = new BufferedWriter(new OutputStreamWriter(os));
            bfw.write(content);

        } catch (IOException e) {
            e.printStackTrace();
        } finally{
            try {
                os.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }





    }


    public void writeFile(String fileName, String content) throws IOException {
        String path = System.getProperty("user.dir") + fileName;
        File f = new File(path);
        if(!f.exists()) {
            f.getParentFile().mkdirs();
            f.createNewFile();
        }
        try (OutputStream os = new FileOutputStream(fileName);
             BufferedWriter bfw = new BufferedWriter(new OutputStreamWriter(os))
        ) {
            bfw.write(String.valueOf(content));
        }
    }



}