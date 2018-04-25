package application;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

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
	@FXML
	private Label MessageLabel;
	
	private static File inputFile;
	private static File outputFile;
	
	public void onInputOpenButtonClicked(ActionEvent aEvent){
		FileChooser fc = new FileChooser();
		fc.setTitle("�t�@�C����I��");
		fc.getExtensionFilters().addAll(
				new FileChooser.ExtensionFilter("Playlist File", "*.m3u","*.m3u8"));
		
		File file = fc.showOpenDialog(null);
		inputFile = file;
		
		if(file != null){
			InputLabel.setText(file.getPath().toString());
		}
	}
	
	public void onOutputOpenButtonClicked(ActionEvent aEvent){
		FileChooser fc = new FileChooser();
		fc.setTitle("�t�@�C����ۑ�");
		fc.getExtensionFilters().addAll(
				new FileChooser.ExtensionFilter("Playlist File", "*.m3u8"));
		
		File file = fc.showSaveDialog(null);
		outputFile = file;
		
		if(file != null){
			OutputLabel.setText(file.getPath().toString());
		}
	}
	
	public void onStartButtonClicked(ActionEvent aEvent){	
		try{
			FileInputStream fis = new FileInputStream(inputFile);
			InputStreamReader isr = new InputStreamReader(fis,"UTF-8");
			BufferedReader br = new BufferedReader(isr);
			
			FileOutputStream fos = new FileOutputStream(outputFile);
			OutputStreamWriter osw = new OutputStreamWriter(fos,"UTF-8");
			BufferedWriter bw = new BufferedWriter(osw);
			
			String str;
			//String uHome = System.getProperty("user.home");
			while((str = br.readLine()) != null){
				//xxxx�ɂ͎b��I�Ɏ����̖��O�������Ă�
				str = str.replaceAll("C:\\\\Users\\\\xxxx\\\\Music\\\\Media Go\\\\", "");
				bw.write(str+"\n");
			}
			br.close();
			bw.close();
			MessageLabel.setText("���`���܂���");
		}catch(IOException e){
			e.printStackTrace();
			MessageLabel.setText("�t�@�C���̓��o�͂ŗ�O��f���܂���");
		}catch(NullPointerException e){
			e.printStackTrace();
			MessageLabel.setText("�k���|��f���܂���");
		}
	}
}
