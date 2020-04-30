package sample;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.*;

public class Controller {

   @FXML
   public Button playButton;
   public Button backButton;
   public Button forwardButton;

   public void playSong() {
      System.out.println("Playing song...");
   }

   public void lastSong() {
      System.out.println("Skipping back a song...");
   }

   public void nextSong() {
      System.out.println("Skipping forward a song...");
   }
}