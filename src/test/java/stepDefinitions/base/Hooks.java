package stepDefinitions.base;

import io.cucumber.java.After;
import io.cucumber.java.Before;

import static drivers.DriverFactory.cleanupDriver;
import static drivers.DriverFactory.getDriver;

public class Hooks {

    @Before
    public void setup() {
        getDriver();
    }

    @Before(value = "@kullanıcıyaadresekle", order = 10)
    public void setup2() {
        System.out.println("kullanıcıyaadresekle");
    }

    @Before(value = "@kullanıcıyıyarat", order = 9)
    public void setup3() {
        System.out.println("kullanıcıyıyarat");

    }

    @After(value = "@kullanıcıadresinisil", order = 10)
    public void setup5() {
        System.out.println("kullanıcıadresinisil");
    }

    @After(value = "@kullanıcıyısil", order = 9)
    public void setup6() {
        System.out.println("kullanıcıyısil");

    }


    @After
    public void closeDriver() {
        cleanupDriver();
    }
}
