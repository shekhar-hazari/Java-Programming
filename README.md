# My-Block
In this repositories, I will upload an assignment I did in Java programming language during Semester 1 of my Masters in Data Science.
Here is a brief description of the assignment:

MyBlock is a simple tool which can help one design a block of land. Your task is to write a Java program that implements the design functionality, checks if all the rules are followed, displays the block.

TASKS

The constructor of the MyBlock class takes 2 parameters: the number of rows of the block, the number of columns of the block. In the constructor of this class, write code to initialize the block with the size of row and column. Initialize each value of the array block with the value 0, which means that block is unused. Initialize the value of vacant to true.

Write a method of the MyBlock class called displayBlock() that prints the block as a two dimensional array. Give a space between each element during printing, and use a line for each row.

Write a method of the MyBlock class called clearBlock()that sets the value of each element of the array ‘block’ to zero (0). Set the value of vacant to true.

From the main method, the user can enter the row and column of the block. The number of rows and the number of columns should be an integer greater than 2 and less than or equal to 10. If any input is incorrect, show an error message and ask for that input again. If all inputs are correct, create an object of MyBlock class from main method. The row and column values are passed as the parameter of its constructor.

From the main method, show a menu to the user with the following options. If the input is neither 1,2,3,4, show an error message and ask the user for input again.

Add a house

Display the block

Clear the block

Quit

RULES:

If the block is empty, a house can be anywhere in the block, but not touching the edges. That means there needs to be at least one row and one column gap between the house and the four sides of the block. For example, the largest possible house in a 5 x 7 block is of size 3 x 5, with a top-left corner position (1, 1)

If there is already a house or houses in the block, the new house must be one row or one column away, yet still observing Rule 1

No part of a house can go outside of the block

The smallest house size is 1 x 1

Represent the first house with ‘1’, the second with ‘2’, the third with ‘3’ and so on. If any of the rules is violated, the addHouse method should return with no house added. Consider where and how an error message should be showed to user. You may discuss that in comments. If no rule is violated, the addHouse method should change the values in the block array for the house(s). The value of vacant should be correct. After building the house, call displayBlock() from the addHouse method to show the updated block.
