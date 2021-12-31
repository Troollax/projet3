package Link;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

public class test extends Application {
	

    @Override
    public void start(Stage Stage) throws IOException {

    	TextArea ta = new TextArea();
    	ta.setEditable(false);
        Console console = new Console(ta);
        PrintStream ps = new PrintStream(console, true);
        System.setOut(ps);
        System.setErr(ps);
        Scene app = new Scene(ta);

        Stage.setScene(app);
        Stage.show();

        for (char c : "some text".toCharArray()) {
            console.write(c);
        }
        ps.close();
    }

    public static void main(String[] args) {
        launch(args);
    }

    public static class Console extends OutputStream {

        private TextArea output;

        public Console(TextArea ta) {
            this.output = ta;
        }

        @Override
        public void write(int i) throws IOException {
            output.appendText(String.valueOf((char) i));
        }
    }
    
    
  
    }
    
   

