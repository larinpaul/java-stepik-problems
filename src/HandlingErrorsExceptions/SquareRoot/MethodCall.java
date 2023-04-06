package HandlingErrorsExceptions.SquareRoot;

public class MethodCall {

    public static String getCallerClassAndMethodName() {
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        if (stackTrace.length < 4) {
            // At least 4 stack frames are needed for this method to work
            return null;
        } else {
            StackTraceElement caller = stackTrace[3];
            return caller.getClassName() + "#" + caller.getMethodName();
        }
    }



}
