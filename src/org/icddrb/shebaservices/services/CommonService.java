package org.icddrb.shebaservices.services;

import org.icddrb.shebaservices.db.ConnectionParameter;
import org.icddrb.shebaservices.db.CurrentHospitalPatient;
import org.icddrb.shebaservices.db.Patient;

/**
 * Created by IntelliJ IDEA.
 * User: siddik
 * Date: 4/15/14
 * Time: 3:22 PM
 * To change this template use File | Settings | File Templates.
 */
public interface CommonService {

public String currentHospitalPatient(ConnectionParameter cp, String patientID);

public String patientStatus(CurrentHospitalPatient chp);

public String patientStatusForNewProgressReport(CurrentHospitalPatient chp);

public String getPatient(ConnectionParameter cp, String patientID);

public String patientStatus(Patient chp);

public String patientStatusForNewProgressReport(Patient chp);

}
