package pl.training;

import java.util.Map;

public class Template {

    private static final String EXPRESSION_START = "\\$\\{";
    private static final String EXPRESSION_END = "\\}";
    private static final String EXPRESSION = ".*\\$\\{[^}]+\\}.*";

    private String textWithExpressions;

    public Template(String textWithExpressions) {
        this.textWithExpressions = textWithExpressions;
    }

    public String evaluate(Map<String, String> parameters) {
        String result = substituteParameters(textWithExpressions, parameters);
        validateEvaluatedText(result);
        return result;
    }

    private void validateEvaluatedText(String result) {
        if (result.matches(EXPRESSION)) {
            throw new IllegalArgumentException();
        }
    }

    private String substituteParameters(String textWithExpressions, Map<String, String> parameters) {
        for (Map.Entry<String, String> parameter : parameters.entrySet()) {
            textWithExpressions = textWithExpressions.replaceAll(createExpression(parameter.getKey()), parameter.getValue());
        }
        return textWithExpressions;
    }

    private String createExpression(String parameterName) {
        return EXPRESSION_START + parameterName + EXPRESSION_END;
    }

}
