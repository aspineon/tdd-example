package pl.training;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class TemplateTest {

    @Test
    public void shouldEvaluateTextWithExpressions() {
        Map<String, String> parameters = new HashMap<>();
        parameters.put("firstName", "John");
        parameters.put("lastName", "Smith");

        Template template = new Template("My name is ${firstName} ${lastName}");
        Assert.assertEquals("My name is John Smith", template.evaluate(parameters));
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowExceptionWhenParameterIsMissing() {
        new Template("My name is ${firstName} ${lastName}").evaluate(new HashMap<>());
    }

}
