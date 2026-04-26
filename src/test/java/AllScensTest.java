import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;

@Suite
@SelectClasses({
        Scen1.class,
        Scen2.class,
        Scen3.class
})
public class AllScensTest {
}