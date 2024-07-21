public class example {
    public static void main(String[] args) {
//        I/P---->>>my name is venkat reddy
//        o/p--->>>ym eman si taknev ydder
        String str = "my name is venkat reddy";

        String[] stringArr =  str.split(" ");

        String result = "";

        for(int i = 0 ; i < stringArr.length; i++){

            if(stringArr[i].length()%2 == 0){
                result += stringArr[i].toUpperCase()+" ";
            }else {
                result += reverString(stringArr[i])+" ";
            }
            
        }

        System.out.println("result  : "+result.trim());
    }

    public static String reverString(String str ){
        String newStr = "";

        for(int i = 0 ; i < str.length() ; i++){
            newStr += str.charAt(str.length()-1-i);
        }

        return newStr;
    }
}