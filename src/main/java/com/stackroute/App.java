package com.stackroute;

import com.stackroute.jdbcDemo.*;

/**
 * Hello world!
 *
 */
public class App
{
    public static void main( String[] args )
    {
        //System.out.println( "Hello World!");
        System.out.println("Data manager :");
        DataManager datamanager=new DataManager();
        datamanager.getAllStudents();


        System.out.println("Prepared Statement :");
        PrepareStatementDemo preparedstatamentdemo=new PrepareStatementDemo();
        preparedstatamentdemo.getEstudentByName("vijay");
        preparedstatamentdemo.getEstudentByNameDuration("OS",17);

        //Database metadata demo
        System.out.println("database meta data :");
        DataBaseMetDataDemo databaseMetaDataDemo=new DataBaseMetDataDemo();
        databaseMetaDataDemo.getDatabaseMetaData();

        //Resultset metadata
        System.out.println("Result set meta data :");
        ResultSetDemo resultSetDemo=new ResultSetDemo();
        resultSetDemo.getAllStudents();

        //transaction demo
       System.out.println("Jdbc Transactions done ");
        JdbcTransactionDemo jdbcTransactionDemo=new JdbcTransactionDemo();
        jdbcTransactionDemo.transactionData();

        //bATCH pROCESSING  demo
        System.out.println("row set :");
        JdbcBatchProcessing jdbcBatchProces=new JdbcBatchProcessing();
        jdbcBatchProces.batchProcessing();

    }
}