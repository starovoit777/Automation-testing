package test_suite;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.automation.ui.model.GoogleTranslate;

/**
 * Created by Micro on 1/31/2017.
 */
public class GoogleTranslateTest {
    String queryForTranslation = "Apple";
    String translationResult = "Apfel";

    @Test(groups = { "translate" })
    public void testTranslate() throws Exception {
        GoogleTranslate googleTranslate = new GoogleTranslate();
        Assert.assertEquals(googleTranslate.translate(queryForTranslation) , translationResult);
    }

}