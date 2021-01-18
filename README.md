# TSP_Genetics

## Summary
- Personal Project(17-2)    

A program that uses genetic algorithms to solve the travel sales program(TSP). TSP is a problem that cannot be solved without considering the number of all cases. To solve these problems, I used a genetic algorithm to generate a path by considering the weight of all nodes, and to evolve each generated path to derive the most appropriate results. After that, I further resolved the TSP problem using a library called [Jenetics](https://jenetics.io/), and compared the results, I found that the program in this project had a better resolution at the same time. The comparison results will be uploaded additionally.

## Program Design
<pre>
src ----- tsp ----- main ---------- Main.java
              |          |     
              |          ---------- ReadFile.java
              |          |
              |          ---------- MakeNode.java
              |          |
              |          ---------- MakeSequence.java
              |
              ----- evolution ----- Path.java
              |               |
              |               ----- Generation.java
              |               |
              |               ----- Evolution.java
              |               
              ----- gui ----------- ShowData.java
              
<b>ANT</b>
  1. ant build
  2. ant clean
  3. ant doc

</pre>
