package IntrumTask.helpers;

import io.cucumber.java.Scenario;
import java.util.ArrayList;
import java.util.List;

public class TestCaseContext {

    public static List<String> id_values = new ArrayList<>();

    public static List<String> new_users_id_values = new ArrayList<>();


    public static String random_id;

    private static Scenario scenario;

    public static void setScenario(Scenario scenario) {
        TestCaseContext.scenario = scenario;
    }

    public static Scenario getScenario() {
        return scenario;
    }
}

