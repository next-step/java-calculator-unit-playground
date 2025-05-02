package stringCalc;

public class DelimiterAndBodyInfo {
    private String customDelimiter;
    private String body;

    public DelimiterAndBodyInfo(String delimiter, String body) {
        this.customDelimiter = delimiter;
        this.body = body;
    }

    public String getDelimiter(){
        return customDelimiter;
    }

    public String getBody(){
        return body;
    }
}
