import edu.princeton.cs.algs4.MinPQ;
import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdOut;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Jannik.Richter
 */
public class Solver {   
    
    private class Move implements Comparable<Move>{
        private int moves;
        private Board node;    
        private Move prev;   
        
        public Move(Board board){
            this.moves = 0;
            this.node = board;
            this.prev = null;
        }
        
        public Move(Board board, Move prev){
            this.moves = prev.moves + 1;
            this.node = board;
            this.prev = prev;
        }
        
        @Override
        public int compareTo(Move move) {
            return (this.node.manhattan() - move.node.manhattan()) + (this.moves - move.moves);
        }
    }
    
    private MinPQ<Move> pq;
    private MinPQ<Move> twinPQ;
    private Move lastMove;
    
    /**
     * @description find a solution to the initial board (using the A* algorithm)
     * @param initial 
     */
    public Solver(Board initial) {
        
        // main 
        pq = new MinPQ<>();
        pq.insert(new Move(initial));
        
        // twin
        twinPQ = new MinPQ<>();
        twinPQ.insert(new Move(initial.twin()));    
        
        while(true) {     
            lastMove = expand(pq);            
            if(lastMove != null || expand(twinPQ) != null) return;
        }
    } 
    
    private Move expand(MinPQ<Move> moves) {
        if(moves.isEmpty()) return null;
        Move bestMove = moves.delMin();
        if(bestMove.node.isGoal()) return bestMove;
        for(Board neighbor : bestMove.node.neighbors()) {                
            if(bestMove.prev == null || !neighbor.equals(bestMove.prev.node)) {                    
                pq.insert(new Move(neighbor, bestMove));
            }                
        }
        return null;
    }
            
    /**
     * @description is the initial board solvable?
     * @return 
     */
    public boolean isSolvable() {
        return lastMove != null;
    }    
   
    /**
     * @description min number of moves to solve initial board; -1 if unsolvable
     * @return 
     */
    public int moves() {
        
        if(!isSolvable()) return -1;
        
        return lastMove.moves;
    } 
    
    /**
     * @description sequence of boards in a shortest solution; null if unsolvable
     * @return 
     */
    public Iterable<Board> solution() {
        
        if(!isSolvable()) return null;
        
        Stack<Board> solution = new Stack<>();
        Move tmp = lastMove;
        while(tmp.prev != null) {
            solution.push(tmp.node);
            tmp = tmp.prev;
        }
        
        solution.push(tmp.node);
        
        return solution;
    }  
    
            /**
     * @description solve a slider puzzle (given below)
     * @param args 
     */
    public static void main(String[] args) {
        
    }
}