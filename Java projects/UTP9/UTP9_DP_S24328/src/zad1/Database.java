package zad1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.*;

public class Database
{

    private final TravelData data;
    private final String url;

    public Database(String url,TravelData data)
    {
        this.url = url;
        this.data = data;
    }

    public void create()
    {
        try
        {
            Class.forName("org.h2.Driver");
            Connection con = DriverManager.getConnection(url, "sa", "");
            Statement statement = con.createStatement();
            statement.execute("DROP TABLE IF EXISTS Offers");
            statement.execute("CREATE TABLE Offers" +
                    "("
                    +
                    "ID INT PRIMARY KEY, " +
                    "COUNTRY VARCHAR(100) , " +
                    "DATE_OUT DATE , " +
                    "DATE_RETURN DATE , " +
                    "PLACE VARCHAR(100) , " +
                    "PRICE VARCHAR(2000) ," +
                    "CURRENCY VARCHAR(20)  " +
                    ")");
            statement.getUpdateCount();
            PreparedStatement preparedStatement = con.prepareStatement(
                    "INSERT INTO Offers VALUES(?,?,?,?,?,?,?)");
            for (int i = 0; i < data.getCountryDeparture().size(); i++)
            {
                preparedStatement.setInt(1,i);
                preparedStatement.setString(2,data.getCountryDeparture().get(i));
                preparedStatement.setString(3,data.getDateRet().get(i));
                preparedStatement.setString(4,data.getDateP().get(i));
                preparedStatement.setString(5,data.getPlace().get(i));
                preparedStatement.setString(6,data.getPrice().get(i));
                preparedStatement.setString(7,data.getPriceCurrency().get(i));
                preparedStatement.execute();
            }
        }catch (Exception exception)
        {
            exception.printStackTrace();
        }


    }

    public void showGui()
    {
        JTable table = new JTable(new Table(data));
        SwingUtilities.invokeLater(new Runnable()
        {
            @Override
            public void run()
            {
                JFrame frame = new JFrame("Table");
                frame.setVisible(true);
                frame.pack();
                frame.add(new JScrollPane(table));
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setSize(640,640);
                frame.setLocationRelativeTo(null);
            }
        });
    }
}
