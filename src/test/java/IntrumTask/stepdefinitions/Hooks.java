package IntrumTask.stepdefinitions;

import IntrumTask.helpers.TestCaseContext;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

import static IntrumTask.clients.GoRestClients.deleteAllUsers;

public class Hooks {

    @Before
    public void beforeHook(Scenario scenario){
        TestCaseContext.setScenario(scenario);
        System.out.println("THE SCENARIO HAS STARTED");
    }

    @After
    public void afterHook(){
        System.out.println("THE SCENARIO HAS ENDED");
    }

    @After("@Users")
    public void afterHookForUserRemoval(){
        deleteAllUsers();
    }

}
