package design;

import java.util.LinkedList;
import java.util.Queue;

//https://baihuqian.github.io/2018-08-12-design-snake-game/
public class designSnakeGame {
    Queue<Integer> snake;
    boolean[][] board;
    int[][] food ;
    int foodIndex;
    int height, width;
    int row, col;
    int score;

    /** Initialize your data structure here.
     @param width - screen width
     @param height - screen height
     @param food - A list of food positions
     E.g food = [[1,1], [1,0]] means the first food is positioned at [1,1], the second is at [1,0]. */
    public designSnakeGame(int width , int height , int[][] food){
        this.board = new boolean[width][height];
        this.food = food;
        this.snake = new LinkedList<>();
        this.width = width;
        this.height = height;
        this.row = 0;
        this.col = 0;
        this.score = 0;
    }

    /** Moves the snake.
     @param direction - 'U' = Up, 'L' = Left, 'R' = Right, 'D' = Down
     @return The game's score after the move. Return -1 if game over.
     Game over when snake crosses the screen boundary or bites its body. */
    public int move(String dirction){
        if (score == - 1) return -1;
        if (dirction.equals("U")) row--;
        else if (dirction.equals("L")) col--;
        else if (dirction.equals("R")) col++;
        else if (dirction.equals("D")) row++;

        // cross boundry
        if (row < 0 || row >= height || col < 0 || col >= width){
            score =  -1 ;
            return score;
        }

        // Food or Not
        if (foodIndex == food.length || !(row == food[foodIndex][0] && food[foodIndex][1] == col)){
            // remove tail
            int idx = snake.poll();
            board[idx / width] [idx % width] = false;
        }else {
            score++;
            foodIndex++;
        }
        // Bite it self
        if (board[row][col]){
            score = -1;
            return score;
        }else {
            snake.offer(row * width + col);
            board[row][col] = true;
        }
        return  score;
    }
}
