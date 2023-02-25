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
        for (int i = 0; i < 10; i++) {
            Person person = new Person();
            person.setFirstName(faker.name().firstName());
            person.setLastName(faker.name().lastName());
            person.setAddress(faker.address().fullAddress());
            person.setPhone(faker.phoneNumber().cellPhone());
            person.setCreated(LocalDateTime.now());
            person.setUpdated(LocalDateTime.now());
            person.setSex(faker.options().option('M', 'F'));
            person.setDob(faker.date().birthday().toInstant().atZone(ZoneId.systemDefault()).toLocalDate());
            person.setCategory(Person.Category.values()[faker.random().nextInt(Person.Category.values().length)]);
            people.add(person);
        }
        personRepo.saveAll(people);

        List<User> users = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            User user = new User();
            user.setEmail(faker.internet().emailAddress());
            user.setStatus(User.Status.values()[faker.random().nextInt(User.Status.values().length)]);
            user.setPassword(faker.internet().password());
            user.setCreated(LocalDateTime.now());
            user.setUpdated(LocalDateTime.now());
            users.add(user);
        }
        userRepo.saveAll(users);


        List<Customer> customers = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            Customer customer = new Customer();
            customer.setPerson(people.get(i));
            customer.setStatus(Customer.Status.values()[faker.random().nextInt(Customer.Status.values().length)]);
            customer.setCreated(LocalDateTime.now());
            customer.setUpdated(LocalDateTime.now());
            customer.setUser(users.get(i));

            customers.add(customer);
        }
        customerRepo.saveAll(customers);


        List<Employee> employees = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            Employee employee = new Employee();
            employee.setPerson(people.get(i + 5));
            employee.setPosition(Employee.Position.values()[faker.random().nextInt(Employee.Position.values().length)]);
            employee.setCreated(LocalDateTime.now());
            employee.setUpdated(LocalDateTime.now());
            employees.add(employee);
        }
        employeeRepo.saveAll(employees);


        List<Report> reports = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            Report report = new Report();
            report.setCustomer(customers.get(i));
            report.setEmployee(employees.get(i));
            report.setPeriod(Report.Period.values()[faker.random().nextInt(Report.Period.values().length)]);
            report.setCreated(LocalDateTime.now());
            report.setUpdated(LocalDateTime.now());
            reports.add(report);
        }
        reportRepo.saveAll(reports);

        List<Request> requests = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            Request request = new Request();
            request.setCustomer(customers.get(i));
            request.setEmployee(employees.get(i));
            request.setCreated(LocalDateTime.now());
            request.setUpdated(LocalDateTime.now());
            request.setDescription(faker.lorem().sentence());
            request.setStatus(Request.State.values()[faker.random().nextInt(Request.State.values().length)]);
            requests.add(request);
        }
        requestRepo.saveAll(requests);


        LocalDate created = LocalDate.of(2023, 02, 25);
        LocalDateTime inMethod = created.atStartOfDay();
        List<Report> reportList = reportRepo.findAllByCreated(inMethod);
        for (Report report : reportList) {
            System.out.println(report);
        }


        LocalDate updated = LocalDate.of(2023, 02, 25);
        LocalDateTime localDateTime = updated.atStartOfDay();
        List<Report> reports1 = reportRepo.findAllByUpdated(localDateTime);
        for (Report report : reports1) {
            System.out.println(report);
        }


        LocalDate localDate = LocalDate.of(2023, 02, 24);
        LocalDateTime localDateTime1 = localDate.atTime(LocalTime.MAX);
        List<Report> some = reportRepo.findAllByCreatedGreaterThan(localDateTime1);
        for (Report report : some) {
            System.out.println(report);
        }


        LocalDate iNeed = LocalDate.of(2023, 02, 25);
        LocalDateTime from = iNeed.atStartOfDay();
        LocalDateTime to = iNeed.atTime(LocalTime.MAX);
        List<Report> again = reportRepo.findAllByCreatedBetween(from, to);
        for (Report report : again) {
            System.out.println(report);
        }


        List<Report> reportList1 = reportRepo.findAllByCreatedBetweenAndCustomer_Id(LocalDateTime.of(2023, 02, 25, 01, 10), LocalDateTime.of(2023, 02, 25, 23, 59), 2L);
        for (Report report : reportList1) {
            System.out.println(report);
        }


    }
}
