package com.company;

import java.util.ArrayList;

public class DotComBust {
    private GameHeler helper = new GameHeler();
    private ArrayList<DotCom> dotComList = new ArrayList<DotCom>();
    private int numOfGuesses = 0;

    private void setUpGame(){
        DotCom one = new DotCom();
        one.setName("Pets.com");

        DotCom two = new DotCom();
        two.setName("eToys.com");

        DotCom three = new DotCom();
        three.setName("Go2.com");

        dotComList.add(one);
        dotComList.add(two);
        dotComList.add(three);

        System.out.println("Ваша цель - потопить три сайтаю");
        System.out.println("Pets.com, eToys.com, Go2.com");
        System.out.println("Попытайтесь потопить их за минимальное количество ходов");

        for (DotCom dotComToSet : dotComList) {
            ArrayList<String> newLocation = helper.placeDotCom(3);
            dotComToSet.setLocationCells(newLocation);
        }
    }

    private void startPlaying() {
        while (!dotComList.isEmpty()) {
            String userGuess = helper.getUserInput("Сделайте ход");
            checkUserGuess(userGuess);
        }

        finishGame();
    }

    private void checkUserGuess(String userGuess) {
        numOfGuesses++;
        String result = "Мимо";

        for (DotCom dotComToSet : dotComList) {
            result = dotComToSet.checkYourself(userGuess);

            if (result.equals("Попал")){
                dotComList.remove(dotComToSet);
                break;
            }

        }

        System.out.println(result);
    }

    private void finishGame(){
        System.out.println("конец игры");

        if (numOfGuesses <= 18) {
            System.out.println("Поздравляю. У вас всего" + numOfGuesses + "попыток");

        } else {
            System.out.println("Ничего страшного вы показали не лучший результат. У вас всего" + numOfGuesses + "попыток");
        }
    }

    public static void main (String[] args) {
        DotComBust game = new DotComBust();
                game.setUpGame();
                game.startPlaying();
    }


}
