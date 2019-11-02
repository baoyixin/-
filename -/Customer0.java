interface FactoryBMW {  
    BMW createBMW();  
}  
public class FactoryBMW320 implements FactoryBMW{  
  
    @Override  
    public BMW320 createBMW() {  
  
        return new BMW320();  
    }  
  
}  
public class FactoryBMW523 implements FactoryBMW {  
    @Override  
    public BMW523 createBMW() {  
  
        return new BMW523();  
    }  
}  
public class Customer0 {  
    public static void main(String[] args) {  
        FactoryBMW320 factoryBMW320 = new FactoryBMW320();  
        BMW320 bmw320 = factoryBMW320.createBMW();  
  
        FactoryBMW523 factoryBMW523 = new FactoryBMW523();  
        BMW523 bmw523 = factoryBMW523.createBMW();  
    }  
}  