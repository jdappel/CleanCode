import com.sun.xml.internal.bind.v2.TODO

// Let's assume that we have the following class that represents an arbitrary employee
// that may be working for us
data class Employee(
    val firstName: String,
    val lastName: String,
    val employmentType: EmployeeType,
    val salaryType: SalaryType,
    val salary: Float
)
enum class EmployeeType(val desc: String) {
    FULL_TIME("Full Time"),
    PART_TIME("Part time")
}
enum class SalaryType(val desc: String, val unit: SalaryUnit) {
    EXEMPT("Exempt - not eligible for overtime", SalaryUnit.YEARLY),
    NON_EXEMPT("Non-Exempt - eligible for overtime", SalaryUnit.HOURLY)
}
enum class SalaryUnit(val desc: String) {
    HOURLY("Hourly"),
    YEARLY("Annual salary based")
}


fun findPartTimeEmployees(employees: List<Employee>): Set<Employee> {
    val partTimers = mutableSetOf<Employee>()
    employees.forEach { employee ->
        if (employee.employmentType == EmployeeType.PART_TIME) {
            partTimers.add(employee)
        }
    }
    return partTimers
}

fun findFullTimeEmployees(employees: List<Employee>): Set<Employee> {
    val fullTimers = mutableSetOf<Employee>()
    for (i in 0 until employees.size) {
        val employee = employees[i]
        if (employee.employmentType == EmployeeType.FULL_TIME) {
            fullTimers.add(employee)
        }
    }
    return fullTimers
}
// Step 1: Implement this method to only return a Set<Employee> who are part-time workers
fun findPartTimeEmployeesOptimized(employees: List<Employee>): Set<Employee> { TODO("please implement") }
// Step 2: Implement this method to only return a Set<Employee> who are full-time workers
fun findFullTimeEmployeesOptimized(employees: List<Employee>): Set<Employee> { TODO("please implement") }

val nancy = Employee("Nancy", "Negative", EmployeeType.FULL_TIME, SalaryType.EXEMPT, 50000.0f)
val debbie = Employee("Debbie", "Downer", EmployeeType.PART_TIME, SalaryType.NON_EXEMPT, 20.0f)
val alexander = Employee("Alexander", "Educated", EmployeeType.PART_TIME, SalaryType.NON_EXEMPT, 20.0f)
val winston = Employee("Winston", "Wise", EmployeeType.FULL_TIME, SalaryType.EXEMPT, 50000.0f)
val phil = Employee("Phillip", "Physical", EmployeeType.FULL_TIME, SalaryType.EXEMPT, 50000.0f)
val employees = listOf(alexander, debbie, nancy, winston, phil)

debbie in findPartTimeEmployees(employees)
alexander in findPartTimeEmployees(employees)
phil in findPartTimeEmployees(employees)

debbie in findFullTimeEmployees(employees)
alexander in findFullTimeEmployees(employees)
phil in findFullTimeEmployees(employees)

debbie in findPartTimeEmployeesOptimized(employees)
alexander in findPartTimeEmployeesOptimized(employees)
phil in findPartTimeEmployeesOptimized(employees)

debbie in findFullTimeEmployeesOptimized(employees)
alexander in findFullTimeEmployeesOptimized(employees)
phil in findFullTimeEmployeesOptimized(employees)