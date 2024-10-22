package dao;

import model.FileUploadModel;

import java.io.InputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class FileDao {

    private static String saveFileSQL ="insert into FileUpload (fileName, fileType, file) values (?,?,?)";


    public static boolean saveFile(FileUploadModel fileUpload) {

        boolean isSaved = false;

        try (Connection connection = DatabaseCon.getConncetion();
             PreparedStatement preparedStatement = connection.prepareStatement(saveFileSQL)
        ) {
            preparedStatement.setString(1,fileUpload.getFileName());
            preparedStatement.setString(2, fileUpload.getFileType());
            preparedStatement.setBinaryStream(3, fileUpload.getFile());

            isSaved = preparedStatement.executeUpdate()>0;
            System.out.println(isSaved?"File Upload successfully":"File upload failed.");

        } catch (Exception e) {
            e.printStackTrace();

        }


        return isSaved;
    }


    public static ArrayList<FileUploadModel> getAllFile() {

        ArrayList<FileUploadModel> files = new ArrayList<>();
        String fileSQL = "select * from fileupload";

        try (Connection connection = DatabaseCon.getConncetion();
        PreparedStatement preparedStatement = connection.prepareStatement(fileSQL)){

            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                FileUploadModel fileUploadModel = new FileUploadModel();
                fileUploadModel.setId(rs.getInt(1));
                fileUploadModel.setFileName(rs.getString(2));
                fileUploadModel.setFileType(rs.getString(3));

                Blob blob = rs.getBlob(4);

                if (blob !=null) {
                    InputStream inputStream = blob.getBinaryStream();
                    fileUploadModel.setFile(inputStream);
                }else {
                    fileUploadModel.setFile(null);
                }

                files.add(fileUploadModel);




            }


        } catch (Exception e) {
            e.printStackTrace();

        }


        return files;

    }


    public static FileUploadModel getFileById(int id) {

        FileUploadModel fileUploadModel = new FileUploadModel();
        String getFileSQL = "select * from fileupload where id =?";

        try (Connection connection = DatabaseCon.getConncetion();
        PreparedStatement preparedStatement = connection.prepareStatement(getFileSQL)){

            preparedStatement.setInt(1, id);
            try (ResultSet resultSet = preparedStatement.executeQuery()){

                if (resultSet.next()) {
                    fileUploadModel.setId(resultSet.getInt(1));
                    fileUploadModel.setFileName(resultSet.getString(2));
                    fileUploadModel.setFileType(resultSet.getString(3));
                    Blob blob = resultSet.getBlob(4);

                    if (blob != null) {
                        InputStream inputStream= blob.getBinaryStream();
                        fileUploadModel.setFile(inputStream);
                    }


                }


            } catch (Exception e) {
                e.printStackTrace();

            }




        } catch (Exception e) {
            e.printStackTrace();

        }


        return fileUploadModel;

    }
}
