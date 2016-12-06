package de.westphaf;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import de.westphaf.meldeauskunft.domain.Resident;
import de.westphaf.meldeauskunft.repository.ResidentRepository;

public class ResidentRepositoryStub implements ResidentRepository{
	
	private List<Resident> residents = new ArrayList<Resident>();
	
	public ResidentRepositoryStub(){
		try {
			residents.add(new Resident("Jochen","von Jochenhausen","Jochenstreet 9","Jochencity",new SimpleDateFormat("dd/MM/yyyy").parse("01/01/2000")));
			residents.add(new Resident("Karl","von Karlhausen","Karlstreet 9","Jochencity",new SimpleDateFormat("dd/MM/yyyy").parse("01/01/1999")));
			residents.add(new Resident("Gustav","von Gustavhausen","Gustavstreet 9","Jochencity",new SimpleDateFormat("dd/MM/yyyy").parse("01/01/1998")));
			residents.add(new Resident("Otto","von Ottohausen","Ottostreet 9","Jochencity",new SimpleDateFormat("dd/MM/yyyy").parse("01/01/1997")));
			residents.add(new Resident("Günni","von Günnihausen","Günnistreet 9","Jochencity",new SimpleDateFormat("dd/MM/yyyy").parse("01/01/1996")));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public List<Resident> getResidents(){
		return residents;
	}
}
