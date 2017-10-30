package builderpattern

public class Meal {
  //items 라는 설계도를 만들고
    private var items = arrayListOf<Item>()
  //설계도에 맞춰 구체화된 부품들을 가져온다
  //복잡하게 생성되야 하는 객체를 다른객체에 책임을 떠념겨서
  //보기좋게 생성
    public fun addItem(item : Item){
        items.add(item)
    }

    public fun getCost(): Float{
        var cost: Float = 0.0f

        for (item in items){
            cost += item.price()
        }
        return cost
    }

    public fun showItems(){

        for(item in items){
            print("Item : ${item.name()}")
            print(", Packing : ${item.packing().pack()}")
            println(", Price : ${item.price()}")
        }
    }


}