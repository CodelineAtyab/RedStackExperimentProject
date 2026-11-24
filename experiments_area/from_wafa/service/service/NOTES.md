

#Service & `@Autowired`
- Service (`@Service`): A Spring-managed bean that holds the data list and logic so the controller only handles HTTP requests.
- `@Autowired`:Injects the Spring-managed `EmployeeService` bean automatically without using new.

#Refactored Resource
- Employees `EmployeeController` and `EmployeeService` in `com.Layer.service`.

#Blockers & Lessons Learned
- No blockers.
- Moving all logic and stream code out of the controller while keeping every Postman response the same.