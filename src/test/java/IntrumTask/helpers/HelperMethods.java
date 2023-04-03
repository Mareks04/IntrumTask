package IntrumTask.helpers;

import io.restassured.response.Response;
import org.json.JSONArray;
import org.json.JSONObject;


import java.util.List;
import java.util.Map;
import java.util.Random;

public class HelperMethods {
    public static void extractIds(Response obj) {
        JSONArray jsonArray = new JSONArray(obj.asString());

        for (int i = 0; i < jsonArray.length(); i++) {
          JSONObject jsonObject = jsonArray.getJSONObject(i);
          int id = jsonObject.getInt("id");
          TestCaseContext.id_values.add(id);
        }
    }

    public static int getRandomId(List<Integer> intList) {
        Random rand = new Random();
        int randomIndex = rand.nextInt(intList.size());
        return intList.get(randomIndex);
    }
}
