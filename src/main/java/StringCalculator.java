public class StringCalculator {
    public int strPlus(String str){
        if(str==null)   throw new RuntimeException("non-input");

        String delimiter = findDelimiter(str);
        str = str.substring((str.indexOf("\n")==2)? 4:str.indexOf("\n")+1, str.length());
        int ans=0;
        try{
            for(String n: str.split(delimiter)){
                if(n.isBlank())    continue;
                
                if(ans <= Integer.MAX_VALUE - Integer.parseInt(n))
                    ans+=Integer.parseInt(n);
                else
                    throw new RuntimeException("overflow");
            }
        }
        catch(NumberFormatException e){
            throw new RuntimeException("invalid delimiter");
        }

        return ans;
    }
    
    private String findDelimiter(String str){
        String delimiter;

        if(str.startsWith("//")){
            if(str.indexOf("\n")==2)    delimiter = "\n";
            else                            delimiter = str.substring(2, str.indexOf("\n"));
        }
        else{
            delimiter = "[,|:]";            
        }

        return delimiter;
    }
    
}
