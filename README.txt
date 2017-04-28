=:=:=:=:=:=:=:=:=:=:=:=:=:=:=:=:=:=:=
CIS 120 Game Project README
PennKey: _______
=:=:=:=:=:=:=:=:=:=:=:=:=:=:=:=:=:=:=

===================
=: Core Concepts :=
===================

- List the four core concepts, the features they implement, and why each feature
  is an appropriate use of the concept. Incorporate the feedback you got after
  submitting your proposal.

  1. Collections - In the proposal, it was indicated that my reason for using collection was too
                   vague and I needed to be more specific. The collection I chose to use was a
                   LinkedList, and I used it to model my falling objects in the game, because
                   I need multiple objects to fall at a time. After some
                   interval of time, an object is added to both my fruit object LinkedList and
                   my killer object LinkedList. I use the Lists to check intersections and also
                   to draw and paint.

  2. IO - I was given the go ahead in my proposal feedback to implement it as I wrote. I use 
          I/O to write in the user’s score (ie. how many fruit objects he picks). I also use I/O to keep 
          track of the user’s scores as he plays more games and there is a button on the screen that if 
          pressed gives a dialog box with all the users previous scores.

  3. Inheritance / Dynamic dispatch - In the proposal, it was indicated that my explanation didn't
                  show distinct method implementation. I implemented this by having an abstract Killer Object
                  class that extends the GameObject class, but is farther extended by two subclasses:
                  BigKiller and SmallKiller. The two subclassses inherit the draw method from
                  KillerObject but have different implementations for the resize() method, which
                  I call in the GameCourt class.
                  

  4. J-Unit Testing - In the proposal it was indicated that my explanation didn't really show how
           my game is unit testable. This is a concept I struggled with because I was doing
           most things in the GUI, but I managed to test my abstract KillerObject class because
           it was integral to the game but most of its functionality was outside the GUI.
           I wrote tests for the different methods in the class and its subclasses.


=========================
=: Your Implementation :=
=========================

- Provide an overview of each of the classes in your code, and what their
  function is in the overall game.
  
1. CharObj.java - Extends the GameObject class and is the functionality for the main character.
2. KillerObj.java - Abstract class that has two subclasses and is the functionality for the killer 
   objects.
3. BigKiller.java - A subclass of KillerObj
4. SmallKiller.java - A subclass of KillerObj
5. FruitObj.java - Extends the GameObj class and is the functionality for the fruit objects.
6. GameCourt.java - This class holds the primary game logic for how different objects interact with one another
7. Game.java - The main class where the game runs from
8. GameTests.java - Tests the KillerObj class
9. Background.java - Forms the background image of the main JFrame

- Were there any significant stumbling blocks while you were implementing your
  game (related to your design, or otherwise)?
  
   I found it difficult to model it in a way that could be tested by JUnit, because I
   was thinking of doing everything in the GUI but I overcame this.

- Evaluate your design. Is there a good separation of functionality? How well is
  private state encapsulated? What would you refactor, if given the chance?
  I don't think I have the best design in this game, especially because I have hardcoded
  many things like object size, but moving forward I would definitely make my game more 
  unit testable so as to ensure that my private state is encapsulated.


========================
=: External Resources :=
========================

- Cite any external resources (libraries, images, tutorials, etc.) that you may
  have used while implementing your game.
  I used different images from the internet and they are all included in the zip file.
  I also used a tutorial on JOption Panes 
  from http://alvinalexander.com/java/joptionpane-showinputdialog-examples, to learn about how to
  use the JOptionpanes in my introduction.

