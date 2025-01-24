public class StringCalculrator {
    public int strPlus(String str){
        String divStr;
        if(str.charAt(0)=='/' && str.charAt(1)=='/'){
            divStr = Character.toString(str.charAt(2));
            str = str.substring(4, str.length());
        }
        else{
            divStr = "[,|:]";
        }
        
        int ans=0;
        for(var n: str.split(divStr))    ans+=Integer.parseInt(n);

        return ans;
    }
}
