package com.nilabja.ExpenseTracker.service;


import com.nilabja.ExpenseTracker.model.*;
import com.nilabja.ExpenseTracker.repo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ExpenseService {

    @Autowired
    FoodItemRepo foodRepo;
    @Autowired
    MescRepo mescRepo;
    @Autowired
    MonthRepo monthRepo;
    @Autowired
    StuffRepo stuffRepo;
    @Autowired
    TravelRepo travelRepo;
    @Autowired
    YearRepo yearRepo;
    @Autowired
    UserRepo userRepo;

    public void addFood(FoodItem food, String monthValue, int year) {

//        Food

        Optional<Year> yearOpt = yearRepo.findByYear(year);
        long id = -1;
        if (yearOpt.isPresent()) {
            id = yearOpt.get().getYear_id();
        }
        String monthName = monthValue;

        // ✅ Try to find existing month for same name + year
        Optional<Month> monthOpt = monthRepo.findByMonthAndYearId(monthName, id);

        Month month;

        // Create a Month and link it to the Year
        if (monthOpt.isPresent()) {
            // Use existing month
            month = monthOpt.get();
            System.out.println("⚠️ Using existing month: " + monthName + " (" + month.getMonthId() + ")");
        } else {
            // Create a new month only if not present
            month = new Month();
            month.setMonth(monthName);
            month.setYearId(id);
            monthRepo.save(month);
            System.out.println("✅ Created new month: " + monthName);
        }

        // Create a FoodItem and link it to the Month

        food.setMonth(month);

        foodRepo.save(food);
    }


    public List<FoodItem> getAllFood() {
        return foodRepo.findAll();
    }


    //Mesc


    public void addMesc(MescItem mesc, String monthValue, int year) {
        Optional<Year> yearOpt = yearRepo.findByYear(year);
        long id = -1;
        if (yearOpt.isPresent()) {
            id = yearOpt.get().getYear_id();
        }
        String monthName = monthValue;

        // ✅ Try to find existing month for same name + year
        Optional<Month> monthOpt = monthRepo.findByMonthAndYearId(monthName, id);

        Month month;

        // Create a Month and link it to the Year
        if (monthOpt.isPresent()) {
            // Use existing month
            month = monthOpt.get();
            System.out.println("⚠️ Using existing month: " + monthName + " (" + month.getMonthId() + ")");
        } else {
            // Create a new month only if not present
            month = new Month();
            month.setMonth(monthName);
            month.setYearId(id);
            monthRepo.save(month);
            System.out.println("✅ Created new month: " + monthName);
        }

        // Create a FoodItem and link it to the Month

        mesc.setMonth(month);

        mescRepo.save(mesc);
    }


    public List<MescItem> getAllMesc() {
        return mescRepo.findAll();
    }

    //Stuff


    public void addStuff(StuffItem stuff, String monthValue, int year) {

        Optional<Year> yearOpt = yearRepo.findByYear(year);
        long id = -1;
        if (yearOpt.isPresent()) {
            id = yearOpt.get().getYear_id();
        }
        String monthName = monthValue;

        // ✅ Try to find existing month for same name + year
        Optional<Month> monthOpt = monthRepo.findByMonthAndYearId(monthName, id);

        Month month;

        // Create a Month and link it to the Year
        if (monthOpt.isPresent()) {
            // Use existing month
            month = monthOpt.get();
            System.out.println("⚠️ Using existing month: " + monthName + " (" + month.getMonthId() + ")");
        } else {
            // Create a new month only if not present
            month = new Month();
            month.setMonth(monthName);
            month.setYearId(id);
            monthRepo.save(month);
            System.out.println("✅ Created new month: " + monthName);
        }

        // Create a FoodItem and link it to the Month

        stuff.setMonth(month);

        stuffRepo.save(stuff);
    }


    public List<StuffItem> getAllStuff() {
        return stuffRepo.findAll();
    }


    //Travel

    public void addTravel(TravelItem travel, String monthValue, int year) {
        Optional<Year> yearOpt = yearRepo.findByYear(year);
        long id = -1;
        if (yearOpt.isPresent()) {
            id = yearOpt.get().getYear_id();
        }
        String monthName = monthValue;

        // ✅ Try to find existing month for same name + year
        Optional<Month> monthOpt = monthRepo.findByMonthAndYearId(monthName, id);

        Month month;

        // Create a Month and link it to the Year
        if (monthOpt.isPresent()) {
            // Use existing month
            month = monthOpt.get();
            System.out.println("⚠️ Using existing month: " + monthName + " (" + month.getMonthId() + ")");
        } else {
            // Create a new month only if not present
            month = new Month();
            month.setMonth(monthName);
            month.setYearId(id);
            monthRepo.save(month);
            System.out.println("✅ Created new month: " + monthName);
        }

        // Create a FoodItem and link it to the Month

        travel.setMonth(month);

        travelRepo.save(travel);
    }


    public List<TravelItem> getAllTravel() {
        return travelRepo.findAll();
    }


    // finding data for a particular time (month, year)

    public List<ExpenseItem> getParticularData(String month, int year) {
        Optional<Year> yearOpt = yearRepo.findByYear(year);
        long yearId = -1;
        if (yearOpt.isPresent()) {
            yearId = yearOpt.get().getYear_id();
        }

        Optional<Month> monthOpt = monthRepo.findByMonthAndYearId(month, yearId);
        long monthId = monthOpt.get().getMonthId();

        List<FoodItem> foodL = foodRepo.findByMonth_MonthId(monthId);
        List<MescItem> mescL = mescRepo.findByMonth_MonthId(monthId);
        List<StuffItem> stuffL = stuffRepo.findByMonth_MonthId(monthId);
        List<TravelItem> travelL = travelRepo.findByMonth_MonthId(monthId);

        List<ExpenseItem> result = new ArrayList<>();
        result.addAll(foodL);
        result.addAll(mescL);
        result.addAll(stuffL);
        result.addAll(travelL);


        return result;


    }

    public void deleteItem(String item, long id) {
        if (item.equals("food")) {
            foodRepo.deleteById(id);
        } else if (item.equals("travel")) {
            travelRepo.deleteById(id);
        } else if (item.equals("stuff")) {
            stuffRepo.deleteById(id);
        } else if (item.equals("mesc")) {
            mescRepo.deleteById(id);
        }
    }

    public void updateItem(ExpenseDTO expItem, String item, long id) {
        if (item.equals("food")) {
            Optional<FoodItem> ex = foodRepo.findById(id);
            if (ex.isPresent()) {
                FoodItem existing = ex.get();
                existing.setItemName(expItem.getItemName());
                existing.setItemCost(expItem.getItemCost());
                foodRepo.save(existing); // ✅ Save changes
            }

        } else if (item.equals("travel")) {
            Optional<TravelItem> ex = travelRepo.findById(id);
            if (ex.isPresent()) {
                TravelItem existing = ex.get();
                existing.setItemName(expItem.getItemName());
                existing.setItemCost(expItem.getItemCost());
                travelRepo.save(existing); // ✅ Save changes
            }

        } else if (item.equals("stuff")) {
            Optional<StuffItem> ex = stuffRepo.findById(id);
            if (ex.isPresent()) {
                StuffItem existing = ex.get();
                existing.setItemName(expItem.getItemName());
                existing.setItemCost(expItem.getItemCost());
                stuffRepo.save(existing); // ✅ Save changes
            }

        } else if (item.equals("mesc")) {
            Optional<MescItem> ex = mescRepo.findById(id);
            if (ex.isPresent()) {
                MescItem existing = ex.get();
                existing.setItemName(expItem.getItemName());
                existing.setItemCost(expItem.getItemCost());
                mescRepo.save(existing); // ✅ Save changes
            }
        }
    }

    public List<FoodItem> getAllFoodByMonthAndYear(String month, int year,String user) {
        Optional<Year> yearOpt = yearRepo.findByYear(year);
        long yearId = -1;
        if (yearOpt.isPresent()) {
            yearId = yearOpt.get().getYear_id();
        }

        Optional<Month> monthOpt = monthRepo.findByMonthAndYearId(month, yearId);
        long monthId = monthOpt.get().getMonthId();

        List<FoodItem> foodL = foodRepo.findByMonth_MonthIdAndUser(monthId,user);
        System.out.println(foodL);

        return foodL;
    }

    public List<MescItem> getAllMescByMonthAndYear(String month, int year ,String user) {
        Optional<Year> yearOpt = yearRepo.findByYear(year);
        long yearId = -1;
        if (yearOpt.isPresent()) {
            yearId = yearOpt.get().getYear_id();
        }

        Optional<Month> monthOpt = monthRepo.findByMonthAndYearId(month, yearId);
        long monthId = monthOpt.get().getMonthId();
        List<MescItem> mescL = mescRepo.findByMonth_MonthIdAndUser(monthId,user);
        return mescL;
    }

    public List<StuffItem> getAllStuffByMonthAndYear(String month, int year ,String user) {
        Optional<Year> yearOpt = yearRepo.findByYear(year);
        long yearId = -1;
        if (yearOpt.isPresent()) {
            yearId = yearOpt.get().getYear_id();
        }

        Optional<Month> monthOpt = monthRepo.findByMonthAndYearId(month, yearId);
        long monthId = monthOpt.get().getMonthId();
        List<StuffItem> stuffL = stuffRepo.findByMonth_MonthIdAndUser(monthId,user);
        return stuffL;
    }

    public List<TravelItem> getAllTravelByMonthAndYear(String month, int year ,String user) {
        Optional<Year> yearOpt = yearRepo.findByYear(year);
        long yearId = -1;
        if (yearOpt.isPresent()) {
            yearId = yearOpt.get().getYear_id();
        }

        Optional<Month> monthOpt = monthRepo.findByMonthAndYearId(month, yearId);
        long monthId = monthOpt.get().getMonthId();
        List<TravelItem> travelL = travelRepo.findByMonth_MonthIdAndUser(monthId,user);
        return travelL;
    }


    public double getSum(String category, String month, int year,String user) {
        double sum=0;

        if(category.equals("travel")){
            Optional<Year> yearOpt = yearRepo.findByYear(year);
            long yearId = -1;
            if (yearOpt.isPresent()) {
                yearId = yearOpt.get().getYear_id();
            }
            Optional<Month> monthOpt = monthRepo.findByMonthAndYearId(month, yearId);
            long monthId = monthOpt.get().getMonthId();
            List<TravelItem> travelL = travelRepo.findByMonth_MonthIdAndUser(monthId,user);
            for(TravelItem i:travelL){
                sum+=i.getItemCost();
            }

        }else  if(category.equals("stuff")){
            Optional<Year> yearOpt = yearRepo.findByYear(year);
            long yearId = -1;
            if (yearOpt.isPresent()) {
                yearId = yearOpt.get().getYear_id();
            }
            Optional<Month> monthOpt = monthRepo.findByMonthAndYearId(month, yearId);
            long monthId = monthOpt.get().getMonthId();
            List<StuffItem> stuffL = stuffRepo.findByMonth_MonthIdAndUser(monthId,user);
            for(StuffItem i:stuffL){
                sum+=i.getItemCost();
            }

        }else  if(category.equals("food")){
            Optional<Year> yearOpt = yearRepo.findByYear(year);
            long yearId = -1;
            if (yearOpt.isPresent()) {
                yearId = yearOpt.get().getYear_id();
            }
            Optional<Month> monthOpt = monthRepo.findByMonthAndYearId(month, yearId);
            long monthId = monthOpt.get().getMonthId();

            List<FoodItem> foodL = foodRepo.findByMonth_MonthIdAndUser(monthId,user);
            for(FoodItem i:foodL){
                sum+=i.getItemCost();
            }

        }else  if(category.equals("mesc")){
            Optional<Year> yearOpt = yearRepo.findByYear(year);
            long yearId = -1;
            if (yearOpt.isPresent()) {
                yearId = yearOpt.get().getYear_id();
            }
            Optional<Month> monthOpt = monthRepo.findByMonthAndYearId(month, yearId);
            long monthId = monthOpt.get().getMonthId();

            List<MescItem> mescL = mescRepo.findByMonth_MonthIdAndUser(monthId,user);
            for(MescItem i:mescL){
                sum+=i.getItemCost();
            }

        }

        return sum;

    }

    public void addUser(Users user) {
      userRepo.save(user);
    }

    public boolean loginUser(String userName, String password) {
        return userRepo.existsByUserName(userName) && userRepo.existsByUserPassword(password);
    }

    public boolean existingUser(String userName) {
        return userRepo.existsByUserName(userName);

    }
}