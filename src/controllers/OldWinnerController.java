package controllers;

import model.Field;
import model.Figure;
import model.Point;

public class OldWinnerController {

    private int countX;

    private int countO;

    private boolean findWinner;

    public String getWinner (Field field) {

        final int SIZE = field.getSize();
        findWinner = false;

        checkLine(field, SIZE);
        checkColumn(field, SIZE);
        checkDiagonal(field, SIZE);
        checkDiagonal2(field, SIZE);

        if (countX == SIZE){
            return "X";
        }
        if (countO == SIZE){
            return "O";
        }
        else {
            return null;
        }
    }

    private void countFigure(final Figure figure){
        if (figure.equals("X")) {
            this.countX++;
        }
        if (figure.equals("O")) {
            this.countO++;
        }
    }

    private void checkLine(final Field field, int size) {
        for (int i = 0; i < size; i++) { //search line
            if (countX != size || countO != size) {
                countX = 0;
                countO = 0;
            }
            for (int j = 0; j < size; j++) {
                final Point point = new Point(i, j);
                final Figure figure = field.getFigure(point);
                if (figure == null) {
                    break;
                }
                countFigure(figure);
                if (countX == size || countO == size) {
                    findWinner = true;
                    return;
                }
            }
        }
    }

    private void checkColumn(final Field field, int size) {
        if (findWinner == true){
            return;
        }
        for (int j = 0; j < size; j++) { //search line
            if (countX != size || countO != size) {
                countX = 0;
                countO = 0;
            }
            for (int i = 0; i < size; i++) {
                final Point point = new Point(i, j);
                final Figure figure = field.getFigure(point);
                if (figure == null) {
                    break;
                }
                countFigure(figure);
                if (countX == size || countO == size) {
                    findWinner = true;
                    return;
                }
            }
        }
    }

    private void checkDiagonal(final Field field, int size) {
        if (findWinner == true){
            return;
        }
        countX = 0;
        countO = 0;

        for (int i = 0; i < size; i++) { //search first diagonal
            final Point point = new Point(i, i);
            final Figure figure = field.getFigure(point);
            if (figure == null) {
                countX = 0;
                countO = 0;
                return;
            }
            countFigure(figure);
            if (countX == size || countO == size) {
                findWinner = true;
                return;
            }
        }
    }

    private void checkDiagonal2(final Field field, int size) {
        if (findWinner == true){
            return;
        }
        countX = 0;
        countO = 0;

        for (int j = 0; j < size; j++) { //search second diagonal
            for (int i = 0; i < size; i++) {
                final Point point = new Point(i, j);
                final Figure figure = field.getFigure(point);
                if (i + j == (size - 1)) {
                    if (figure == null) {
                        countX = 0;
                        countO = 0;
                        return;
                    }
                    countFigure(figure);
                    if (countX == size || countO == size) {
                        findWinner = true;
                        return;
                    }
                }
            }
        }
    }

}
