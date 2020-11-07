package com.example.p;

public class Operations {

    /*public static final String LOGTAG = "EMP_MNGMNT_SYS";

    SQLiteOpenHelper dbhandler;
    SQLiteDatabase database;

    private static final String[] allColumns = {
            EmployeeDBHandler.COLUMN_ID,
            EmployeeDBHandler.COLUMN_FIRST_NAME,
            EmployeeDBHandler.COLUMN_LAST_NAME,
            EmployeeDBHandler.COLUMN_GENDER,
            EmployeeDBHandler.COLUMN_HIRE_DATE,
            EmployeeDBHandler.COLUMN_DEPT

    };

    public EmployeeOperations(Context context){
        dbhandler = new EmployeeDBHandler(context);
    }

    public void open(){
        Log.i(LOGTAG,"Database Opened");
        database = dbhandler.getWritableDatabase();


    }
    public void close(){
        Log.i(LOGTAG, "Database Closed");
        dbhandler.close();

    }
    public Employee addEmployee(Employee Employee){
        ContentValues values  = new ContentValues();
        values.put(EmployeeDBHandler.COLUMN_FIRST_NAME,Employee.getFirstname());
        values.put(EmployeeDBHandler.COLUMN_LAST_NAME,Employee.getLastname());
        values.put(EmployeeDBHandler.COLUMN_GENDER, Employee.getGender());
        values.put(EmployeeDBHandler.COLUMN_HIRE_DATE, Employee.getHiredate());
        values.put(EmployeeDBHandler.COLUMN_DEPT, Employee.getDept());
        long insertid = database.insert(EmployeeDBHandler.TABLE_EMPLOYEES,null,values);
        Employee.setEmpId(insertid);
        return Employee;

    }

    // Getting single Employee
    public Employee getEmployee(long id) {

        Cursor cursor = database.query(EmployeeDBHandler.TABLE_EMPLOYEES,allColumns,EmployeeDBHandler.COLUMN_ID + "=?",new String[]{String.valueOf(id)},null,null, null, null);
        if (cursor != null)
            cursor.moveToFirst();

        Employee e = new Employee(Long.parseLong(cursor.getString(0)),cursor.getString(1),cursor.getString(2),cursor.getString(3),cursor.getString(4),cursor.getString(5));
        // return Employee
        return e;
    }

    public List<Employee> getAllEmployees() {

        Cursor cursor = database.query(EmployeeDBHandler.TABLE_EMPLOYEES,allColumns,null,null,null, null, null);

            List<Employee> employees = new ArrayList<>();
        if(cursor.getCount() > 0){
            while(cursor.moveToNext()){
                Employee employee = new Employee();
                employee.setEmpId(cursor.getLong(cursor.getColumnIndex(EmployeeDBHandler.COLUMN_ID)));
                employee.setFirstname(cursor.getString(cursor.getColumnIndex(EmployeeDBHandler.COLUMN_FIRST_NAME)));
                employee.setLastname(cursor.getString(cursor.getColumnIndex(EmployeeDBHandler.COLUMN_LAST_NAME)));
                employee.setGender(cursor.getString(cursor.getColumnIndex(EmployeeDBHandler.COLUMN_GENDER)));
                employee.setHiredate(cursor.getString(cursor.getColumnIndex(EmployeeDBHandler.COLUMN_HIRE_DATE)));
                employee.setDept(cursor.getString(cursor.getColumnIndex(EmployeeDBHandler.COLUMN_DEPT)));
                employees.add(employee);
            }
        }
        // return All Employees
        return employees;
    }




 */










}
