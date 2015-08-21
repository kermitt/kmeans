
public class Caller {

    public static void showStack(String msg) {

        StackTraceElement[] ste = new Throwable().getStackTrace();

        String out = msg + "\n";

        for ( int i = 1; i < ste.length; i++) {

                                             /* skip the 0th, i.e., the Caller object itself */

            int j = i - 1;

            String clazz = ste[i].getClassName();

            if ( doNotNotPayAttention(clazz)) {

                String line = " ln: " + ste[i].getLineNumber();

                String name = " c: " + ste[i].getClassName();

                String method = " m: " + ste[i].getMethodName();

                out +=  j + line + name + method + "\n";

            }

        }

        System.out.println( out );

    }

 

    public static void error(String msg, Exception e) {

        StackTraceElement[] ste = e.getStackTrace();

        String out = msg + "\n";

        for ( int i = 0; i < ste.length; i++) {

            String clazz = ste[i].getClassName();

            if ( doNotNotPayAttention(clazz)) {

                String line = " ln: " + ste[i].getLineNumber();

                String name = " c: " + ste[i].getClassName();

                String method = " m: " + ste[i].getMethodName();

                msg +=  i + line + name + method;

            }

        }

        System.out.println( out );

    }

 

    public static void log_from_helper(String msg) {

        StackTraceElement[] ste = new Throwable().getStackTrace();

        String out = msg + "\n";

        

        boolean isRelevent = true;

        

        for ( int i = 1; i < ste.length; i++) {

               

                                             /* skip the 0th, i.e., the Caller object itself */

            int j = i - 1;

            String clazz = ste[i].getClassName();

            if ( doNotNotPayAttention(clazz)) {

                String line = " ln: " + ste[i].getLineNumber();

                String name = " c: " + ste[i].getClassName();

                String method = " m: " + ste[i].getMethodName();

            

                if ( method.contains("<init>")) {

                              isRelevent = false;

                }

                if ( isRelevent ) {

              g                out +=  j + line + name + method + "\n";

                }

            }

        }

        System.out.println( out );

    }

    

    public static void log( String msg ){

        StackTraceElement[] ste = new Throwable().getStackTrace();

 

        String line = " ln: " + ste[1].getLineNumber();

        String clazz = " c: " + ste[1].getClassName();

        String method = " m: " + ste[1].getMethodName();

 

        String out = msg + " |\t" + line + clazz + method;

 

        System.out.println( out );

    }

    public static void info( String msg ) {

               System.out.println( msg ); 

    }

    public static void log( boolean b, String msg ){

        StackTraceElement[] ste = new Throwable().getStackTrace();

 

        String line = " ln: " + ste[1].getLineNumber();

        String clazz = " c: " + ste[1].getClassName();

        String method = " m: " + ste[1].getMethodName();

        String m = "FAIL";

        if ( b ) {

            m = "PASS";

        }

 

        String out = m + " " + msg + " |\t" + line + clazz + method;

 

        System.out.println( out );

    }

 

    public static void log( boolean b  ){

        StackTraceElement[] ste = new Throwable().getStackTrace();

 

        String line = " ln: " + ste[1].getLineNumber();

        String clazz = " c: " + ste[1].getClassName();

        String method = " m: " + ste[1].getMethodName();

        String msg = "Fail";

        if ( b ) {

            msg = "PASS";

        }

        String out = msg + " |\t" + line + clazz + method;

 

        System.out.println( out );

    }

//   public static void log2(String s ) { 

 //           System.out.println( s ); 

 //   }

    

    public static boolean doNotNotPayAttention(String candidate) {

        if ( candidate.startsWith("sun") || candidate.startsWith("com.sun")  || candidate.startsWith("com.ibm") || candidate.startsWith("java.") || candidate.startsWith("org.junit") || candidate.startsWith("org.eclipse")) {

            return false;

        }

        return true;

    }

}
