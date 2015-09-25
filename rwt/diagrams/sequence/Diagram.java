package rwt.diagrams.sequence;

import java.util.List;
import java.util.ArrayList;

/** An abstract representation of a diagram, suitable
  * for rendering to screen.
  * @author Richard Todd
  */
public class Diagram {
    // a pure data object, no encapsulation or boilerplate
    /** Represents an actor in the diagram.
      * @author Richard Todd
      */
    class Actor {
      String name;
      String displayName;
      Actor(String name, String displayName) {
         this.name = name;
         this.displayName = displayName;
      } 
    }
    
    // a pure data object, no encapsulation or boilerplate
    /** Represents an arrow or note in the diagram.
      * @author Richard Todd 
      */ 
    class Event {
      Actor from;
      Actor to;
      boolean dashed;
      boolean note;
      String desc;
    
      Event(Actor from, Actor to) {
         this.from = from;
         this.to = to;
         dashed = false;
         note = false;
         desc = "";
      }
    }

   private String title;
   String getTitle() { return title; }
   void setTitle(String t) { title = t; }

   private boolean errorState; 
   boolean hasErrors() { return errorState; }
   void setErrors(boolean e) { errorState = e; }

   private List<Actor> actors;
   List<Actor> getActors() { return actors; }

   private List<Event> lines;
   List<Event> getLines() { return lines; } 

   public Diagram()
   {
       errorState = false;
       title = "Untitled";
       actors = new ArrayList<Actor>();
       lines = new ArrayList<Event>();
   }

   Actor maybeNewActor(String name)
   {
       String searchFor = name.toUpperCase();
       int idx = actors.indexOf(searchFor);
       Actor ans; 
       
       if (idx >= 0) {
           ans = actors.get(idx);
       } else {
           ans = new Actor(searchFor,name);
           actors.add(ans);
       }
       return ans;
   }

   Event addEvent(Actor from, Actor to)
   {
       Event ans = new Event(from, to);
       lines.add(ans);
       return ans;
   }
}
