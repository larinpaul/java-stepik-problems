//package HandlingErrorsExceptions.RobotConnection;
//
//public class RobotConnection {
//
//    // В данной задаче требуется реализовать метод moveRobot, который подключается к роботу
//    // по беспроводному каналу связи и отдает ему команду на перемещение в заданную точку,
//    // повторяя эту последовательность до трех раз в случае неудачи.
//    // Все возможные исключения должны быть обработаны.
//
//    // TODO Задачу СДЕЛАТЬ С НУЛЯ
//    public static void moveRobot(RobotConnectionManager robotConnectionManager, int toX, int toY) {
//
//        for (int i = 0; i < 3; i++) {
//            try (RobotConnection connection = robotConnectionManager.getConnection()) {
//                connection.moveRobotTo(toX, toY);
//                return;
//            } catch (RobotConnectionException e) {
//                continue;
//            } catch (Exception e) {
//                try {
//                    robotConnectionManager.getConnection().close();
//                } catch (Exception ex) {}
//                throw e;
//            }
//        }
//        throw new RobotConnectionException("Unable to establish connection");
//    }
//
//    Для решения задачи можно использовать следующий алгоритм:
//
//    Создать объект RobotConnectionManager
//    и вызвать его метод getConnection() для получения соединения.
//    Обернуть выполнение метода moveRobotTo() в цикл, который будет повторять попытки до трех раз,
//    если возникает исключение RobotConnectionException.
//    После каждой попытки закрывать соединение с помощью метода close() объекта RobotConnection.
//    Если после трех попыток соединение не удалось установить, закрыть соединение и выбросить исключение.
//    Если во время выполнения метода moveRobotTo() возникает исключение,
//    не связанное с RobotConnectionException, закрыть соединение и больше ничего не делать.
//    Вот реализация метода moveRobot():
//
//    php
//    Copy code
//    public static void moveRobot(RobotConnectionManager robotConnectionManager, int toX, int toY) {
//        int retriesLeft = 3;
//        boolean connectionEstablished = false;
//        RobotConnection connection = null;
//
//        while (retriesLeft > 0 && !connectionEstablished) {
//            try {
//                connection = robotConnectionManager.getConnection();
//                connection.moveRobotTo(toX, toY);
//                connection.close();
//                connectionEstablished = true;
//            } catch (RobotConnectionException e) {
//                retriesLeft--;
//                if (retriesLeft == 0) {
//                    if (connection != null) {
//                        try {
//                            connection.close();
//                        } catch (Exception ignored) {}
//                    }
//                    throw e;
//                }
//            } catch (Exception e) {
//                if (connection != null) {
//                    try {
//                        connection.close();
//                    } catch (Exception ignored) {}
//                }
//                break;
//            }
//        }
//    }
//    В этой реализации используется переменная retriesLeft для хранения количества оставшихся попыток.
//    Цикл продолжается, пока остаются попытки или соединение не будет успешно установлено.
//    После установления соединения метод moveRobotTo() вызывается один раз, а затем соединение закрывается.
//    Если при вызове moveRobotTo() возникает исключение RobotConnectionException,
//    уменьшается количество оставшихся попыток.
//    Если попыток не осталось, соединение закрывается и выбрасывается исключение.
//    Если во время выполнения метода moveRobotTo() возникает исключение,
//    не связанное с RobotConnectionException, цикл прерывается и соединение закрывается.
//
//
//
//}
