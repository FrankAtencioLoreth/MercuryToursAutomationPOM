package runner;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import test.LoginTest;
import test.RegisterTest;

@RunWith(Suite.class)
@Suite.SuiteClasses({
    LoginTest.class,
    RegisterTest.class
})
public class Runner {
}
