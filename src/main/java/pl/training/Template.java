package pl.training;

import java.util.Map;

public class Template {

    private String textWithExpressions;

    public Template(String textWithExpressions) {
        this.textWithExpressions = textWithExpressions;
    }

    public String evaluate(Map<String, String> parameters) {
        for (Map.Entry<String, String> parameter : parameters.entrySet()) {
            textWithExpressions = textWithExpressions.replaceAll("\\$\\{" + parameter.getKey() + "\\}", parameter.getValue());
        }
        return textWithExpressions;
    }

}
