import java.util.List;

public class ExpressionSplitter {

    private final Delimiters delimiters;

    public ExpressionSplitter(Delimiters delimiters) {
        this.delimiters = delimiters;
    }

    public String[] split(String expression) {
        List<String> delimiterList = delimiters.getDelimiters();
        String regex = String.join("|", delimiterList);
        return expression.split(regex);
    }
}
