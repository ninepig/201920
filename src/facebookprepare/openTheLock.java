package facebookprepare;

/**
 * Created by yangw on 2019/7/2.
 */
public class openTheLock {
    public int openLock(String[] deadends, String target) {
        Set<String> visited = new HashSet<>();

        Set<String> deadSet = new HashSet<>(Arrays.asList(deadends));

        Queue<String> queue = new LinkedList<>();

        int level = 0;

        queue.offer("0000");

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                String s = queue.poll();

                if (visited.contains(s)) continue;

                if (deadSet.contains(s)) continue;

                if (s.equals(target)) return level;

                visited.add(s);

                char[] cArr = s.toCharArray();

                for (int j = 0; j < cArr.length; j++) {
                    char tmp = cArr[j];

                    if (cArr[j] < '9')
                        cArr[j]++;
                    else
                        cArr[j] = '0';

                    queue.offer(new String(cArr));

                    cArr[j] = tmp;

                    if (cArr[j] > '0')
                        cArr[j]--;
                    else
                        cArr[j] = '9';

                    queue.offer(new String(cArr));

                    cArr[j] = tmp;

                }

            }

            level++;
        }


        return -1;
    }
}
