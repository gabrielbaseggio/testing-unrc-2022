package testing.mocks.ejercicio2;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import static org.easymock.EasyMock.*;

public class IPBlacklistTest {
    @Test
    public void successfulLoginOnSecondTry() {
    	LoginService lService = createStrictMock( LoginService.class );
    	
    	IPBlacklist IPblacklist = new IPBlacklist();
    	IPblacklist.setService( lService );
    	
    	String ip        = "192.0.10.1";
    	String userName  = "SirGabriel";
    	String password1 = "SrGabriel123";
    	String password2 = "SirGabriel";
    
    	expect( lService.login(ip, userName, Utils.getPasswordHashMD5( password1 )) ).andReturn( false );
    	expect( lService.login(ip, userName, Utils.getPasswordHashMD5( password2 )) ).andReturn( true );
    	replay( lService );
    	
    	IPblacklist.login( ip, userName, password1 );
    	
    	assertEquals( IPblacklist.numOfRetries, 1 );
    	
    	assertTrue( IPblacklist.login( ip, userName, password2 ) );
    	
    	verify( lService );
    }

	@Test
	public void ipBlacklistedAfterThreeAttempts() {
		LoginService lService = createStrictMock( LoginService.class );
		
		IPBlacklist IPblacklist = new IPBlacklist();
    	IPblacklist.setService( lService );
    	
    	String ip        = "192.0.10.1";
    	String userName  = "SirGabriel";
    	String password  = "SirGabriel123";
    	
    	expect( lService.login(ip, userName, Utils.getPasswordHashMD5(password)) ).andReturn( false );
    	expectLastCall().times( 3 );
    	replay( lService );
    	
    	// 0 attempts
    	assertFalse( IPblacklist.blacklisted( ip ) );
    	IPblacklist.login( ip, userName, password );
    	// 1 attempts
    	assertFalse( IPblacklist.blacklisted( ip ) );
    	IPblacklist.login( ip, userName, password );
    	// 2 attempts
    	assertFalse( IPblacklist.blacklisted( ip ) );
    	IPblacklist.login( ip, userName, password );
    	
    	assertTrue( IPblacklist.blacklisted( ip ) );
    	
    	verify( lService );
	}
	
	@Test
	public void ipNotBlacklistedBeforeThreeAttempts() {
		LoginService lService = createStrictMock( LoginService.class );
		
		IPBlacklist IPblacklist = new IPBlacklist();
    	IPblacklist.setService( lService );
    	
    	String ip        = "192.0.10.1";
    	String userName  = "SirGabriel";
    	String password  = "SirGabriel123";
    	
    	expect( lService.login(ip, userName, Utils.getPasswordHashMD5(password)) ).andReturn( false );
    	expectLastCall().times( 2 );
    	replay( lService );
    	
    	// 0 attempts
    	assertFalse( IPblacklist.blacklisted( ip ) );
    	
    	IPblacklist.login( ip, userName, password );
    	
    	// 1 attempts
    	assertFalse( IPblacklist.blacklisted( ip ) );
    	
    	IPblacklist.login( ip, userName, password );
    	
    	// 2 attempts
    	assertFalse( IPblacklist.blacklisted( ip ) );
    	
    	verify( lService );
	}
	
	@Test
	public void ipBlacklistedAfterFourAttempts() {
		LoginService lService = createStrictMock( LoginService.class );
		
		IPBlacklist IPblacklist = new IPBlacklist();
    	IPblacklist.setService( lService );
    	
    	String ip        = "192.0.10.1";
    	String userName  = "SirGabriel";
    	String password  = "SirGabriel123";
    	
    	expect( lService.login(ip, userName, Utils.getPasswordHashMD5(password)) ).andReturn( false );
    	expectLastCall().times( 3 );
    	replay( lService );
    	
    	IPblacklist.login( ip, userName, password );
    	IPblacklist.login( ip, userName, password );
    	IPblacklist.login( ip, userName, password );
    	IPblacklist.login( ip, userName, password );
    	
    	assertTrue( IPblacklist.blacklisted( ip ) && IPblacklist.numOfRetries == 0 );
    	
    	verify( lService );
	}
	
	@Test
	public void loginWithAnotherIPResetsNumOfRetries() {
		LoginService lService = createStrictMock( LoginService.class );
		
		IPBlacklist IPblacklist = new IPBlacklist();
    	IPblacklist.setService( lService );
    	
    	String ip1       = "192.0.10.1";
    	String ip2       = "192.0.10.2";
    	String userName  = "SirGabriel";
    	String password  = "SirGabriel123";
    	
    	expect( lService.login(ip1, userName, Utils.getPasswordHashMD5(password)) ).andReturn( false );
    	expectLastCall().times( 2 );
    	
    	expect( lService.login(ip2, userName, Utils.getPasswordHashMD5(password)) ).andReturn( false );
    	
    	replay( lService );
    	
    	IPblacklist.login( ip1, userName, password );
    	IPblacklist.login( ip1, userName, password );
    	assertTrue( IPblacklist.numOfRetries == 2 );
    	IPblacklist.login( ip2, userName, password );
    	assertTrue( IPblacklist.numOfRetries == 1 );
    	
    	verify( lService );
	}
}
