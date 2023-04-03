package IntrumTask.clients;

import IntrumTask.helpers.TestCaseContext;
import com.opencsv.exceptions.CsvValidationException;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.JSONObject;
import com.opencsv.CSVReader;
import java.io.FileReader;
import java.io.IOException;

import static IntrumTask.constants.ProjectConstants.API_TOKEN;
import static IntrumTask.helpers.HelperMethods.extractIds;
import static IntrumTask.helpers.TestCaseContext.id_values;

public class GoRestClients {

    private static RequestSpecification goRestSpec(){
        return RestAssured
                .given().log().all()
                .header("Authorization", API_TOKEN)
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON);
    }



    public static void createUsersFromCSV(String csv_filepath) throws IOException, CsvValidationException {
        CSVReader reader = new CSVReader(new FileReader(csv_filepath));
        String[] nextLine;
        while ((nextLine = reader.readNext()) != null) {
            JSONObject requestBody = new JSONObject();
            requestBody.put("name", nextLine[0]);
            requestBody.put("gender", nextLine[1]);
            requestBody.put("email", nextLine[2]);
            requestBody.put("status", nextLine[3]);

            RestAssured
                    .given(goRestSpec())
                    .body(requestBody.toString())
                    .when()
                    .post("https://gorest.co.in/public/v2/users")
                    .then().log().all()
                    .statusCode(201);
        }
    }

    public static Response getAllUsers(){
        return RestAssured
                .given(goRestSpec())
                .when()
                .get("https://gorest.co.in/public/v2/users")
                .then().log().all()
                .statusCode(200)
                .extract().response();
    }

    public static Response getUser(String id){
        return RestAssured
                .given(goRestSpec())
                .when()
                .get("https://gorest.co.in/public/v2/users/" + id)
                .then().log().all()
                .statusCode(200)
                .extract().response();
    }


    public static Response updateUserDetails(String key, String value) {
        String userId = String.valueOf(TestCaseContext.random_id);
        String endpoint = "https://gorest.co.in/public/v2/users/" + userId;
        return RestAssured
                .given(goRestSpec())
                .when()
                .queryParam(key, value)
                .patch(endpoint)
                .then()
                .log()
                .all()
                .statusCode(200)
                .extract().response();
    }




    public static void deleteUser(String id){
        RestAssured
            .given(goRestSpec())
            .when()
            .delete("https://gorest.co.in/public/v2/users/" + id)
            .then().log().all()
            .statusCode(204)
            .extract().response();
    }

    public static void deleteAllUsers(){
        Response response = getAllUsers();
        extractIds(response);
        for (int i = 0; i < TestCaseContext.id_values.size(); i++) {
            String userId = String.valueOf(TestCaseContext.id_values.get(i));
            deleteUser(userId);
        }
    }


}
