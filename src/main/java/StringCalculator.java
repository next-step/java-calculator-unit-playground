public class StringCalculator {

    public int add(String string) {
        if (string.isEmpty()) {
            return 0;
        }


        String[] numbers = string.split(",|:");
        return sum(numbers);
    }

    private int sum(String[] numbers) {
        int total = 0;

        for (String number : numbers) {
            int num = checkNumber(number);
            total += num;
        }

        return total;
    }

    private int checkNumber(String number) {
        if (number.isEmpty()) {
            return 0;
        }

        // 숫자가 아닌 경우 RuntimeException 발생
        try {
            int num = Integer.parseInt(number);
            if (num < 0) {
                throw new RuntimeException("음수가 포함되어 있습니다.");
            }
            return num;
        } catch (NumberFormatException e) {
            throw new RuntimeException("잘못된 입력입니다.");
        }
    }
}