package de.westphaf.meldeauskunft.service;

import java.util.List;

import de.westphaf.meldeauskunft.domain.Resident;

/**
 * @author Stefan Betermieux
 */
public interface ResidentService {

  Resident getUniqueResident(Resident filterResident) throws ResidentServiceException;

  List<Resident> getFilteredResidentsList(Resident filterResident);
  
  int test= 0;

}