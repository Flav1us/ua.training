package util;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import model.UserMeal;
import model.UserMealWithExceed;

/**
 * GKislin
 * 31.05.2015.
 */
public class UserMealsUtil {
    public static void main(String[] args) {
        List<UserMeal> mealList = Arrays.asList(
                new UserMeal(LocalDateTime.of(2015, Month.MAY, 30,10,0), "Завтрак", 500),
                new UserMeal(LocalDateTime.of(2015, Month.MAY, 30,13,0), "Обед", 1000),
                new UserMeal(LocalDateTime.of(2015, Month.MAY, 30,20,0), "Ужин", 500),
                new UserMeal(LocalDateTime.of(2015, Month.MAY, 31,10,0), "Завтрак", 1000),
                new UserMeal(LocalDateTime.of(2015, Month.MAY, 31,13,0), "Обед", 500),
                new UserMeal(LocalDateTime.of(2015, Month.MAY, 31,20,0), "Ужин", 510)
        );
        
        List<UserMealWithExceed> mealListWE = getFilteredWithExceeded(mealList, LocalTime.of(7, 0), LocalTime.of(12,0), 2000);
//        .toLocalDate();
//        .toLocalTime();
        
       for(UserMealWithExceed umwe : mealListWE) {
        	System.out.println(umwe.toString());
        }
    }

    public static List<UserMealWithExceed>  getFilteredWithExceeded(List<UserMeal> mealList, LocalTime startTime, LocalTime endTime, int caloriesPerDay) {
    	List<UserMealWithExceed> mealWithExceedList = new ArrayList<>();
    	//Iterator<UserMeal> i = mealList.iterator();
    	Map<LocalDate, Integer> totalCalPerDay = new HashMap<>();
    	
    	for(UserMeal curr : mealList) {
    		LocalDate day = extractYMD(curr);
    		if(!totalCalPerDay.containsKey(day)) {
    			totalCalPerDay.put(day, 0);
    		}
    		totalCalPerDay.put(day, totalCalPerDay.get(day) + curr.getCalories());
    	}
    	
    	for(Map.Entry<LocalDate, Integer> e : totalCalPerDay.entrySet())  {System.out.println(e.getKey() + "\t" + e.getValue());}
    	
    	for(UserMeal curr : mealList) {
    		if(TimeUtil.isBetween(curr.getDateTime().toLocalTime(), startTime, endTime)) {
    			boolean exceed = (totalCalPerDay.get(extractYMD(curr)) > caloriesPerDay);
    			UserMealWithExceed umwe = new UserMealWithExceed(curr.getDateTime(), curr.getDescription(), curr.getCalories(), exceed);
    			mealWithExceedList.add(umwe);
    		}
    	}
        
    	return mealWithExceedList;
    }

	private static LocalDate extractYMD(UserMeal curr) {
		return LocalDate.of(curr.getDateTime().getYear(), curr.getDateTime().getMonth(), curr.getDateTime().getDayOfMonth());
	}
    

}
