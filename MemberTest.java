package library.entities;

import java.util.Date;
import java.util.List;
import library.interfaces.entities.EMemberState;
import library.interfaces.entities.IBook;
import library.interfaces.entities.ILoan;
import library.interfaces.entities.IMember;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author baris
 */
public class MemberTest {
    Loan instance; // loan object
    IBook book; // used for book object
    IMember member; // used for member object
    Date borrowDate, returnDate; // used to create new dates
    
    public MemberTest() {
    }
    
    @Before
    public void setUp() {
        book = new Book("Author1","ITC515","0055455",12345); // creating a book object
        member = new Member("James", "Mack", "046977777", "email1", 123); // creating a member object
        borrowDate = new Date(2016,05,10);
        returnDate = new Date(2016, 07, 10);
        
        instance = new Loan(book, member, borrowDate, returnDate); // a loan object
    }
    
    @Test
    public void testGetMember(){ // test if the member constructor can be called and new object created
        IMember expectedResult = member;
        IMember result = instance.getBorrower();
        assertEquals(expectedResult, result);
    }
    
    @Test
    public void testGetState() {  // output should be BORROWING_ALLOWED as it is a default in constructor for new object
        String expResult = "BORROWING_ALLOWED";
        EMemberState result = member.getState();
        System.out.println(member.getState());
        assertEquals(String.valueOf(expResult), String.valueOf(result));
    }
    
    @Test
    public void testGetFirstName() { // test if the first name of a member can be obtained
        String expResult = "James";
        String result = member.getFirstName();
        assertEquals(expResult, result);
    }
    
    @Test
    public void testGetLastName() { // test if the last name of a member can be obtained
        String expResult = "Mack";
        String result = member.getLastName();
        assertEquals(expResult, result);
    }
    
    @Test
    public void testGetContactPhone() { // test if the phone number of a member can be obained
        String expResult = "046977777";
        String result = member.getContactPhone();
        assertEquals(expResult, result);
    }
    
    @Test
    public void testGetEmailAddress() { // test if the email address of a member can be obtained
        String expResult = "email@gmail.com";
        String result = member.getEmailAddress();
        assertEquals(expResult, result);
    }
    
    @Test
    public void testGetID() { // test if the ID of a member can be obtained
        String expResult = "123";
        String result = String.valueOf(member.getID());
        assertNotNull(result);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testHasOverDueLoans() { // test if correct amount is obtained from testHasOverDueLoans method
        List<ILoan> list;
        Loan loan = new Loan(book, member, borrowDate, returnDate);
        assertFalse(member.hasOverDueLoans());
    }
    
    @Test
    public void testHasReachedLoanLimit() { // test if HasReachedLoanLimit produce the correct output for a member
        assertFalse(member.hasReachedLoanLimit());
    }
    
    @Test
    public void testHasFinesPayable() { // test if testHasFinesPayable produce the correct output for a member
        assertFalse(member.hasFinesPayable());
    }
    
     @Test
    public void testHasReachedFineLimit() { // test if testHasReachedFineLimit produce the correct output for a member
        assertFalse(member.hasReachedFineLimit());
    }
    
    @Test
    public void testGetFineAmount() { // test if testGetFineAmount produce the correct output for a member
        float expResult = 0.0F;
        float result = member.getFineAmount();
        assertEquals(expResult, result, 0.0);
    }
    
    @Test
    public void testGetLoans() { // test if testGetLoans output the correct list of loans for a member
        List<ILoan> expResult = Collections.<ILoan>emptyList(); 
        List<ILoan> result = member.getLoans();
        assertEquals(expResult, result);
    }
    
    @After
    public void tearDown() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        
    }
    
    @AfterClass
    public static void tearDownClass() {
    }

    
}

