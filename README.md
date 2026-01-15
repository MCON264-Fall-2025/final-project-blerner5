# Event Planner Mini

This project demonstrates practical use of data structures:
linked lists, stacks, queues, maps, trees, sorting, and searching.

## What You Must Do
- Implement all TODO methods
- Write JUnit 5 tests for core logic
- Pass instructor autograding tests
- Explain your design choices in this README

See Canvas assignment for full requirements.

I used a queue for tasks because tasks should be done in the order they were added.
A queue naturally does first‑in‑first‑out, which matched what I needed.

I used a stack for undoing tasks because I wanted to undo the most recent task first. 
A stack does last‑in‑first‑out, which is exactly what “undo” means.

I used a list to store guests because I just needed something that could grow as I added more people. 
A list was the easiest thing to work with, and I didn’t need anything fancy like sorting or indexing by name at first.

I used a loop for the menu because the program needs to keep running until the user chooses to exit. 
A simple while‑loop was the easiest way to do that.

I made helper methods for sample guests and sample venues so the Main method wouldn’t get too long. 
It also made it easier to change the sample data later.

put the seating logic in its own class because it was required but also it felt too big to keep in Main. 
Also, seating depends on the venue, so it made sense to group that logic together.

I tried to keep Main focused on handling user input and calling the right methods. 
I didn’t want Main doing all the work because it becomes hard to read and harder to fix later.

The stack part was pretty straightforward too. 
Undoing things naturally feels like going backwards, so using a stack made the code easier for me to understand when I came back to it.

I stuck with a queue because it honestly just made sense for how tasks should flow. 
I didn’t want to overthink it, and a queue did exactly what I needed without extra work.