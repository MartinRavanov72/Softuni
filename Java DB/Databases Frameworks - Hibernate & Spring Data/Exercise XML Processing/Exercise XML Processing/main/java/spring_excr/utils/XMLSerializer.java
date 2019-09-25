package spring_excr.utils;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

public class XMLSerializer {
    public <T> T importFromFile(Class<T> classObj, String fileName) {
        String path = System.getProperty("user.dir") + fileName;
        try {
            File file = new File(path);
            JAXBContext jaxbContext = JAXBContext.newInstance(classObj);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            T importFromFileDTO = (T) unmarshaller.unmarshal(file);
            return importFromFileDTO;
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return null;
    }

    public <T> void exportToFile(T t, String fileName) {
        JAXBContext jaxbContext = null;
        String path = System.getProperty("user.dir") + fileName;
        try {
            FileWriter writer = new FileWriter(path);
            jaxbContext = JAXBContext.newInstance(t.getClass());
            Marshaller marshaller = jaxbContext.createMarshaller();
            marshaller.marshal(t, writer);
        } catch (JAXBException e) {
            e.printStackTrace();
        }catch(FileNotFoundException e){
            e.printStackTrace();
        }catch(IOException e) {
            e.printStackTrace();
        }
    }
}
