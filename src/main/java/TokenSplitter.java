public class TokenSplitter {

    private static final String DEFAULT_REGEX = "[,|:]";

    public String[] getToken(final String input) {
        return input.split(DEFAULT_REGEX);
    }
}
