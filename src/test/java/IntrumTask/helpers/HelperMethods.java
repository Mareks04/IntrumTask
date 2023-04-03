package IntrumTask.helpers;

import io.restassured.response.Response;
import org.json.JSONArray;
import org.json.JSONObject;


import java.util.List;
import java.util.Random;

public class HelperMethods {
    public static void extractIds(Response obj) {
        JSONArray jsonArray = new JSONArray(obj.asString());

        for (int i = 0; i < jsonArray.length(); i++) {
          JSONObject jsonObject = jsonArray.getJSONObject(i);
          int id = jsonObject.getInt("id");
          String userId = String.valueOf(id);
          TestCaseContext.id_values.add(userId);
        }
    }

    public static String getRandomId(List<String> stringList) {
        Random rand = new Random();
        int randomIndex = rand.nextInt(stringList.size());
        return stringList.get(randomIndex);
    }
}
