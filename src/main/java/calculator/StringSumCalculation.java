package calculator;

public class StringSumCalculation {
	private final String expression;
	private int index = 0;
	private String[] separators = {",", ":"};
	
	public StringSumCalculation(String expression) {
		this.expression = expression;
	}
	
	
	public int executeSum() {
		if(index != 0) throw new RuntimeException("execute는 한번만 호출해주세요!");
		
		int result = 0;
		
		String separator = parseSeparatorInput();
		if(separator != null) separators = new String[] {separator};
		
		Integer output;
		if((output = parseInteger()) == null)
			throw new RuntimeException("올바른 숫자를 입력해주세요.");
		result += output;
		
		while(index < expression.length()) {
			if(parseSeparator() == null)
				throw new RuntimeException("숫자 뒤에는 구분자가 와야 합니다.");
			if((output = parseInteger()) == null)
				throw new RuntimeException("올바른 숫자를 입력해주세요.");
			result += output;
		}
		
		return result;
	}
	
	
	/// 파서
	
	private String parseSeparatorInput() {
		String separatorPrefix = "//";
		String separatorSuffix = "\n";
		if(!expression.startsWith(separatorPrefix, index)) return null;
		
		int separatorEnd = expression.indexOf(separatorSuffix, index);
		if(separatorEnd == -1)
			throw new RuntimeException("구분자 입력 형식이 잘못되었습니다. //과 \\n 사이에 구분자를 넣어주세요.");
		
		return expression.substring(index + separatorPrefix.length(), separatorEnd);
	}
	
	private String parseSeparator() {
		for(String separator : separators) {
			if(!expression.startsWith(separator, index)) continue;
			
			index += separator.length();
			return separator;
		}
		
		return null;
	}
	
	private Integer parseInteger() {
		int startIndex = index;
		if(startIndex >= expression.length())
			throw new RuntimeException("숫자를 예상했지만 표현식이 끝났습니다...");
		
		char first = expression.charAt(startIndex);
		if(!isDigit(first)) {
			if(first == '-') throw new RuntimeException("음수는 지원되지 않습니다.");
			return null;
		}
		
		index++;
		
		while(index < expression.length()) {
			char current = expression.charAt(index);
			if(isDigit(current)) index++;
			else break;
		}
		
		try {
			return Integer.parseInt(expression.substring(startIndex, index));
		} catch(NumberFormatException e) {
			throw new RuntimeException("올바르지 않은 숫자입니다.", e);
		}
	}
	
	
	/// 유틸리티
	
	private boolean isDigit(char c) {
		return "0123456789".indexOf(c) != -1;
	}
}
