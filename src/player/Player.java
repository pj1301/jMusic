package player;

import java.io.File;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.util.Duration;
import java.util.List;

public class Player {
   private File file;
   private File[] files;
   private String fileName;
   private MediaPlayer mediaPlayer;
   private Boolean playing = false;
   private int trackIndex = 0;
   private Duration duration;

   public void setFiles(List<File> list) {
      files = new File[list.size()];
      list.toArray(files);
   }

   public String getFileName() {
      return this.fileName;
 }

   public Duration giveDuration() { return this.duration; }

   public Boolean confirmPlaying() {
      if (playing) return true;
      return false;
   }

   public void playFile() {
      if (playing) {
         mediaPlayer.pause();
         playing = false;
      } else {
         File currentTrack = files[trackIndex];
         Media media = new Media(currentTrack.toURI().toString());
         mediaPlayer = new MediaPlayer(media);
         this.fileName = currentTrack.getName();
         mediaPlayer.play();
         playing = true;
      }
   }

   public void back() {
      mediaPlayer.stop();
      playing = false;
      if (trackIndex > 0) { trackIndex -=1; }
      playFile();
   }

   public void forward() {
      mediaPlayer.stop();
      playing = false;
      if (trackIndex < files.length) { trackIndex += 1; }
      playFile();
   }

}