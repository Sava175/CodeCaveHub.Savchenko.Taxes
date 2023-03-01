package com.taxes;

import com.github.javafaker.Faker;
import com.taxes.domain.*;
import com.taxes.repositories.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.Resource;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@SpringBootApplication
public class TaxesApplication implements CommandLineRunner {
    @Resource
    CustomerRepo customerRepo;
    @Resource
    EmployeeRepo employeeRepo;
    @Resource
    PersonRepo personRepo;
    @Resource
    ReportRepo reportRepo;
    @Resource
    RequestRepo requestRepo;
    @Resource
    UserRepo userRepo;

    public static void main(String[] args) {
        SpringApplication.run(TaxesApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
                Faker faker = new Faker();





        List<Person> people = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            Person person = new Person();
            person.setFirstName(faker.name().firstName());
            person.setLastName(faker.name().lastName());
            person.setAddress(faker.address().fullAddress());
            person.setPhone(faker.phoneNumber().cellPhone());
            person.setCreated(LocalDateTime.now().plusDays(i));
            person.setUpdated(LocalDateTime.now().plusDays(i));
            person.setSex(faker.options().option('M', 'F'));
            person.setDob(faker.date().birthday().toInstant().atZone(ZoneId.systemDefault()).toLocalDate());
            person.setCategory(Person.Category.values()[faker.random().nextInt(Person.Category.values().length)]);
            people.add(person);
        }
        personRepo.saveAll(people);

        List<User> users = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            User user = new User();
            user.setEmail(faker.internet().emailAddress());
            user.setStatus(User.Status.values()[faker.random().nextInt(User.Status.values().length)]);
            user.setPassword(faker.internet().password());
            user.setCreated(LocalDateTime.now().plusDays(i));
            user.setUpdated(LocalDateTime.now().plusDays(i));
            users.add(user);
        }
        userRepo.saveAll(users);


        List<Customer> customers = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Customer customer = new Customer();
            customer.setPerson(people.get(i));
            customer.setStatus(Customer.Status.values()[faker.random().nextInt(Customer.Status.values().length)]);
            customer.setCreated(LocalDateTime.now().plusDays(i));
            customer.setUpdated(LocalDateTime.now().plusDays(i));
            customer.setUser(users.get(i));

            customers.add(customer);
        }
        customerRepo.saveAll(customers);


        List<Employee> employees = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Employee employee = new Employee();
            employee.setPerson(people.get(i + 10));
            employee.setPosition(Employee.Position.values()[faker.random().nextInt(Employee.Position.values().length)]);
            employee.setCreated(LocalDateTime.now().plusDays(i));
            employee.setUpdated(LocalDateTime.now().plusDays(i));
            employees.add(employee);
        }
        employeeRepo.saveAll(employees);


        List<Report> reports = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Report report = new Report();
            report.setCustomer(customers.get(i));

            report.setEmployee(employees.get(i));
            report.setPeriod(Report.Period.values()[faker.random().nextInt(Report.Period.values().length)]);
            report.setCreated(LocalDateTime.now().plusDays(i));
            report.setUpdated(LocalDateTime.now().plusDays(i));
            reports.add(report);
        }
        for (int i = 0; i < 10; i++) {
            Report report = new Report();
            report.setCustomer(customers.get(i));
            customers.get(i).getReports().add(report);
            report.setEmployee(employees.get(i));
            report.setPeriod(Report.Period.values()[faker.random().nextInt(Report.Period.values().length)]);
            report.setCreated(LocalDateTime.now().plusDays(i+1));
            report.setUpdated(LocalDateTime.now().plusDays(i+2));
            reports.add(report);
        }
        reportRepo.saveAll(reports);

        List<Request> requests = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Request request = new Request();
            request.setCustomer(customers.get(i));
            customers.get(i).getRequests().add(request);
            request.setEmployee(employees.get(i));
            request.setCreated(LocalDateTime.now().plusDays(i));
            request.setUpdated(LocalDateTime.now().plusDays(i));
            request.setDescription(faker.lorem().sentence());
            request.setStatus(Request.State.values()[faker.random().nextInt(Request.State.values().length)]);
            requests.add(request);
        }
        for (int i = 0; i < 10; i++) {
            Request request = new Request();
            request.setCustomer(customers.get(i));
            request.setEmployee(employees.get(i));
            request.setCreated(LocalDateTime.now().plusDays(i+1));
            request.setUpdated(LocalDateTime.now().plusDays(i+2));
            request.setDescription(faker.lorem().sentence());
            request.setStatus(Request.State.values()[faker.random().nextInt(Request.State.values().length)]);
            requests.add(request);
        }
        requestRepo.saveAll(requests);

        customerRepo.saveAll(customers);





        List<Report> list = customerRepo.findAllLastReportsOfCustomer();
        for (Report report: list){
            System.out.println(report);
        }














//        List<Report> byLastName =  reportRepo.findReportsByEmployee_Person_LastNameStartsWith("S");
//        for (Report report: byLastName){
//            System.out.println(report);
//        }
//
//
//
//
//        List<Report> first = reportRepo.findAllByCreatedBetweenAndUpdatedBefore(LocalDateTime.now(), LocalDateTime.now().plusDays(6), LocalDateTime.now().plusDays(3));
//        for(Report report: first){
//            System.out.println(report);
//        }













//        LocalDate created = LocalDate.of(2023, 02, 25);
//        LocalDateTime inMethod = created.atStartOfDay();
//        List<Report> reportList = reportRepo.findAllByCreated(inMethod);
//        for (Report report : reportList) {
//            System.out.println(report);
//        }
//
//
//        LocalDate updated = LocalDate.of(2023, 02, 25);
//        LocalDateTime localDateTime = updated.atStartOfDay();
//        List<Report> reports1 = reportRepo.findAllByUpdated(localDateTime);
//        for (Report report : reports1) {
//            System.out.println(report);
//        }
//
//
//        LocalDate localDate = LocalDate.of(2023, 02, 24);
//        LocalDateTime localDateTime1 = localDate.atTime(LocalTime.MAX);
//        List<Report> some = reportRepo.findAllByCreatedGreaterThan(localDateTime1);
//        for (Report report : some) {
//            System.out.println(report);
//        }
//
//
//        LocalDate iNeed = LocalDate.of(2023, 02, 25);
//        LocalDateTime from = iNeed.atStartOfDay();
//        LocalDateTime to = iNeed.atTime(LocalTime.MAX);
//        List<Report> again = reportRepo.findAllByCreatedBetween(from, to);
//        for (Report report : again) {
//            System.out.println(report);
//        }
    }
}





