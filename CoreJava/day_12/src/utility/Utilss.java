package utility;

import java.time.LocalDate;
import java.util.Map;

import customException.CusException;
import primary.Customer2;
import primary.SerPlan;

public class Utilss {
    public static void duplicateUser(String email, Map<String,Customer2> customers) throws CusException {
        if (customers.containsKey(email)) {
            throw new CusException("User Already exists in Database. Can't create !!!!");
        }
    }

    public static void validatePlanAmount(double registrationAmount) throws CusException {
        if (SerPlan.getPlanName((int) registrationAmount).equals(SerPlan.INVALID)) {
            throw new CusException("NO plan available for this amount");
        }
    }

    public static LocalDate validateDateOfBirth(String date) throws CusException {
        LocalDate dob = LocalDate.parse(date);
        LocalDate currDate = LocalDate.now();

        if (dob.isAfter(currDate)) {
            throw new CusException("Date of birth can't be in future");
        }

        return dob;
    }

    public static Customer2 validateUser(String firstName, String lastName, String email, String password, String date,
            double registrationAmount, Map<String,Customer2> customers) throws CusException {

        duplicateUser(email, customers);
        validatePlanAmount(registrationAmount);
        LocalDate dob = validateDateOfBirth(date);

        return Customer2.signUp(firstName, lastName, email, password, dob, registrationAmount);
    }
}