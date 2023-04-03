package IntrumTask.helpers;

import IntrumTask.domain.Users;
import io.cucumber.java.Scenario;
import java.util.ArrayList;
import java.util.List;

public class TestCaseContext {

    public static List<Integer> id_values = new ArrayList<>();

    public static int random_id;

    private static Users users;
    private static Scenario scenario;

    public static void init() {
        users = null;
    }

    public static void setUsers(Users users) {
        TestCaseContext.users = users;
    }

    public static Users getUsers() {
        return users;
    }

    public static void setScenario(Scenario scenario) {
        TestCaseContext.scenario = scenario;
    }

    public static Scenario getScenario() {
        return scenario;
    }
}

