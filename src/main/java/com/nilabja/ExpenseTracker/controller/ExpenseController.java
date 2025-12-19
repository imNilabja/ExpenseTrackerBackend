    package com.nilabja.ExpenseTracker.controller;

    import com.nilabja.ExpenseTracker.model.*;
    import com.nilabja.ExpenseTracker.service.ExpenseService;
    import org.apache.catalina.User;
    import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.web.bind.annotation.*;

    import java.util.*;


    @RestController
    //@CrossOrigin(origins = "*")
//    @CrossOrigin(origins = "http://localhost:5173")
    @CrossOrigin(origins = "http://localhost:8081")



    public class ExpenseController {
        @Autowired
        ExpenseService service;


/*        POST MAPPING

http://localhost:8080/addFood/{month}/{year}
http://localhost:8080/addMesc/{month}/{year}
http://localhost:8080/addStuff/{month}/{year}
http://localhost:8080/addTravel/{month}/{year}



         GET MAPPING

http://localhost:8080/getFood
http://localhost:8080/getMesc
http://localhost:8080/getTravel
http://localhost:8080/getStuff
http://localhost:8080/searchForMonthAndYear/{month}/{year}


         PUT MAPPING

http://localhost:8080/updateItem/{item}/{id}


         DELETE MAPPING

http://localhost:8080/deleteItem/{item}/{id}




 */

      //checking if remote git is working
      @GetMapping("/test")
      public boolean test(){
          System.out.printf("in test!!!");
          return true;
      }

// add user

        @PostMapping("/addUser")
        public void addUser(@RequestBody Users user){
            service.addUser(user);
        }

        @PostMapping("/loginUser/{userName}/{password}")
        public boolean addUser(@PathVariable String userName,@PathVariable String password){
            return service.loginUser(userName,password);
        }

        @PostMapping("/existingUser/{userName}")
        public boolean addUser(@PathVariable String userName){
            return service.existingUser(userName);
        }






        //For food service

        @PostMapping("/addFood/{month}/{year}")
        public String addFood(@RequestBody FoodItem food,@PathVariable String month,@PathVariable int year) {
            service.addFood(food,month,year);
            return "Food added!!!";
        }

        @GetMapping("/getFood")
        public List<FoodItem> getFood() {

            return service.getAllFood();
        }

        @GetMapping("/getFoodByYear/{month}/{year}/{user}")
        public List<FoodItem> getFoodByMandY(@PathVariable String month,@PathVariable int year,@PathVariable String user) {

            return service.getAllFoodByMonthAndYear(month,year,user);
        }


        //for Mesc service

        @GetMapping("/getMesc")
        public List<MescItem> addMesc() {

            return service.getAllMesc();
        }

        @PostMapping("/addMesc/{month}/{year}")
        public String addMesc(@RequestBody MescItem mesc,@PathVariable String month,@PathVariable int year) {
            service.addMesc(mesc,month,year);
            return "Mesc added!!!";
        }

        @GetMapping("/getMescByYear/{month}/{year}/{user}")
        public List<MescItem> getMescByMandY(@PathVariable String month,@PathVariable int year,@PathVariable String user) {

            return service.getAllMescByMonthAndYear(month,year,user);
        }

        //for Stuff service

        @GetMapping("/getStuff")
        public List<StuffItem> addStuff() {
            return service.getAllStuff();
        }

        @PostMapping("/addStuff/{month}/{year}")
        public String addStuff(@RequestBody StuffItem stuff,@PathVariable String month,@PathVariable int year) {
            service.addStuff(stuff,month,year);
            return "Stuff added!!!";
        }

        @GetMapping("/getStuffByYear/{month}/{year}/{user}")
        public List<StuffItem> getStuffByMandY(@PathVariable String month,@PathVariable int year,@PathVariable String user) {

            return service.getAllStuffByMonthAndYear(month,year,user);
        }
        //for Travel service

        @GetMapping("/getTravel")
        public List<TravelItem> addTravel() {
            return service.getAllTravel();
        }

        @GetMapping("/getTravelByYear/{month}/{year}/{user}")
        public List<TravelItem> getTravelByMandY(@PathVariable String month,@PathVariable int year,@PathVariable String user) {

            return service.getAllTravelByMonthAndYear(month,year,user);
        }



        @PostMapping("/addTravel/{month}/{year}")
        public String addTravel(@RequestBody TravelItem travel,@PathVariable String month,@PathVariable int year) {
            service.addTravel(travel,month,year);
            return "Travel added!!!";
        }

        //


        @GetMapping("/searchForMonthAndYear/{month}/{year}")
        public List<ExpenseItem> getItems(@PathVariable String month,@PathVariable int year){
            return service.getParticularData(month, year);
        }


        @DeleteMapping("/deleteItem/{item}/{id}")
        public String deleteItem(@PathVariable String item,@PathVariable long id){
            service.deleteItem(item,id);
            return "deleted!!!";
        }


        @PutMapping("/updateItem/{item}/{id}")

        public String updateItem(@RequestBody ExpenseDTO expItem,@PathVariable String item,@PathVariable long id){
            service.updateItem(expItem,item,id);
            return "updated!!!";
        }

        @GetMapping("/ItemSum/{category}/{month}/{year}/{user}")
        public double getSum(@PathVariable String category,@PathVariable String month,@PathVariable int year,@PathVariable String user){
           return service.getSum(category,month,year,user);

        }
    }
