package stringCalc;

import java.util.Objects;

public class ExtractedDelimiterAndBody {
    private String customDelimiter;
    private String body;

    public ExtractedDelimiterAndBody(String delimiter, String body) {
        this.customDelimiter = delimiter;
        this.body = body;
    }

    public String getDelimiter(){
        return customDelimiter;
    }

    public String getBody(){
        return body;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ExtractedDelimiterAndBody that = (ExtractedDelimiterAndBody) o;
        return Objects.equals(customDelimiter, that.customDelimiter) &&
                Objects.equals(body, that.body);
    }

    @Override
    public int hashCode() {
        return Objects.hash(customDelimiter, body);
    }



}
