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
        // Get the current coordinates and direction of the robot
        int x = robot.getX();
        int y = robot.getY();
        Direction direction = robot.getDirection();

        // Loop until the robot reaches the target position
        while (x != toX || y != toY) {
            // Check if the robot needs to move horizontally
            if (x != toX) {
                // Check if the robot needs to move right or left
                if (x < toX) {
                    // Turn the robot right if it is not facing right
                    while (direction != Direction.RIGHT) {
                        robot.turnRight();
                        direction = robot.getDirection();
                    }
                } else {
                    // Turn the robot left if it is not facing left
                    while (direction != Direction.LEFT) {
                        robot.turnLeft();
                        direction = robot.getDirection();
                    }
                }
                // Move the robot forward until it reaches the target x coordinate
                while (x != toX) {
                    robot.stepForward();
                    x = robot.getX();
                }
            }

            // Check if the robot needs to move vertically
            if (y != toY) {
                // Check if the robot needs to move up or down
                if (y < toY) {
                    // Turn the robot up if it is not facing up
                    while (direction != Direction.UP) {
                        robot.turnRight();
                        direction = robot.getDirection();
                    }
                } else {
                    // Turn the robot down if it is not facing down
                    while (direction != Direction.DOWN) {
                        robot.turnLeft();
                        direction = robot.getDirection();
                    }
                }
                // Move the robot forward until it reaches the target y coordinate
                while (y != toY) {
                    robot.stepForward();
                    y = robot.getY();
                }
            }
        }
    }


}
