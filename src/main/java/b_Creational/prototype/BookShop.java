package b_Creational.prototype;

import java.util.ArrayList;
import java.util.List;

public class BookShop implements Cloneable {
    private String shopName;
    private List<Book> booksList =  new ArrayList<>();

    public void getBooksFromDataBase(){
        for (int i=0;i<10;i++){
            booksList.add(new Book(i,"Book"+i));
        }
    }

    //Default clone override: SHALLOW copy
    /*@Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }*/

    //DEEP copy
    @Override
    protected BookShop clone() throws CloneNotSupportedException{
        BookShop bShop = new BookShop();
        for(Book b: this.getBooksList()){
            bShop.getBooksList().add(b);
        }
        return bShop;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    @Override
    public String toString() {
        return "BookShop{" +
                "shopName='" + shopName + '\'' +
                ", booksList=" + booksList +
                '}';
    }

    public List<Book> getBooksList() {
        return booksList;
    }

    public void setBooksList(List<Book> booksList) {
        this.booksList = booksList;
    }
}
