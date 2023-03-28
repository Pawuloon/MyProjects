package zad1;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.List;

public class Table extends AbstractTableModel
{
    private final TravelData data;
    private static final List<String>myModel = new ArrayList<>();

    public Table(TravelData data)
    {
        this.data = data;
        myModel.add("Country");
        myModel.add("Date depart");
        myModel.add("Date ret");
        myModel.add("Place");
        myModel.add("Price");
        myModel.add("Currency");
    }

    @Override
    public String getColumnName(int col)
    {
        return myModel.get(col);
    }

    @Override
    public int getRowCount()
    {
        return this.data.getContent().size();
    }

    @Override
    public int getColumnCount()
    {
        return myModel.size();
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex)
    {
        if (columnIndex==0)
            return this.data.getCountryDeparture().get(rowIndex);
        if (columnIndex==1)
            return this.data.getDateP().get(rowIndex);
        if (columnIndex==2)
            return this.data.getDateRet().get(rowIndex);
        if (columnIndex==3)
            return this.data.getPlace().get(rowIndex);
        if (columnIndex==4)
            return this.data.getPrice().get(rowIndex);
        if (columnIndex==5)
            return this.data.getPriceCurrency().get(rowIndex);
        else
            return null;
    }
}
