# Chess Engine

This repository contains a Java implementation of a chess engine. The engine features a GUI built using Java Swing and a powerful AI built using the Minimax algorithm.

## Features
* Well Organized & Manageable Codebase
* Advanced AI
* Neat & Intuitive Interface

## Usage
* To run the chess engine, simply run the main method in the Jchess class.


## Design
* The chess engine follows the Singleton and Builder design patterns to create a clean and maintainable codebase. The Board class is implemented as a Singleton to ensure that there is only one instance of the game at any time. Builder pattern is used to create instances of the Board class and easily setup the game.

* The different pieces in the game are represented by the Piece class, and the moves made by the pieces are represented by the Move class. The Player class represents the two players in the game.

* The AI is built using the Minimax algorithm, which evaluates all possible moves and chooses the one that leads to the best outcome for the AI player.

* The GUI is built using Java Swing, providing a simple and user-friendly interface for playing the game.
