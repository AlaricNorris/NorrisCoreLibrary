package alaric.norris.core.library;

public class Test {
    public static void main ( String args[] ) {
        int a = 5;
        a = a++ * 3;
        System.out.println( a );
        int b = 5;
        b = ( b++ ) * 3;
        System.out.println( b );
    }

    @Override
    public String toString () {
        return super.toString();
    }
}
