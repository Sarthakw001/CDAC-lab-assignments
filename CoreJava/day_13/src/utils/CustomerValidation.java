package utils;

import java.time.LocalDate;
import java.util.Map;

import core.Customer1;
import core.ServicePlan;
import customException.CustomerException;

public class CustomerValidation {
    public static void duplicateUser(String email, Map<String,Customer1> customers) throws CustomerException {
        if (customers.containsKey(email)) {
            throw new CustomerException("User Already exists in Database. Can't create !!!!");
        }
    }

    public static void validatePlanAmount(double registrationAmount) throws CustomerException {
        if (ServicePlan.getPlanName((int) registrationAmount).equals(ServicePlan.INVALID)) {
            throw new CustomerException("NO plan available for this amount");
        }
    }

    public static LocalDate validateDateOfBirth(String date) throws CustomerException {
        LocalDate dob = LocalDate.parse(date);
        LocalDate currDate = LocalDate.now();

        if (dob.isAfter(currDate)) {
            throw new CustomerException("Date of birth can't be in future");
        }

        return dob;
    }

    public static Customer1 validateUser(String firstName, String lastName, String email, String password, String date,
            double registrationAmount, Map<String,Customer1> customers) throws CustomerException {

        duplicateUser(email, customers);
        validatePlanAmount(registrationAmount);
        LocalDate dob = validateDateOfBirth(date);

        return Customer1.signUp(firstName, lastName, email, password, dob, registrationAmount);
    }
}
