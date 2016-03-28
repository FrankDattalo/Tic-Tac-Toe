# Tick-Tack-Toe
class Board
> holds current board positions

class Action
> holds action x -> y where x is Player and y is Position

class Player
> either computer or human

Position x : (0 <= x <= 8)

Node
> Board
> Action
> Children Of Node
> Utility u : (number based off of how good the outcome is for computer)

> Create Tree of Nodes given a board state and a previous action
> change from min and max utilities as one progresses down the tree
> assign utility values to nodes based off of their respective mins and maxes

> Ask user for input
> if is users turn
> get user input
> change current board state in tree to the action that the player took
> change turn
> if it is the computers turn
> get branch with highest utility <= ?