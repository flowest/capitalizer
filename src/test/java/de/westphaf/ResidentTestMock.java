package de.westphaf;

import static org.junit.Assert.*;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.easymock.*;
import org.junit.BeforeClass;
import org.junit.Test;
import de.westphaf.meldeauskunft.domain.Resident;
import de.westphaf.meldeauskunft.repository.ResidentRepository;
import de.westphaf.meldeauskunft.service.BaseResidentService;
import de.westphaf.meldeauskunft.service.ResidentServiceException;

public class ResidentTestMock {
	private static List<Resident> residents = new ArrayList<Resident>();

	@BeforeClass
	public static void init() {

		residents.add(new Resident("Jochen", "von Jochenhausen", "Jochenstreet 9", "Jochencity", new Date()));
		residents.add(new Resident("Karl", "von Karlhausen", "Karlstreet 9", "Jochencity", new Date()));

	}

	@Test
	public void test() throws ResidentServiceException {
		ResidentRepository repoMock = EasyMock.createMock(ResidentRepository.class);
		EasyMock.expect(repoMock.getResidents()).andReturn(residents);

		EasyMock.replay(repoMock);
		BaseResidentService service = new BaseResidentService();
		service.setResidentRepository(repoMock);

		Resident filterResident = new Resident();
		filterResident.setFamilyName("von Karlhausen");
		Resident expectedResident = service.getUniqueResident(filterResident);

		assertEquals(residents.get(1).getGivenName(), expectedResident.getGivenName());
	}
}
