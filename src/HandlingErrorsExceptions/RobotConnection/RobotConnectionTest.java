//package HandlingErrorsExceptions.RobotConnection;
//
//import javax.swing.plaf.PanelUI;
//
//public class RobotConnectionTest {
//
//    // https://stepik.org/lesson/12773/step/7?after_pass_reset=true&unit=3121
//
//    // Теперь вспомним нашего старого знакомого робота из этой задачи ( https://stepik.org/lesson/12766/step/12 )
//    // Теперь мы будем давать роботу команды удаленно, подключаясь к нему по беспроводному каналу связи
//
//    // Подключеие к роботу представляется в программе интерфейсом RobotConnection:
//    public interface RobotConnection extends AutoCloseable {
//        void moveRobotTo(int x, int y);
//        @Override
//        void close();
//    }
//
//    // Да, робот с тех пор поумнел и стал понимать команду на перемещение в заданную точку метод (moveRobotTo).
//    // Ему больше не нужны пошаговые инструкции
//
//    // RobotConnection - это временно устанавливаемое соединение, которое надо закрывать, когда оно больше не нужно.
//    // Для закрытия соединения в интерфейсе есть метод close().
//
//    // За установку соединения отвечает RobotConnectionManager:
//    public interface RobotConnectionManager {
//        RobotConnection getConnection();
//    }
//
//    // Метод getConnection() делает попытку соединиться с роботом и возвращает установленное соединение,
//    // через которое можно отдавать роботу команды.
//
//    // Установка соединения может завершиться неуспешно, а также уже установленное содеинение может внезапно разорваться.
//    // Всякое бывает. Поэтому любой метод RobotConnectionManager и RobotConnection
//    // может бросить непроверяемое исключение RobotConnectionException:
//    public class RobotConnectionException extends RuntimeException {
//
//        public RobotConnectionException(String message) {
//            super(message);
//        }
//
//        public RobotConnectionException(String message, Throwable cause) {
//            super(message, cause);
//        }
//
//    }
//
//    // Ваша задача - реализовать метод, который устанавливает соединение с роботом,
//    // отдает ему команду на перемещение в заданную точку и затем закрывает соединение,
//    // выполняя при необходимости повтор этой последовательности до трех раз.
//
//    // При этом:
//    // 1. Попытка отдать команду роботу считается успешной, если удалось установить соединение
//    // и выполнить метод RobotConnection.moveRobotTo() без исключений.
//    // Ошибка закрытия соединения не важна и должна игнорироваться.
//    // 2. Если первая попытка подключиться и отдать команду оказалась неуспешной,
//    // то закрываем соединение и выполняем вторую попытку. Если вторая тоже не удалась,
//    // то выполняется третья. После третьей неудачи метод должен бросить исключение RobotConnectionException.
//    // 3. Метод отвечает за открытие и закрытие соединения.
//    // Если соединение удалось установить, то оно обязательно должно быть закрыто
//    // несмотря на возможные исключения, случившиеся в дальнейшем во время работы метода.
//    // 4. Если во время работы метода случилось исключение любого типа, отличного от RobotConnectionException,
//    // метод должен завершиться и выбросить это исключение, не выполняя повторных попыток пообщаться с роботом.
//    // Единственное, что метод должен сделать перед выбросом этого исключения
//    // - закрыть открытое соединение RobotConnection.
//
//    ////
//
//    // Условия короче и яснее, на русском понятном.
//    // RobotConnection.getConnection() устанавливает и возвращает соединение.
//    // RobotConnection.close() закрывает соединение.
//    // Задача: установить соединение. Переместить робота. Закрыть соединение.
//    // Если есть исключение от соединения робота, то попробовать ещё раз. Три попытки.
//    // Попытка засчитывается не глядя на проблемы закрытия, достаточно переместить робота.
//    // Соедниение не получилось? Закрываем его не гляда на проблемы с ним.
//    // Исключение во время работы не от соединения робота? Закрываем коннект и больше ничего не делаем.
//
//    //// Albert Bagdasaryan
//    // 3 дня поставлял регулярно неправильные решения и наконец свершилось.
//    // Не могу назвать решение моим собственным, так как подсмотрел решение 4 года давности
//    // и добавил одну рекомендацию по поводу искусственной установки шага в 3, чтобы завершить метод.
//    // Попробую подытожить:
//    // 1. Конечно использовать цикл for (int step=1; step < 3; step++) и конечно try с ресурсами.
//    // Нигде не вызывать явно close().
//    // 2. Если робот переместился нормально, то выход из цикла путем присвоения step=3.
//    // 3. Но один try() нужны две ловушки: первая ловит заданное специальное исключение RobotConnectionException,
//    // ничего не делает до третьего шага итерации, а на третьем шагу кидает это же исключение;
//    // вторая ловит все Exception и просто кидает пойманный объект "е".
//    // Это решение намного непонятного для меня пункта задания - под номером 4.
//
//    // Спасибо комментаторам по поводу Failed test #1. Test4.
//    // Unexpected RobotConnectionException thrown. Выход по break, метки и return не помогали.
//    // Оказалось в try с ресурсами блоки catch и finally обрабратываются после осовобождения ресурса.
//    // И если произошло исключение при освобождении ресурса оно также обрабатывается в catch.
//
//
//    public static void main(String[] args) {
//
//        // Prdudgin gmail.com
//        // Интересная задача. Совет тем, у кого не получается, напишите реализацию
//        // всех методов и классов, которые испольщуются для того, чтобы можно было тестировать.
//        // Вот его реализация:
//
//        public class RemoteRobot {
//
//            public interface RobotConnection extends AutoCloseable {
//                void moveRobotTo(int x, int y);
//                @Override
//                void close();
//            }
//
//            public interface RobotConnectionManager {
//                RobotConnection getConnection();
//            }
//
//            public class RobotConnectionException extends RuntimeException {
//                public RobotConnectionException(String message) {
//                    super(message);
//                }
//                public RobotConnectionException(String message, Throwable cause) {
//                    super(message, cause);
//                }
//            }
//
//            public class MyRobotConnection implements RobotConnection {
//
//                @Override
//                public void moveRobotTo(int x, int y) {
//                    System.out.println("connection got a command to move");
//                    if (1 == 1) {
//                        throw new RobotConnectionException("connection had thrown an exception");
//                    }
//                    System.out.println("moved successfully");
//                }
//
//                @Override
//                public void close() {
//                    System.out.println("connection for a command to close");
//                }
//            }
//
//            public class MyRobotConnectionManager implements RobotConnectionManager {
//                @Override
//                public RemoteRobot.RobotConnection getConnection() {
//                    System.out.println("creating a new connection");
//
//                    if (1 == 2) {
//                        throw new RobotConnectionException("connection manager thrown exception");
//                    }
//                    return new MyRobotConnection();
//                }
//            }
//
//            public static void moveRobot(RobotConnectionManager robotConnectionManager), int toX, intY {
//                // здесь ваша реализация
//            }
//        }
//
//        public class Main {
//
//            public static void main(String[] args) {
//
//                System.out.println("Hello!");
//
//                RemoteRobot.MyRobotConnectionManager robotConnectionManager = new RemoteRobot().new MyRobotConnectionManager();
//
//                RemoteRobot.moveRobot(robotConnectionManager, 10, 10);
//
//            }
//
//        }
//
//    }
//
//}
