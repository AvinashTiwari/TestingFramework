package Generic.lowerboundwildcard;

public class Store <T> {
  T[] list;

  public Store(T[] list){
   this.list = list;
  }

  public void greaterThen(Store<? super Integer> otherStore){
    if(list.length > otherStore.list.length){
      System.out.println("TRUE");
    }else
    {
      System.out.println("FALSE");
    }
  }
}
