package de.westphaf;

import static org.junit.Assert.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;

import de.westphaf.meldeauskunft.domain.Resident;
import de.westphaf.meldeauskunft.service.BaseResidentService;
import de.westphaf.meldeauskunft.service.ResidentServiceException;

public class ResidentTest {

	private static ResidentRepositoryStub residentReopStub = new ResidentRepositoryStub();
	private static BaseResidentService residentService = new BaseResidentService();

	@BeforeClass
	public static void init() {
		residentService.setResidentRepository(residentReopStub);
	}

	@Test
	public void getFilteredResidentListTestLastName() {
		Resident residentFilter = new Resident();
		residentFilter.setGivenName("Jo*");

		Resident jochen = residentService.getFilteredResidentsList(residentFilter).get(0);
		assertEquals("von Jochenhausen", jochen.getFamilyName());
	}

	@Test
	public void getFilteredResidentListTestMatchOneResident() {

		Resident filterResident = new Resident();
		filterResident.setGivenName("Jochen");
		Resident expectedResident = residentReopStub.getResidents().get(0);

		Resident foundResident = residentService.getFilteredResidentsList(filterResident).get(0);

		assertEquals(expectedResident, foundResident);
	}
	
	@Test
	public void getFilteredResidentListTestWildcard() {

		Resident filterResident = new Resident();
		filterResident.setGivenName("*");
		List<Resident> expectedResidents = residentReopStub.getResidents();

		List<Resident> foundResidents = residentService.getFilteredResidentsList(filterResident);

		assertEquals(expectedResidents, foundResidents);
	}
	
	@Test 
	public void getUniqueResidentTestLastName(){
		Resident filterResident = new Resident();
		filterResident.setGivenName("Karl");
		
		Resident expectedResident = residentReopStub.getResidents().get(1);
		
		try {
			Resident actualResident = residentService.getUniqueResident(filterResident);
			assertEquals(expectedResident, actualResident);
			
		} catch (ResidentServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			fail("No Resident found");
		}
	}
	
	@Test(expected=ResidentServiceException.class)
	public void getUniqueResidentTestException() throws ResidentServiceException{
		Resident filterResident = new Resident();
		filterResident.setGivenName("asdf");
		
		residentService.getUniqueResident(filterResident);
	}
	
	@Test(expected = ResidentServiceException.class)
	public void getUniqueTestWildcard() throws ResidentServiceException{
		Resident filterResident = new Resident();
		filterResident.setGivenName("Jo*");
		
		residentService.getUniqueResident(filterResident);
	}
	

}
