package company.oracle.onsiteMianjing;

import java.util.*;

public class pathForActorAndMovies {
    /*
    Could it be mulitply paths?
    1. 给出一个<电影明星，电影作品>的字典和任意两个明星，找出他们之间的关系路径。例：约翰有作品1,2,3，汤姆有作品3,4,
    山姆有作品4,5。求汤姆和山姆的路径，是约翰->3->汤姆->4->山姆.

    自己想出来的 DFS 方法， 因为要回溯回去。 所以不知道怎么用bfs做
    need a set to remove duplicated
     */
    final boolean ACTOR = true;
    final boolean MOVIE = false;
    public List<String> pathForActorAndMovies(HashMap<String , List<String>> actorMovies , String targetActor , String endActor){
        List<String> res = new ArrayList<>();
        if (actorMovies == null || actorMovies.size() == 0) return res;
        // Step 1  build MovieActor map
        HashMap<String, List<String>> moviesActor = new HashMap<>();
        for (String actor : actorMovies.keySet()){
            List<String> movies = actorMovies.get(actor);
            for (String movie : movies){
                if (!moviesActor.containsKey(movie)){
                    moviesActor.put(movie, new ArrayList<>());
                    moviesActor.get(movie).add(actor);
                }
            }
        }
//        Queue<String> q = new LinkedList<>();
//        q.offer(targetActor);

//
//        // BFS how to recursion?
//        while (!q.isEmpty()){
//            String curString = q.poll();
//            if (actorOrMovie == ACTOR && curString == endActor){
//
//            }
//        }
//        boolean actorOrMovie = MOVIE;

        dfs(actorMovies, moviesActor, targetActor , endActor , new StringBuilder(),
                res, MOVIE, new HashSet<String>() ,new HashSet<String>());
        return res;
    }
    private void dfs(HashMap<String, List<String>> actorMovies, HashMap<String, List<String>> moviesActor,
                     String CUR, String endActor, StringBuilder s, List<String> res, boolean flag,
                     HashSet<String> actors, HashSet<String> movies) {
        if (flag == ACTOR && CUR == endActor){
            s.append(CUR);
            res.add(s.toString());
        }else {
            if (flag == ACTOR){
                for (String movie : actorMovies.get(CUR)) {
                    int index = s.length();
                    if (!movies.contains(movie)) {
                        movies.add(movie);
                        s.append("->").append(movie);
                        dfs(actorMovies, moviesActor, movie, endActor, s, res, MOVIE, actors, movies);
                        s.delete(index, s.length() - 1);
                    }
                }
            }else {
                for (String actor :moviesActor.get(CUR)){
                    if (!actors.contains(actor)) {
                        actors.add(actor);
                        int index = s.length();
                        s.append("->").append(actor);
                        dfs(actorMovies, moviesActor, actor, endActor, s, res, ACTOR, actors, movies);
                        s.delete(index, s.length() - 1);
                    }
                }
            }
        }
    }
}
