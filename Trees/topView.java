import java.util.Map;
import java.util.Queue;

import jdk.internal.util.xml.impl.Pair;

class topView{
    static ArrayList<Integer> topview(Node root){
        Queue<Pair> q=new ArrayDeque<>();
        Map<Integer,Integer> map=new TreeMap<>();

        q.add(new Pair(0,root));
        while(!q.isEmpty()){
            Pair cur=q.poll();
            if(!map.containsKey(cur.hd)){
                map.put(cur.hd,cur.node.data);
            }

            if(cur.node.left != null){
                q.add(new Pair(cur.hd - 1, cur.node.left));
            }
            if(cur.node.right!=null){
                q.add(new Pair(cur.hd+1,cur.node.right));
            }
        }
        ArrayList<Integer> ans=new ArrayList<>();
        for(Map.entry<Integer,Integer> entry: map.entrySet())
        ans.add(entry.getValue());

    }
    return ans;

}

    static class Pair{
        int hd;
        Node node;
        public Pair(int hd,Node node){
            this.node=node;
            this.hd=hd;
        }
    }
