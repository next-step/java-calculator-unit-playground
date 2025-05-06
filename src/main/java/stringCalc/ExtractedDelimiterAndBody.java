package stringCalc;

public class ExtractedDelimiterAndContent {
    private String customDelimiter;
    private String content;

    public ExtractedDelimiterAndContent(String delimiter, String content) {
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
