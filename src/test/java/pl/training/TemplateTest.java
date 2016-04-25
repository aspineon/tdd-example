package pl.training;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

public class TemplateTest {

    private Template template = new Template("My name is ${firstName} ${lastName}");
    private Map<String, String> parameters = new HashMap<>();

    @Before
    public void init() {
        parameters.put("firstName", "John");
        parameters.put("lastName", "Smith");
    }

    @Test
    public void shouldEvaluateTextWithExpressions() {
        assertEquals(template.evaluate(parameters), "My name is John Smith");
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowExceptionWhenParameterIsMissing() {
        template.evaluate(new HashMap<>());
    }

}
