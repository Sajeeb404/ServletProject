package dao;


import controller.Regi;
import model.Register;

import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class RegisterDao {

    private static String insertSQL = "insert into register (username, email, password, confirmpassword, img) values (?, ?, ?, ?, ?)";
    private static String getAllSQL = "select * from register";
    private static String deleteSQL = "delete from register where id = ?";
    private static String getByIdSQL = "select * from register where id = ?";
    private static String updateSQL = "update register set username=?, email=?, password=?, confirmpassword=?, img = ? where id =?";
    private static String validateSQL = "select * from register where username = ? and password=?";
    private static String fileGetByIdSQL= "select username, img from register where id = ?";



    public static boolean saved(Register register) {
        boolean isSaved = false;


        try (Connection connection = DatabaseCon.getConncetion();
             PreparedStatement preparedStatement = connection.prepareStatement(insertSQL);) {


            preparedStatement.setString(1, register.getUserName());
            preparedStatement.setString(2, register.getEmail());
            preparedStatement.setString(3, register.getPassword());
            preparedStatement.setString(4, register.getConfirmPassword());

            preparedStatement.setBinaryStream(5, register.getImage());

            isSaved = preparedStatement.executeUpdate() > 0;
            System.out.println(isSaved ? "Data Saved Successfully" : "Data not saved!");


        } catch (Exception e) {
            e.printStackTrace();

        }

        return isSaved;
    }


    public static ArrayList<Register> getAllRegister() {

        ArrayList<Register> ulist = new ArrayList<>();

        try (Connection connection = DatabaseCon.getConncetion();
             PreparedStatement preparedStatement = connection.prepareStatement(getAllSQL);) {

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Register register = new Register();
                register.setId(resultSet.getInt(1));
                register.setUserName(resultSet.getString(2));
                register.setEmail(resultSet.getString(3));
                register.setPassword(resultSet.getString(4));
                register.setConfirmPassword(resultSet.getString(5));

                Blob imageBlob = resultSet.getBlob(6);
                if (imageBlob != null) {
                    InputStream inputStream = imageBlob.getBinaryStream();
                    register.setImage(inputStream);
                }else {
                    register.setImage(null);
                }

                ulist.add(register);
            }


        } catch (Exception e) {
            e.printStackTrace();

        }


        return ulist;

    }


    public static int deleteById(int id) {

        int rowDeleted = 0;

        try (Connection connection = DatabaseCon.getConncetion();
             PreparedStatement preparedStatement = connection.prepareStatement(deleteSQL);) {

            preparedStatement.setInt(1, id);

            rowDeleted = preparedStatement.executeUpdate();


            System.out.println(rowDeleted > 0 ? "Deleted successfully." : "Not deleted data!");


        } catch (Exception e) {
            e.printStackTrace();

        }


        return rowDeleted;
    }


    public static Register getRegisterById(int id) {

        Register register = new Register();

        try (Connection connection = DatabaseCon.getConncetion();
             PreparedStatement preparedStatement = connection.prepareStatement(getByIdSQL);) {


            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                register.setId(resultSet.getInt(1));
                register.setUserName(resultSet.getString(2));
                register.setEmail(resultSet.getString(3));
                register.setPassword(resultSet.getString(4));
                register.setConfirmPassword(resultSet.getString(5));

            }

        } catch (Exception e) {
            e.printStackTrace();

        }


        return register;

    }


    public static int updateRegi(Register register) {

        int rowUpdated = 0;

        try (Connection connection = DatabaseCon.getConncetion();
             PreparedStatement preparedStatement = connection.prepareStatement(updateSQL);) {

            preparedStatement.setString(1, register.getUserName());
            preparedStatement.setString(2, register.getEmail());
            preparedStatement.setString(3, register.getPassword());
            preparedStatement.setString(4, register.getConfirmPassword());
            preparedStatement.setBinaryStream(5, register.getImage());
            preparedStatement.setInt(6, register.getId());

            rowUpdated = preparedStatement.executeUpdate();

            System.out.println(rowUpdated > 0 ? "Data Updated successfully." : "Data not updated!");


        } catch (Exception e) {
            e.printStackTrace();

        }


        return rowUpdated;

    }


    public static boolean isValidate(String uName, String pass) {

        boolean status = false;


        try (Connection connection = DatabaseCon.getConncetion();
            PreparedStatement preparedStatement = connection.prepareStatement(validateSQL))   {

            preparedStatement.setString(1, uName);
            preparedStatement.setString(2, pass);

            ResultSet resultSet = preparedStatement.executeQuery();
            status =resultSet.next();

        } catch (Exception e) {
            e.printStackTrace();

        }


        return status;
    }


    public static Register getFileByID(int fileId) {
        Register register = new Register();
//        String fileGetByIdSQL = "SELECT username, img FROM your_table_name WHERE id = ?"; // Ensure the table name is correct

        try (Connection connection = DatabaseCon.getConncetion();
             PreparedStatement preparedStatement = connection.prepareStatement(fileGetByIdSQL)) {

            preparedStatement.setInt(1, fileId); // Set the parameter before executing the query

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) { // Check if there are results
                    register.setUserName(resultSet.getString("username")); // Use column name for clarity

                    Blob b = resultSet.getBlob("img");
                    if (b != null) {
                        InputStream inputStream = b.getBinaryStream();
                        register.setImage(inputStream);
                    } else {
                        register.setImage(null);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return register;
    }


    public static Register getRegisterByUserName(String uName) {

        Register register = new Register();

        String getRegisterSQL="select * from register where username = ?";


        try (Connection connection = DatabaseCon.getConncetion();
        PreparedStatement preparedStatement = connection.prepareStatement(getRegisterSQL)){

            preparedStatement.setString(1, uName);
            try (ResultSet resultSet = preparedStatement.executeQuery()){
                if (resultSet.next()) {
                    register.setUserName(resultSet.getString("username"));
                    Blob blob = resultSet.getBlob("img");

                    if (blob != null) {
                        InputStream inputStream = blob.getBinaryStream();
                        register.setImage(inputStream);
                    }else {
                        register.setImage(null);
                    }



                }


            } catch (Exception e) {
                e.printStackTrace();

            }


        } catch (Exception e) {
            e.printStackTrace();

        }


        return register;

    }



}
