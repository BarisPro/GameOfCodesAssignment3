/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package library.entities;

import java.util.Calendar;
import java.util.Date;
import library.interfaces.entities.ELoanState;
import library.interfaces.entities.IBook;
import library.interfaces.entities.IMember;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Nikul
 */
public class CheckOverDueTest {
    
    // Create the required instances.
    Loan instance;
    IBook book;
    IMember member;
    Date borrowDate, returnDate;
    
    // Set up the required objects.
    @Before
    public void setUp() {
        book = new Book("Author1","ITC515","0055455",12345);
        member = new Member("James", "Mack", "046977777", "email1", 123);
        borrowDate = new Date(2016,05,10);
        returnDate = new Date(2016, 30, 11);
        
        instance = new Loan(book, member, borrowDate, returnDate);
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    
    // Test the check overDue book.
    @Test
    public void testCheckOverDue() {
        boolean expectedResult = false;
        instance.setState(ELoanState.CURRENT);
        
        assertEquals(expectedResult, instance.checkOverDue(borrowDate));
    }
}
