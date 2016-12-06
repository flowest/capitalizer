package de.westphaf.meldeauskunft.repository;

import java.util.List;

import de.westphaf.meldeauskunft.domain.Resident;

/**
 * @author Stefan Betermieux
 */
public interface ResidentRepository {

  List<Resident> getResidents();

}