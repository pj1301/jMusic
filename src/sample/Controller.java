package sample;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.scene.shape.SVGPath;
import player.Player;

import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.File;
import java.util.List;

public class Controller {
   Player player = new Player();

   @FXML
   public Button playButton;
   public Button backButton;
   public Button forwardButton;
   public Button openBtn;
   public Label nowPlayingLabel;
   public Label timeLeftLabel;

   public void playSong() {
      player.playFile();
      setTrackInfo();
      if (player.confirmPlaying()) {
         SVGPath pause = new SVGPath();
         pause.setContent("M9 16h2V8H9v8zm3-14C6.48 2 2 6.48 2 12s4.48 10 10 10 10-4.48 10-10S17.52 2 12 2zm0 18c-4.41 0-8-3.59-8-8s3.59-8 8-8 8 3.59 8 8-3.59 8-8 8zm1-4h2V8h-2v8z");
         pause.setScaleX(1.6);
         pause.setScaleY(1.6);
         pause.setFill(Color.web("#63bfdd"));
         playButton.setGraphic(pause);
      } else {
         SVGPath play = new SVGPath();
         play.setContent("M10 16.5l6-4.5-6-4.5v9zM12 2C6.48 2 2 6.48 2 12s4.48 10 10 10 10-4.48 10-10S17.52 2 12 2zm0 18c-4.41 0-8-3.59-8-8s3.59-8 8-8 8 3.59 8 8-3.59 8-8 8zM10 16.5l6-4.5-6-4.5v9zM12 2C6.48 2 2 6.48 2 12s4.48 10 10 10 10-4.48 10-10S17.52 2 12 2zm0 18c-4.41 0-8-3.59-8-8s3.59-8 8-8 8 3.59 8 8-3.59 8-8 8z");
         play.setScaleX(1.6);
         play.setScaleY(1.6);
         play.setFill(Color.web("#63bfdd"));
         playButton.setGraphic(play);
      }
   }

   public void lastSong() {
      player.back();
      setTrackInfo();
   }

   public void nextSong() {
      player.forward();
      setTrackInfo();
   }

   public void handleOpenBtnClick(MouseEvent event) {
      Stage mainStage = (Stage)((Node)((MouseEvent) event).getSource()).getScene().getWindow();
      FileChooser selectFile = new FileChooser();
      selectFile.setTitle("Select file to open");
      List<File> files = selectFile.showOpenMultipleDialog(mainStage);
      player.setFiles(files);
   }

   private void setTrackInfo() {
      nowPlayingLabel.setText(player.getFileName());
   }
}