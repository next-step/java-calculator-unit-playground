public class CustomDelimiterRegister {

    private final Delimiters delimiters;

    public CustomDelimiterRegister(Delimiters delimiters) {
        this.delimiters = delimiters;
    }

    public void register(String customDelimiter) {
        delimiters.addCustomDelimiters(customDelimiter);
    }
}
