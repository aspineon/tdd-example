package pl.training;

import java.util.Map;

public class Template {

    private static final String EXPRESSION_START = "\\$\\{";
    private static final String EXPRESSION_END = "\\}";

    private String textWithExpressions;

    public Template(String textWithExpressions) {
        this.textWithExpressions = textWithExpressions;
    }

    public String evaluate(Map<String, String> parameters) {
        String result = textWithExpressions;
        for (Map.Entry<String, String> parameter : parameters.entrySet()) {
            result  = result.replaceAll(createExpression(parameter.getKey()), parameter.getValue());
        }
        return result;
    }

    private String createExpression(String parameterName) {
        return EXPRESSION_START + parameterName + EXPRESSION_END;
    }

}
