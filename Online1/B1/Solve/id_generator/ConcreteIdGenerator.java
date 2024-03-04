package id_generator;

public class ConcreteIdGenerator implements IdGenerator {
    private int id;
    private static ConcreteIdGenerator concreteIdGenerator = null;
    private ConcreteIdGenerator(){
        this.id = 0;
    }
    public static ConcreteIdGenerator getInstance(){
        if(concreteIdGenerator==null){
            concreteIdGenerator = new ConcreteIdGenerator();
        }
        return concreteIdGenerator;
    }

    @Override
    public int generate() {
        return ++id;
    }
}
