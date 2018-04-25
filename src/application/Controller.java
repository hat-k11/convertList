package application;

import java.io.File;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.FileChooser;

public class Controller {
	@FXML
	private Button InputOpenButton;
	@FXML
	private Button OutputOpenButton;
	@FXML
	private Button StartButton;
	@FXML
	private Label InputLabel;
	@FXML
	private Label OutputLabel;
	
	public void onInputOpenButtonClicked(ActionEvent aEvent){
		FileChooser fc = new FileChooser();
		fc.setTitle("ファイルを選択");
		fc.getExtensionFilters().addAll(
				new FileChooser.ExtensionFilter("Playlist File", "*.m3u","*.m3u8"));
		
		File file = fc.showOpenDialog(null);
		
		if(file != null){
			InputLabel.setText(file.getPath().toString());
		}
	}
	
	public void onOutputOpenButtonClicked(ActionEvent aEvent){
		FileChooser fc = new FileChooser();
		fc.setTitle("ファイルを保存");
		fc.getExtensionFilters().addAll(
				new FileChooser.ExtensionFilter("Playlist File", "*.m3u8"));
		
		File file = fc.showSaveDialog(null);
		
		if(file != null){
			OutputLabel.setText(file.getPath().toString());
		}
	}
	
	public void onStartButtonClicked(ActionEvent aEvent){
		
	}
}
