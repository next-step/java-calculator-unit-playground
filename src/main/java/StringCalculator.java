public class StringCalculator {
    int sum(String str){
//        System.out.println(str);
        if(str == null || str.isEmpty()){
            return 0;
        }
        if(str.contains("-")){//음수이면
            throw new RuntimeException();
        }
        if(str.matches(".*[가-힣ㄱ-ㅎㅏ-ㅣa-zA-Z].*")){//숫자 이외의 값이 들어온다면
            throw new RuntimeException();
        }


        int total = 0;
        String del = "";//구분자
        if(str.contains("//")){
            del = str.substring(2,3);
            str = str.substring(5);
        }
        else if(str.contains(",") || str.contains(":")){
            del = "[,|:]";
        }

        String[] arr = str.split(del);
        for(String s : arr){
            total += Integer.parseInt(s);
        }

        return total;
    }
}
