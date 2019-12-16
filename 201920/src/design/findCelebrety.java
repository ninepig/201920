package design;

public class findCelebrety {
    private boolean knows(int a, int b){
        return false;
    }

    public int findWellKnows(int n){
        if (n <= 0) return -1;
        int candidate = 0;
        // Find candidate.
        for (int i = 1 ; i <= n ;i++){
            if (knows(i , i + 1)) candidate = i + 1;
        }

        // Verify
        for (int i = 1 ; i <= n ; i++){
            if (i != candidate && (!knows(i,candidate) || knows(candidate,i))){
                return -1;
            }
        }
        return candidate;
    }

    /*
    from candidate + 1 --- n  we dont need do know (candidate , i) again , it has been down in finding stage.
     */
    public int findWellKnowsImprove(int n ){
        if (n <= 0) return -1;
        int candidate = 0;
        // Find candidate.
        for (int i = 1 ; i <= n ;i++){
            if (knows(i , i + 1)) candidate = i + 1;
        }

        // Verify
        for (int i = 1 ; i< candidate ; i++){
            if (!knows(i,candidate) || knows(candidate,i)){
                return -1;
            }
        }
        for (int i = candidate + 1 ; i <= n ; i++){
            if (knows(candidate , i )){
                return -1;
            }
        }
        return candidate;
    }
}
