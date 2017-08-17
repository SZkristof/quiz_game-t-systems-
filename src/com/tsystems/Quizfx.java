package com.tsystems;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.collections.ObservableList;
import java.util.ArrayList;
import java.util.Collections;
import javafx.scene.image.Image;
import java.io.FileInputStream;


public class Quizfx extends Application {
    //fx
    //creating a Group object
    Group group = new Group();
    //Creating a Scene by passing the group object, height and width
    Scene scene = new Scene(group ,800, 600);
    //Retrieving the observable list object
    ObservableList list = group.getChildren();

    //csv
    csvReader file = new csvReader();
    ArrayList questionTable = new ArrayList(file.readFile());

    //globals
    ArrayList<String> questionLine = new ArrayList<>();
    int score = 0;

    @Override
    public void start(Stage primaryStage) throws Exception {
        Intro();
        //setting color to the scene
        scene.setFill(Color.MAGENTA);
        //Setting the title to Stage.
        primaryStage.setTitle("The Ultimate Quiz Challenge");
        //Adding the scene to Stage
        primaryStage.setScene(scene);
        //Disabling resize
        primaryStage.setResizable(false);
        //Displaying the contents of the stage
        primaryStage.show();
    }
    public void createScore(int score){
        Rectangle rectangleScore = new Rectangle();
        rectangleScore.setX(100);
        rectangleScore.setY(500);
        rectangleScore.setHeight(30);
        rectangleScore.setWidth(180);
        rectangleScore.setFill(Color.GREY);

        Text textScore = new Text();
        textScore.setFont(new Font(20));
        textScore.setX(110);
        textScore.setY(520);
        textScore.setText("Your score is: " + String.valueOf(score));

        list.add(rectangleScore);
        list.add(textScore);
    }
    public void createAnswer(int answerX, int answerY, String answerText) {
        //Answer rectangle
        Rectangle rectangleAnswer = new Rectangle();
        Text textAnswer = new Text();

        //Resources to dynamically resize rectangle for smoothly containing the text
        int textSize = answerText.length();
        int textWidth = (textSize * 40)/3 - 25;
        System.out.println(textSize);
        System.out.println(textWidth);

        //Setting the properties of the rectangle
        rectangleAnswer.setX(answerX);
        rectangleAnswer.setY(answerY);
        if (textWidth > 100) {
            rectangleAnswer.setWidth(textWidth);
        } else {
            rectangleAnswer.setWidth(100.0f);
        }
        rectangleAnswer.setHeight(40.0f);
        //Setting the height and width of the arc
        rectangleAnswer.setArcWidth(30.0);
        rectangleAnswer.setArcHeight(20.0);
        //Color rectangle
        rectangleAnswer.setFill(Color.LIGHTYELLOW);

        //Setting font to the text
        textAnswer.setFont(new Font(20));
        //setting the position of the text
        textAnswer.setX(answerX+10);
        textAnswer.setY(answerY+25);
        //Setting the text to be added.
        textAnswer.setText(answerText);

        EventHandler<MouseEvent> eventHandler = new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent e) {
                System.out.println("Answer clicked!");
                if (questionLine.get(1) == textAnswer.getText()) { score += 1;}
                group.getChildren().clear();
                turnGenerator(questionGenerator(questionTable));
            }
        };

        //Registering the event filter
        rectangleAnswer.addEventFilter(MouseEvent.MOUSE_CLICKED, eventHandler);
        textAnswer.addEventFilter(MouseEvent.MOUSE_CLICKED, eventHandler);

        list.add(rectangleAnswer);
        list.add(textAnswer);
    }
    public void createQuestion(String questionText){
        //Question rectangle
        Rectangle rectangleQuestion = new Rectangle();
        //Setting the properties of the rectangle
        rectangleQuestion.setX(100.0f);
        rectangleQuestion.setY(75.0f);
        rectangleQuestion.setWidth(600.0f);
        rectangleQuestion.setHeight(80.0f);
        //Setting the height and width of the arc
        rectangleQuestion.setArcWidth(30.0);
        rectangleQuestion.setArcHeight(20.0);
        //Color rectangle
        rectangleQuestion.setFill(Color.LIGHTYELLOW);

        //Question text
        Text textQuestion = new Text();
        //Setting font to the text
        textQuestion.setFont(new Font(50));
        //setting the position of the text
        textQuestion.setX(120);
        textQuestion.setY(130);
        //Setting the text to be added.
        textQuestion.setText(questionText);

        list.add(rectangleQuestion);
        list.add(textQuestion);
    }

    public void gameOver(){
        group.getChildren().clear();
        Text textGameOver = new Text();
        textGameOver.setX(150);
        textGameOver.setY(200);
        textGameOver.setText("Game Over!");
        textGameOver.setFont(new Font(50));

        Text textScore = new Text();
        textScore.setX(150);
        textScore.setY(300);
        textScore.setText("Your final score is: "+ score);
        textScore.setFont(new Font(40));

        Rectangle rectangleScore = new Rectangle();
        rectangleScore.setX(140.0f);
        rectangleScore.setY(255.0f);
        rectangleScore.setWidth(430.0f);
        rectangleScore.setHeight(60.0f);
        rectangleScore.setArcWidth(30.0);
        rectangleScore.setArcHeight(20.0);
        rectangleScore.setFill(Color.LIGHTYELLOW);

        Rectangle rectangleGameOver = new Rectangle();
        rectangleGameOver.setX(140.0f);
        rectangleGameOver.setY(150.0f);
        rectangleGameOver.setWidth(320.0f);
        rectangleGameOver.setHeight(65.0f);
        rectangleGameOver.setArcWidth(30.0);
        rectangleGameOver.setArcHeight(20.0);
        rectangleGameOver.setFill(Color.LIGHTYELLOW);

        Text textExit = new Text();
        textExit.setX(148);
        textExit.setY(435);
        textExit.setText("EXIT");
        textExit.setFont(new Font(30));

        Rectangle rectangleExit = new Rectangle();
        rectangleExit.setX(140.0f);
        rectangleExit.setY(405.0f);
        rectangleExit.setWidth(80.0f);
        rectangleExit.setHeight(40.0f);
        rectangleExit.setArcWidth(30.0);
        rectangleExit.setArcHeight(20.0);
        //Color rectangle
        rectangleExit.setFill(Color.RED);

        //Creating the mouse event handler
        EventHandler<MouseEvent> eventHandler = new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent e) {
                System.exit(0);
            }
        };

        //Registering the event filter
        rectangleExit.addEventFilter(MouseEvent.MOUSE_CLICKED, eventHandler);
        textExit.addEventFilter(MouseEvent.MOUSE_CLICKED, eventHandler);

        list.add(rectangleGameOver);
        list.add(textGameOver);
        list.add(rectangleScore);
        list.add(textScore);
        list.add(rectangleExit);
        list.add(textExit);
    }

    public ArrayList questionGenerator(ArrayList<ArrayList<String>> questionTable){
        if (questionTable.size() > 0){
            questionLine = new ArrayList<>(questionTable.get(0));
            String question = questionLine.get(0);

            System.out.println(questionLine);
            ArrayList<String> tempQuestion = new ArrayList<>(questionLine);
            tempQuestion = questionTable.get(0);

            tempQuestion.remove(0);
            Collections.shuffle(tempQuestion);
            tempQuestion.add(0, question);

            System.out.println(questionLine);
            System.out.println(tempQuestion);

            questionTable.remove(0);

            return tempQuestion;
        } else {
            ArrayList<String> thisIsTheEnd = new ArrayList<>();
            return thisIsTheEnd;
        }
    }

    public void turnGenerator(ArrayList<String> questionLine){
        if (questionLine.size() == 0) {
            gameOver();
        } else {
            createScore(score);
            createQuestion(questionLine.get(0));
            createAnswer(100, 200, questionLine.get(1));
            createAnswer(400, 200, questionLine.get(2));
            createAnswer(100, 300, questionLine.get(3));
            createAnswer(400, 300, questionLine.get(4));
        }
    }

    public void Intro(){


        //Creating an image
        //Image image = new Image(new FileInputStream("images/tsystemslogo.png"));

        //Loading image from URL
        //Image image = new Image(new FileInputStream("url for the image));

        //Drawing a Circle
        Circle circleStart = new Circle();
        //Setting the properties of the circle
        circleStart.setCenterX(400.0f);
        circleStart.setCenterY(300.0f);
        circleStart.setRadius(200.0f);
        circleStart.setFill(Color.WHITE);

        //Creating a welcome text object
        Text textStart = new Text();
        //Setting font to the text
        textStart.setFont(new Font(25));
        //setting the position of the text
        textStart.setX(230);
        textStart.setY(300);
        //Setting the text to be added.
        textStart.setText("Click here to start the Quiz");

        //Creating a line object
        Line lineStart = new Line();
        //Setting the properties to a line
        lineStart.setStartX(230.0);
        lineStart.setStartY(305.0);
        lineStart.setEndX(565.0);
        lineStart.setEndY(305.0);

        //Creating the mouse event handler
        EventHandler<MouseEvent> eventHandler = new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent e) {
                System.out.println("Fasten your seatbelts!");
                group.getChildren().remove(lineStart);
                group.getChildren().remove(circleStart);
                group.getChildren().remove(textStart);
                scene.setFill(Color.MAGENTA);
                turnGenerator(questionGenerator(questionTable));
            }
        };
        //Registering the event filter
        circleStart.addEventFilter(MouseEvent.MOUSE_CLICKED, eventHandler);

        //Setting the text object as a node to the group object
        list.add(circleStart);
        list.add(lineStart);
        list.add(textStart);
    }
    public static void main(String[] args){
        launch(args);
    }
}
