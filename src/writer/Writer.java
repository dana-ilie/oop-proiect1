package writer;

import com.fasterxml.jackson.databind.ObjectMapper;
import database.Database;
import interfaces.IChild;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class Writer {
    private final FileWriter file;

    public Writer(final String path) throws IOException {
        this.file = new FileWriter(path);
    }

    public void writeFile(Database database) throws IOException {
        annualChildren annualChildren = new annualChildren();
        for (List<IChild> childrenList : database.getResultsList()) {
            children children = new children(childrenList);
            annualChildren.getAnnualChildren().add(children);
        }
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.writerWithDefaultPrettyPrinter().writeValue(file, annualChildren);
    }

}
