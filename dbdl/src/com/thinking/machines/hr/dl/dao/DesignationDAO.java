package com.thinking.machines.hr.dl.dao;
import com.thinking.machines.hr.dl.interfaces.*;
import com.thinking.machines.hr.dl.exceptions.*;
import com.thinking.machines.hr.dl.dto.*;
import java.util.*;
import java.sql.*;
public class DesignationDAO implements DesignationDAOInterface
{
public void add(DesignationDTOInterface designationDTO) throws DAOException
{
try
{
String title=designationDTO.getTitle().trim();
Connection connection=DAOConnection.getConnection();
PreparedStatement preparedStatement;
preparedStatement=connection.prepareStatement("select * from designation where title=?");
preparedStatement.setString(1,title);
ResultSet resultSet;
resultSet=preparedStatement.executeQuery();
if(resultSet.next()==true)
{
resultSet.close();
preparedStatement.close();
connection.close();
throw new DAOException(title+" exists");
}
resultSet.close();
preparedStatement.close();
preparedStatement=connection.prepareStatement("insert into designation (title) values(?)",Statement.RETURN_GENERATED_KEYS);
preparedStatement.setString(1,title);
preparedStatement.executeUpdate();
resultSet=preparedStatement.getGeneratedKeys();
resultSet.next();
int code=resultSet.getInt(1);
resultSet.close();
preparedStatement.close();
connection.close();
designationDTO.setCode(code);
}catch(SQLException s)
{
throw new DAOException(s.getMessage());
}
}
public void update(DesignationDTOInterface designationDTO) throws DAOException
{
try
{
int code=designationDTO.getCode();
String title=designationDTO.getTitle().trim();
Connection connection=DAOConnection.getConnection();
PreparedStatement preparedStatement;
preparedStatement=connection.prepareStatement("select * from designation where code=?");
preparedStatement.setInt(1,code);
ResultSet resultSet;
resultSet=preparedStatement.executeQuery();
if(resultSet.next()==false)
{
resultSet.close();
preparedStatement.close();
connection.close();
throw new DAOException("Invalid code :"+code);
}
resultSet.close();
preparedStatement.close();
preparedStatement=connection.prepareStatement("select * from designation where title=? and code!=?");
preparedStatement.setString(1,title);
preparedStatement.setInt(2,code);
resultSet=preparedStatement.executeQuery();
if(resultSet.next()==true)
{
resultSet.close();
preparedStatement.close();
connection.close();
throw new DAOException(title+" exists");
}
resultSet.close();
preparedStatement.close();
preparedStatement=connection.prepareStatement("update designation set title=? where code=?");
preparedStatement.setString(1,title);
preparedStatement.setInt(2,code);
preparedStatement.executeUpdate();
preparedStatement.close();
connection.close();
}catch(SQLException s)
{
throw new DAOException(s.getMessage());
}
}
public void delete(int code) throws DAOException
{
try
{
int dCode=code;
Connection connection=DAOConnection.getConnection();
PreparedStatement preparedStatement;
preparedStatement=connection.prepareStatement("select * from designation where code=?");
preparedStatement.setInt(1,dCode);
ResultSet resultSet;
resultSet=preparedStatement.executeQuery();
if(resultSet.next()==false)
{
resultSet.close();
preparedStatement.close();
connection.close();
throw new DAOException("Invalid code :"+dCode);
}
resultSet.close();
preparedStatement.close();
preparedStatement=connection.prepareStatement("delete from designation where code=?");
preparedStatement.setInt(1,dCode);
preparedStatement.executeUpdate();
preparedStatement.close();
connection.close();
}catch(SQLException s)
{
throw new DAOException(s.getMessage());
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
resultSet=statement.executeQuery("select * from designation");
while(resultSet.next())
{
dCount++;
}
resultSet.close();
statement.close();
connection.close();
}catch(SQLException s)
{
throw new DAOException(s.getMessage());
}
return dCount;
}
public List<DesignationDTOInterface> getAll() throws DAOException
{
List<DesignationDTOInterface> designations;
designations=new LinkedList<>();
try
{
Connection connection=DAOConnection.getConnection();
Statement statement;
statement=connection.createStatement();
ResultSet resultSet;
resultSet=statement.executeQuery("select * from designation");
DesignationDTOInterface designationDTO;
while(resultSet.next())
{
designationDTO=new DesignationDTO();
designationDTO.setCode(resultSet.getInt("code"));
designationDTO.setTitle(resultSet.getString("title").trim());
designations.add(designationDTO);
}
resultSet.close();
statement.close();
connection.close();
}catch(SQLException s)
{
throw new DAOException(s.getMessage());
}
return designations;
}
public DesignationDTOInterface getByCode(int code) throws DAOException
{
DesignationDTOInterface designationDTO;
designationDTO=new DesignationDTO();
try
{
int dCode=code;
Connection connection=DAOConnection.getConnection();
PreparedStatement preparedStatement;
preparedStatement=connection.prepareStatement("select * from designation where code=?");
preparedStatement.setInt(1,dCode);
ResultSet resultSet;
resultSet=preparedStatement.executeQuery();
if(resultSet.next()==false)
{
resultSet.close();
preparedStatement.close();
connection.close();
throw new DAOException("Invalid code :"+dCode);
}
resultSet.close();
preparedStatement.close();
preparedStatement=connection.prepareStatement("select * from designation where code=?");
preparedStatement.setInt(1,dCode);
resultSet=preparedStatement.executeQuery();
String title="";
if(resultSet.next())
{
title=resultSet.getString("title").trim();
}
resultSet.close();
preparedStatement.close();
connection.close();
designationDTO.setCode(dCode);
designationDTO.setTitle(title);
}catch(SQLException s)
{
throw new DAOException(s.getMessage());
}
return designationDTO;
}
public DesignationDTOInterface getByTitle(String title) throws DAOException
{
DesignationDTOInterface designationDTO;
designationDTO=new DesignationDTO();
try
{
String dTitle=title;
Connection connection=DAOConnection.getConnection();
PreparedStatement preparedStatement;
preparedStatement=connection.prepareStatement("select * from designation where title=?");
preparedStatement.setString(1,dTitle);
ResultSet resultSet;
resultSet=preparedStatement.executeQuery();
if(resultSet.next()==false)
{
resultSet.close();
preparedStatement.close();
connection.close();
throw new DAOException(title+" doesn't exists");
}
resultSet.close();
preparedStatement.close();
preparedStatement=connection.prepareStatement("select * from designation where title=?");
preparedStatement.setString(1,dTitle);
resultSet=preparedStatement.executeQuery();
int dCode=0;
if(resultSet.next())
{
dCode=resultSet.getInt("code");
}
resultSet.close();
preparedStatement.close();
connection.close();
designationDTO.setCode(dCode);
designationDTO.setTitle(dTitle);
}catch(SQLException s)
{
throw new DAOException(s.getMessage());
}
return designationDTO;
}
public boolean codeExists(int code) throws DAOException
{
try
{
int dCode=code;
Connection connection=DAOConnection.getConnection();
PreparedStatement preparedStatement;
preparedStatement=connection.prepareStatement("select * from designation where code=?");
preparedStatement.setInt(1,dCode);
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
}catch(SQLException s)
{
throw new DAOException(s.getMessage());
}
return true;
}
public boolean titleExists(String title) throws DAOException
{
try
{
String dTitle=title;
Connection connection=DAOConnection.getConnection();
PreparedStatement preparedStatement;
preparedStatement=connection.prepareStatement("select * from designation where title=?");
preparedStatement.setString(1,dTitle);
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
}catch(SQLException s)
{
throw new DAOException(s.getMessage());
}
return true;
}
}