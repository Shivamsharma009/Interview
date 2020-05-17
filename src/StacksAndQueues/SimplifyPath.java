package StacksAndQueues;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class SimplifyPath {
   static public String SimplifyPathFinder(String path)
    {
        Stack<String> s = new Stack<>();
        String[] p =  path.split("/");
        for(String t : p)
        {
            if(!s.isEmpty() && t.equals("..")){
                s.pop();
            }else if(!t.equals(".")&& !t.equals(" ")&& !t.equals("..")){
                s.push(t);
            }
        }
        List<String> res = new ArrayList<>(s);
        return "/" + String.join("/",res);
    }

    //Driver Program
    public static  void main(String[] args)
    {
        String path = "/a/../b/../../c/";
        System.out.println(SimplifyPathFinder(path));
    }
}
