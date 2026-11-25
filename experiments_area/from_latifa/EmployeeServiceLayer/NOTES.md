
A service keeps the main logic separate from the controller. 
`@Autowired` connects the service to the controller without using `new`.

Before, `EmployeeController.java` had the employee list and all the logic. 
Now, the list and six operations are in `EmployeeService.java`, and the controller only calls the service methods.

I did not use `ResponseEntity`, status codes, or a database because they are not needed in this task.

**Blockers:** No blockers. Understanding `@Autowired` was a little difficult at first.