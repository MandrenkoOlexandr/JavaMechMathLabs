public class SqrExepHMW extends ArithmeticException{
    public String detail;

    SqrExepHMW(String message) {
        this.detail = message;
    }

    @Override
    public String toString() {
        return "D is negative, no real roots! " + detail;
    }
}
