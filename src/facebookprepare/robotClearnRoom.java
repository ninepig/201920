package facebookprepare;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by yangw on 2019/7/1.
 */
public class robotClearnRoom {
    int[] dx = {-1, 0, 1, 0};
    int[] dy = {0, 1, 0, -1};
    public void cleanRoom(Robot robot) {
        //write your code here
        dfs(robot, new HashSet<>(), 0, 0, 0);
    }

    public void dfs(Robot robot, Set<String> visited, int x, int y, int curDir) {
        String key = x + "@" + y;
        if (visited.contains(key))  {
            return;
        }
        visited.add(key);
        robot.clean();

        for (int i = 0; i < 4; i++) {
            if(robot.move()) {
                //go all the way till cannot move, then back one step
                dfs(robot, visited, x + dx[curDir], y + dy[curDir], curDir);
                //trace back
                backtrack(robot);
            }

            robot.turnRight(); // or turnRight();
            curDir += 1;
            curDir %= 4;
        }
    }
    private void backtrack(Robot robot) {
        robot.turnLeft();
        robot.turnLeft();
        robot.move();
        robot.turnRight();
        robot.turnRight();
    }

    private class Robot {
        public void clean() {
        }
        public boolean move(){
            return false;
        }
        public void turnLeft(){

        }
        public void turnRight(){

        }
    }
}
