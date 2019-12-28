package hw6.setting;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import hw2.auth.AuthData;
import hw5.generator.json_generator.Folder;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;

public class JsonSettings {

    public static AuthData getUser() throws FileNotFoundException {
        BufferedReader br = new BufferedReader(new FileReader("settings.json"));
        Gson gson = new Gson();

        List<AuthData> data = gson.fromJson(br, new TypeToken<List<AuthData>>(){}.getType());
        return data.get(0);
    }
}
