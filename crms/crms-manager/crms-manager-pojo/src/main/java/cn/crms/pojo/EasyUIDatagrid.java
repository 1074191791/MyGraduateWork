package cn.crms.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.util.List;

/**
 * @author zhous
 * @create 2019-03-15 21:42
 */
public class EasyUIDatagrid implements Serializable {
    //总个数
    private int total;
    //当前页数据
    private List<?> rows;

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public List<?> getRows() {
        return rows;
    }

    public void setRows(List<?> rows) {
        this.rows = rows;
    }

    @Override
    public String toString() {
        return "EasyUIDatagrid{" +
                "total=" + total +
                ", rows=" + rows +
                '}';
    }
}
