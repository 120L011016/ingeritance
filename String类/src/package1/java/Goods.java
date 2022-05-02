package1 package1.java;

public class Goods implements Comparable{
    private String name;
    private double price;

    //compare goods by price first,then compare goods by name .

    @Override
    public int compareTo(Object o) {
        if (o instanceof Goods){
            Goods goods = (Goods) o;
            //way1:
            if(this.price > goods.price){
                return 1;
            }else if(this.price < goods.price)
            {
                return -1;
            }else{
                return -this.name.compareTo(goods.name);
            }
        }
        throw new RuntimeException("the type difference");
    }
}
