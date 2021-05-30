import java.util.*;
public class GuitarHero { 
   public static final int NUM_NOTES = 37;
   public static void main(String[] args) { 
      final String KEYBOARD = "q2we4r5ty7u8i9op-[=zxdcfvgbnjmk,.;/' ";
      ArrayList<GuitarString> piano = newStrings();
      
      // the main input loop
      while (true) {
      
         // check if the user has typed a key, and, if so, process it
         if (StdDraw.hasNextKeyTyped()) {
         
            // the user types this character
            char key = StdDraw.nextKeyTyped();
         
            // pluck the corresponding string
            int index = KEYBOARD.indexOf(key);
            if (index != -1) {
               GuitarString note = piano.get(index);
               note.pluck();
            }
         }
         
         // compute the superposition of the samples
         double sample = 0.0;
         for (int i = 0; i < piano.size(); i++) { 
            sample += piano.get(i).sample();
         }
      
         // send the result to standard audio
         StdAudio.play(sample);
      
         // advance the simulation of each guitar string by one step
         for (int i = 0; i < piano.size(); i++) { 
            piano.get(i).tic();
         }
      }
   } 
   public static ArrayList<GuitarString> newStrings() {
      ArrayList<GuitarString> piano = new ArrayList<GuitarString>(); 
      for (int i = 0; i < NUM_NOTES; i++) { 
         double frequency = 440 * Math.pow(1.05956, i - 24); 
         GuitarString note = new GuitarString(frequency);
         piano.add(note);
      }
      return piano;
   }


}