
/*
Design a simple parking lot system with "programmable floors and no of spots" in each floor
eg:

4 floors and 10 spots on each floor in a straigh light like an array...
  floor 4 : [ 1 | 2 | 3 | 4 | 5 | 6 | 7 | 8 | 9 | 10]
  floor 3 : [ 1 | 2 | 3 | 4 | 5 | 6 | 7 | 8 | 9 | 10]
  floor 2 : [ 1 | 2 | 3 | 4 | 5 | 6 | 7 | 8 | 9 | 10]
  floor 1 : [ 1 | 2 | 3 | 4 | 5 | 6 | 7 | 8 | 9 | 10]
  
  
(no need to program it such that it will accept variable number of spots on each floor)
fr eg : floor 1 has 10 spots but floor 2 can have 15 (Not a requirement)
your task is to: keep a track of occupied and available spot count per floor.
after designing your system, write functions from dirver method:
1. create customer with id:
2. park(): parks and gives a ticket to user, ie assigns floorid_spotId to user/customer class: 1-3 (1st floor 3 rd spot)
  so this is how customer gets to know where he should go and park correct?
3. leave(): makes location available
4 statistics(): this will print floorwise slots which are booked and available

"create 10 customers, park 5 of them print statistics and park other 5 and print statistics and leave 5 and print stats"

no need to worry about parking cost :-P that would be part 2 if you perform well in this :-P
*/
import java.io.*;
import java.util.*;
class Floors{
    boolean[] spots;
    public Floors(int num_of_spots){ 
      this.spots = new boolean[num_of_spots];
    }
}
class Customer{
  int customer_id;
  String park_pos;
  public Customer(int id){
    this.customer_id = id;
  }
}


class ParkingLotSystem{
  
  public static void park(List<Floors> listOfFloors, Customer c){

    for(int i= 0; i< listOfFloors.size(); i++ ){
      
      for (int j=0; j < listOfFloors.get(i).spots.length;j++){
        
        if(listOfFloors.get(i).spots[j] == false){
          
          c.park_pos = i + "_" + j;
          
          listOfFloors.get(i).spots[j] = true;
          System.out.print(c.park_pos+ " ");
          return;
        }
      }
    
    
  }
}
   
  
  
  
  public static void main(String[] args) {
    //System.out.print("HI");
      List<Customer> listOfCustomers = new ArrayList<>();
      for(int i =1; i <= 50; i++){
        Customer c = new Customer(i);
        listOfCustomers.add(c);
      }
     
     int numberOFfloor = 5;
     int numOfSpots = 10;
   
     List<Floors> listOfFloors = new ArrayList<>();
      for(int i =1; i <= numberOFfloor; i++){
        Floors f = new Floors(numOfSpots);
        listOfFloors.add(f);
      }
    
    
      for(int i =0; i<50; i++){
        park(listOfFloors,listOfCustomers.get(i));
        
      }
    
  }
}
