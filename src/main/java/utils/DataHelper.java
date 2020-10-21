package utils;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Data;
import lombok.Getter;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DataHelper {

    @JsonProperty("id")
    String id;

    @JsonProperty("searchKey")
    String searchKey;


    public static List<DataHelper> get(String fileName) throws JsonParseException, JsonMappingException, IOException {
        ObjectMapper mapper = new ObjectMapper();
        List<DataHelper> dataHelpers = new ArrayList<>();
        return Arrays.asList(mapper.readValue(new File(fileName), DataHelper[].class));
    }

    public static DataHelper get(String fileName, String id) {
        try{
            List<DataHelper> list = get(fileName);
            return list.stream().filter(
                    el -> el.getId().equals(id)).findAny().orElse(null);
        }catch (Exception e){
            return null;
        }
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSearchKey() {
        return searchKey;
    }

    public void setSearchKey(String searchKey) {
        this.searchKey = searchKey;
    }
}
