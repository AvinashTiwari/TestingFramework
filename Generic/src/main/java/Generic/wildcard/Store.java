package Generic.wildcard;

public class Store <T> {
  T[] list;

  public Store(T[] list){
   this.list = list;
  }

  public void greaterThen(Store<?> otherStore){
    if(list.length > otherStore.list.length){
      System.out.println("TRUE");
    }else
    {
      System.out.println("FALSE");
    }
  }
}
