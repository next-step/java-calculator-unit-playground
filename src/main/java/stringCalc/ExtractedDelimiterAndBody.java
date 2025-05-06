package stringCalc;

import java.util.Objects;

public class ExtractedDelimiterAndBody {
    private String customDelimiter;
    private String content;

    public ExtractedDelimiterAndBody(String delimiter, String content) {
        this.customDelimiter = delimiter;
        this.content = content;
    }

    public String getDelimiter(){
        return customDelimiter;
    }

    public String getContent(){
        return content;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ExtractedDelimiterAndBody that = (ExtractedDelimiterAndBody) o;
        return Objects.equals(customDelimiter, that.customDelimiter) &&
                Objects.equals(content, that.content);
    }

    @Override
    public int hashCode() {
        return Objects.hash(customDelimiter, content);
    }



}
