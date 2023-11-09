package MyApp.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.util.Random;

public class ShellGameController {

    @FXML
    Button btn1,btn2,btn3;

    @FXML
    Button raiseBtn,dropBtn;

    @FXML
    Label labelShuffel,labelCredit,labelGambleAmount;


    Image queen;
    Image jack;
    Image yugi;


    public Button[] buttons;
    int gambleAmount = 0;
    int raise =+ 10;
    int credit = 100;
    int guessCard = 0;
    boolean win;



    public void initialize(){
        labelShuffel.setText(" ");
        labelGambleAmount.setText("Amount: " + gambleAmount);

        queen = new Image(getClass().getResourceAsStream("/images/queen.png"));
        jack = new Image(getClass().getResourceAsStream("/images/jack.png"));
        yugi = new Image(getClass().getResourceAsStream("/images/yugi1.png"));
        showBackCards();
        schuffelCard();
        updateCredit();
        disableCardsCheck();
    }


    public void schuffelCard(){
        Random random = new Random();
        guessCard = random.nextInt(3) + 1 ;
        labelShuffel.setText("Number is: " + guessCard + ".");
    }

    public void showCards(ActionEvent actionEvent) {
        Button button = (Button) actionEvent.getSource();


//        Button[] buttons = {btn1,btn2,btn3};
//
//        for(Button b: buttons){
//            b.setText("");
//        }


        if(button.equals(btn1) && guessCard == 1) {
            button.setGraphic(new ImageView(queen));
            button.setStyle("-fx-border-color: green");

            btn2.setGraphic(new ImageView(jack));
            btn2.setStyle("-fx-border-color: red");

            btn3.setGraphic(new ImageView(jack));
            btn3.setStyle("-fx-border-color: red");

            win = true;
        }else if(button.equals(btn2) && guessCard == 2){
            button.setGraphic(new ImageView(queen));
            button.setStyle("-fx-border-color: green");

            btn1.setGraphic(new ImageView(jack));
            btn1.setStyle("-fx-border-color: red");

            btn3.setGraphic(new ImageView(jack));
            btn3.setStyle("-fx-border-color: red");

            win = true;

        }else if(button.equals(btn3) && guessCard == 3){
            button.setGraphic(new ImageView(queen));
            button.setStyle("-fx-border-color: green");


            btn1.setGraphic(new ImageView(jack));
            btn1.setStyle("-fx-border-color: red");

            btn2.setGraphic(new ImageView(jack));
            btn2.setStyle("-fx-border-color: red");

            win = true;

        }else{
            button.setGraphic(new ImageView(jack));

            if(guessCard == 1){
                btn1.setGraphic(new ImageView(queen));
                btn1.setStyle("-fx-border-color: green");
                btn2.setGraphic(new ImageView(jack));
                btn2.setStyle("-fx-border-color: red");
                btn3.setGraphic(new ImageView(jack));
                btn3.setStyle("-fx-border-color: red");
            }else if( guessCard == 2 ){
                btn1.setGraphic(new ImageView(jack));
                btn1.setStyle("-fx-border-color: red");
                btn2.setGraphic(new ImageView(queen));
                btn2.setStyle("-fx-border-color: green");
                btn3.setGraphic(new ImageView(jack));
                btn3.setStyle("-fx-border-color: red");
            }else if(guessCard == 3){
                btn1.setGraphic(new ImageView(jack));
                btn1.setStyle("-fx-border-color: red");
                btn2.setGraphic(new ImageView(jack));
                btn2.setStyle("-fx-border-color: red");
                btn3.setGraphic(new ImageView(queen));
                btn3.setStyle("-fx-border-color: green");

            }
        }

        if(win){
            credit += gambleAmount;
            win = false;
        }else {
            credit -= gambleAmount;

        }

        updateCredit();

    }




    public void onClickBtnRaise(){
        Button[] buttons = {btn1,btn2,btn3};

        if(credit <= gambleAmount) {
            raiseBtn.isDisabled();
        }else if(credit > gambleAmount && gambleAmount >= 0){


                for(Button b: buttons){
                    b.setDisable(false);
                }

            gambleAmount += raise;
        }

        labelGambleAmount.setText("Amount: " + gambleAmount);
    }

    public void onClickBtnDrop() {
        Button[] buttons = {btn1, btn2, btn3};


        if (gambleAmount <= 0) {
            raiseBtn.isDisabled();
        } else {
            gambleAmount -= raise;

            if (gambleAmount == 0) {
                for (Button b : buttons) {
                    b.setDisable(true);
                }
            }
            labelGambleAmount.setText("Amount: " + gambleAmount);
        }
    }


    public void updateCredit(){
        labelCredit.setText("Credit: " + credit);
        resetGambleAmount();

    }

    public void showBackCards(){
        btn1.setText("");
        btn1.setGraphic(new ImageView(yugi));
        btn2.setText("");
        btn2.setGraphic(new ImageView(yugi));
        btn3.setText("");
        btn3.setGraphic(new ImageView(yugi));
    }

    public void resetGambleAmount(){
        gambleAmount = 0;
        labelGambleAmount.setText(String.valueOf("Amount: " + gambleAmount));
    }
    public void onClickBtnShuffle(ActionEvent actionEvent) {

        btn1.setStyle(null);
        btn2.setStyle(null);
        btn3.setStyle(null);

        resetGambleAmount();
        schuffelCard();
        showBackCards();
        disableCardsCheck();
    }


    public void disableCardsCheck(){
        Button[] buttons = {btn1,btn2,btn3};
        if(gambleAmount == 0 ){
            for(Button b: buttons){
                b.setDisable(true);
            }
        }}

}
