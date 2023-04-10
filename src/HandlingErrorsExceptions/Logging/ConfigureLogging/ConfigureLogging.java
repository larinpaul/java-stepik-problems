package HandlingErrorsExceptions.Logging.ConfigureLogging;

// https://stepik.org/lesson/12774/step/8?unit=3122

// В этой задаче вам нужно реализовать метод, настраивающий параметры логгирования.
// Конфигурирование в коде позволяет выполнить более тонкую и хитрую настройку,
// чем при помощи properties-файла.

// Требуется выставить такие настройки, чтобы:
// 1. Логгер с именем "org.stepic.java.logging.ClassA" принимал сообщения всех уровней.
// 2. Логгер с именем "org.stepic.java.loging.ClassB" принимал только сообщения уровня WARNING и серьезнее.
// 3. Все сообщения, пришедшие от нижестоящих логгеров на уровень "org.stepic.java", независимо от серьезности
// сообщения печатались в консоль в формате XML (*) и НЕ передавались вышестоящим обработчикам
// на уровень "org.stepic", "org" и "".

// Не упомянутые здесь настройки изменяться не должны.

// (*) В реальных программах мы бы конечно печатали XML не в консоль, а в файл.
// Но проверяющая система не разрешает создавать файлы на диске, поэтому придется так.

// Подсказки:
// 1. Level есть не только у Logger, но и у Handler.
// 2. Передача сообщения на обработку родительскому Handler'у регулируется свойством useParentHandlers.

// Константин Кононенко:
// Пошаговая стратегия (для тех, кто очень хочет уложиться в мягкий дедлайн)
// - инициализируем переменную для логгера класса А и устанавливаем ему заданный ровень
// - то же для класса В
// - инициализируем переменную для логгера класса "org.stepic.java"
// - лезем в документацию и смотрим что там с родителями логгера - как сделать так, чтобы сообщения не передавались выше
// - устанавливаем ему эту фичу
// - инициализируем ConsoleHandler
// - устанавливаем ему нужный уровень
// - добавляем его к логгеру нашего самого верхнего уровня
// - инициализируем нужный форматтер
// - устанавливаем его нашему ConsoleHandler


import java.util.logging.ConsoleHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.XMLFormatter;

public class ConfigureLogging {

    private static void configureLogging() {
        // Инициализируем логгеры классов А и В и устанавливаем им нужный уровень
        Logger classALogger = Logger.getLogger("org.stepic.java.logging.ClassA");
        classALogger.setLevel(Level.ALL);

        Logger classBLogger = Logger.getLogger("org.stepic.java.logging.ClassB");
        classBLogger.setLevel(Level.WARNING);

        // Инициализируем логгер нашего самого верхнего уровня и выставляем ему нужные настройки
        Logger topLogger = Logger.getLogger("org.stepic.java");
        topLogger.setUseParentHandlers(false);
        topLogger.setLevel(Level.ALL);

        // Инициализируем ConsoleHandler и устанавливаем ему нужный уровень
        ConsoleHandler consoleHandler = new ConsoleHandler();
        consoleHandler.setLevel(Level.ALL);

        // Добавляем ConsoleHandler к нашему самому верхнему логгеру
        topLogger.addHandler(consoleHandler);

        // Инициализируем форматтер и устанавливаем его нашему ConsoleHandler
        XMLFormatter xmlFormatter = new XMLFormatter();
        consoleHandler.setFormatter(xmlFormatter);

    }

}
