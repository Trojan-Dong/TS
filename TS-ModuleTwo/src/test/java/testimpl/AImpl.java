package testimpl;

public abstract class AImpl implements TestService{
    
    @Override
    public void test() {
        System.out.println("A");
    }
}
