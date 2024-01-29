import java.util.HashSet;
import java.util.Set;

public class sumPair {
    public int isPairPresent(Node root, int target){
        Set<Integer> set= new HashSet<>();
        boolean ans= util(root, target, set);
        return ans? 1: 0;
    }

    public boolean util(Node root, int sum, Set<Integer> set){
        if(root==null) return false;
        if(util(root.left,sum,set)==true) return true;

        if(set.contains(sum-root.data)){
            return true;
        }
        


    }
}
