# Monopoly - Quarter 4 Project

## Description

[![start-of-game.png](https://i.postimg.cc/Sxp0ZPGf/start-of-game.png)](https://postimg.cc/mtV6k8JP)

We recreated the Monopoly game owned by Hasbro in Java. The game consists of players rolling dice to move around the board, buying properties, collecting money, drawing cards, and winning by being the last alive. When players have no more money (negative money) and owe money to the bank or other players, they must sell or morgtage their properties to achieve enough money to pay their debts back. When players have no more money, they lose and are out of the game. 

The Monopoly board consists of 40 properties, with the corners being GO (the starting position), Visting Jail / Jail, Free Parking, and Go TO JAIL. Passing GO gives the player $200, while being in Jail makes the player not able to move for 3 moves. 

The player moves by rolling two dice every turn, labeled from one to six. The sum of the dice (ranging from 2-12) is the distance the player moves from its current position. 

Chance and Community Chests are positions in the board which cannot be owned. When the player lands on a Chance or Community Card, the player draws a card which grants one of the following: 

1) Gain $200
2) Lose $200 
3) GO TO JAIL

If the player lands on a property that is not yet owned, they can purcahese the property for a certain amount of money shown in the UI Interface to the right. If a player lands on a property that they own, nothing happens. If a player lands on a property owned by another property, they have pay that player a certain amount of money based on the following rules: 

1) If the property is a railroad the pay due depends on the amount owned by the player: 1 = $50, 2 = $100, 3 = $150, 4 = $200
2) If the property is a utility the pay depends on the amount of utiltiies owned by the player: 1 = twice the dice rolled, 2 = four times the dice rolled
3) Otherwise, the amount of pay is specific to the property owned

## How to Play

At the start of the game, click either "2 Players" or "3 Players" depending on how many players you want to play with. The game starts with Player 0, and rotates to Player 1 (and Player 2 if 3 players), and returns to Player 0's turn until the game is over. 

[![beginning.png](https://i.postimg.cc/sgx97jkB/beginning.png)](https://postimg.cc/9D37jhFV)

To roll, click the Roll Button. The dice rolled and distance moved will be shown, with your current position to the right in the UI Interface. 

[![board.png](https://i.postimg.cc/XYK3KW9b/board.png)](https://postimg.cc/TKPZGZk7)

To buy a property, click the Buy Property Button. If the purcahse is successful, there will be a successful message, you will lose money, and the properties owned list will be updated. If unsucessful (not enough money), an error message will be shown. 

To end turn, click the End Turn Button. 

To mortgage a property (only available if negative money), click the Mortgage Button and then the property you wish to mortgage on the board screen. 

## Installation

This Monopoly game is playable on any device that can compile Java. However, the frame resolution is 1900 x 1035 pixels, so your monitor resolution must be big enough to view and play the game properly. 

## Project Status 

This project was made for the Quarter 4 AP Computer Science Class at Westview High School. 

The project was finished on 5/31/2022. 

Almost all aspects of Monopoly have been coded into the game. Features that can be added are hotels, more community chests and chance cards, and more players. 

Playthrough Snippet of Game: https://youtu.be/C0_TsifJUCs

## Author and Acknowledgements

Made By William Pan, Joseph Carter, Henry Clark

Students at Westview High School 

williamlpan22@gmail.com

We did not create or deisgn Monopoly. The Monopoly game and its related iamges are owned by Hasbro.
