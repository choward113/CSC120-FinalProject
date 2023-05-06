# CSC120-FinalProject

## Design Justification
I chose to design the game with the Person, Cat, Inventory, Item, Location, and Main classes along with the Personality enum to make the project more manageable. Each class serves a specific purpose, such as tracking the player's inventory or defining the characteristics of the game's characters. Also, I was able to keep the code more organized, making it easier to debug when something went wrong. 

An alternative approach I considered was to use strings to store the exits for the Location class. I decided against this because I felt like using a map made storing the exits much easier. Also, I already spent a decent amount of time trying to figure out how to use the graphs.

## Additional Reflection Questions
 - What was your **overall approach** to tackling this project?
 I started with Item, Inventory, and Location classes since I needed them for the Cat and Person classes. Once I finished those, I moved onto the Cat and Person classes. Finally, I made the Main class.

 - What **new thing(s)** did you learn / figure out in completing this project?
 I learned how to use the for (type iterator : iterable) and how to use a graph.

 - Is there anything that you wish you had **implemented differently**?
 I wish I implemented the use method in the Person class differently. It feels very clunky.

 - If you had **unlimited time**, what additional features would you implement?
 If I had more time I'd add more items and the ability to take the cat outside. I was planning to do that until I ran out of time.

 - If you could go back in time and give your past self some **advice** about this project, what hints would you give?
 I'd say to not spend a lot of time on figuring out graphs. 