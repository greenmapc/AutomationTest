package hw6.json_generator;


import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import lombok.SneakyThrows;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class JsonGenerator {

    @SneakyThrows
    public static void jsonGeneration() {

        List<Folder> folderList = new ArrayList<Folder>();

        for (int i = 0; i < 3;  i ++) {
            folderList.add(new Folder(UUID.randomUUID().toString()));
        }

        Gson gson = new Gson();
        String json = gson.toJson(folderList);

        FileWriter fileWriter = new FileWriter("generationData.json");
        fileWriter.write(json);
        fileWriter.flush();
    }


    @SneakyThrows
    public static List<Folder> folderDeserializer() {
        BufferedReader br = new BufferedReader(new FileReader("generationData.json"));
        Gson gson = new Gson();

        return gson.fromJson(br, new TypeToken<List<Folder>>(){}.getType());
    }
}
