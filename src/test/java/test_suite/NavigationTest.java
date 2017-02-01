package test_suite;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.automation.ui.model.Navigation;

/**
 * Created by Micro on 1/31/2017.
 */
public class NavigationTest {

    @Test(groups = { "navigation" })
    public void testTranslate() throws Exception {
        Navigation navigation = new Navigation();
        Assert.assertEquals(navigation.navigate("Orange", 1), 10);
        Assert.assertEquals(navigation.navigate("Orange", 2), 10);
        Assert.assertEquals(navigation.navigate("Orange", 10), 10);

    }


}