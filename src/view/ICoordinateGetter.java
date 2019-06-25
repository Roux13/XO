package view;

import model.Field;
import model.Point;

public interface ICoordinateGetter {

    Point getMoveCoordinate(final Field field);

}
