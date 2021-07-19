package com.thinking.machines.hr.dl.dao;
import com.thinking.machines.hr.dl.interfaces.*;
import com.thinking.machines.hr.dl.exceptions.*;
import com.thinking.machines.hr.dl.dto.*;
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.sql.*;
public class EmployeeDAO implements EmployeeDAOInterface
{
public void add(EmployeeDTOInterface employeeDTO) throws DAOException
{
String name=employeeDTO.getName();
int designationCode=employeeDTO.getDesignationCode();
SimpleDateFormat simpleDateFormat;
simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd");
String dateOfBirth=simpleDateFormat.format(employeeDTO.getDateOfBirth());
BigDecimal basicSalary=employeeDTO.getBasicSalary();
String g=employeeDTO.getGender();
String gender;
if(g.equals("Male"))gender="M";
else gender="F";
boolean isIndian=employeeDTO.isIndian();
String panNumber=employeeDTO.getPANNumber();
String aadharCardNumber=employeeDTO.getAadharCardNumber();
try
{
Connection connection;
connection=DAOConnection.getConnection();
PreparedStatement preparedStatement;
preparedStatement=connection.prepareStatement("select * from designation where code=?");
preparedStatement.setInt(1,designationCode);
ResultSet resultSet;
resultSet=preparedStatement.executeQuery();
if(!resultSet.next())
{
resultSet.close();
preparedStatement.close();
connection.close();
throw new DAOException("Invalid designation code :"+designationCode);
}
resultSet.close();
preparedStatement.close();
preparedStatement=connection.prepareStatement("select * from employee where pan_number=?");
preparedStatement.setString(1,panNumber);
resultSet=preparedStatement.executeQuery();
if(resultSet.next())
{
resultSet.close();
preparedStatement.close();
connection.close();
throw new DAOException("Pan Number already exists :"+panNumber);
}
resultSet.close();
preparedStatement.close();
preparedStatement=connection.prepareStatement("select * from employee where aadhar_card_number=?");
preparedStatement.setString(1,aadharCardNumber);
resultSet=preparedStatement.executeQuery();
if(resultSet.next())
{
resultSet.close();
preparedStatement.close();
connection.close();
throw new DAOException("Aadhar Card Number already exists :"+aadharCardNumber);
}
resultSet.close();
preparedStatement.close();
preparedStatement=connection.prepareStatement("insert into employee(name,designation_code,date_of_birth,basic_salary,gender,is_indian,pan_number,aadhar_card_number) values(?,?,?,?,?,?,?,?)",Statement.RETURN_GENERATED_KEYS);
preparedStatement.setString(1,name);
preparedStatement.setInt(2,designationCode);
preparedStatement.setString(3,dateOfBirth);
preparedStatement.setBigDecimal(4,basicSalary);
preparedStatement.setString(5,gender);
preparedStatement.setBoolean(6,isIndian);
preparedStatement.setString(7,panNumber);
preparedStatement.setString(8,aadharCardNumber);
preparedStatement.executeUpdate();
resultSet=preparedStatement.getGeneratedKeys();
resultSet.next();
int employeeId=resultSet.getInt(1)+100000;
resultSet.close();
preparedStatement.close();
connection.close();
String newEmployeeId="EMP"+String.valueOf(employeeId);
employeeDTO.setEmployeeId(newEmployeeId);
}catch(Exception e)
{
throw new DAOException(e.getMessage());
}
}
public void update(EmployeeDTOInterface employeeDTO) throws DAOException
{
try
{
String gg=employeeDTO.getEmployeeId();
if(gg.length()<=3)throw new DAOException("Invalid Employee Id :"+gg);
int employeeIdNumericPart;
try
{
employeeIdNumericPart=Integer.parseInt(gg.substring(3));
}catch(NumberFormatException numberFormatException)
{
throw new DAOException("Invalid Employee Id:"+gg);
}
if(employeeIdNumericPart<=100000)throw new DAOException("Invalid Employee Id :"+gg);
employeeIdNumericPart=employeeIdNumericPart-100000;
String name=employeeDTO.getName();
int designationCode=employeeDTO.getDesignationCode();
SimpleDateFormat simpleDateFormat;
simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd");
String dateOfBirth=simpleDateFormat.format(employeeDTO.getDateOfBirth());
BigDecimal basicSalary=employeeDTO.getBasicSalary();
String gender;
if(employeeDTO.getGender().equals("Male"))gender="M";
else gender="F";
boolean isIndian=employeeDTO.isIndian();
String panNumber=employeeDTO.getPANNumber();
String aadharCardNumber=employeeDTO.getAadharCardNumber();
Connection connection;
connection=DAOConnection.getConnection();
PreparedStatement preparedStatement;
preparedStatement=connection.prepareStatement("select * from designation where code=?");
preparedStatement.setInt(1,designationCode);
ResultSet resultSet;
resultSet=preparedStatement.executeQuery();
if(resultSet.next()==false)
{
resultSet.close();
preparedStatement.close();
connection.close();
throw new DAOException("Invalid designation code :"+designationCode);
}
resultSet.close();
preparedStatement.close();
preparedStatement=connection.prepareStatement("select * from employee where employee_id=?");
preparedStatement.setInt(1,employeeIdNumericPart);
resultSet=preparedStatement.executeQuery();
if(resultSet.next()==false)
{
resultSet.close();
preparedStatement.close();
connection.close();
throw new DAOException("Invalid Employee Id: "+gg);
}
resultSet.close();
preparedStatement.close();
preparedStatement=connection.prepareStatement("select * from employee where pan_number=? and employee_id!=?");
preparedStatement.setString(1,panNumber);
preparedStatement.setInt(2,employeeIdNumericPart);
resultSet=preparedStatement.executeQuery();
if(resultSet.next())
{
resultSet.close();
preparedStatement.close();
connection.close();
throw new DAOException("PAN Number already exists :"+panNumber);
}
resultSet.close();
preparedStatement.close();
preparedStatement=connection.prepareStatement("select * from employee where aadhar_card_number=? and employee_id!=?");
preparedStatement.setString(1,aadharCardNumber);
preparedStatement.setInt(2,employeeIdNumericPart);
resultSet=preparedStatement.executeQuery();
if(resultSet.next())
{
resultSet.close();
preparedStatement.close();
connection.close();
throw new DAOException("Aadhar Card Number already exists :"+aadharCardNumber);
}
resultSet.close();
preparedStatement.close();
preparedStatement=connection.prepareStatement("update employee set name=?,designation_code=?,date_of_birth=?,basic_salary=?,gender=?,is_indian=?,pan_number=?,aadhar_card_number=? where employee_id=?");
preparedStatement.setString(1,name);
preparedStatement.setInt(2,designationCode);
preparedStatement.setString(3,dateOfBirth);
preparedStatement.setBigDecimal(4,basicSalary);
preparedStatement.setString(5,gender);
preparedStatement.setBoolean(6,isIndian);
preparedStatement.setString(7,panNumber);
preparedStatement.setString(8,aadharCardNumber);
preparedStatement.setInt(9,employeeIdNumericPart);
preparedStatement.executeUpdate();
preparedStatement.close();
connection.close();
}catch(Exception e)
{
throw new DAOException(e.getMessage());
}
}
public void delete(String employeeId) throws DAOException
{
try
{
if(employeeId.length()<=3)throw new DAOException("Invalid Employee Id :"+employeeId);
int employeeIdNumericPart;
try
{
employeeIdNumericPart=Integer.parseInt(employeeId.substring(3));
}catch(NumberFormatException numberFormatException)
{
throw new DAOException("Invalid Employee Id:"+employeeId);
}
if(employeeIdNumericPart<=100000)throw new DAOException("Invalid Employee Id :"+employeeId);
employeeIdNumericPart=employeeIdNumericPart-100000;
Connection connection=DAOConnection.getConnection();
PreparedStatement preparedStatement;
preparedStatement=connection.prepareStatement("select * from employee where employee_id=?");
preparedStatement.setInt(1,employeeIdNumericPart);
ResultSet resultSet;
resultSet=preparedStatement.executeQuery();
if(resultSet.next()==false)
{
resultSet.close();
preparedStatement.close();
connection.close();
throw new DAOException("Invalid Employee Id :"+employeeId);
}
resultSet.close();
preparedStatement.close();
preparedStatement=connection.prepareStatement("delete from employee where employee_id=?");
preparedStatement.setInt(1,employeeIdNumericPart);
preparedStatement.executeUpdate();
preparedStatement.close();
connection.close();
}catch(Exception e)
{
throw new DAOException(e.getMessage());
}
}
public int getCount() throws DAOException
{
int dCount=0;
try
{
Connection connection=DAOConnection.getConnection();
Statement statement;
statement=connection.createStatement();
ResultSet resultSet;
resultSet=statement.executeQuery("select * from employee");
while(resultSet.next())
{
dCount++;
}
resultSet.close();
statement.close();
connection.close();
}catch(Exception e)
{
throw new DAOException(e.getMessage());
}
return dCount;
}
public List<EmployeeDTOInterface> getAll() throws DAOException
{
List<EmployeeDTOInterface> employees;
employees=new LinkedList<>();
try
{
Connection connection=DAOConnection.getConnection();
Statement statement;
statement=connection.createStatement();
ResultSet resultSet;
resultSet=statement.executeQuery("select * from employee");
EmployeeDTOInterface employeeDTO;
SimpleDateFormat simpleDateFormat=new SimpleDateFormat("dd/MM/yyyy");
while(resultSet.next())
{
employeeDTO=new EmployeeDTO();
int employeeId=resultSet.getInt(1)+100000;
String newEmployeeId="EMP"+String.valueOf(employeeId);
employeeDTO.setEmployeeId(newEmployeeId);
employeeDTO.setName(resultSet.getString("name").trim());
employeeDTO.setDesignationCode(resultSet.getInt("designation_code"));
employeeDTO.setDateOfBirth(resultSet.getDate("date_of_birth"));
employeeDTO.setBasicSalary(resultSet.getBigDecimal("basic_salary"));
String vGender=resultSet.getString("gender");
if(vGender.equals("M"))
{
employeeDTO.setGender(EmployeeDTOInterface.MALE);
}
else
{
employeeDTO.setGender(EmployeeDTOInterface.FEMALE);
}
employeeDTO.isIndian(resultSet.getBoolean("is_indian"));
employeeDTO.setPANNumber(resultSet.getString("pan_number").trim());
employeeDTO.setAadharCardNumber(resultSet.getString("aadhar_card_number").trim());
employees.add(employeeDTO);
}
resultSet.close();
statement.close();
connection.close();
}catch(Exception e)
{
throw new DAOException(e.getMessage());
}
return employees;
}
public EmployeeDTOInterface getByEmployeeId(String employeeId) throws DAOException
{
EmployeeDTOInterface employeeDTO;
employeeDTO=new EmployeeDTO();
try
{
if(employeeId.length()<=3)throw new DAOException("Invalid Employee Id :"+employeeId);
int employeeIdNumericPart;
try
{
employeeIdNumericPart=Integer.parseInt(employeeId.substring(3));
}catch(NumberFormatException numberFormatException)
{
throw new DAOException("Invalid Employee Id:"+employeeId);
}
if(employeeIdNumericPart<=100000)throw new DAOException("Invalid Employee Id :"+employeeId);
employeeIdNumericPart=employeeIdNumericPart-100000;
Connection connection=DAOConnection.getConnection();
PreparedStatement preparedStatement;
preparedStatement=connection.prepareStatement("select * from employee where employee_id=?");
preparedStatement.setInt(1,employeeIdNumericPart);
ResultSet resultSet;
resultSet=preparedStatement.executeQuery();
if(resultSet.next()==false)
{
resultSet.close();
preparedStatement.close();
connection.close();
throw new DAOException("Invalid Employee Id :"+employeeId);
}
resultSet.close();
preparedStatement.close();
preparedStatement=connection.prepareStatement("select * from employee where employee_id=?");
preparedStatement.setInt(1,employeeIdNumericPart);
resultSet=preparedStatement.executeQuery();
if(resultSet.next())
{
employeeDTO.setEmployeeId(employeeId);
employeeDTO.setName(resultSet.getString("name").trim());
employeeDTO.setDesignationCode(resultSet.getInt("designation_code"));
employeeDTO.setDateOfBirth(resultSet.getDate("date_of_birth"));
employeeDTO.setBasicSalary(resultSet.getBigDecimal("basic_salary"));
String vGender=resultSet.getString("gender");
if(vGender.equals("M"))
{
employeeDTO.setGender(EmployeeDTOInterface.MALE);
}
else
{
employeeDTO.setGender(EmployeeDTOInterface.FEMALE);
}
employeeDTO.isIndian(resultSet.getBoolean("is_indian"));
employeeDTO.setPANNumber(resultSet.getString("pan_number").trim());
employeeDTO.setAadharCardNumber(resultSet.getString("aadhar_card_number").trim());
}
resultSet.close();
preparedStatement.close();
connection.close();
}catch(Exception e)
{
throw new DAOException(e.getMessage());
}
return employeeDTO;
}
public EmployeeDTOInterface getByPANNumber(String panNumber) throws DAOException
{
EmployeeDTOInterface employeeDTO;
employeeDTO=new EmployeeDTO();
try
{
Connection connection=DAOConnection.getConnection();
PreparedStatement preparedStatement;
preparedStatement=connection.prepareStatement("select * from employee where pan_number=?");
preparedStatement.setString(1,panNumber);
ResultSet resultSet;
resultSet=preparedStatement.executeQuery();
if(resultSet.next()==false)
{
resultSet.close();
preparedStatement.close();
connection.close();
throw new DAOException(panNumber+" doesn't exists");
}
resultSet.close();
preparedStatement.close();
preparedStatement=connection.prepareStatement("select * from employee where pan_number=?");
preparedStatement.setString(1,panNumber);
resultSet=preparedStatement.executeQuery();
if(resultSet.next())
{
int employeeId=resultSet.getInt(1)+100000;
String newEmployeeId="EMP"+String.valueOf(employeeId);
employeeDTO.setEmployeeId(newEmployeeId);
employeeDTO.setName(resultSet.getString("name").trim());
employeeDTO.setDesignationCode(resultSet.getInt("designation_code"));
employeeDTO.setDateOfBirth(resultSet.getDate("date_of_birth"));
employeeDTO.setBasicSalary(resultSet.getBigDecimal("basic_salary"));
String vGender=resultSet.getString("gender");
if(vGender.equals("M"))
{
employeeDTO.setGender(EmployeeDTOInterface.MALE);
}
else
{
employeeDTO.setGender(EmployeeDTOInterface.FEMALE);
}
employeeDTO.isIndian(resultSet.getBoolean("is_indian"));
employeeDTO.setPANNumber(resultSet.getString("pan_number").trim());
employeeDTO.setAadharCardNumber(resultSet.getString("aadhar_card_number").trim());
}
resultSet.close();
preparedStatement.close();
connection.close();
}catch(Exception e)
{
throw new DAOException(e.getMessage());
}
return employeeDTO;
}
public EmployeeDTOInterface getByAadharCardNumber(String aadharCardNumber) throws DAOException
{
EmployeeDTOInterface employeeDTO;
employeeDTO=new EmployeeDTO();
try
{
Connection connection=DAOConnection.getConnection();
PreparedStatement preparedStatement;
preparedStatement=connection.prepareStatement("select * from employee where aadhar_card_number=?");
preparedStatement.setString(1,aadharCardNumber);
ResultSet resultSet;
resultSet=preparedStatement.executeQuery();
if(resultSet.next()==false)
{
resultSet.close();
preparedStatement.close();
connection.close();
throw new DAOException(aadharCardNumber+" doesn't exists");
}
resultSet.close();
preparedStatement.close();
preparedStatement=connection.prepareStatement("select * from employee where aadhar_card_number=?");
preparedStatement.setString(1,aadharCardNumber);
resultSet=preparedStatement.executeQuery();
if(resultSet.next())
{
int employeeId=resultSet.getInt(1)+100000;
String newEmployeeId="EMP"+String.valueOf(employeeId);
employeeDTO.setEmployeeId(newEmployeeId);
employeeDTO.setName(resultSet.getString("name").trim());
employeeDTO.setDesignationCode(resultSet.getInt("designation_code"));
employeeDTO.setDateOfBirth(resultSet.getDate("date_of_birth"));
employeeDTO.setBasicSalary(resultSet.getBigDecimal("basic_salary"));
String vGender=resultSet.getString("gender");
if(vGender.equals("M"))
{
employeeDTO.setGender(EmployeeDTOInterface.MALE);
}
else
{
employeeDTO.setGender(EmployeeDTOInterface.FEMALE);
}
employeeDTO.isIndian(resultSet.getBoolean("is_indian"));
employeeDTO.setPANNumber(resultSet.getString("pan_number").trim());
employeeDTO.setAadharCardNumber(resultSet.getString("aadhar_card_number").trim());
}
resultSet.close();
preparedStatement.close();
connection.close();
}catch(Exception e)
{
throw new DAOException(e.getMessage());
}
return employeeDTO;
}
public boolean EmployeeIdExists(String employeeId) throws DAOException
{
try
{
if(employeeId.length()<=3)throw new DAOException("Invalid Employee Id :"+employeeId);
int employeeIdNumericPart;
try
{
employeeIdNumericPart=Integer.parseInt(employeeId.substring(3));
}catch(NumberFormatException numberFormatException)
{
throw new DAOException("Invalid Employee Id:"+employeeId);
}
if(employeeIdNumericPart<=100000)throw new DAOException("Invalid Employee Id :"+employeeId);
employeeIdNumericPart=employeeIdNumericPart-100000;
Connection connection=DAOConnection.getConnection();
PreparedStatement preparedStatement;
preparedStatement=connection.prepareStatement("select * from employee where employee_id=?");
preparedStatement.setInt(1,employeeIdNumericPart);
ResultSet resultSet;
resultSet=preparedStatement.executeQuery();
if(resultSet.next()==false)
{
resultSet.close();
preparedStatement.close();
connection.close();
return false;
}
resultSet.close();
preparedStatement.close();
connection.close();
}catch(Exception e)
{
throw new DAOException(e.getMessage());
}
return true;
}
public boolean panNumberExists(String panNumber) throws DAOException
{
try
{
Connection connection=DAOConnection.getConnection();
PreparedStatement preparedStatement;
preparedStatement=connection.prepareStatement("select * from employee where pan_number=?");
preparedStatement.setString(1,panNumber);
ResultSet resultSet;
resultSet=preparedStatement.executeQuery();
if(resultSet.next()==false)
{
resultSet.close();
preparedStatement.close();
connection.close();
return false;
}
resultSet.close();
preparedStatement.close();
connection.close();
}catch(Exception e)
{
throw new DAOException(e.getMessage());
}
return true;
}
public boolean aadharCardNumberExists(String aadharCardNumber) throws DAOException
{
try
{
Connection connection=DAOConnection.getConnection();
PreparedStatement preparedStatement;
preparedStatement=connection.prepareStatement("select * from employee where aadhar_card_number=?");
preparedStatement.setString(1,aadharCardNumber);
ResultSet resultSet;
resultSet=preparedStatement.executeQuery();
if(resultSet.next()==false)
{
resultSet.close();
preparedStatement.close();
connection.close();
return false;
}
resultSet.close();
preparedStatement.close();
connection.close();
}catch(Exception e)
{
throw new DAOException(e.getMessage());
}
return true;
}
public boolean designationCodeExists(int designationCode) throws DAOException
{
try
{
Connection connection;
connection=DAOConnection.getConnection();
PreparedStatement preparedStatement;
preparedStatement=connection.prepareStatement("select * from employee where designation_code=?");
preparedStatement.setInt(1,designationCode);
ResultSet resultSet;
resultSet=preparedStatement.executeQuery();
if(resultSet.next()==false)
{
resultSet.close();
preparedStatement.close();
connection.close();
return false;
}
resultSet.close();
preparedStatement.close();
connection.close();
}catch(Exception e)
{
throw new DAOException(e.getMessage());
}
return true;
}
}