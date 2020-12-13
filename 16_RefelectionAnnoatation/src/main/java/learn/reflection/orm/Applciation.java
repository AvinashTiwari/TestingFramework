package learn.reflection.orm;

import java.sql.SQLException;

public class Applciation {
    public static void main(String[] args) throws Exception {
        TransactionHistory t1 = new TransactionHistory(1531, "Avinash", "Credit",1);
        TransactionHistory t2 = new TransactionHistory(1532, "Avinash1", "Credit",1000);
        TransactionHistory t3 = new TransactionHistory(1533, "Avinash2", "Debit",1000);
        TransactionHistory t4 = new TransactionHistory(1534, "Avinash3", "Debit",10);

        Hibernate<TransactionHistory> hibernate = Hibernate.getConnection();
       // hibernate.write(t1);
        //hibernate.write(t2);
       // hibernate.write(t3);
        //hibernate.write(t4);

        TransactionHistory obj = hibernate.read(TransactionHistory.class,1L);
        System.out.println(obj);
    }
}
