# 8-Puzzle


![alt text](https://github.com/ayushakash990/8-Puzzle/blob/master/images/Screenshot%20(11).png?raw=true)




![alt text](https://github.com/ayushakash990/8-Puzzle/blob/master/images/Screenshot%20(12).png?raw=true)


### A* search

Now, we describe a solution to the **8-puzzle** problem that illustrates a general artificial intelligence methodology known as the **A search algorithm**. We define a search node of the game to be a board, the number of moves made to reach the board, and the previous search node. First, insert the initial search node (the initial board, 0 moves, and a null previous search node) into a priority queue. Then, delete from the priority queue the search node with the minimum priority, and insert onto the priority queue all neighboring search nodes (those that can be reached in one move from the dequeued search node). Repeat this procedure until the search node dequeued corresponds to the goal board.

The efficacy of this approach hinges on the choice of priority function for a search node. We consider two priority functions:

The Hamming priority function is the Hamming distance of a board plus the number of moves made so far to get to the search node. Intuitively, a search node with a small number of tiles in the wrong position is close to the goal, and we prefer a search node if has been reached using a small number of moves.
The Manhattan priority function is the Manhattan distance of a board plus the number of moves made so far to get to the search node.
To solve the puzzle from a given search node on the priority queue, the total number of moves we need to make (including those already made) is at least its priority, using either the Hamming or Manhattan priority function. Why? Consequently, when the goal board is dequeued, we have discovered not only a sequence of moves from the initial board to the goal board, but one that makes the fewest moves. (Challenge for the mathematically inclined: prove this fact.)

### Game tree

One way to view the computation is as a game tree, where each search node is a node in the game tree and the children of a node correspond to its neighboring search nodes. The root of the game tree is the initial search node; the internal nodes have already been processed; the leaf nodes are maintained in a priority queue; at each step, the **A algorithm** removes the node with the smallest priority from the priority queue and processes it (by adding its children to both the game tree and the priority queue).


![alt text](https://github.com/ayushakash990/8-Puzzle/blob/master/images/Screenshot%20(13).png?raw=true)



![alt text](https://github.com/ayushakash990/8-Puzzle/blob/master/images/Screenshot%20(14).png?raw=true)



![alt text](https://github.com/ayushakash990/8-Puzzle/blob/master/images/Screenshot%20(15).png?raw=true)




