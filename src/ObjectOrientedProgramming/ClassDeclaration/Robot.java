package ObjectOrientedProgramming.ClassDeclaration;

public class Robot {

    // https://pastebin.com/eTsVZZrK
    // https://stepik.org/lesson/12766/step/12?after_pass_reset=true&unit=3114

//    На игровом поле находится робот. Позиция робота на поле описывается двумя целочисленным координатами: X и Y.
//    Ось X смотрит слева направо, ось Y — снизу вверх. (Помните, как рисовали графики функций в школе?)
//
//    В начальный момент робот находится в некоторой позиции на поле.
//    Также известно, куда робот смотрит: вверх, вниз, направо или налево.
//    Ваша задача — привести робота в заданную точку игрового поля.
//
//    Робот описывается классом Robot. Вы можете пользоваться следующими его методами (реализация вам неизвестна):
//
//    public class Robot {
//
//        public Direction getDirection() {
//            // текущее направление взгляда
//        }
//
//        public int getX() {
//            // текущая координата X
//        }
//
//        public int getY() {
//            // текущая координата Y
//        }
//
//        public void turnLeft() {
//            // повернуться на 90 градусов против часовой стрелки
//        }
//
//        public void turnRight() {
//            // повернуться на 90 градусов по часовой стрелке
//        }
//
//        public void stepForward() {
//            // шаг в направлении взгляда
//            // за один шаг робот изменяет одну свою координату на единицу
//        }
//    }
//    Direction, направление взгляда робота, — это перечисление:
//    public enum Direction {
//        UP,
//        DOWN,
//        LEFT,
//        RIGHT
//    }
//
//    Как это выглядит:
//
//    Пример
//
//    В метод передано: toX == 3, toY == 0; начальное состояние робота такое: robot.getX() == 0, robot.getY() == 0, robot.getDirection() == Direction.UP
//
//    Чтобы привести робота в указанную точку (3, 0), метод должен вызвать у робота следующие методы:
//
//robot.turnRight();
//robot.stepForward();
//robot.stepForward();
//robot.stepForward();

    int x;
    int y;
    Direction direction;

    public Robot(int x, int y, Direction direction) {
        this.x = x;
        this.y = y;
        this.direction = direction;
    }

    public Direction getDirection() {
        return direction;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void turnLeft() {
        if (direction == Direction.UP) {
            direction = Direction.LEFT;
        } else if (direction == Direction.DOWN) {
            direction = Direction.RIGHT;
        } else if (direction == Direction.LEFT) {
            direction = Direction.DOWN;
        } else if (direction == Direction.LEFT) {
            direction = Direction.DOWN;
        } else if (direction == Direction.RIGHT) {
            direction = Direction.UP;
        }
    }

    public void turnRight() {
        if (direction == Direction.UP) {
            direction = Direction.RIGHT;
        } else if (direction == Direction.DOWN) {
            direction = Direction.LEFT;
        } else if (direction == Direction.LEFT) {
            direction = Direction.UP;
        } else if (direction == Direction.RIGHT) {
            direction = Direction.DOWN;
        }
    }

    public void stepForward() {
        if (direction == Direction.UP) {
            y++;
        }
        if (direction == Direction.DOWN) {
            y--;
        }
        if (direction == Direction.LEFT) {
            x--;
        }
        if (direction == Direction.RIGHT) {
            x++;
        }
    }

    public static void moveRobot(Robot robot, int toX, int toY) {

        int targetX = toX;
        int targetY = toY;

        int currentX = robot.getX();
        int currentY = robot.getY();
        Direction currentDirection = robot.getDirection();

        // Find the relative position of the target point
        int relativeX = targetX - currentX;
        int relativeY = targetY - currentY;

        // Face the correct direction to move towards the target point
        while ((currentDirection != Direction.UP && relativeY > 0) ||
                (currentDirection != Direction.DOWN && relativeY < 0)) {
            if (currentDirection == Direction.LEFT || currentDirection == Direction.RIGHT) {
                robot.turnLeft();
            } else {
                robot.turnRight();
            }
            currentDirection = robot.getDirection();
        }

        while ((currentDirection != Direction.RIGHT && relativeX > 0) ||
                (currentDirection != Direction.LEFT && relativeX < 0)) {
            if (currentDirection == Direction.UP || currentDirection == Direction.DOWN) {
                robot.turnLeft();
            } else {
                robot.turnRight();
            }
            currentDirection = robot.getDirection();
        }

        // Move toward the target point
        while (robot.getX() != targetX) {
            robot.stepForward();
        }
        while (robot.getY() != targetY) {
            robot.stepForward();
        }
    }

}
