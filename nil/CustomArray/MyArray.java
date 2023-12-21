package nil.CustomArray;
import java.util.Scanner;

class ArrayTest{
    Scanner ip;

   ArrayTest() {
      this.ip = new Scanner(System.in);
   }
   
    // Print The Array
    public void printArray(int arr[]){
        for (int i = 0; i < arr.length; i++) {
            System.out.println("Element no. "+(i+1)+" : "+arr[i]);
        }
    }

    // Take input in Array
    public int[] arrayInput(int size){
        int arr[] = new int[size];
        for (int i = 0; i < arr.length; i++) {
            System.out.print("Index no "+i+" : ");
            arr[i] = ip.nextInt();
        }
        return arr;
    }

    // 1. Change The Value Of An Given Index
    public  void updateArray(int arr[], int value, int index){
        if (index >= 0 && index <  arr.length) {
            arr[index] = value;
        }
        else{
            System.out.println("Invalid array index location.");
        }
    }

    //2. Insert value in a index.
    public void insertValueAtIndex(int arr[],int value, int index){
        if (index >= 0 && index < arr.length) {
            for (int i = arr.length; i > index; i--) {
                arr[i] = arr[i-1];
            }
            arr[index] = value;
        }
        else{
            System.out.println("Wrong index.");
        }
    }

    //3. Update a value of the array with new value
    public void insertValueAt(int arr[],int value, int oldvalue){
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == oldvalue) {
                arr[i] = value;
            }
        }
    }

    //4. Delete data from index
    public void deleteAtIndex(int arr[], int index){
        if (index >= 0 && index < arr.length) {
            for (int i = index; i < arr.length-1; i++) {
                arr[i] = arr[i+1];
            }
            arr[arr.length-1] = 0;
        }
        else{
            System.out.println("Invalid array index location.");
        }
    }

    //5. Delete an value exist in array
    public void deleteAtValue(int arr[], int value){
        int index = -1;
        int size = arr.length;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == value) {
                index = i;
            }
        }
        for (int i = index; i < size-1; i++) {
            arr[i] = arr[i+1];
        }
        arr[size-1] = 0;
    }

    //6. Search the value of an index.
    public int searchByIndex(int arr[], int index){
        int value;
        value = arr[index];
        return value;
    }

    //7. Search the index of a value exist in the array
    public int searchByValue(int arr[], int data){
        int index = -1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == data) {
                index = i;
            }
        }
        return index;
    }

    //8. Marging of 2 array
    public int[] concatArray(int arr1[], int arr2[]){
        int len1 = arr1.length;
        int len2 = arr2.length;
        int n_arr[] = new int[len1+len2];

        int count = 0;
        for (int i = 0; i < len1; i++) {
            n_arr[count] = arr1[i];
            count++;
        }
        for (int i = 0; i < len2; i++) {
            n_arr[count] = arr2[i];
            count++;
        }
        return n_arr;
    }
} 

class MyArray {
    public static void main(String[] args) {
        Scanner ip = new Scanner(System.in);
        int size,value,index;
        ArrayTest obj = new ArrayTest();

        System.out.print("Enter the size of the array : ");
        size = ip.nextInt();
        int arr[] = obj.arrayInput(size);
        obj.printArray(arr);

        boolean choice = true;
        while (choice) {
            System.out.println("Enter following number.");
            System.out.println("1. Change The Value Of An Given Index.");
            System.out.println("2. Insert value in a index.");
            System.out.println("3. Update a value of the array with new value.");
            System.out.println("4. Delete data from index.");
            System.out.println("5. Delete an value exist in array.");
            System.out.println("6. Search the value of an index.");
            System.out.println("7. Search the index of a value exist in the array.");
            System.out.println("8. Concat two array.");

            int menu = ip.nextInt();
            switch (menu) {
                case 1:
                    System.out.print("Enter value you want to update : ");
                    value = ip.nextInt();
                    System.out.print("Enter the index you want to update : ");
                    index = ip.nextInt();
                    obj.updateArray(arr,value,index);
                    obj.printArray(arr);
                    break;
                
                case 2:
                    System.out.print("Enter value you want to update : ");
                    value = ip.nextInt();
                    System.out.print("Enter the index you want to update : ");
                    index = ip.nextInt();
                    obj.insertValueAtIndex(arr, value, index);
                    obj.printArray(arr);
                    break;
            
                case 3:
                    System.out.print("Enter value you want to update : ");
                    int oldvalue = ip.nextInt();
                    System.out.print("Enter the new value : ");
                    value = ip.nextInt();
                    obj.insertValueAt(arr, value, oldvalue);
                    obj.printArray(arr);
                    break;

                case 4:
                     System.out.print("Enter index you want to delete : ");
                    index = ip.nextInt();
                    obj.deleteAtIndex(arr, index);
                    obj.printArray(arr);
                    break;

                case 5:
                    System.out.print("Enter value you want to delete : ");
                    value = ip.nextInt();
                    obj.deleteAtValue(arr, value);
                    obj.printArray(arr);
                    break;
                case 6:
                    System.out.print("Enter Index you want to find data in it : ");
                    index = ip.nextInt();
                    value = obj.searchByIndex(arr, index);
                    System.out.println("Index : "+index+" Value : "+value);
                    break;
                case 7:
                    System.out.print("Enter the value you want to find : ");
                    value = ip.nextInt();
                    index = obj.searchByValue(arr, value);
                    if (index != -1) {
                        System.out.println("Index : "+index+" Value : "+value+" Element no. : "+(index + 1));
                    }
                    else{
                        System.out.println("Data is not in array..");
                    }
                    break;
                case 8:
                    System.out.print("Array 2 : ");
                    System.out.print("Enter the size of the array : ");
                    size = ip.nextInt();
                    int arr2[] = obj.arrayInput(size);
                    int array[] = obj.concatArray(arr, arr2);
                    obj.printArray(array);
                    break;
                default:
                System.out.println("Wrong Choice.");
                    break;
            }
            while (true) {
                System.out.println("Press 1 for continue and 0 for exit.");
                int c = ip.nextInt();
                if (c == 1) {
                    choice = true;
                    break;
                }
                else if (c == 0) {
                    choice = false;
                    break;
                }
                else{
                    System.out.println("Invalid.Try Again.");
                }
            }
        }
       
        // Close Scanner instance after using all inputs
        ip.close();
    }
}