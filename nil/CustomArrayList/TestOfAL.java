package nil.CustomArrayList;
import java.util.ArrayList;
import java.util.Scanner;
class ArrayListImplement{
    Scanner ip;
    ArrayListImplement(){
        this.ip = new Scanner(System.in);
    }
    public ArrayList inputList(ArrayList list,int size){
        String data;
        for (int i = 1; i <= size; i++) {
            System.out.print("Element "+i+" : ");
            data  = ip.nextLine();
            list.add(data);
        }
        return list;
    } 
    public void displayList(ArrayList list){
        int size = list.size();
        for (int i = 0; i < size; i++) {
            System.out.println("Index : "+i+" Element : "+list.get(i));
        }
    }
    public ArrayList indexAt(ArrayList list, int index){
        if (index > list.size()) {
            list.add("\0");
        }
        System.out.print("Element : ");
        String data  = ip.nextLine();
        list.add(index,data);
        return list;
    }
    public String indexOf(ArrayList list, String data){
        if (list.indexOf(data) != -1) {
            return Integer.toString(list.indexOf(data));
        }
        else{
            return "Not Found";
        }
    }
}

class TestOfAL {
    public static void main(String[] args) {
        Scanner ip = new Scanner(System.in);
        Scanner sip = new Scanner(System.in);
        int index,size;
        String data;
        ArrayList<String> list = new ArrayList<>();
        ArrayListImplement imp = new ArrayListImplement();
        System.out.print("Enter the number of data : ");
        size = ip.nextInt();
        System.out.println("Enter the details one by one.....");
        imp.inputList(list, size);
        imp.displayList(list);

        // System.out.println("Enter the index location : ");
        // index = ip.nextInt();
        // imp.indexAt(list, index);
        // imp.displayList(list);

        System.out.println("Enter the element : ");
        data = sip.nextLine();
        System.out.println("Index : "+list.indexOf(data));


    }
}
