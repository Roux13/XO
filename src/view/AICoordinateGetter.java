package view;

import model.Field;
import model.Figure;
import model.Point;

public class AICoordinateGetter implements ICoordinateGetter {

    private static int COUNT_X;

    private static int COUNT_O;

    private static int SIZE;

    public Point getMoveCoordinate(final Field field) {
        // BEGIN (write your solution here) (write your solution here)
        SIZE = field.getSize();
        checkField(field);
        Point p;
        if (COUNT_X == 0 && COUNT_O == 0) {
            p = new Point(1, 1);
            return p;
        }
        if (COUNT_X == 1 && COUNT_O == 1) {
            p = new Point(2, 2);
            Figure fig = field.getFigure(p);
            if (fig == null) {
                return p;
            } else {
                p = new Point(0, 2);
                return p;
            }
        }
        p = checkDiagonal(field, Figure.X);
        if (p != null) {
            return p;
        }
        p = checkDiagonal2(field, Figure.X);
        if (p != null) {
            return p;
        }
        p = checkColumn(field, Figure.X);
        if (p != null) {
            return p;
        }
        p = checkLine(field, Figure.X);
        if (p != null) {
            return p;
        }
        p = checkDiagonal(field, Figure.O);
        if (p != null) {
            return p;
        }
        p = checkDiagonal2(field, Figure.O);
        if (p != null) {
            return p;
        }
        p = checkColumn(field, Figure.O);
        if (p != null) {
            return p;
        }
        p = checkLine(field, Figure.O);
        if (p != null) {
            return p;
        }
        p = new Point(2, 2);
        Figure fig = field.getFigure(p);
        if (fig == null) {
            return p;
        }
        p = new Point(0, 2);
        fig = field.getFigure(p);
        if (fig == null) {
            return p;
        }
        p = new Point(2, 0);
        fig = field.getFigure(p);
        if (fig == null) {
            return p;
        }
        RandomCoordinateGetter rCG = new RandomCoordinateGetter();
        return rCG.getMoveCoordinate(field);
    }
    // END

    // BEGIN (write your solution here)

    private Point checkDiagonal(final Field field, final Figure fig) {
        int countFig = 0;
        int countNull = 0;
        Point nullPoint = null;
        for (int i = 0; i < SIZE; i++) { //search first diagonal
            final Point point = new Point(i, i);
            final Figure figure = field.getFigure(point);
            if (figure == fig) {
                countFig++;
            }
            if (figure == null) {
                countNull++;
                nullPoint = point;
            }
        }
        if (countFig == 2 && countNull == 1) {
            return nullPoint;
        } else {
            return null;
        }
    }

    private Point checkDiagonal2(final Field field, final Figure fig) {
        int countFig = 0;
        int countNull = 0;
        Point nullPoint = null;
        for (int j = 0; j < SIZE; j++) { //search second diagonal
            for (int i = 0; i < SIZE; i++) {
                if (i + j == (SIZE - 1)) {
                    final Point point = new Point(i, j);
                    final Figure figure = field.getFigure(point);
                    if (figure == fig) {
                        countFig++;
                    }
                    if (figure == null) {
                        countNull++;
                        nullPoint = point;
                    }
                }
            }
        }
        if (countFig == 2 && countNull == 1) {
            return nullPoint;
        } else {
            return null;
        }
    }

    private Point checkColumn(final Field field, final Figure fig) {
        int countFig = 0;
        int countNull = 0;
        Point nullPoint = null;
        for (int j = 0; j < SIZE; j++) { //search line
            countFig = 0;
            countNull = 0;
            nullPoint = null;
            for (int i = 0; i < SIZE; i++) {
                final Point point = new Point(i, j);
                final Figure figure = field.getFigure(point);
                if (figure == fig) {
                    countFig++;
                }
                if (figure == null) {
                    countNull++;
                    nullPoint = point;
                }
            }
            if (countFig == 2 && countNull == 1) {
                return nullPoint;
            }
        }
        if (countFig == 2 && countNull == 1) {
            return nullPoint;
        }
        return null;
    }

    private Point checkLine(final Field field, final Figure fig) {
        int countFig = 0;
        int countNull = 0;
        Point nullPoint = null;
        for (int i = 0; i < SIZE; i++) { //search line
            countFig = 0;
            countNull = 0;
            nullPoint = null;
            for (int j = 0; j < SIZE; j++) {
                final Point point = new Point(i, j);
                final Figure figure = field.getFigure(point);
                if (figure == fig) {
                    countFig++;
                }
                if (figure == null) {
                    countNull++;
                    nullPoint = point;
                }
            }
            if (countFig == 2 && countNull == 1) {
                return nullPoint;
            }
        }
        if (countFig == 2 && countNull == 1) {
            return nullPoint;
        }
        return null;
    }

    private void checkField(Field field) {
        COUNT_X = 0;
        COUNT_O = 0;
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                Point p = new Point(i, j);
                Figure fig = field.getFigure(p);
                if (fig == Figure.X) {
                    COUNT_X++;
                }
                if (fig == Figure.O) {
                    COUNT_O++;
                }
            }
        }
    }
    // END
}