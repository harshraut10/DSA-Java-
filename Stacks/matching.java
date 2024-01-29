import java.util.Stack;
public class matching {
    static boolean isOpening(Character c){
        return c=='(' || c=='{'||c=='[';
    }

    static boolean isMatching(Character a,Character b){
        return (a=='(' && b==')')||(a=='{' && b=='}')||(a=='[' && b==']');
    }
    static boolean check(String string){
         Stack<Character> s=new Stack<>();
        
        for (int i=0;i<string.length();i++){
            Character cur=string.charAt(i);
            if(isOpening(cur)){
                s.push(cur);
            }
           else{
            if(s.isEmpty()) return false;

            else if(!isMatching(s.peek(),cur)){
                return false;
             }else{
                s.pop();
             }
           } 

            
        }
        return s.isEmpty();
    }
    public static void main(String[] args) {
       
        String str="()[()]";
        if(check(str)){
            System.out.println("matching");
        } else{
            System.out.println("not matching");
        } 

    }
}
