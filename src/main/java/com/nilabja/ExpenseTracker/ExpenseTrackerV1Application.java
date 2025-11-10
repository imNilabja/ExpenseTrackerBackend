package com.nilabja.ExpenseTracker;

import com.nilabja.ExpenseTracker.model.*;
import com.nilabja.ExpenseTracker.repo.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.Optional;

@SpringBootApplication
public class ExpenseTrackerV1Application {

	public static void main(String[] args) {

        ApplicationContext context = SpringApplication.run(ExpenseTrackerV1Application.class, args);
        YearRepo yearRepo = context.getBean(YearRepo.class);
        MonthRepo monthRepo = context.getBean(MonthRepo.class);
        FoodItemRepo foodRepo = context.getBean(FoodItemRepo.class);
        StuffRepo stuffRepo=context.getBean(StuffRepo.class);
        TravelRepo travelRepo=context.getBean(TravelRepo.class);
        MescRepo mescRepo=context.getBean(MescRepo.class);

//		for (int i = 2020; i <= 2030; i++) {
//			Year year = new Year();
//			year.setYear(i);
//			yearRepo.save(year);
//		}

//        Optional<Year> yearOpt = yearRepo.findByYear(2025);
//        long id = -1;
//        if (yearOpt.isPresent()) {
//            id = yearOpt.get().getYear_id();
//        }
//
//
//
//		String monthName = "January";
//
//		// ✅ Try to find existing month for same name + year
//		Optional<Month> monthOpt = monthRepo.findByMonthAndYearId(monthName, id);
//
//		Month month;
//
//		// Create a Month and link it to the Year
//		if (monthOpt.isPresent()) {
//			// Use existing month
//			month = monthOpt.get();
//			System.out.println("⚠️ Using existing month: " + monthName + " (" + month.getMonthId() + ")");
//		} else {
//			// Create a new month only if not present
//			month = new Month();
//			month.setMonth(monthName);
//			month.setYearId(id);
//			monthRepo.save(month);
//			System.out.println("✅ Created new month: " + monthName);
//		}
//
//        // Create a FoodItem and link it to the Month
//        FoodItem food = new FoodItem();
//        food.setItemName("Pizza");
//        food.setItemCost(1000);
//        food.setMonth(month);
//        foodRepo.save(food);


//        TravelItem travel=new TravelItem();
//        travel.setItemName("Bike");
//        travel.setItemCost(130);
//        travel.setMonth(month);
//        travelRepo.save(travel);
//
//
//        MescItem mesc=new MescItem();
//        mesc.setItemName("Fuel");
//        mesc.setItemCost(500);
//        mesc.setMonth(month);
//        mescRepo.save(mesc);
//
//
//        StuffItem stuffItem=new StuffItem();
//        stuffItem.setItemName("Movie Ticket");
//        stuffItem.setItemCost(250);
//        stuffItem.setMonth(month);
//        stuffRepo.save(stuffItem);
    }

}
