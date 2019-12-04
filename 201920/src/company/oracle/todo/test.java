package company.oracle.todo;

import company.oracle.wordbreak2;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class test {
    public static void main(String ... args){
        String a = "catsanddog";
        Set<String> b = new HashSet<>();
        b.add("cat");
        b.add("cats");
        b.add("and");
        b.add("sand");
        b.add("dog");
        wordbreak2 c = new wordbreak2();
        List<String> d = c.wordBreak(a,b);
        for (String e : d){
            System.out.println(e);
        }
    }
}
