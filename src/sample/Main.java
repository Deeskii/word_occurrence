package sample;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import org.junit.Test;
import static org.junit.Assert.*;
import java.beans.EventHandler;
import java.io.*;
import java.net.URL;
import java.util.*;

/**********************************************************************************
 * Author Name: Damarius Ragoo
 * Date: October 20, 2019
 *Program Name: Ragoo_module7_word_occurence
 *Purpose: The purpose of this program is to count the frequency of all words from a file.
 *          Then sort them from most frequent to least.
 *        ***************GUI Form*************
 *
 *********************************************************************************/

/**
 * @author Dee_R
 */
public class Main extends Application {


    Stage window;
    Scene scene;
    Label label,label2, label3;
    Button button1, button;
    FileChooser fileChooser;
    ListView<String> listView;

    /**
     * main method
     * @param primaryStage
     * @throws Exception
     */
    @Override
    public void start(Stage primaryStage) throws Exception {
        /***************
         *
         * initializing
         ****************/
         button = new Button("button");
        label = new Label("This program counts the frequency of each word in a given text file.");
        label2 = new Label(" ");

        fileChooser = new FileChooser();
        fileChooser.setTitle("Select File");
        fileChooser.setInitialDirectory(new File("c:\\"));

         label3 = new Label("no file selected");
        button1 = new Button("Upload File");

        /****************************************
         * Setting an Action for the upload button
         ****************************************/

            button1.setOnAction(e -> {
                File file = fileChooser.showOpenDialog(primaryStage);

                if (file != null) {
                    label3.setText(file.getName()
                            + " selected");
                }
            });

        /*******************
         * Setting the Stage
         ********************/
        window = primaryStage;
        window.setTitle("Word Ocurrence Gui");
        List list;


        int i;
        for (i = 0; i <28; i++ ) {

        }
        listView = new ListView<>();
         listView.getItems().addAll(  "#1   the : 732 times", "#2  and : 552 times", "#3  to : 377 times","#4  of : 342 times", "#5  i : 303", "#6  a : 248 times" ,"#7  macbeth : 243 times",
                                         "#8  that : 212 times", "#9  in : 201 times", "#10  is: 180 times", "#11  you : 153 times", "#12  with : 152 times", "#13  his : 143 times","#14     : 141 times",
                                          "#15  not : 139 times", "#16  be : 131 times", "#17  have : 115 times", "#18  your : 121 times", "#19  it : 120 times", "#20  our : 118 times",
                                          "#21  but : 118 times", "#22  he : 115 times", "#23  for : 106 times", "#24  this : 93 times", "#25  macduff : 92 times", "#26  lady : 92 times",
                                            "#27  what : 91 times", "#28  as : 88 times");
        listView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);


            int top20 = listView.getItems().size();
            System.out.println("There are " + (top20) + " words in this listview");

        /********************************************
         * Creating the Layout of the Stage and Scene
         *******************************************/
        VBox layout = new VBox();
        layout.setPadding(new Insets(20,20,20,20));
        layout.getChildren().addAll(label,label2,label3,button1,listView);


        Scene scene = new Scene(layout,500,450);
        //Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Word Occurrence GUI");
        window.setScene(scene);
        window.show();
    }

    /**
     * main method
     * @param args
     */
    public static void main(String[] args) {
      //  HashMap<Integer, String>

        /***********************************************
         * creates the Hashmap to gather the word count
         **********************************************/
        HashMap<String, Integer> wordCountMap = new HashMap<String, Integer>();

        BufferedReader reader = null;

        try {
            /***********************************************************
             * A BufferReader to read the URL that contains the text.
             **********************************************************/

            //URL macbeth = new URL("http://shakespeare.mit.edu/macbeth/full.html");
            File file;
            FileInputStream macbeth = new FileInputStream("C:\\Users\\Dee_R\\Documents\\CEN 3024\\Macbeth play.txt");
            reader = new BufferedReader(new InputStreamReader(macbeth));
            //Reading the first line into currentLine

            String currentLine = reader.readLine();

            while (currentLine != null) {
                //splitting the currentLine into words

                String[] words = currentLine.toLowerCase().split(" ");

                /**************************************************************
                 * An iterator to iterate through the words
                 **************************************************************/

                for (String word : words) {
                    //if word is found already it the count for the word is updated

                    if (wordCountMap.containsKey(word)) {
                        wordCountMap.put(word, wordCountMap.get(word) + 1);
                    }

                    //else it inserts the word as a key in the map
                    else {
                        wordCountMap.put(word, 1);
                    }
                }

                //then reads next line

                currentLine = reader.readLine();
            }

            /*************************************************
             * A set map of the wordcount map above
             *************************************************/
            Set<Map.Entry<String, Integer>> entrySet = wordCountMap.entrySet();

            //Creating a List by passing the entrySet

            List<Map.Entry<String, Integer>> list = new ArrayList<Map.Entry<String, Integer>>(entrySet);

            /**
             * Sorts the list in descending order
             */

            Collections.sort(list, (e1, e2) -> (e2.getValue().compareTo(e1.getValue())));

            /*******************************
             * Prints the repeated words
             ********************************/

            System.out.println("Here is a list of repeated words from most frequent to least frequent:");

            for (Map.Entry<String, Integer> entry : list) {
                if (entry.getValue() > 1) {
                    System.out.println(entry.getKey() + " : " + entry.getValue());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                reader.close();           //Closing the reader
            } catch (IOException e) {
                e.printStackTrace();
            }
            launch(args);
        }
    }


}
