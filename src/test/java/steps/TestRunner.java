    package steps;

    import io.cucumber.testng.AbstractTestNGCucumberTests;
    import io.cucumber.testng.CucumberOptions;

    import org.testng.annotations.BeforeMethod;
    import org.testng.annotations.DataProvider;
    import org.testng.annotations.Listeners;
    import org.testng.annotations.Parameters;
    import utils.BrowserContext;

    @CucumberOptions(
            features = "src/test/resources/Parallel",
            glue = {"steps"},
            tags = "@smoke",
            plugin = {"pretty",
                    "html:target/cucumber-reports/cucumber.html",
                    "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm",
                    "com.aventstack.chaintest.plugins.ChainTestCucumberListener:"
            },
            monochrome = true
    )
    public class TestRunner extends AbstractTestNGCucumberTests {
//    //    TheadLocal<String> br
//
        @Parameters("browser")
        @BeforeMethod
        public void setupBrowser(String browserName){
        if (!browserName.isEmpty()){
            BrowserContext.setBrowseName(browserName);
        }
        }

        @Override
        @DataProvider(parallel = true)
        public Object[][] scenarios() {
            return super.scenarios();
        }
    }