package IntrumTask.stepdefinitions;
import IntrumTask.domain.Users;
import com.opencsv.exceptions.CsvValidationException;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.response.Response;
import IntrumTask.helpers.TestCaseContext;
import org.assertj.core.api.Assertions;
import org.json.JSONObject;

import java.io.IOException;
import java.util.Map;

import static IntrumTask.clients.GoRestClients.*;
import static IntrumTask.constants.ProjectConstants.CSV_FILE_PATH;
import static IntrumTask.helpers.HelperMethods.*;

public class GoRestSteps {

    @Given("Create new users from file")
    public void createNewUsers() throws CsvValidationException, IOException {
        createUsersFromCSV(CSV_FILE_PATH);

        TestCaseContext.getScenario().log("Users have been successfully created");
    }


    @Given("All users is listed")
    public void allUsersIsListed() {
        Response response = getAllUsers();
        extractIds(response);

        TestCaseContext.getScenario().log("Users have successfully listed and all users id's have retrieved");
    }

    @Given("Get user details")
    public void getUserDetails(){
        TestCaseContext.random_id = getRandomId(TestCaseContext.id_values);
        String userId = String.valueOf(TestCaseContext.random_id);
        Response response = getUser(userId);

        Users user = response.as(Users.class);
        TestCaseContext.setUsers(user);

        System.out.println("ID IS: " + TestCaseContext.getUsers().getId());

        TestCaseContext.getScenario().log("User name is " + user.getName() + " and user email is " + user.getEmail());
    }

    @Given("Change user {string} to {string}")
    public void changeUserDetails(String key, String value){
        Response response = updateUserDetails(key, value);
        Users user = response.as(Users.class);

        Assertions.assertThat(user.getName())
                .as("We assert that the user " + key +" is correct")
                .isEqualTo(value);

        TestCaseContext.getScenario().log("User name was successfully changed to " + user.getName());
    }


    @Given("Delete user with updated details")
    public void removeUser(){
        String userId = String.valueOf(TestCaseContext.random_id);
        deleteUser(userId);
        TestCaseContext.getScenario().log("User was successfully deleted");
    }


}
