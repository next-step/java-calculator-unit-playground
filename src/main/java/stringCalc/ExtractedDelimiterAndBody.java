package stringCalc;

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
}
