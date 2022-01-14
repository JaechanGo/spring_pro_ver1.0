package hello.core.order;

public class Order {
    private Long memberID;
    private String itemName;
    private int itemPrice;
    private int discountPrice;

    public Order(Long memberID, String itemName, int itemPrice, int discountPrice) {
        this.memberID = memberID;
        this.itemName = itemName;
        this.itemPrice = itemPrice;
        this.discountPrice = discountPrice;
    }

    public int calculatePrice(){
        return itemPrice-discountPrice;
    }

    public Long getMemberID() {
        return memberID;
    }

    public void setMemberID(Long memberID) {
        this.memberID = memberID;
    }

    @Override
    public String toString() {
        return "Order{" +
                "memberID=" + memberID +
                ", itemName='" + itemName + '\'' +
                ", itemPrice=" + itemPrice +
                ", discountPrice=" + discountPrice +
                '}';
    }
}
