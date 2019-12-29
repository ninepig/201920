package company.oracle.mianjing.array;

public class countPrime {
    public int countPrime(int N){
        if (N <= 1) return 0;
        boolean[] helper = new boolean[N];
        int count = 0 ;
        for (int i = 2 ; i < N ; i++){
            if (helper[i] == false) count++;
            for (int j = 1 ; j * i < N ; j++){
                helper[j*i] = true;
            }
        }
        return count;
    }
}
